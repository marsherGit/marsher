package chowonhee.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import chowonhee.DTO.*;
import chowonhee.DTO.*;
@Controller
public class jegoServiceImpl implements jegoService {
	@Autowired
	private jegoDAO dao;

	//입고
	public void setDao(jegoDAO dao) {
		this.dao = dao;
	}
	
	public List<Object> getArticles(int startRow,int endRow){
		return dao.getArticles(startRow, endRow);
	}
	
	public List<Object> getArticlesDate(String inout_deadline,int startRow,int endRow){
		return dao.getArticlesDate(inout_deadline,startRow,endRow);
	}
	
	public List<Object> getArticlesFacName(String inout_sender,int startRow,int endRow){
		return dao.getArticlesFacName(inout_sender,startRow, endRow);
	}
	
	public List<Object> getArticlesDateFacName(String inout_sender,String inout_deadline,int startRow,int endRow){
		return dao.getArticlesDateFacName(inout_sender,inout_deadline,startRow, endRow);
	}
	
	public List<Object> getArticlelist(int inout_num){
		return dao.getArticlelist(inout_num);
	}
	
	public int getArticlelistCount(int inout_num){
		return dao.getArticlelistCount(inout_num);
	}
	
	public int getArticlesDateCount(String inout_deadline){
		return dao.getArticlesDateCount(inout_deadline);
	}
	
	public int getArticleCount(){
		return dao.getArticleCount();
	}

	public int getArticleFacNameCount(String fac_name){
		return dao.getArticleFacNameCount(fac_name);
	}
	
	public int getArticleDateFacNameCount(String inout_sender,String inout_deadline){
		return dao.getArticleDateFacNameCount(inout_sender,inout_deadline);
	}
	
	public List<Object> jegoDRProductGetArticle(){
		return dao.jegoDRProductGetArticle();
	}
	
	public Product jegoDRProductGetArticles(String pro_name){
		return dao.jegoDRProductGetArticles(pro_name);
	}
	
	public List<Object> facList(){
		return dao.facList();
	}
	
	public int findNumberIG(){
		return dao.findNumberIG();
	}
	
	public void changoIGBoard(changoIGBoard changoIGBoard){
		dao.changoIGBoard(changoIGBoard);
	}
	
	public void changoIGBoard1(changoIGBoard changoIGBoard){
		dao.changoIGBoard1(changoIGBoard);
	}	

	public void changoIGBoard2(inoutBoard inoutBoard){
		dao.changoIGBoard2(inoutBoard);
	}	
	public void changoIGBoardSequence(){
		dao.changoIGBoardSequence();
	}
	public inoutBoard getArticleboard(int inout_num){
		return dao.getArticleboard(inout_num);
	}
	public List<Object> facNameList(){
		return dao.facNameList();
	}
	public void productSetTotal(int totalStockAmount,String pro_num){
		dao.productSetTotal(totalStockAmount, pro_num);
	}
	public void productSetTotalplus(int totalStockAmount,String pro_num){
		dao.productSetTotalplus(totalStockAmount, pro_num);
	}
	//출고
	public List<Object> getArticlesCG(int startRow,int endRow){
		return dao.getArticlesCG(startRow, endRow);
	}
	
	public List<Object> getArticlesDateCG(String inout_deadline,int startRow,int endRow){
		return dao.getArticlesDateCG(inout_deadline,startRow,endRow);
	}
	
	public List<Object> getArticlesFacNameCG(String inout_sender,int startRow,int endRow){
		return dao.getArticlesFacNameCG(inout_sender,startRow, endRow);
	}
	
	public List<Object> getArticlesDateFacNameCG(String inout_sender,String inout_deadline,int startRow,int endRow){
		return dao.getArticlesDateFacNameCG(inout_sender,inout_deadline,startRow, endRow);
	}
	
	public int getArticleCountCG(){
		return dao.getArticleCountCG();
	}
	
	public int getArticlesDateCountCG(String inout_deadline){
		return dao.getArticlesDateCountCG(inout_deadline);
	}
	
	public int getArticleFacNameCountCG(String fac_name){
		return dao.getArticleFacNameCountCG(fac_name);
	}
	
	public int getArticleDateFacNameCountCG(String inout_sender,String inout_deadline){
		return dao.getArticleDateFacNameCountCG(inout_sender,inout_deadline);
	}
	
