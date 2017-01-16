package chowonhee.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chowonhee.DTO.*;
import org.springframework.stereotype.Controller;
@Controller
public interface jegoService {
	//입고
	public List<Object> getArticles(int startRow,int endRow);
	public List<Object> getArticlesDate(String inout_deadline,int startRow,int endRow);
	public List<Object> getArticlesFacName(String inout_sender,int startRow,int endRow);
	public List<Object> getArticlesDateFacName(String inout_sender,String inout_deadline,int startRow,int endRow);
	public List<Object> getArticlelist(int inout_num);
	public int getArticlelistCount(int inout_num);
	public int getArticleCount();
	public int getArticlesDateCount(String inout_deadline);
	public int getArticleFacNameCount(String fac_name);
	public int getArticleDateFacNameCount(String inout_sender,String inout_deadline);
	
	public List<Object> jegoDRProductGetArticle();
	public Product jegoDRProductGetArticles(String pro_name);
	
	public List<Object> facList();
	
	public int findNumberIG();
	public void changoIGBoard(changoIGBoard changoIGBoard);
	public void changoIGBoard1(changoIGBoard changoIGBoard);
	public void changoIGBoard2(inoutBoard inoutBoard);
	public void changoIGBoardSequence();
	public inoutBoard getArticleboard(int inout_num);
	public List<Object> facNameList();
	public void productSetTotal(int totalStockAmount,String pro_num);
	public void productSetTotalplus(int totalStockAmount,String pro_num);
	//출고
	public List<Object> getArticlesCG(int startRow,int endRow);
	public List<Object> getArticlesDateCG(String inout_deadline,int startRow,int endRow);
	public List<Object> getArticlesFacNameCG(String inout_sender,int startRow,int endRow);
	public List<Object> getArticlesDateFacNameCG(String inout_sender,String inout_deadline,int startRow,int endRow);
	public int getArticleCountCG();
	public int getArticlesDateCountCG(String inout_deadline);
	
	public int findNumberCG();
	public void changoCGBoard(changoCGBoard changoCGBoard);
	public void changoCGBoard1(changoCGBoard changoCGBoard);
	public void changoCGBoard2(inoutBoard inoutBoard);
	
	public List<Object> storeList();
	
	public List<Object> getArticlelistCG(int inout_num);
	public int getArticlelistCountCG(int inout_num);
	public int getArticleFacNameCountCG(String inout_sender);
	public int getArticleDateFacNameCountCG(String inout_sender,String inout_deadline);
	
	public inoutBoard getArticleboardCG(int inout_num);
	public List<Object> stNameList();
	//재고조회,재고조정
	public List<Object> selectListItems();
	public List<Object> selectListStores();
	public List<Object> selectListItemsProNames(String pro_bcategory);
	public List<Object> JHandJJList();
	public List<Object> JHandJJListSearch(String pro_name);
	public int JHandJJListSearchCount(String pro_name);
	public int JHandJJListSearchTotalproperstock(String search);
	public int JHandJJListSearchTotalStockAmount(String search);
	public int JHandJJListSearchTotalStockAmountStore(String search);
	public List<Object> JHandJJListfummok(String select1);
	public int JHandJJListfummokTotalproperstock(String select1);
	public int JHandJJListfummokTotalStockAmount(String select1);
	public int JHandJJListfummokTotalStockAmountStore(String select1);
	public List<Object> JHandJJListFindOneSelect2(String pro_name);
	public List<Object> JHandJJListStore();
	public int JHandJJListCount();
	public String JHandJJStockAmount(String pro_num);
	public String JHandJJStockAmountStore(String pro_num);
	public List<Object> JHandJJStockProNum();
	public void updateTotalStockAmount(int totalStockAmount,String pro_num);
	public void updateTotalStockAmountStore(int updateTotalStockAmountStore,String pro_num);
	public int totalAppropriate();
	public int countProdcut();
	public List<Object> productPronumList();
	public int checkStockPronum(String pro_num);
	public int findtotalstockamount(String pro_num);
	//재고조회
	public List<Object> getStockPronums(String st_id);
	public List<Object> getStockProstockamounts(String st_id);
	public int getStIdCount(String st_id);
	public List<Object> notInProNums(String st_id);
	
	//재고조정
	public void insertStockModify(String pro_num,int real_stockAmount,int old_stockAmount);
	public void insertStockModify2(int mod_number,String pro_num,int real_stockAmount,int old_stockAmount);
	public int maxModnumber();
	public void ModifyBoard(int mod_number,String title);
	public String findProName(String pro_num);
	public int JJListCount();
	public int JJListNameCount(String pro_name);
	public int JJListDateCount(String pro_name,String dateCheck);
	public int JJListNDCount(String pro_name,String dateCheck);
	public List<Object> JJListgetArticles(int startRow,int endRow);
	public List<Object> JJNameArticles(String pro_num,int startRow,int endRow);
	public List<Object> JJDateArticles(String mod_regdate,int startRow,int endRow);
	public List<Object> JJNDArticles(String pro_name,String mod_regdate,int startRow,int endRow);
	public List<Object> JJListgetContents(int mod_number);
	public int ContentsCount(int mod_number);
	//jegoDR,CGjegoDR 후에, 재고테이블 insert 혹은 재고테이블 update
	public int findPronum(String pro_num);
	public int checkCountStidIG(String st_id,String pro_num);
	public int findPronumCG(String pro_num);
	public String findst_IdCG(String st_name);
	public int checkCountStid(String st_id,String pro_num);
	
	public void insertStock(Stock stock);
	public void updateStockIG(Stock stock);
	public void updateStockCG(Stock stock);
	
	//CGjegoDR에서 st_id 갯수 가져오는 메서드
	public int findstId(String st_name);
	
	//jegoJJListJHPro에서 값되돌릴 떄 사용
	public void revertJHList(int old_stockAmount,String pro_num);
	public void deleteStock(int mod_number);
	public void deleteStockboard(int mod_number);
	
	//매장재고조회
	public store StfindName(String st_id);

	//매장재고조정
	public List<Object> findNotInsert(String st_id);
	public void insertSetZero(String st_id,String pro_num);
	public void updateStockamount(int pro_stockamount,String st_id,String pro_num);
	public List<Object> updateChangoAmount(int totalStockAmountStore,int actuality,String pro_num);
	

}
