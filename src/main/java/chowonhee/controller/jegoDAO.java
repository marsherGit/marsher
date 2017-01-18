package chowonhee.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Controller;
import chowonhee.DTO.*;

public class jegoDAO extends SqlSessionDaoSupport { // sql세션팩토링 주입받으면
														// SqlSessionDaoSupport
														// 사용가능
	//입고
	public int findNumberIG(){
		return getSqlSession().selectOne("cho.findNumberIG");
	}
	
	public void changoIGBoard(changoIGBoard changoIGBoard) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("inout_name", changoIGBoard.getInout_name());
		map.put("pro_num", changoIGBoard.getPro_num());
		map.put("pro_count", changoIGBoard.getPro_count());
		map.put("inout_sender", changoIGBoard.getInout_sender());
		map.put("inout_receiver", changoIGBoard.getInout_receiver());
		map.put("inout_note", changoIGBoard.getInout_note());
		
		getSqlSession().insert("cho.changoIGBoard", map);
		
	}
	
	public void changoIGBoard1(changoIGBoard changoIGBoard) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("inout_num", changoIGBoard.getInout_num());
		map.put("inout_name", changoIGBoard.getInout_name());
		map.put("pro_num", changoIGBoard.getPro_num());
		map.put("pro_count", changoIGBoard.getPro_count());
		map.put("inout_sender", changoIGBoard.getInout_sender());
		map.put("inout_receiver", changoIGBoard.getInout_receiver());
		map.put("inout_note", changoIGBoard.getInout_note());
		
		getSqlSession().insert("cho.changoIGBoard1", map);
		
	}	

	public void changoIGBoard2(inoutBoard inoutBoard) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("inout_num", inoutBoard.getInout_num());
		map.put("inout_name", inoutBoard.getInout_name());
		map.put("inout_sender", inoutBoard.getInout_sender());
		map.put("inout_receiver", inoutBoard.getInout_receiver());
		map.put("inout_note", inoutBoard.getInout_note());
		map.put("total", inoutBoard.getTotal());
		getSqlSession().insert("cho.changoIGBoard2", map);
		
	}	
	
	public void changoIGBoardSequence(){
		getSqlSession().insert("cho.changoIGBoardSequence");
	}
	
	public List<Object> getArticles(int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticles",map);
		return getArticles;
	}

	public List<Object> getArticlesDate(String inout_deadline,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_deadline", inout_deadline);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticlesDate",map);
		return getArticles;
	}
	
	public List<Object> getArticlesFacName(String inout_sender,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_sender", inout_sender);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticlesFacName",map);
		return getArticles;
	}
	
	public List<Object> getArticlesDateFacName(String inout_sender,String inout_deadline,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_sender", inout_sender);
		map.put("inout_deadline", inout_deadline);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticlesDateFacName",map);
		return getArticles;
	}
	
	public List<Object> getArticlelist(int inout_num){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("inout_num", inout_num);
		List<Object> getArticlelist = getSqlSession().selectList("cho.getArticlelist", map);
		return getArticlelist;
	}
	
	public int getArticlelistCount(int inout_num){
		int count = getSqlSession().selectOne("cho.getArticlelistCount",inout_num);
		return count;
	}
	
	public inoutBoard getArticleboard(int inout_num){
		return getSqlSession().selectOne("cho.getArticleboard",inout_num);
	}
	
	public int getArticleCount() {
		int count = getSqlSession().selectOne("cho.getArticleCount",Integer.class); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public int getArticlesDateCount(String inout_deadline) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_deadline",inout_deadline);
		int count = getSqlSession().selectOne("cho.getArticlesDateCount",map); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public int getArticleFacNameCount(String inout_sender) {
		int count = getSqlSession().selectOne("cho.getArticleFacNameCount",inout_sender); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public int getArticleDateFacNameCount(String inout_sender,String inout_deadline) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_sender", inout_sender);
		map.put("inout_deadline", inout_deadline);
		int count = getSqlSession().selectOne("cho.getArticleDateFacNameCount",map); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public List<Object> jegoDRProductGetArticle(){
		return getSqlSession().selectList("cho.jegoDRProductGetArticle");
	}
	
	public Product jegoDRProductGetArticles(String pro_name){
		//Map<String,String> map = new HashMap<String,String>();
		//map.put("pro_num", pro_num);
		return getSqlSession().selectOne("cho.jegoDRProductGetArticles",pro_name);
	}

	public List<Object> facList(){
		return getSqlSession().selectList("cho.facList");
	}
	public List<Object> facNameList(){
		return getSqlSession().selectList("cho.facNameList");
	}
	
	public void productSetTotal(int totalStockAmount,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalStockAmount", totalStockAmount);
		map.put("pro_num", pro_num);
		getSqlSession().update("cho.productSetTotal",map);
	}
	
	public void productSetTotalplus(int totalStockAmount,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalStockAmount", totalStockAmount);
		map.put("pro_num", pro_num);
		getSqlSession().update("cho.productSetTotalplus",map);
	}
	//출고
	public List<Object> getArticlesCG(int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticlesCG",map);
		return getArticles;
	}
	
	public List<Object> getArticlesDateCG(String inout_deadline,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_deadline", inout_deadline);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticlesDateCG",map);
		return getArticles;
	}
	
	public List<Object> getArticlesFacNameCG(String inout_receiver,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_receiver", inout_receiver);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticlesFacNameCG",map);
		return getArticles;
	}
	
	public List<Object> getArticlesDateFacNameCG(String inout_receiver,String inout_deadline,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_receiver", inout_receiver);
		map.put("inout_deadline", inout_deadline);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getArticles = getSqlSession().selectList("cho.getArticlesDateFacNameCG",map);
		return getArticles;
	}
	
	public int findNumberCG(){
		return getSqlSession().selectOne("cho.findNumberCG");
	}
	
	public int getArticleCountCG() {
		int count = getSqlSession().selectOne("cho.getArticleCountCG",Integer.class); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public int getArticlesDateCountCG(String inout_deadline) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_deadline",inout_deadline);
		int count = getSqlSession().selectOne("cho.getArticlesDateCountCG",map); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public int getArticleFacNameCountCG(String inout_receiver) {
		int count = getSqlSession().selectOne("cho.getArticleFacNameCountCG",inout_receiver); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public int getArticleDateFacNameCountCG(String inout_receiver,String inout_deadline) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inout_receiver", inout_receiver);
		map.put("inout_deadline", inout_deadline);
		int count = getSqlSession().selectOne("cho.getArticleDateFacNameCountCG",map); //cityMapper 매퍼파일 안에있는 쿼리문 실행
		return count;
	}
	
	public void changoCGBoard(changoCGBoard changoCGBoard) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("inout_name", changoCGBoard.getInout_name());
		map.put("pro_num", changoCGBoard.getPro_num());
		map.put("pro_count", changoCGBoard.getPro_count());
		map.put("inout_sender", changoCGBoard.getInout_sender());
		map.put("inout_receiver", changoCGBoard.getInout_receiver());
		map.put("inout_note", changoCGBoard.getInout_note());
		
		getSqlSession().insert("cho.changoCGBoard", map);
		
	}
	
	public void changoCGBoard1(changoCGBoard changoCGBoard) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("inout_num", changoCGBoard.getInout_num());
		map.put("inout_name", changoCGBoard.getInout_name());
		map.put("pro_num", changoCGBoard.getPro_num());
		map.put("pro_count", changoCGBoard.getPro_count());
		map.put("inout_sender", changoCGBoard.getInout_sender());
		map.put("inout_receiver", changoCGBoard.getInout_receiver());
		map.put("inout_note", changoCGBoard.getInout_note());
		
		getSqlSession().insert("cho.changoCGBoard1", map);
		
	}	

	public void changoCGBoard2(inoutBoard inoutBoard) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("inout_num", inoutBoard.getInout_num());
		map.put("inout_name", inoutBoard.getInout_name());
		map.put("inout_sender", inoutBoard.getInout_sender());
		map.put("inout_receiver", inoutBoard.getInout_receiver());
		map.put("inout_note", inoutBoard.getInout_note());
		map.put("total", inoutBoard.getTotal());
		getSqlSession().insert("cho.changoCGBoard2", map);
		
	}	
	
	public List<Object> storeList(){
		return getSqlSession().selectList("cho.storeList");
	}
	
	public List<Object> getArticlelistCG(int inout_num){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("inout_num", inout_num);
		List<Object> getArticlelist = getSqlSession().selectList("cho.getArticlelistCG", map);
		return getArticlelist;
	}
	
	public int getArticlelistCountCG(int inout_num){
		int count = getSqlSession().selectOne("cho.getArticlelistCountCG",inout_num);
		return count;
	}
	
	public inoutBoard getArticleboardCG(int inout_num){
		return getSqlSession().selectOne("cho.getArticleboardCG",inout_num);
	}	
	
	public List<Object> stNameList(){
		return getSqlSession().selectList("cho.stNameList");
	}
	//재고조회,재고조정
	public List<Object> selectListItems(){
		return getSqlSession().selectList("cho.selectListItems");
	}
	
	public List<Object> selectListStores(){
		return getSqlSession().selectList("cho.selectListStores");
	}
	
	public List<Object> selectListItemsProNames(String pro_bcategory){
		return getSqlSession().selectList("cho.selectListItemsProNames",pro_bcategory);
	}
	
	public List<Object> JHandJJList(){
		return getSqlSession().selectList("cho.JHandJJList"); 
	}
	
	public List<Object> JHandJJListSearch(String pro_name){
		return getSqlSession().selectList("cho.JHandJJListSearch",pro_name); 
	}
	
	public int JHandJJListSearchCount(String pro_name){
		return getSqlSession().selectOne("cho.JHandJJListSearchCount",pro_name); 
	}
	
	public int JHandJJListSearchTotalproperstock(String search){
		return getSqlSession().selectOne("cho.JHandJJListSearchTotalproperstock",search);
	}
	public int JHandJJListSearchTotalStockAmount(String search){
		return getSqlSession().selectOne("cho.JHandJJListSearchTotalStockAmount",search);
	}
	public int JHandJJListSearchTotalStockAmountStore(String search){
		return getSqlSession().selectOne("cho.JHandJJListSearchTotalStockAmountStore",search);
	}
	public List<Object> JHandJJListfummok(String select1){
		return getSqlSession().selectList("cho.JHandJJListfummok",select1); 
	}
	
	public int JHandJJListfummokTotalproperstock(String select1){
		return getSqlSession().selectOne("cho.JHandJJListfummokTotalproperstock",select1); 
	}
	
	public int JHandJJListfummokTotalStockAmount(String select1){
		return getSqlSession().selectOne("cho.JHandJJListfummokTotalStockAmount",select1); 
	}
	
	public int JHandJJListfummokTotalStockAmountStore(String select1){
		return getSqlSession().selectOne("cho.JHandJJListfummokTotalStockAmountStore",select1); 
	}
	
	public List<Object> JHandJJListFindOneSelect2(String pro_name){
		return getSqlSession().selectList("cho.JHandJJListFindOneSelect2",pro_name); 
	}
	
	public List<Object> JHandJJListStore(){
		return getSqlSession().selectList("cho.JHandJJListStore"); 
	}
	
	public int JHandJJListCount(){
		return getSqlSession().selectOne("cho.JHandJJListCount");
	}
	
	public String JHandJJStockAmount(String pro_num){
		return getSqlSession().selectOne("cho.JHandJJStockAmount",pro_num); 
	}
	
	public String JHandJJStockAmountStore(String pro_num){
		return getSqlSession().selectOne("cho.JHandJJStockAmountStore",pro_num); 
	}
	
	public List<Object> JHandJJStockProNum(){
		return getSqlSession().selectList("cho.JHandJJStockProNum");
	}
	
	public void updateTotalStockAmount(int totalStockAmount,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalStockAmount",totalStockAmount);
		map.put("pro_num", pro_num);
		getSqlSession().update("cho.updateTotalStockAmount",map);
	}
	
	public void updateTotalStockAmountStore(int totalStockAmountStore,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalStockAmountStore",totalStockAmountStore);
		map.put("pro_num", pro_num);
		getSqlSession().update("cho.updateTotalStockAmountStore",map);
	}
	
	public int totalAppropriate(){
		return getSqlSession().selectOne("cho.totalAppropriate");
	}
	
	public int countProdcut(){
		return getSqlSession().selectOne("cho.countProdcut");
	}
	
	public List<Object> productPronumList(){
		return getSqlSession().selectList("cho.productPronumList");
	}
	
	public int checkStockPronum(String pro_num){
		return getSqlSession().selectOne("cho.checkStockPronum",pro_num);
	}
	
	public int findtotalstockamount(String pro_num){
		return getSqlSession().selectOne("cho.findtotalstockamount",pro_num);
	}
	//재고조회
	public List<Object> getStockPronums(String st_id){
		return getSqlSession().selectList("cho.getStockPronums",st_id);
	}
	
	public List<Object> getStockProstockamounts(String st_id){
		return getSqlSession().selectList("cho.getStockProstockamounts",st_id);
	}
	
	public int getStIdCount(String st_id){
		return getSqlSession().selectOne("cho.getStIdCount",st_id);
	}
	
	public List<Object> notInProNums(String st_id){
		return getSqlSession().selectList("cho.notInProNums",st_id);
	}
	
	//재고조정
	public void insertStockModify(String pro_num,int real_stockAmount,int old_stockAmount){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_num", pro_num);
		map.put("real_stockAmount", real_stockAmount);
		map.put("old_stockAmount", old_stockAmount);
		getSqlSession().update("cho.insertStockModify",map);
	}
	
	public void insertStockModify2(int mod_number,String pro_num,int real_stockAmount,int old_stockAmount){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mod_number", mod_number);
		map.put("pro_num", pro_num);
		map.put("real_stockAmount", real_stockAmount);
		map.put("old_stockAmount", old_stockAmount);
		getSqlSession().update("cho.insertStockModify2",map);
	}
	
	public int maxModnumber(){
		return getSqlSession().selectOne("cho.maxModnumber");
	}
	
	public void ModifyBoard(int mod_number,String title){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mod_number", mod_number);
		map.put("title", title);
		getSqlSession().update("cho.ModifyBoard",map);
	}
	
	public String findProName(String pro_num){
		return getSqlSession().selectOne("cho.findProName",pro_num);
	}
	
	public int JJListCount(){
		return getSqlSession().selectOne("cho.JJListCount");
	}
	
	public int JJListNameCount(String pro_name){
		return getSqlSession().selectOne("cho.JJListNameCount",pro_name);
	}
	
	public int JJListDateCount(String pro_name,String mod_regdate){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_name", pro_name);
		map.put("mod_regdate", mod_regdate);
		return getSqlSession().selectOne("cho.JJListDateCount",map);
	}
	
	public int JJListNDCount(String pro_name,String mod_regdate){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_name", pro_name);
		map.put("mod_regdate", mod_regdate);
		return getSqlSession().selectOne("cho.JJListNDCount",map);
	}
	
	public List<Object> JJListgetArticles(int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return getSqlSession().selectList("cho.JJListgetArticles",map);
	}
	
	public List<Object> JJNameArticles(String pro_name,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_name", pro_name);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return getSqlSession().selectList("cho.JJNameArticles",map);
	}
	
	public List<Object> JJDateArticles(String mod_regdate,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mod_regdate",mod_regdate );
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return getSqlSession().selectList("cho.JJDateArticles",map);
	}
	
	public List<Object> JJNDArticles(String pro_name,String mod_regdate,int startRow,int endRow){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_name", pro_name);
		map.put("mod_regdate", mod_regdate);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return getSqlSession().selectList("cho.JJNDArticles",map);
	}
	
	public List<Object> JJListgetContents(int mod_number){
		return getSqlSession().selectList("cho.JJListgetContents", mod_number);
	}
	
	public int ContentsCount(int mod_number){
		return getSqlSession().selectOne("cho.ContentsCount",mod_number);
	}
	
	//jegoDR,CGjegoDR 후에, 재고테이블 insert 혹은 재고테이블 update
	public int findPronum(String pro_num){
		return getSqlSession().selectOne("cho.findPronum",pro_num);
	}
	
	public int checkCountStidIG(String st_id,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("st_id", st_id);
		map.put("pro_num", pro_num);
		return getSqlSession().selectOne("cho.checkCountStidIG",map);
	}
	
	
	public int findPronumCG(String pro_num){
		return getSqlSession().selectOne("cho.findPronumCG",pro_num);
	}
	
	public String findst_IdCG(String st_name){
		return getSqlSession().selectOne("cho.findst_IdCG",st_name);
	}
	
	public int checkCountStid(String st_id,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("st_id", st_id);
		map.put("pro_num", pro_num);
		return getSqlSession().selectOne("cho.checkCountStid",map);
	}
	
	public void insertStock(Stock stock){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("st_id",stock.getSt_id());
		map.put("pro_num", stock.getPro_num());
		map.put("pro_stockamount", stock.getPro_stockAmount());
		map.put("pro_remark", stock.getPro_remark());
		
		getSqlSession().insert("cho.insertStock",map);
	}
	
	public void updateStockIG(Stock stock){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_stockamount", stock.getPro_stockAmount());
		map.put("st_id", stock.getSt_id());
		map.put("pro_num",stock.getPro_num());
		map.put("pro_remark",stock.getPro_remark());
		getSqlSession().insert("cho.updateStockIG",map);
	}
	
	public void updateStockCG(Stock stock){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_stockamount", stock.getPro_stockAmount());
		map.put("st_id", stock.getSt_id());
		map.put("pro_num",stock.getPro_num());
		getSqlSession().insert("cho.updateStockCG",map);
	}
	
	//CGjegoDR에서 store name비교하는 메서드
	public int findstId(String st_name){
		return getSqlSession().selectOne("cho.findstId",st_name);
	}
	

	//jegoJJListJHPro.jsp
	public void revertJHList(int old_stockAmount,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("totalstockamount", old_stockAmount);
		map.put("pro_num", pro_num);
		
		getSqlSession().update("cho.revertJHList",map);
	}
	
	public void deleteStock(int mod_number){
		getSqlSession().delete("cho.deleteStock",mod_number);
	}
	
	public void deleteStockboard(int mod_number){
		getSqlSession().delete("cho.deleteStockboard",mod_number);
	}
	
	//매장 재고조회
	public store StfindName(String st_id){
		
		return getSqlSession().selectOne("cho.StfindName",st_id);
	}
	
	//매장 재고조정
	public List<Object> findNotInsert(String st_id){
		return getSqlSession().selectList("cho.findNotInsert",st_id);
	}
	
	public void insertSetZero(String st_id,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("st_id", st_id);
		map.put("pro_num", pro_num);
		getSqlSession().selectOne("cho.insertSetZero",map);
	}
	
	public void updateStockamount(int pro_stockamount,String st_id,String pro_num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_stockamount",pro_stockamount);
		map.put("st_id",st_id);
		map.put("pro_num",pro_num);
		getSqlSession().selectOne("cho.updateStockamount",map);
	}
	
	public List<Object> updateChangoAmount(int totalStockAmountStore,int actuality,String pro_num){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("totalStockAmountStore", totalStockAmountStore);
		map.put("actuality", actuality);
		map.put("pro_num", pro_num);
		return getSqlSession().selectList("cho.updateChangoAmount",map);
	}

}