	public int findNumberCG(){
		return dao.findNumberCG();
	}
	
	public void changoCGBoard(changoCGBoard changoCGBoard){
		dao.changoCGBoard(changoCGBoard);
	}
	public void changoCGBoard1(changoCGBoard changoCGBoard){
		dao.changoCGBoard1(changoCGBoard);
	}
	public void changoCGBoard2(inoutBoard inoutBoard){
		dao.changoCGBoard2(inoutBoard);
	}
	public List<Object> storeList(){
		return dao.storeList();
	}
	public List<Object> getArticlelistCG(int inout_num){
		return dao.getArticlelistCG(inout_num);
	}
	public int getArticlelistCountCG(int inout_num){
		return dao.getArticlelistCountCG(inout_num);
	}
	public inoutBoard getArticleboardCG(int inout_num){
		return dao.getArticleboardCG(inout_num);
	}
	public List<Object> stNameList(){
		return dao.stNameList();
	}
	
	//재고조회,재고조정
	public List<Object> selectListItems(){
		return dao.selectListItems();
	}
	public List<Object> selectListStores(){
		return dao.selectListStores();
	}
	public List<Object> selectListItemsProNames(String pro_bcategory){
		return dao.selectListItemsProNames(pro_bcategory);
	}
	public List<Object> JHandJJList(){
		return dao.JHandJJList();
	}
	public List<Object> JHandJJListSearch(String pro_name){
		return dao.JHandJJListSearch(pro_name); 
	}
	public int JHandJJListSearchCount(String pro_name){
		return dao.JHandJJListSearchCount(pro_name); 
	}
	public int JHandJJListSearchTotalproperstock(String search){
		return dao.JHandJJListSearchTotalproperstock(search);
	}
	public int JHandJJListSearchTotalStockAmount(String search){
		return dao.JHandJJListSearchTotalStockAmount(search);
	}
	public int JHandJJListSearchTotalStockAmountStore(String search){
		return dao.JHandJJListSearchTotalStockAmountStore(search);
	}
	public List<Object> JHandJJListfummok(String select1){
		return dao.JHandJJListfummok(select1); 
	}
	public int JHandJJListfummokTotalproperstock(String select1){
		return dao.JHandJJListfummokTotalproperstock(select1); 
	}
	public int JHandJJListfummokTotalStockAmount(String select1){
		return dao.JHandJJListfummokTotalStockAmount(select1); 
	}
	public int JHandJJListfummokTotalStockAmountStore(String select1){
		return dao.JHandJJListfummokTotalStockAmountStore(select1); 
	}
	public List<Object> JHandJJListFindOneSelect2(String pro_name){
		return dao.JHandJJListFindOneSelect2(pro_name); 
	}
	public List<Object> JHandJJListStore(){
		return dao.JHandJJListStore(); 
	}
	public int JHandJJListCount(){
		return dao.JHandJJListCount();
	}
	public String JHandJJStockAmount(String pro_num){
		return dao.JHandJJStockAmount(pro_num); 
	}
	public String JHandJJStockAmountStore(String pro_num){
		return dao.JHandJJStockAmountStore(pro_num); 
	}
	public List<Object> JHandJJStockProNum(){
		return dao.JHandJJStockProNum();
	}
	public void updateTotalStockAmount(int totalStockAmount,String pro_num){
		dao.updateTotalStockAmount(totalStockAmount, pro_num);
	}
	public void updateTotalStockAmountStore(int totalStockAmountStore,String pro_num){
		dao.updateTotalStockAmountStore(totalStockAmountStore, pro_num);
	}
	public int totalAppropriate(){
		return dao.totalAppropriate();
	}
	public int countProdcut(){
		return dao.countProdcut();
	}
	public List<Object> productPronumList(){
		return dao.productPronumList();
	}
	public int checkStockPronum(String pro_num){
		return dao.checkStockPronum(pro_num);
	}
	public int findtotalstockamount(String pro_num){
		return dao.findtotalstockamount(pro_num);
	}
	//재고조회
	public List<Object> getStockPronums(String st_id){
		return dao.getStockPronums(st_id);
	}
	
	public List<Object> getStockProstockamounts(String st_id){
		return dao.getStockProstockamounts(st_id);
	}
	
	public int getStIdCount(String st_id){
		return dao.getStIdCount(st_id);
	}
	
