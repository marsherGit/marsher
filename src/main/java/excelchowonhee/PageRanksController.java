package excelchowonhee;

	import java.util.ArrayList;

	import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

	import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
	
import chowonhee.DTO.*;

@Controller
public class PageRanksController {
	//@RequestMapping("/pageRanks")
	@RequestMapping("/download/pageRanks")
	public ModelAndView handleRequestInternal(String st_id,int totalstore,int totalchango,int totalappropriate,HttpServletRequest request) throws Throwable {
		System.out.println("체크체크");
		request.getSession().setAttribute("st_id", st_id);
		request.getSession().setAttribute("totalstore", totalstore);
		request.getSession().setAttribute("totalchango", totalchango);
		request.getSession().setAttribute("totalappropriate", totalappropriate);	
		
		List<Object> JHandJJList = new ArrayList<Object>();
		if((List) request.getSession().getAttribute("excel")==null){
			
			JHandJJList.add(0,1); 		
		}else{
			JHandJJList = (List) request.getSession().getAttribute("excel");
		}
		
		if(st_id.equals("admin")){
				JHandJJList.clear();	
		}
		System.out.println("체크");
		System.out.println(JHandJJList.size()); 		
	
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		ProductPlusRemark[] ProductPlusRemark = new ProductPlusRemark[JHandJJList.size()];
		
		for(int i=0;i<JHandJJList.size();i++){
			ProductPlusRemark[i] = new ProductPlusRemark();
			ProductPlusRemark[i] = (ProductPlusRemark) JHandJJList.get(i);
		}
		
		for(int i=0;i<JHandJJList.size();i++){ 
		pageRanks.add(new PageRank(i+1,ProductPlusRemark[i].getPro_num(),ProductPlusRemark[i].getPro_bcategory(),ProductPlusRemark[i].getPro_name(),ProductPlusRemark[i].getPro_container(),
				ProductPlusRemark[i].getPro_volume(),ProductPlusRemark[i].getPro_cPrice(),ProductPlusRemark[i].getPro_uPrice(),ProductPlusRemark[i].getTotalStockAmount(),
				ProductPlusRemark[i].getTotalStockAmountStore(),ProductPlusRemark[i].getPro_properStock(),ProductPlusRemark[i].getPro_remark()));
		}

		return new ModelAndView("pageRanks", "pageRanks", pageRanks);
	}

}


