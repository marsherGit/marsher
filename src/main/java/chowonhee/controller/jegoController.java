package chowonhee.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;
import org.springframework.web.servlet.ModelAndView;

import chowonhee.DTO.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class jegoController {
	@Autowired
	private jegoService service; // CityServiceImpl객체를 받아온다. CityService
									// interface이므로

	public void setService(jegoService service) {
		this.service = service;
	}

	//입고
	@RequestMapping(value = "/chowonheeView/changgoIGList")
	public String changgoIGList(String pageNum,String fac_name,String dateCheck,Model model,HttpServletRequest request) throws Throwable {
		System.out.println("/changgoIGList.do요청");
		
		String logintype =(String) request.getSession().getAttribute("logintype");
		System.out.println(logintype);
		
		if(logintype.equals("store")){
			return "AccessError";
		}
		
		String st_id = (String) request.getSession().getAttribute("memId");
		System.out.println("st_id:"+st_id);
		if (pageNum == null) {
			pageNum = "1";
		}
		if (fac_name == null) {
			fac_name = "공장선택";
		}
		
		if ((dateCheck == null)||(dateCheck == "")) {
			System.out.println("데이트체크");
			dateCheck = "";
		}else{   
		String year=dateCheck.substring(2, 4);
		String month=dateCheck.substring(5, 7);
		String day=dateCheck.substring(8, 10);
		dateCheck=year+"/"+month+"/"+day;
		System.out.println("dateCheck : " + dateCheck);
		}
		
		System.out.println(fac_name);
		int pageSize = 5;// 한 페이지의 글의 개수
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
		int count = 0;
		int number = 0;

		List articleList = null;
		
		if(((fac_name.equals("공장선택")||fac_name.equals("전체")))){
			System.out.println("체크체크");
			if(dateCheck==""){
				count = service.getArticleCount();
				System.out.println("체크체크2");
					if (count > 0) {
						articleList = service.getArticles(startRow, endRow);// 현재 페이지에 해당하는	
						System.out.println("체크체크");
					} else {
						articleList = Collections.EMPTY_LIST;
						System.out.println("체크체크");
					}
			}
			else{
				count = service.getArticlesDateCount(dateCheck);
				System.out.println("count : " + count);
				if (count > 0) {
					articleList = service.getArticlesDate(dateCheck,startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
				} else {
					articleList = Collections.EMPTY_LIST;
				}
			}
		}
		else{
			if(dateCheck==""){
				count = service.getArticleFacNameCount(fac_name);
			
				if (count > 0) {
					articleList = service.getArticlesFacName(fac_name,startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
				} else {
					articleList = Collections.EMPTY_LIST;
				}
			}
			else{
				count = service.getArticleDateFacNameCount(fac_name, dateCheck);
				
				if (count > 0) {
					articleList = service.getArticlesDateFacName(fac_name,dateCheck,startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
				} else {
					articleList = Collections.EMPTY_LIST;
				}
			}
		}
		
		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		
		List<Object> facNameList = new ArrayList<Object>();
		facNameList = service.facNameList();
		// 해당 뷰에서 사용할 속성
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("articleList", articleList);
		model.addAttribute("facNameList", facNameList);
		
		return "changgoIGList";// 해당 뷰
		
	}
	
	
	@RequestMapping(value = "/chowonheeView/IGjegoJH")
	public String IGjegoJH(@RequestParam("num") int num, String pageNum, Model model) throws Throwable {
		System.out.println("/IGjegoJH.do요청");
		int number = service.getArticlelistCount(num);
		System.out.println(number);
		List articleList = null;
		articleList = service.getArticlelist(num);// 해당 글번호에 대한 해당 레코드

		System.out.println("IGjegoJH");
		inoutBoard inoutBoard = new inoutBoard();
		inoutBoard = service.getArticleboard(num);
		
		System.out.println(inoutBoard.getInout_receiver());
		System.out.println(inoutBoard.getInout_sender());
		System.out.println("inoutBoard.getDeadline():"+inoutBoard.getInout_deadline());
		System.out.println("IGjegoJH");
		// 해당 뷰에서 사용할 속성
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("articleList", articleList);
		model.addAttribute("inoutBoard", inoutBoard);
		
		return "IGjegoJH";// 해당 뷰
	}
	
	@RequestMapping(value = "/chowonheeView/jegoDR")
	public String jegoDR(Model model) throws Throwable {
		List articleList = null;
		List changoList = null;
		
		articleList = service.jegoDRProductGetArticle();
		changoList = service.facList();		
		
		model.addAttribute("articleList", articleList);
		model.addAttribute("changoList",changoList);
	
		
		return "jegoDR"; // 해당 뷰
	}
	
	@RequestMapping(value = "/chowonheeView/ajax/jegoDR", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public void jegoDR(HttpServletResponse resp,String pro_name) throws Exception {
		Product articleLists = null;
		articleLists = service.jegoDRProductGetArticles(pro_name);
		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", articleLists); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
		//jso.put("다른이름",list) 가능
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
		
		System.out.println("articleLists="+articleLists);

		String data = jso.toString();
		System.out.println(data);
	}   //리스폰스에다가 데이터값 쏴준다.
	

	
	@RequestMapping(value = "/chowonheeView/ajax/jegoDR1", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public void jegoDR1(HttpServletResponse resp,String pro_count) throws Exception {

		int total = 0;
		total = Integer.parseInt(pro_count);
		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", total); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
		//jso.put("다른이름",list) 가능
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
		
		System.out.println("total="+total);

		String data = jso.toString();
		System.out.println(data);
	}   //리스폰스에다가 데이터값 쏴준다.
	
	@Transactional
	@RequestMapping(value = "/chowonheeView/jegoDRPro")
	public String jegoDRPro(String[] pro_num,String[] pro_name,String[] pro_container,int[] pro_volume,
			int[] pro_count,String[] pro_remark,String fac_name,String comment,int total,Model model) throws Throwable {
		
		System.out.println(pro_remark[0]);
		changoIGBoard[] changoIGBoard=new changoIGBoard[pro_name.length];
		inoutBoard inoutBoard=new inoutBoard();
		
		for(int i=0;i<pro_name.length;i++){
			changoIGBoard[i]=new changoIGBoard();
		}
		
		for(int i=0;i<pro_name.length;i++){
			
			System.out.println("pro_num : "+pro_num[i]);
			System.out.println("pro_name : "+pro_name[i]);
			System.out.println("pro_container : "+pro_container[i]);
			System.out.println("pro_volume : "+pro_volume[i]);
			System.out.println("pro_count : "+pro_count[i]);
			
			System.out.println("pro_name.length : "+pro_name.length);
			System.out.println("comment : "+comment);
		}
		
		int number=0;
		for(int i=0;i<pro_name.length;i++){
			if(pro_name.length==1){
					
				if(pro_count[i]!=0){
			
					changoIGBoard[i].setInout_name(pro_name[i]+" 창고입고");	
					changoIGBoard[i].setPro_num(pro_num[i]);
					changoIGBoard[i].setPro_count(pro_count[i]);
					changoIGBoard[i].setInout_sender(fac_name);
					changoIGBoard[i].setInout_receiver("창고");
					changoIGBoard[i].setInout_note(comment);
					
					service.changoIGBoard(changoIGBoard[i]);
					number = service.findNumberIG();
						
					inoutBoard.setInout_num(number);
					inoutBoard.setInout_name(changoIGBoard[i].getInout_name());
					inoutBoard.setInout_sender(changoIGBoard[i].getInout_sender());
					inoutBoard.setInout_receiver("창고");
					inoutBoard.setInout_note(changoIGBoard[i].getInout_note());	
					inoutBoard.setTotal(total);
					break;
				}
			}
			else{	
					if(i==0){
						changoIGBoard[i].setInout_name(pro_name[i]+" 외 "+ (pro_name.length-1) +"개 창고입고");	
						changoIGBoard[i].setPro_num(pro_num[i]);
						changoIGBoard[i].setPro_count(pro_count[i]);
						changoIGBoard[i].setInout_sender(fac_name);
						changoIGBoard[i].setInout_receiver("창고");
						changoIGBoard[i].setInout_note(comment);
						
						service.changoIGBoard(changoIGBoard[i]);	
						number = service.findNumberIG();
					}
					else{
						changoIGBoard[i].setInout_num(number);
						changoIGBoard[i].setInout_name(pro_name[0]+" 외 "+ (pro_name.length-1) +"개 창고입고");	
						changoIGBoard[i].setPro_num(pro_num[i]);
						changoIGBoard[i].setPro_count(pro_count[i]);
						changoIGBoard[i].setInout_sender(fac_name);
						changoIGBoard[i].setInout_receiver("창고");
						changoIGBoard[i].setInout_note(comment);
																
						service.changoIGBoard1(changoIGBoard[i]);
					}	
					
					if(i==(pro_name.length-1)){
						inoutBoard.setInout_num(number);
						inoutBoard.setInout_name(changoIGBoard[i].getInout_name());
						inoutBoard.setInout_sender(changoIGBoard[i].getInout_sender());
						inoutBoard.setInout_receiver("창고");
						inoutBoard.setInout_note(changoIGBoard[i].getInout_note());	
						inoutBoard.setTotal(total);
					}
			}	
		}
		
		for(int i=0;i<pro_name.length;i++){	
			int count = service.findPronum(pro_num[i]);
			int checkCountStidIG = service.checkCountStidIG("admin",pro_num[i]);
			
			if((count==0)||(checkCountStidIG==0)){
					Stock Stock = new Stock();
					Stock.setSt_id("admin");
					Stock.setPro_num(pro_num[i]);
					Stock.setPro_stockAmount(pro_count[i]);
					Stock.setPro_remark(pro_remark[i]);
					service.insertStock(Stock);
					service.productSetTotal(pro_count[i],pro_num[i]);
			}
			else{
				Stock Stock = new Stock();
			
				Stock.setPro_stockAmount(pro_count[i]);
				Stock.setSt_id("admin");
				Stock.setPro_num(pro_num[i]);
				Stock.setPro_remark(pro_remark[i]);
				service.updateStockIG(Stock);
				service.productSetTotalplus(pro_count[i],pro_num[i]);
			}
		}
		
		service.changoIGBoard2(inoutBoard);

		
		
		System.out.println("fac_name : "+fac_name);
		System.out.println("comment : "+comment);
		return "jegoDRPro"; // 해당 뷰
	}
	
	//출고
	@RequestMapping(value = "/chowonheeView/changgoCGList")
	public String changgoCGList(String pageNum,String st_name,String dateCheck,Model model,HttpServletRequest request) throws Throwable {
		System.out.println("/changgoCGList.do요청");

		String logintype =(String) request.getSession().getAttribute("logintype");
		System.out.println(logintype);
		
		if(logintype.equals("store")){
			return "AccessError1";
		}
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		if (st_name == null) {
			st_name = "매장선택";
		}
		
		if ((dateCheck == null)||(dateCheck == "")) {
			System.out.println("데이트체크");
			dateCheck = "";
		}else{   
		String year=dateCheck.substring(2, 4);
		String month=dateCheck.substring(5, 7);
		String day=dateCheck.substring(8, 10);
		dateCheck=year+"/"+month+"/"+day;
		System.out.println("dateCheck : " + dateCheck);
		}
		
		int pageSize = 5;// 한 페이지의 글의 개수
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
		int count = 0;
		int number = 0;

		List articleList = null;
		
		if(((st_name.equals("매장선택")||st_name.equals("전체")))){
			if(dateCheck==""){
				count = service.getArticleCountCG();
		
				if (count > 0) {
					articleList = service.getArticlesCG(startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
				} else {
					articleList = Collections.EMPTY_LIST;
				}
			}else{
				count = service.getArticlesDateCountCG(dateCheck);
				System.out.println("count : " + count);
				if (count > 0) {
					articleList = service.getArticlesDateCG(dateCheck,startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
				} else {
					articleList = Collections.EMPTY_LIST;
				}
			}
		}else{
			if(dateCheck==""){
				count = service.getArticleFacNameCountCG(st_name);
				System.out.println("헬로우!!"+count);
				if (count > 0) {
					articleList = service.getArticlesFacNameCG(st_name,startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
				} else {
					articleList = Collections.EMPTY_LIST;
				}
			}
			else{
				count = service.getArticleDateFacNameCountCG(st_name, dateCheck);
				
				if (count > 0) {
					articleList = service.getArticlesDateFacNameCG(st_name,dateCheck,startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
				} else {
					articleList = Collections.EMPTY_LIST;
				}
			}
		}
		
		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		
		List<Object> stNameList = new ArrayList<Object>();
		stNameList = service.stNameList();
		// 해당 뷰에서 사용할 속성
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("articleList", articleList);
		model.addAttribute("stNameList", stNameList);
		
		return "changgoCGList";// 해당 뷰
		
	}
	
	
	@RequestMapping(value = "/chowonheeView/CGjegoDR")
	public String CGjegoDR(Model model) throws Throwable {
		List articleList = null;
		List storeList = null;	
		
		articleList = service.jegoDRProductGetArticle();
		storeList = service.storeList();		
		
		model.addAttribute("articleList", articleList);
		model.addAttribute("storeList",storeList);
	
		
		return "CGjegoDR"; // 해당 뷰
	}
	
	@RequestMapping(value = "/chowonheeView/ajax/CGjegoDR", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public void CGjegoDR(HttpServletResponse resp,String pro_name) throws Exception {
		Product articleLists = null;
		articleLists = service.jegoDRProductGetArticles(pro_name);
		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", articleLists); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
		//jso.put("다른이름",list) 가능
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
		
		System.out.println("articleLists="+articleLists);

		String data = jso.toString();
		System.out.println(data);
	}   //리스폰스에다가 데이터값 쏴준다.
	

	
	@RequestMapping(value = "/chowonheeView/ajax/CGjegoDR1", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public void CGjegoDR1(HttpServletResponse resp,String pro_count) throws Exception {

		int total = 0;
		total = Integer.parseInt(pro_count);
		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", total); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
		//jso.put("다른이름",list) 가능
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
		
		System.out.println("total="+total);

		String data = jso.toString();
		System.out.println(data);
	}   //리스폰스에다가 데이터값 쏴준다.
	
	
	@RequestMapping(value = "/chowonheeView/CGjegoDRPro")
	public String CGjegoDRPro(String[] pro_num,String[] pro_name,String[] pro_container,int[] pro_volume,
			int[] pro_count,String st_name,String comment,int total,HttpServletResponse response,Model model) throws Throwable {
		
		changoCGBoard[] changoCGBoard=new changoCGBoard[pro_name.length];
		inoutBoard inoutBoard=new inoutBoard();
		
		for(int i=0;i<pro_name.length;i++){
			changoCGBoard[i]=new changoCGBoard();
		}
		
		for(int i=0;i<pro_name.length;i++){
			
			System.out.println("pro_num : "+pro_num[i]);
			System.out.println("pro_name : "+pro_name[i]);
			System.out.println("pro_container : "+pro_container[i]);
			System.out.println("pro_volume : "+pro_volume[i]);
			System.out.println("pro_count : "+pro_count[i]);
			
			System.out.println("pro_name.length : "+pro_name.length);
			System.out.println("comment : "+comment);
		}
		int number=0;
		for(int i=0;i<pro_name.length;i++){
			
			if(pro_name.length==1){
				if(pro_count[i]!=0){
			
					changoCGBoard[i].setInout_name(pro_name[i]+" 창고출고");	
					changoCGBoard[i].setPro_num(pro_num[i]);
					changoCGBoard[i].setPro_count(pro_count[i]);
					changoCGBoard[i].setInout_sender("창고");
					changoCGBoard[i].setInout_receiver(st_name);
					changoCGBoard[i].setInout_note(comment);

					service.changoCGBoard(changoCGBoard[i]);

					number = service.findNumberCG();
					System.out.println("체크2");
					inoutBoard.setInout_num(number);
					inoutBoard.setInout_name(changoCGBoard[i].getInout_name());
					inoutBoard.setInout_sender("창고");
					inoutBoard.setInout_receiver(changoCGBoard[i].getInout_receiver());
					inoutBoard.setInout_note(changoCGBoard[i].getInout_note());	
					inoutBoard.setTotal(total);
					break;
				}
			}
			else{
					if(i==0){
						changoCGBoard[i].setInout_name(pro_name[i]+" 외 "+ (pro_name.length-1) +"개 창고출고");	
						changoCGBoard[i].setPro_num(pro_num[i]);
						changoCGBoard[i].setPro_count(pro_count[i]);
						changoCGBoard[i].setInout_sender("창고");
						changoCGBoard[i].setInout_receiver(st_name);
						changoCGBoard[i].setInout_note(comment);
						
						service.changoCGBoard(changoCGBoard[i]);
						number = service.findNumberCG();
					}
					else{
						changoCGBoard[i].setInout_num(number);
						changoCGBoard[i].setInout_name(pro_name[0]+" 외 "+ (pro_name.length-1) +"개 창고출고");	
						changoCGBoard[i].setPro_num(pro_num[i]);
						changoCGBoard[i].setPro_count(pro_count[i]);
						changoCGBoard[i].setInout_sender("창고");
						changoCGBoard[i].setInout_receiver(st_name);
						changoCGBoard[i].setInout_note(comment);
										
						service.changoCGBoard1(changoCGBoard[i]);
					}	
					
					if(i==(pro_name.length-1)){
						inoutBoard.setInout_num(number);
						inoutBoard.setInout_name(changoCGBoard[i].getInout_name());
						inoutBoard.setInout_sender("창고");
						inoutBoard.setInout_receiver(changoCGBoard[i].getInout_receiver());
						inoutBoard.setInout_note(changoCGBoard[i].getInout_note());	
						inoutBoard.setTotal(total);
					}
			}	
		}
		
		List<Object> notPro_num = new ArrayList<Object>();

		for(int i=0;i<pro_name.length;i++){	
			if(pro_count[i]>service.findtotalstockamount(pro_num[i])){
				notPro_num.add(pro_name[i]);
			}
				
		}
		
		for(int i=0;i<service.countProdcut();i++){	
			List<Object> productPronumList = service.productPronumList();
			
			if(service.checkStockPronum((String) productPronumList.get(i))==0){
					Stock Stock = new Stock();
					Stock.setSt_id("admin");
					Stock.setPro_num((String) productPronumList.get(i));
					Stock.setPro_stockAmount(0);
					Stock.setPro_remark("없음");
					service.insertStock(Stock);
			}
		}
		
		
		
		for(int i=0;i<pro_name.length;i++){	
			if(pro_count[i]>service.findtotalstockamount(pro_num[i])){
				model.addAttribute("notPro_num", notPro_num);
				return "CGerror";
			}
			else{
				Stock[] Stock = new Stock[2];
				for(int j=0;j<2;j++){
					Stock[j] = new Stock();
				}
				
				Stock[0].setPro_stockAmount(-pro_count[i]);
				Stock[0].setSt_id("admin");
				Stock[0].setPro_num(pro_num[i]);
				service.updateStockCG(Stock[0]);
				service.productSetTotalplus(-pro_count[i],pro_num[i]);
				
				int checkPronumCG = service.findPronumCG(pro_num[i]);
				String findst_IdCG = service.findst_IdCG(st_name);
				int checkCountStid = service.checkCountStid(findst_IdCG,pro_num[i]);
				
				
				if((checkPronumCG==0)||(checkCountStid==0)){
					Stock[1].setSt_id(findst_IdCG);
					Stock[1].setPro_num(pro_num[i]);
					Stock[1].setPro_stockAmount(pro_count[i]);
					Stock[1].setPro_remark("zxcvbnmMNBVCXZ");
					service.insertStock(Stock[1]);
		
				}
				else{
					Stock[1].setPro_stockAmount(pro_count[i]);
					Stock[1].setSt_id(findst_IdCG);
					Stock[1].setPro_num(pro_num[i]);
					service.updateStockCG(Stock[1]);
				}	

			}
		}
		
		service.changoCGBoard2(inoutBoard);
		
		System.out.println("comment : "+comment);
		
		return "CGjegoDRPro"; // 해당 뷰
	}
	
	
	@RequestMapping(value = "/chowonheeView/CGjegoJH")
	public String CGjegoJH(@RequestParam("num") int num, String pageNum, Model model) throws Throwable {
		System.out.println("/jegoJH.do요청");
		int number = service.getArticlelistCountCG(num);
		System.out.println(number);
		List articleList = null;
		articleList = service.getArticlelistCG(num);// 해당 글번호에 대한 해당 레코드

		System.out.println("jegoJH");
		inoutBoard inoutBoard = new inoutBoard();
		inoutBoard = service.getArticleboardCG(num);
		System.out.println("jegoJH");
		// 해당 뷰에서 사용할 속성
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("articleList", articleList);
		model.addAttribute("inoutBoard", inoutBoard);
		
		return "CGjegoJH";// 해당 뷰
	}
	
	
	//재고조회
	@RequestMapping(value = "/chowonheeView/jegoJH")
	public String jegoJH(String select1,String select2,String search,String st_id, Model model,HttpServletRequest request) throws Throwable {
		System.out.println("/jegoJH.do요청");
		
		String logintype =(String) request.getSession().getAttribute("logintype");
		System.out.println(logintype);
		
		if(logintype.equals("store")){
			return "AccessError2";
		}
		
		String st_idSave = st_id;
		System.out.println("st_idSave : "+st_idSave);
		if(select1==null){
			select1="품목선택";
		}
		if(select2==null){
			select2="제품명선택";
		}
		if((search=="")||(search==null)){
			search="제품명입력";
		}
		System.out.println("select1 : "+select1+"||select2 : "+select2+"||search : "+search);
		
		for(int i=0;i<service.countProdcut();i++){	
			List<Object> productPronumList = service.productPronumList();
			
			if(service.checkStockPronum((String) productPronumList.get(i))==0){
					Stock Stock = new Stock();
					Stock.setSt_id("admin");
					Stock.setPro_num((String) productPronumList.get(i));
					Stock.setPro_stockAmount(0);
					Stock.setPro_remark("없음");
					service.insertStock(Stock);
			}
		}
				
		int totalchango = 0;
		int totalstore = 0;
		int totalappropriate = service.totalAppropriate();
		
		int[] JHandJJStockAmount = new int[service.JHandJJListCount()];
		List<Object> JHandJJStockProNum = service.JHandJJStockProNum();
		
		for(int i=0;i<service.JHandJJListCount();i++){
			if(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i))!=null){
				JHandJJStockAmount[i]=Integer.parseInt(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i)));
/*				service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
				service.JHandJJList();
				totalchango+=JHandJJStockAmount[i];
			}
			else{
			    JHandJJStockAmount[i]=0;
/*			    service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
			}
		}
			
		if((st_id==null)||(st_id.equals("전체매장"))){
			st_id = "전체매장";
			
		int number = 0;
		
		number=service.JHandJJListCount();
		List<Object> selectListStores = new ArrayList<Object>();
		selectListStores = service.selectListStores();
		List<Object> selectListItems = new ArrayList<Object>();
		selectListItems = service.selectListItems();
		
		for(int j=0;j<service.JHandJJListCount();j++){
			if(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))!=null){
				service.updateTotalStockAmountStore(Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))),(String) JHandJJStockProNum.get(j));
				totalstore+=Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j)));
			}
			else{
			    JHandJJStockAmount[j]=0;
			    service.updateTotalStockAmountStore(JHandJJStockAmount[j], (String) JHandJJStockProNum.get(j));
			}
		}
		
		List JHandJJList = new ArrayList();
		if(((select1.equals("전체")||select1.equals("품목선택")))){
			System.out.println("전체,품목선택 선택");
			JHandJJList = service.JHandJJList();
			model.addAttribute("JHandJJList",JHandJJList);
			request.getSession().setAttribute("excel", JHandJJList);
		}
		else{
			if(!select2.equals("제품명선택")){
				System.out.println("제품명선택");
				JHandJJList = service.JHandJJListFindOneSelect2(select2);
				
				ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
				ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
				
				totalstore=ProductPlusRemark.getTotalStockAmountStore();
				totalchango=ProductPlusRemark.getTotalStockAmount();
				totalappropriate=ProductPlusRemark.getPro_properStock();
				model.addAttribute("JHandJJList",JHandJJList);
				request.getSession().setAttribute("excel", JHandJJList);
			}
			else{
			JHandJJList = service.JHandJJListfummok(select1);
			
			totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
			totalchango=service.JHandJJListfummokTotalStockAmount(select1);
			totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
			
			model.addAttribute("JHandJJList",JHandJJList);
			request.getSession().setAttribute("excel", JHandJJList);
			}
		}
		if(!search.equals("제품명입력")){
			System.out.println("제품명입력 체크");
			JHandJJList = service.JHandJJListSearch(search);
			int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
			if(JHandJJListSearchCount==0){
				System.out.println("체크2");
				totalstore=0;
				totalchango=0;
				totalappropriate=0;
			}
			else{
			totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
			totalchango=service.JHandJJListSearchTotalStockAmount(search);
			totalappropriate=service.JHandJJListSearchTotalproperstock(search);
			}
			model.addAttribute("JHandJJList",JHandJJList);
			request.getSession().setAttribute("excel", JHandJJList);
		}
		
		model.addAttribute("number",number);
		model.addAttribute("selectListStores",selectListStores);
		model.addAttribute("selectListItems",selectListItems);
		model.addAttribute("st_id",st_id);
		model.addAttribute("totalstore", new Integer(totalstore));
		
		}
		else{
			totalstore=0;
			int number = 0;
			number=service.JHandJJListCount();
			
			List getStockPronums = new ArrayList();
			getStockPronums = service.getStockPronums(st_id);
			
			List getStockProstockamounts = new ArrayList();
			getStockProstockamounts = service.getStockProstockamounts(st_id);
		
			List notInProNum = new ArrayList();
			notInProNum =service.notInProNums(st_id);
			
			List selectListStores = new ArrayList();
			selectListStores = service.selectListStores();
			List selectListItems = new ArrayList();
			selectListItems = service.selectListItems();
			
			
			int getStIdCount = 0;
			getStIdCount = service.getStIdCount(st_id);
			
			
			System.out.println("getStIdCount : "+getStIdCount);
			
			int total=0;
			for(int i=0;i<getStIdCount;i++){
				total=(int) getStockProstockamounts.get(i);
				service.updateTotalStockAmountStore(total,(String) getStockPronums.get(i));
				totalstore+=total;
			}
			
			for(int i=0;i<(service.JHandJJListCount()-getStIdCount);i++){
				service.updateTotalStockAmountStore(0,(String) notInProNum.get(i));	
			}
			
			List JHandJJList = new ArrayList();
			if(((select1.equals("전체")||select1.equals("품목선택")))){
				System.out.println("전체,품목선택 선택");
				JHandJJList = service.JHandJJList();
				model.addAttribute("JHandJJList",JHandJJList);
				request.getSession().setAttribute("excel", JHandJJList);
			}
			else{
				if(!select2.equals("제품명선택")){
					System.out.println("제품명선택");
					JHandJJList = service.JHandJJListFindOneSelect2(select2);
					
					ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
					ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
					
					totalstore=ProductPlusRemark.getTotalStockAmountStore();
					totalchango=ProductPlusRemark.getTotalStockAmount();
					totalappropriate=ProductPlusRemark.getPro_properStock();
					model.addAttribute("JHandJJList",JHandJJList);
					request.getSession().setAttribute("excel", JHandJJList);
				}
				else{
				JHandJJList = service.JHandJJListfummok(select1);
				
				totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
				totalchango=service.JHandJJListfummokTotalStockAmount(select1);
				totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
				
				model.addAttribute("JHandJJList",JHandJJList);
				request.getSession().setAttribute("excel", JHandJJList);
				}
			}
			if(!search.equals("제품명입력")){
				System.out.println("제품명입력 체크");
				JHandJJList = service.JHandJJListSearch(search);
				int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
				if(JHandJJListSearchCount==0){
					System.out.println("체크2");
					totalstore=0;
					totalchango=0;
					totalappropriate=0;
				}
				else{
				totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
				totalchango=service.JHandJJListSearchTotalStockAmount(search);
				totalappropriate=service.JHandJJListSearchTotalproperstock(search);
				}
				model.addAttribute("JHandJJList",JHandJJList);
				request.getSession().setAttribute("excel", JHandJJList);
			}
				
			model.addAttribute("number",number);
			model.addAttribute("selectListStores",selectListStores);
			model.addAttribute("selectListItems",selectListItems);
			model.addAttribute("JHandJJList",JHandJJList);
			model.addAttribute("st_id",st_id);
			model.addAttribute("totalstore", new Integer(totalstore));
		}	
		
		
		
		model.addAttribute("totalchango", new Integer(totalchango));
		model.addAttribute("totalappropriate", new Integer(totalappropriate));
		
		
		return "jegoJH";// 해당 뷰
	}
	
	@RequestMapping(value = "/chowonheeView/ajax/jegoJH1", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public void jegoJH1(HttpServletResponse resp,String pro_bcategory) throws Exception {
		List articleLists = new ArrayList();
		articleLists = service.selectListItemsProNames(pro_bcategory);
		System.out.println("/ajax/jegoJH1.do 요청");
	
		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", articleLists);

		// jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
		//jso.put("다른이름",list) 가능
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
		
		System.out.println("articleLists="+articleLists);

		String data = jso.toString();
		System.out.println(data);
	}   //리스폰스에다가 데이터값 쏴준다.
	
	
	
		//재고조정
		@RequestMapping(value = "/chowonheeView/jegoJJ")
		public String jegoJJ(String select1,String select2,String search,String st_id,Model model,HttpServletRequest request) throws Throwable {
			System.out.println("/jegoJJ.do요청");
			
			String logintype =(String) request.getSession().getAttribute("logintype");
			System.out.println(logintype);
			
			if(logintype.equals("store")){
				return "AccessError3";
			}
			
			String st_idSave = st_id;
			System.out.println("st_idSave : "+st_idSave);
			if(select1==null){
				select1="품목선택";
			}
			if(select2==null){
				select2="제품명선택";
			}
			if((search=="")||(search==null)){
				search="제품명입력";
			}
			
			for(int i=0;i<service.countProdcut();i++){	
				List<Object> productPronumList = service.productPronumList();
				
				if(service.checkStockPronum((String) productPronumList.get(i))==0){
						Stock Stock = new Stock();
						Stock.setSt_id("admin");
						Stock.setPro_num((String) productPronumList.get(i));
						Stock.setPro_stockAmount(0);
						Stock.setPro_remark("없음");
						service.insertStock(Stock);
				}
			}
					
			int totalchango = 0;
			int totalstore = 0;
			int totalappropriate = service.totalAppropriate();
			
			int[] JHandJJStockAmount = new int[service.JHandJJListCount()];
			List<Object> JHandJJStockProNum = service.JHandJJStockProNum();
			
			for(int i=0;i<service.JHandJJListCount();i++){
				if(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i))!=null){
					
					JHandJJStockAmount[i]=Integer.parseInt(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i)));
/*					service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
					service.JHandJJList();
					totalchango+=JHandJJStockAmount[i];
				}
				else{
				    JHandJJStockAmount[i]=0;
/*				    service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
				}
			}
				
			if((st_id==null)||(st_id.equals("전체매장"))){
				st_id = "전체매장";
				
			int number = 0;
			
			number=service.JHandJJListCount();
			List<Object> selectListStores = new ArrayList<Object>();
			selectListStores = service.selectListStores();
			List<Object> selectListItems = new ArrayList<Object>();
			selectListItems = service.selectListItems();
			
			for(int j=0;j<service.JHandJJListCount();j++){
				if(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))!=null){
					service.updateTotalStockAmountStore(Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))),(String) JHandJJStockProNum.get(j));
					totalstore+=Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j)));
				}
				else{
				    JHandJJStockAmount[j]=0;
				    service.updateTotalStockAmountStore(JHandJJStockAmount[j], (String) JHandJJStockProNum.get(j));
				}
			}
			
			List JHandJJList = new ArrayList();
			if(((select1.equals("전체")||select1.equals("품목선택")))){
				System.out.println("전체,품목선택 선택");
				JHandJJList = service.JHandJJList();
				model.addAttribute("JHandJJList",JHandJJList);
			}
			else{
				if(!select2.equals("제품명선택")){
					System.out.println("제품명선택");
					JHandJJList = service.JHandJJListFindOneSelect2(select2);
					
					ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
					ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
					
					totalstore=ProductPlusRemark.getTotalStockAmountStore();
					totalchango=ProductPlusRemark.getTotalStockAmount();
					totalappropriate=ProductPlusRemark.getPro_properStock();
					model.addAttribute("JHandJJList",JHandJJList);
				}
				else{
				JHandJJList = service.JHandJJListfummok(select1);
				
				totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
				totalchango=service.JHandJJListfummokTotalStockAmount(select1);
				totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
				
				model.addAttribute("JHandJJList",JHandJJList);
				}
			}
			if(!search.equals("제품명입력")){
				System.out.println("제품명입력 체크");
				JHandJJList = service.JHandJJListSearch(search);
				int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
				if(JHandJJListSearchCount==0){
					System.out.println("체크2");
					totalstore=0;
					totalchango=0;
					totalappropriate=0;
				}
				else{
				totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
				totalchango=service.JHandJJListSearchTotalStockAmount(search);
				totalappropriate=service.JHandJJListSearchTotalproperstock(search);
				}
				model.addAttribute("JHandJJList",JHandJJList);
			}
			
			model.addAttribute("number",number);
			model.addAttribute("selectListStores",selectListStores);
			model.addAttribute("selectListItems",selectListItems);
			model.addAttribute("st_id",st_id);
			model.addAttribute("totalstore", new Integer(totalstore));
			
			}
			else{
				totalstore=0;
				int number = 0;
				number=service.JHandJJListCount();
				
				List getStockPronums = new ArrayList();
				getStockPronums = service.getStockPronums(st_id);
				
				List getStockProstockamounts = new ArrayList();
				getStockProstockamounts = service.getStockProstockamounts(st_id);
			
				List notInProNum = new ArrayList();
				notInProNum =service.notInProNums(st_id);
				
				List selectListStores = new ArrayList();
				selectListStores = service.selectListStores();
				List selectListItems = new ArrayList();
				selectListItems = service.selectListItems();
				
				
				int getStIdCount = 0;
				getStIdCount = service.getStIdCount(st_id);
				
				
				System.out.println("getStIdCount : "+getStIdCount);
				
				int total=0;
				for(int i=0;i<getStIdCount;i++){
					total=(int) getStockProstockamounts.get(i);
					service.updateTotalStockAmountStore(total,(String) getStockPronums.get(i));
					totalstore+=total;
				}
				
				for(int i=0;i<(service.JHandJJListCount()-getStIdCount);i++){
					service.updateTotalStockAmountStore(0,(String) notInProNum.get(i));	
				}
				
				List JHandJJList = new ArrayList();
				if(((select1.equals("전체")||select1.equals("품목선택")))){
					System.out.println("전체,품목선택 선택");
					JHandJJList = service.JHandJJList();
					model.addAttribute("JHandJJList",JHandJJList);
				}
				else{
					if(!select2.equals("제품명선택")){
						System.out.println("제품명선택");
						JHandJJList = service.JHandJJListFindOneSelect2(select2);
						
						ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
						ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
						
						totalstore=ProductPlusRemark.getTotalStockAmountStore();
						totalchango=ProductPlusRemark.getTotalStockAmount();
						totalappropriate=ProductPlusRemark.getPro_properStock();
						model.addAttribute("JHandJJList",JHandJJList);
					}
					else{
					JHandJJList = service.JHandJJListfummok(select1);
					
					totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
					totalchango=service.JHandJJListfummokTotalStockAmount(select1);
					totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
					
					model.addAttribute("JHandJJList",JHandJJList);
					}
				}
				if(!search.equals("제품명입력")){
					System.out.println("제품명입력 체크");
					JHandJJList = service.JHandJJListSearch(search);
					int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
					if(JHandJJListSearchCount==0){
						System.out.println("체크2");
						totalstore=0;
						totalchango=0;
						totalappropriate=0;
					}
					else{
					totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
					totalchango=service.JHandJJListSearchTotalStockAmount(search);
					totalappropriate=service.JHandJJListSearchTotalproperstock(search);
					}
					model.addAttribute("JHandJJList",JHandJJList);
				}
					
				model.addAttribute("number",number);
				model.addAttribute("selectListStores",selectListStores);
				model.addAttribute("selectListItems",selectListItems);
				model.addAttribute("JHandJJList",JHandJJList);
				model.addAttribute("st_id",st_id);
				model.addAttribute("totalstore", new Integer(totalstore));
			}	
			
			
			
			model.addAttribute("totalchango", new Integer(totalchango));
			model.addAttribute("totalappropriate", new Integer(totalappropriate));
			
			
			return "jegoJJ";// 해당 뷰
		}
		
		@RequestMapping(value = "/chowonheeView/jegoJJPro")
		public String jegoJJPro(String[] actuality,String[] pro_num,int[] totalStockAmount,Model model) throws Throwable {
			for(int i=0;i<actuality.length;i++){
				if(actuality[i]==""){
					actuality[i]="실사재고입력하지않음";
				}
				System.out.println(actuality[i]);
			}
			String title = "";
			int count = 0;
			boolean check = true;
			for(int i=0;i<actuality.length;i++){
				if(actuality[i]!="실사재고입력하지않음"){
					if(check){
						service.insertStockModify(pro_num[i], Integer.parseInt(actuality[i]), totalStockAmount[i]);
						service.updateStockamount(Integer.parseInt(actuality[i]),"admin",pro_num[i]);
						title += service.findProName(pro_num[i])+",";
						check = false;
					}else{
						service.insertStockModify2(service.maxModnumber(),pro_num[i], Integer.parseInt(actuality[i]), totalStockAmount[i]);
						service.updateStockamount(Integer.parseInt(actuality[i]),"admin",pro_num[i]);
						title += service.findProName(pro_num[i])+",";
						count++;
					}
					service.updateTotalStockAmount(Integer.parseInt(actuality[i]),pro_num[i]);
				}
				if(i==actuality.length-1){
					if(title.length()>0){
						title = title.substring(0, title.length()-1);
						title += " 창고재고 변경";
						service.ModifyBoard(service.maxModnumber(), title);
					}
				}
			}

			
			return "jegoJJPro";
		}
		
		@RequestMapping(value = "/chowonheeView/ajax/jegoJJ1", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
		@ResponseBody
		public void jegoJJ1(HttpServletResponse resp,String pro_bcategory) throws Exception {
			List articleLists = new ArrayList();
			articleLists = service.selectListItemsProNames(pro_bcategory);
			System.out.println("/ajax/jegoJJ1.do 요청");
		
			JSONObject jso = new JSONObject(); // JASON 객체생성
			jso.put("data", articleLists);

			// jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
			//jso.put("다른이름",list) 가능
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
			out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
			
			System.out.println("articleLists="+articleLists);

			String data = jso.toString();
			System.out.println(data);
		}   //리스폰스에다가 데이터값 쏴준다.
	
		
		@RequestMapping(value = "/chowonheeView/jegoJJList")
		public String jegoJJList(String pageNum,String select1,String select2,String search,String dateCheck,Model model) throws Throwable {

			System.out.println("/jegoJJList.do요청");

			if(select1 == null){
				select1 = "전체";
			}
			
			if(select2 == null){
				select2 = "제품명선택";
			}
			
			if(search == null){
			   search = "";	
			}

			if ((dateCheck == null)||(dateCheck == "")) {
				System.out.println("데이트체크");
				dateCheck = "";
			}else{   
			String year=dateCheck.substring(2, 4);
			String month=dateCheck.substring(5, 7);
			String day=dateCheck.substring(8, 10);
			dateCheck=year+"/"+month+"/"+day;
			System.out.println("dateCheck : " + dateCheck);
			}
			
			System.out.println(select1+"와"+select2);
			if (pageNum == null) {
				pageNum = "1";
			}
			int pageSize = 5;// 한 페이지의 글의 개수
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호
			int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
			int count = 0;
			int number = 0;

			List articleList = null;

			if((select1.equals("전체"))){
				System.out.println("체크");
				if(search.equals("")){
					if(dateCheck==""){
						count = service.JJListCount();
						if (count > 0) {
							articleList = service.JJListgetArticles(startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}
					else{
						count = service.JJListDateCount("",dateCheck);
						System.out.println("count:"+count);
						System.out.println(dateCheck);
						if (count > 0) {
							articleList = service.JJDateArticles(dateCheck,startRow, endRow);// 현재 페이지에 해당하는													// 글 목록
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}
				}
				else{
					if(dateCheck==""){
						count = service.JJListNameCount(search);
						System.out.println("체크1");
						if (count > 0) {
							articleList = service.JJNameArticles(search, startRow, endRow);	
							System.out.println("체크2");
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}
					else{
						count = service.JJListNDCount(search,dateCheck);
						System.out.println("체크1");
						if (count > 0) {
							articleList = service.JJNDArticles(search,dateCheck, startRow, endRow);	
							System.out.println("체크2");
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}
				}
			}
			else{
				if(search.equals("")){
					if(dateCheck==""){
						count = service.JJListNameCount(select2);
						System.out.println("체크1");
						if (count > 0) {
							articleList = service.JJNameArticles(select2, startRow, endRow);	
							System.out.println("체크2");
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}else{
						count = service.JJListNDCount(select2,dateCheck);
						System.out.println("체크1");
						if (count > 0) {
							articleList = service.JJNDArticles(select2,dateCheck, startRow, endRow);	
							System.out.println("체크2");
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}
				}
				else{
					if(dateCheck==""){
						count = service.JJListNameCount(search);
						System.out.println("체크1");
						if (count > 0) {
							articleList = service.JJNameArticles(search, startRow, endRow);	
							System.out.println("체크2");
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}
					else{
						count = service.JJListNDCount(search,dateCheck);
						System.out.println("체크1");
						if (count > 0) {
							articleList = service.JJNDArticles(search,dateCheck, startRow, endRow);	
							System.out.println("체크2");
						} else {
							articleList = Collections.EMPTY_LIST;
						}
					}
				}
				
			}

			number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
			
			List<Object> selectListItems = new ArrayList<Object>();
			selectListItems = service.selectListItems();
			// 해당 뷰에서 사용할 속성
			model.addAttribute("currentPage", new Integer(currentPage));
			model.addAttribute("startRow", new Integer(startRow));
			model.addAttribute("endRow", new Integer(endRow));
			model.addAttribute("count", new Integer(count));
			model.addAttribute("pageSize", new Integer(pageSize));
			model.addAttribute("number", new Integer(number));
			model.addAttribute("articleList", articleList);
			model.addAttribute("selectListItems", selectListItems);
			return "jegoJJList";
		}	
		
		@RequestMapping(value = "/chowonheeView/jegoJJListJH")
		public String jegoJJListJH(int num,String pageNum,Model model) throws Throwable {
		
			System.out.println("num:"+num);
			System.out.println("/jegoJJListJH.do요청");

			int number = 0;
			number = service.ContentsCount(num);
			List<Object> JJListgetContents = new ArrayList<Object>();
			JJListgetContents = service.JJListgetContents(num);
			
			model.addAttribute("number", number);
			model.addAttribute(pageNum, new Integer(pageNum));
			model.addAttribute("JJListgetContents", JJListgetContents);
			model.addAttribute("index",new Integer(num));
			
			return "jegoJJListJH";
		}	
		
		@RequestMapping(value = "/chowonheeView/jegoJJListJHPro")
		public String jegoJJListJHPro(int num,int[] old_stockAmount,String[] pro_num,Model model) throws Throwable {
		
			System.out.println("/jegoJJListJHPro.do요청");

			System.out.println(num);
			
			for(int i=0;i<pro_num.length;i++){
				service.revertJHList(old_stockAmount[i],pro_num[i]);
			}
			service.deleteStock(num);
			System.out.println("체크");
			service.deleteStockboard(num);
			System.out.println("체크");
			return "jegoJJListJHPro";
		}
		
		
		@RequestMapping(value = "/chowonheeView/ajax/jegoJJListJH1", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
		@ResponseBody
		public void jegoJJListJH1(HttpServletResponse resp,String pro_bcategory) throws Exception {
			List articleLists = new ArrayList();
			articleLists = service.selectListItemsProNames(pro_bcategory);
			System.out.println("/ajax/jegoJJ1.do 요청");
		
			JSONObject jso = new JSONObject(); // JASON 객체생성
			jso.put("data", articleLists);

			// jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
			//jso.put("다른이름",list) 가능
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
			out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
			
			System.out.println("articleLists="+articleLists);

			String data = jso.toString();
			System.out.println(data);
		}   //리스폰스에다가 데이터값 쏴준다.
		
		
		/*-----------------------------------------------------------------------------------------*/
		//재고조회
		@RequestMapping(value = "/chowonheeView/StjegoJH")
		public String StjegoJH(String select1,String select2,String search, Model model,HttpServletRequest request) throws Throwable {
			System.out.println("/jegoJH.do요청");
			
			String logintype =(String) request.getSession().getAttribute("logintype");
			System.out.println(logintype);
			
			if(logintype.equals("admin")){
				List<Object> JHandJJList = new ArrayList<Object>();
				store store = new store();
				store.setSt_name("관리자");
				String st_id="admin";
				int totalstore=0;
				int totalchango=0;
				int totalappropriate=0;
				
				model.addAttribute("JHandJJList",JHandJJList);
				model.addAttribute("selectListStores",store);
				model.addAttribute("st_id", new String(st_id));
				model.addAttribute("totalstore", new Integer(totalstore));
				model.addAttribute("totalchango", new Integer(totalchango));
				model.addAttribute("totalappropriate", new Integer(totalappropriate));
				return "StjegoJH";
			}
			
			String st_id = (String) request.getSession().getAttribute("memId");
			System.out.println("st_id:"+st_id);
			
			if(select1==null){
				select1="품목선택";
			}
			if(select2==null){
				select2="제품명선택";
			}
			if((search=="")||(search==null)){
				search="제품명입력";
			}
			System.out.println("select1 : "+select1+"||select2 : "+select2+"||search : "+search);
			
			for(int i=0;i<service.countProdcut();i++){	
				List<Object> productPronumList = service.productPronumList();
				
				if(service.checkStockPronum((String) productPronumList.get(i))==0){
						Stock Stock = new Stock();
						Stock.setSt_id("admin");
						Stock.setPro_num((String) productPronumList.get(i));
						Stock.setPro_stockAmount(0);
						Stock.setPro_remark("없음");
						service.insertStock(Stock);
				}
			}
					
			int totalchango = 0;
			int totalstore = 0;
			int totalappropriate = service.totalAppropriate();
			
			int[] JHandJJStockAmount = new int[service.JHandJJListCount()];
			List<Object> JHandJJStockProNum = service.JHandJJStockProNum();
			
			for(int i=0;i<service.JHandJJListCount();i++){
				if(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i))!=null){
					JHandJJStockAmount[i]=Integer.parseInt(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i)));
	/*				service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
					service.JHandJJList();
					totalchango+=JHandJJStockAmount[i];
				}
				else{
				    JHandJJStockAmount[i]=0;
	/*			    service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
				}
			}
				
			if((st_id==null)||(st_id.equals("전체매장"))){
				st_id = "전체매장";
				
			int number = 0;
			
			number=service.JHandJJListCount();
			store selectListStores = null;
			selectListStores = (store) service.StfindName(st_id);
			List<Object> selectListItems = new ArrayList<Object>();
			selectListItems = service.selectListItems();
			
			for(int j=0;j<service.JHandJJListCount();j++){
				if(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))!=null){
					service.updateTotalStockAmountStore(Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))),(String) JHandJJStockProNum.get(j));
					totalstore+=Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j)));
				}
				else{
				    JHandJJStockAmount[j]=0;
				    service.updateTotalStockAmountStore(JHandJJStockAmount[j], (String) JHandJJStockProNum.get(j));
				}
			}
			
			List JHandJJList = new ArrayList();
			if(((select1.equals("전체")||select1.equals("품목선택")))){
				System.out.println("전체,품목선택 선택");
				JHandJJList = service.JHandJJList();
				model.addAttribute("JHandJJList",JHandJJList);
				request.getSession().setAttribute("excel", JHandJJList);
			}
			else{
				if(!select2.equals("제품명선택")){
					System.out.println("제품명선택");
					JHandJJList = service.JHandJJListFindOneSelect2(select2);
					
					ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
					ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
					
					totalstore=ProductPlusRemark.getTotalStockAmountStore();
					totalchango=ProductPlusRemark.getTotalStockAmount();
					totalappropriate=ProductPlusRemark.getPro_properStock();
					model.addAttribute("JHandJJList",JHandJJList);
					request.getSession().setAttribute("excel", JHandJJList);
				}
				else{
				JHandJJList = service.JHandJJListfummok(select1);
				
				totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
				totalchango=service.JHandJJListfummokTotalStockAmount(select1);
				totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
				
				model.addAttribute("JHandJJList",JHandJJList);
				request.getSession().setAttribute("excel", JHandJJList);
				}
			}
			if(!search.equals("제품명입력")){
				System.out.println("제품명입력 체크");
				JHandJJList = service.JHandJJListSearch(search);
				int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
				if(JHandJJListSearchCount==0){
					System.out.println("체크2");
					totalstore=0;
					totalchango=0;
					totalappropriate=0;
				}
				else{
				totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
				totalchango=service.JHandJJListSearchTotalStockAmount(search);
				totalappropriate=service.JHandJJListSearchTotalproperstock(search);
				}
				model.addAttribute("JHandJJList",JHandJJList);
				request.getSession().setAttribute("excel", JHandJJList);
			}
			
			model.addAttribute("number",number);
			model.addAttribute("selectListStores",selectListStores);
			model.addAttribute("selectListItems",selectListItems);
			model.addAttribute("st_id",st_id);
			model.addAttribute("totalstore", new Integer(totalstore));
			
			}
			else{
				totalstore=0;
				int number = 0;
				number=service.JHandJJListCount();
				
				List getStockPronums = new ArrayList();
				getStockPronums = service.getStockPronums(st_id);
				
				List getStockProstockamounts = new ArrayList();
				getStockProstockamounts = service.getStockProstockamounts(st_id);
			
				List notInProNum = new ArrayList();
				notInProNum =service.notInProNums(st_id);
				
				store selectListStores = null;
				selectListStores = (store) service.StfindName(st_id);
				List selectListItems = new ArrayList();
				selectListItems = service.selectListItems();
				
				
				int getStIdCount = 0;
				getStIdCount = service.getStIdCount(st_id);
				
				
				System.out.println("getStIdCount : "+getStIdCount);
				
				int total=0;
				for(int i=0;i<getStIdCount;i++){
					total=(int) getStockProstockamounts.get(i);
					service.updateTotalStockAmountStore(total,(String) getStockPronums.get(i));
					totalstore+=total;
				}
				
				for(int i=0;i<(service.JHandJJListCount()-getStIdCount);i++){
					service.updateTotalStockAmountStore(0,(String) notInProNum.get(i));	
				}
				
				List JHandJJList = new ArrayList();
				if(((select1.equals("전체")||select1.equals("품목선택")))){
					System.out.println("전체,품목선택 선택");
					JHandJJList = service.JHandJJList();
					model.addAttribute("JHandJJList",JHandJJList);
					request.getSession().setAttribute("excel", JHandJJList);
				}
				else{
					if(!select2.equals("제품명선택")){
						System.out.println("제품명선택");
						JHandJJList = service.JHandJJListFindOneSelect2(select2);
						
						ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
						ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
						
						totalstore=ProductPlusRemark.getTotalStockAmountStore();
						totalchango=ProductPlusRemark.getTotalStockAmount();
						totalappropriate=ProductPlusRemark.getPro_properStock();
						model.addAttribute("JHandJJList",JHandJJList);
						request.getSession().setAttribute("excel", JHandJJList);
					}
					else{
					JHandJJList = service.JHandJJListfummok(select1);
					
					totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
					totalchango=service.JHandJJListfummokTotalStockAmount(select1);
					totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
					
					model.addAttribute("JHandJJList",JHandJJList);
					request.getSession().setAttribute("excel", JHandJJList);
					}
				}
				if(!search.equals("제품명입력")){
					System.out.println("제품명입력 체크");
					JHandJJList = service.JHandJJListSearch(search);
					int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
					if(JHandJJListSearchCount==0){
						System.out.println("체크2");
						totalstore=0;
						totalchango=0;
						totalappropriate=0;
					}
					else{
					totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
					totalchango=service.JHandJJListSearchTotalStockAmount(search);
					totalappropriate=service.JHandJJListSearchTotalproperstock(search);
					}
					model.addAttribute("JHandJJList",JHandJJList);
					request.getSession().setAttribute("excel", JHandJJList);
				}
					
				model.addAttribute("number",number);
				model.addAttribute("selectListStores",selectListStores);
				model.addAttribute("selectListItems",selectListItems);
				model.addAttribute("JHandJJList",JHandJJList);
				model.addAttribute("st_id",st_id);
				model.addAttribute("totalstore", new Integer(totalstore));
			}	
			
			
			
			model.addAttribute("totalchango", new Integer(totalchango));
			model.addAttribute("totalappropriate", new Integer(totalappropriate));
			
			
			return "StjegoJH";// 해당 뷰
		}
		
		@RequestMapping(value = "/chowonheeView/ajax/StjegoJH1", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
		@ResponseBody
		public void StjegoJH1(HttpServletResponse resp,String pro_bcategory) throws Exception {
			List articleLists = new ArrayList();
			articleLists = service.selectListItemsProNames(pro_bcategory);
			System.out.println("/ajax/jegoJH1.do 요청");
		
			JSONObject jso = new JSONObject(); // JASON 객체생성
			jso.put("data", articleLists);

			// jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
			//jso.put("다른이름",list) 가능
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
			out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
			
			System.out.println("articleLists="+articleLists);

			String data = jso.toString();
			System.out.println(data);
		}   //리스폰스에다가 데이터값 쏴준다.
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////
		/*매장 재고조정*/
		//재고조정
		@RequestMapping(value = "/chowonheeView/StjegoJJ")
		public String StjegoJJ(String select1,String select2,String search,Model model,HttpServletRequest request) throws Throwable {
			System.out.println("/StjegoJJ.do요청");
			
			String logintype =(String) request.getSession().getAttribute("logintype");
			System.out.println(logintype);
			
			if(logintype.equals("admin")){
				List<Object> JHandJJList = new ArrayList<Object>();
				store store = new store();
				store.setSt_name("관리자");
				model.addAttribute("JHandJJList",JHandJJList);
				model.addAttribute("selectListStores",store);
				return "StjegoJJ";
			}
			
			String st_id = (String) request.getSession().getAttribute("memId");
			
			if(select1==null){
				select1="품목선택";
			}
			if(select2==null){
				select2="제품명선택";
			}
			if((search=="")||(search==null)){
				search="제품명입력";
			}
			
			
			List<Object> findNotInsert = new ArrayList<Object>();
			findNotInsert = service.findNotInsert(st_id);
			
			for(int i=0;i<findNotInsert.size();i++){
				service.insertSetZero(st_id,(String) findNotInsert.get(i));
			}
			
			
			
			for(int i=0;i<service.countProdcut();i++){	
				List<Object> productPronumList = service.productPronumList();
				
				if(service.checkStockPronum((String) productPronumList.get(i))==0){
						Stock Stock = new Stock();
						Stock.setSt_id("admin");
						Stock.setPro_num((String) productPronumList.get(i));
						Stock.setPro_stockAmount(0);
						Stock.setPro_remark("없음");
						service.insertStock(Stock);
				}	
			}
				
			
			int totalchango = 0;
			int totalstore = 0;
			int totalappropriate = service.totalAppropriate();
			
			int[] JHandJJStockAmount = new int[service.JHandJJListCount()];
			List<Object> JHandJJStockProNum = service.JHandJJStockProNum();
			
			for(int i=0;i<service.JHandJJListCount();i++){
				if(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i))!=null){
					
					JHandJJStockAmount[i]=Integer.parseInt(service.JHandJJStockAmount((String) JHandJJStockProNum.get(i)));
/*					service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
					service.JHandJJList();
					totalchango+=JHandJJStockAmount[i];
				}
				else{
				    JHandJJStockAmount[i]=0;
/*				    service.updateTotalStockAmount(JHandJJStockAmount[i], (String) JHandJJStockProNum.get(i));*/
				}
			}
				
			if((st_id==null)||(st_id.equals("전체매장"))){
				st_id = "전체매장";
				
			int number = 0;
			
			number=service.JHandJJListCount();
			store selectListStores = null;
			selectListStores = (store) service.StfindName(st_id);
			List<Object> selectListItems = new ArrayList<Object>();
			selectListItems = service.selectListItems();
			
			for(int j=0;j<service.JHandJJListCount();j++){
				if(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))!=null){
					service.updateTotalStockAmountStore(Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j))),(String) JHandJJStockProNum.get(j));
					totalstore+=Integer.parseInt(service.JHandJJStockAmountStore((String) JHandJJStockProNum.get(j)));
				}
				else{
				    JHandJJStockAmount[j]=0;
				    service.updateTotalStockAmountStore(JHandJJStockAmount[j], (String) JHandJJStockProNum.get(j));
				}
			}
			
			List JHandJJList = new ArrayList();
			if(((select1.equals("전체")||select1.equals("품목선택")))){
				System.out.println("전체,품목선택 선택");
				JHandJJList = service.JHandJJList();
				model.addAttribute("JHandJJList",JHandJJList);
			}
			else{
				if(!select2.equals("제품명선택")){
					System.out.println("제품명선택");
					JHandJJList = service.JHandJJListFindOneSelect2(select2);
					
					ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
					ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
					
					totalstore=ProductPlusRemark.getTotalStockAmountStore();
					totalchango=ProductPlusRemark.getTotalStockAmount();
					totalappropriate=ProductPlusRemark.getPro_properStock();
					model.addAttribute("JHandJJList",JHandJJList);
				}
				else{
				JHandJJList = service.JHandJJListfummok(select1);
				
				totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
				totalchango=service.JHandJJListfummokTotalStockAmount(select1);
				totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
				
				model.addAttribute("JHandJJList",JHandJJList);
				}
			}
			if(!search.equals("제품명입력")){
				System.out.println("제품명입력 체크");
				JHandJJList = service.JHandJJListSearch(search);
				int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
				if(JHandJJListSearchCount==0){
					System.out.println("체크2");
					totalstore=0;
					totalchango=0;
					totalappropriate=0;
				}
				else{
				totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
				totalchango=service.JHandJJListSearchTotalStockAmount(search);
				totalappropriate=service.JHandJJListSearchTotalproperstock(search);
				}
				model.addAttribute("JHandJJList",JHandJJList);
			}
			
			model.addAttribute("number",number);
			model.addAttribute("selectListStores",selectListStores);
			model.addAttribute("selectListItems",selectListItems);
			model.addAttribute("st_id",st_id);
			model.addAttribute("totalstore", new Integer(totalstore));
			
			}
			else{
				totalstore=0;
				int number = 0;
				number=service.JHandJJListCount();
				
				List getStockPronums = new ArrayList();
				getStockPronums = service.getStockPronums(st_id);
				
				List getStockProstockamounts = new ArrayList();
				getStockProstockamounts = service.getStockProstockamounts(st_id);
			
				List notInProNum = new ArrayList();
				notInProNum =service.notInProNums(st_id);
				
				store selectListStores = null;
				selectListStores = (store) service.StfindName(st_id);
				List selectListItems = new ArrayList();
				selectListItems = service.selectListItems();
				
				
				int getStIdCount = 0;
				getStIdCount = service.getStIdCount(st_id);
				
				
				System.out.println("getStIdCount : "+getStIdCount);
				
				int total=0;
				for(int i=0;i<getStIdCount;i++){
					total=(int) getStockProstockamounts.get(i);
					service.updateTotalStockAmountStore(total,(String) getStockPronums.get(i));
					totalstore+=total;
				}
				
				for(int i=0;i<(service.JHandJJListCount()-getStIdCount);i++){
					service.updateTotalStockAmountStore(0,(String) notInProNum.get(i));	
				}
				
				List JHandJJList = new ArrayList();
				if(((select1.equals("전체")||select1.equals("품목선택")))){
					System.out.println("전체,품목선택 선택");
					JHandJJList = service.JHandJJList();
					model.addAttribute("JHandJJList",JHandJJList);
				}
				else{
					if(!select2.equals("제품명선택")){
						System.out.println("제품명선택");
						JHandJJList = service.JHandJJListFindOneSelect2(select2);
						
						ProductPlusRemark ProductPlusRemark = new ProductPlusRemark();
						ProductPlusRemark = (ProductPlusRemark) service.JHandJJListFindOneSelect2(select2).get(0);
						
						totalstore=ProductPlusRemark.getTotalStockAmountStore();
						totalchango=ProductPlusRemark.getTotalStockAmount();
						totalappropriate=ProductPlusRemark.getPro_properStock();
						model.addAttribute("JHandJJList",JHandJJList);
					}
					else{
					JHandJJList = service.JHandJJListfummok(select1);
					
					totalstore=service.JHandJJListfummokTotalStockAmountStore(select1);
					totalchango=service.JHandJJListfummokTotalStockAmount(select1);
					totalappropriate=service.JHandJJListfummokTotalproperstock(select1);
					
					model.addAttribute("JHandJJList",JHandJJList);
					}
				}
				if(!search.equals("제품명입력")){
					System.out.println("제품명입력 체크");
					JHandJJList = service.JHandJJListSearch(search);
					int JHandJJListSearchCount = service.JHandJJListSearchCount(search);
					if(JHandJJListSearchCount==0){
						System.out.println("체크2");
						totalstore=0;
						totalchango=0;
						totalappropriate=0;
					}
					else{
					totalstore=service.JHandJJListSearchTotalStockAmountStore(search);
					totalchango=service.JHandJJListSearchTotalStockAmount(search);
					totalappropriate=service.JHandJJListSearchTotalproperstock(search);
					}
					model.addAttribute("JHandJJList",JHandJJList);
				}
					
				model.addAttribute("number",number);
				model.addAttribute("selectListStores",selectListStores);
				model.addAttribute("selectListItems",selectListItems);
				model.addAttribute("JHandJJList",JHandJJList);
				model.addAttribute("st_id",st_id);
				model.addAttribute("totalstore", new Integer(totalstore));
			}	
			
			
			
			model.addAttribute("totalchango", new Integer(totalchango));
			model.addAttribute("totalappropriate", new Integer(totalappropriate));
			
			
			return "StjegoJJ";// 해당 뷰
		}
		
		@RequestMapping(value = "/chowonheeView/StjegoJJPro")
		public String StjegoJJPro(String[] actuality,String[] pro_num,int[] totalStockAmountStore,Model model,HttpSession session,HttpServletRequest request) throws Throwable {

			for(int i=0;i<actuality.length;i++){
				if(actuality[i]==""){
					actuality[i]="실사재고입력하지않음";
				}
				System.out.println(actuality[i]);
			}
	
			String st_id = (String) request.getSession().getAttribute("memId");

			for(int i=0;i<actuality.length;i++){
				if(actuality[i]!="실사재고입력하지않음"){		
						service.updateStockamount(Integer.parseInt(actuality[i]),st_id,pro_num[i]);
						service.updateStockamount(-Integer.parseInt(actuality[i]),"admin",pro_num[i]);
						service.updateChangoAmount(totalStockAmountStore[i],Integer.parseInt(actuality[i]),pro_num[i]);
					}
			}
				
			return "StjegoJJPro";
		}
		
		
		@RequestMapping(value = "/chowonheeView/ajax/StjegoJJ1", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
		@ResponseBody
		public void StjegoJJ1(HttpServletResponse resp,String pro_bcategory) throws Exception {
			List articleLists = new ArrayList();
			articleLists = service.selectListItemsProNames(pro_bcategory);
			System.out.println("/ajax/jegoJJ1.do 요청");
		
			JSONObject jso = new JSONObject(); // JASON 객체생성
			jso.put("data", articleLists);

			// jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
			//jso.put("다른이름",list) 가능
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter(); //현재어플리케이션을 기준으로 내용을 보냄
			out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
			
			System.out.println("articleLists="+articleLists);

			String data = jso.toString();
			System.out.println(data);
		}   //리스폰스에다가 데이터값 쏴준다.
}