	public List<Object> notInProNums(String st_id){
		return dao.notInProNums(st_id);
	}
	
	//재고조정
	public void insertStockModify(String pro_num,int real_stockAmount,int old_stockAmount){
		dao.insertStockModify(pro_num,real_stockAmount,old_stockAmount);
	}
	
	public void insertStockModify2(int mod_number,String pro_num,int real_stockAmount,int old_stockAmount){
		dao.insertStockModify2(mod_number,pro_num,real_stockAmount,old_stockAmount);
	}
	
	public int maxModnumber(){
		return dao.maxModnumber();
	}
	
	public void ModifyBoard(int mod_number,String title){
		dao.ModifyBoard(mod_number,title);
	}
	
	public String findProName(String pro_num){
		return dao.findProName(pro_num);
	}
	
	public int JJListCount(){
		return dao.JJListCount();
	}
	
	public int JJListNameCount(String pro_name){
		return dao.JJListNameCount(pro_name);
	}
	
	public int JJListDateCount(String pro_name,String dateCheck){
		return dao.JJListDateCount(pro_name,dateCheck);
	}
	
	public int JJListNDCount(String pro_name,String dateCheck){
		return dao.JJListNDCount(pro_name,dateCheck);
	}
	
	public List<Object> JJListgetArticles(int startRow,int endRow){
		return dao.JJListgetArticles(startRow,endRow);
	}
	
	public List<Object> JJNameArticles(String pro_num,int startRow,int endRow){
		return dao.JJNameArticles(pro_num,startRow,endRow);
	}
	
	public List<Object> JJDateArticles(String mod_regdate,int startRow,int endRow){
		return dao.JJDateArticles(mod_regdate,startRow,endRow);
	}
	
	public List<Object> JJNDArticles(String pro_name,String mod_regdate,int startRow,int endRow){
		return dao.JJNDArticles(pro_name,mod_regdate,startRow,endRow);
	}
	
	public List<Object> JJListgetContents(int mod_number){
		return dao.JJListgetContents(mod_number);
	}
	
	public int ContentsCount(int mod_number){
		return dao.ContentsCount(mod_number);
	}
	//jegoDR,CGjegoDR 후에, 재고테이블 insert 혹은 재고테이블 update
	public int findPronum(String pro_num){
		return dao.findPronum(pro_num);
	}
	
	public int checkCountStidIG(String st_id,String pro_num){
		return dao.checkCountStidIG(st_id,pro_num);
	}
	
	public int findPronumCG(String pro_num){
		return dao.findPronumCG(pro_num);
	}
	
	public String findst_IdCG(String st_name){
		return dao.findst_IdCG(st_name);
	}
	
	public int checkCountStid(String st_id,String pro_num){
		return dao.checkCountStid(st_id,pro_num);
	}
	
	public void insertStock(Stock stock){
		dao.insertStock(stock);
	}
	
	public void updateStockIG(Stock stock){
		dao.updateStockIG(stock);
	}
	
	public void updateStockCG(Stock stock){
		dao.updateStockCG(stock);
	}
	
	//CGjegoDR에서 st_id 갯수 가져오는 메서드
	public int findstId(String st_name){
		return dao.findstId(st_name);
	}
	
	//jegoJJListJHPro에서 값되돌릴 떄 사용
	public void revertJHList(int old_stockAmount,String pro_num){
		dao.revertJHList(old_stockAmount,pro_num);
	}
	
	public void deleteStock(int mod_number){
		dao.deleteStock(mod_number);
	}
	
	public void deleteStockboard(int mod_number){
		dao.deleteStockboard(mod_number);
	}
	
	//매장 재고조회
	public store StfindName(String st_id){
		return dao.StfindName(st_id);
	}
	

	
	//매장 재고조정
	public List<Object> findNotInsert(String st_id){
		return dao.findNotInsert(st_id);
	}
	
	public void insertSetZero(String st_id,String pro_num){
		dao.insertSetZero(st_id,pro_num);
	}
	
	public void updateStockamount(int pro_stockamount,String st_id,String pro_num){
		dao.updateStockamount(pro_stockamount,st_id,pro_num);
	}
	
	public List<Object> updateChangoAmount(int totalStockAmountStore,int actuality,String pro_num){
		return dao.updateChangoAmount(totalStockAmountStore,actuality,pro_num);
	}
	

}
