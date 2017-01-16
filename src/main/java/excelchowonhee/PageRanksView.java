package excelchowonhee;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class PageRanksView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition",
				"attachment; filename=\"Inventory check sheet.xls\";");  // buildExcelDocument()가 종료하면 response가 정보를 클라이언트로 전송한다.
		
		Sheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet,request);

		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");
		int rowNum = 2;
		for (PageRank rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++);
		}
		createPageFinalRow(sheet,rowNum,request);
	}

	private Sheet createFirstSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "재고 조회표");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}

	private void createColumnLabel(Sheet sheet,HttpServletRequest request) {
		
		String st_id = (String) request.getSession().getAttribute("st_id");
		
		Row firstRow = sheet.createRow(0); 
		Cell fcell = firstRow.createCell(0);
		fcell.setCellValue("선택매장");
		
		fcell = firstRow.createCell(1);
		fcell.setCellValue(st_id);
		
		Row secondRow = sheet.createRow(1); 
		Cell cell = secondRow.createCell(0);
		cell.setCellValue("No");

		cell = secondRow.createCell(1);
		cell.setCellValue("제품번호");
		
		cell = secondRow.createCell(2);
		cell.setCellValue("품목");
		
		cell = secondRow.createCell(3);
		cell.setCellValue("제품명");
		
		cell = secondRow.createCell(4);
		cell.setCellValue("용기");
		
		cell = secondRow.createCell(5);
		cell.setCellValue("용량(ml)");
		
		cell = secondRow.createCell(6);
		cell.setCellValue("제품원가(원)");
		
		cell = secondRow.createCell(7);
		cell.setCellValue("판매단가(원)");
		
		cell = secondRow.createCell(8);
		cell.setCellValue("매장재고수량");
		
		cell = secondRow.createCell(9);
		cell.setCellValue("창고재고수량");
		
		cell = secondRow.createCell(10);
		cell.setCellValue("적정재고");
		
		cell = secondRow.createCell(11);
		cell.setCellValue("비고");
	}

	private void createPageRankRow(Sheet sheet, PageRank rank, int rowNum) {
		Row row = sheet.createRow(rowNum);

		Cell cell = row.createCell(0);
		cell.setCellValue(rank.getNo());

		cell = row.createCell(1);
		cell.setCellValue(rank.getPro_num());
		
		cell = row.createCell(2);
		cell.setCellValue(rank.getPro_bcategory());

		cell = row.createCell(3);
		cell.setCellValue(rank.getPro_name());
		
		cell = row.createCell(4);
		cell.setCellValue(rank.getPro_container());

		cell = row.createCell(5);
		cell.setCellValue(rank.getPro_volume());
		
		cell = row.createCell(6);
		cell.setCellValue(rank.getPro_cPrice());

		cell = row.createCell(7);
		cell.setCellValue(rank.getPro_uPrice());
	
		cell = row.createCell(8);
		cell.setCellValue(rank.getTotalStockAmountStore());

		cell = row.createCell(9);
		cell.setCellValue(rank.getTotalStockAmount());
		
		cell = row.createCell(10);
		cell.setCellValue(rank.getPro_properStock());
		
		cell = row.createCell(11);
		cell.setCellValue(rank.getPro_remark());

	}
	
	private void createPageFinalRow(Sheet sheet, int rowNum,HttpServletRequest request) {
		int totalstore = (int) request.getSession().getAttribute("totalstore");
		int totalchango = (int) request.getSession().getAttribute("totalchango");
		int totalappropriate = (int) request.getSession().getAttribute("totalappropriate");
		Row row = sheet.createRow(rowNum);

		Cell cell = row.createCell(0);
		cell.setCellValue("합계");

		cell = row.createCell(8);
		cell.setCellValue(totalstore);
		
		cell = row.createCell(9);
		cell.setCellValue(totalchango);
		
		cell = row.createCell(10);
		cell.setCellValue(totalappropriate);
	}

}