<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Calendar"%>
<%@page import="mj.Notice.controller.NoticeDataBean"%>
<%@page import="spring.message.ReceiveMsg"%>
<%@page import="java.util.List"%>

<!-- calendar -->
<%
Calendar cal=Calendar.getInstance();
int startDay = 1;
int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
int week = cal.get(Calendar.DAY_OF_WEEK);
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH)+1;
int day  = cal.get(Calendar.DAY_OF_MONTH);

String _year = request.getParameter("year");
String _month = request.getParameter("month");
String _day  = request.getParameter("day");

if(_year != null)
    year = Integer.parseInt(_year);

if(_month != null)
    month = Integer.parseInt(_month);

if (_day != null )
	day = Integer.parseInt(_day);

cal.set(year, month-1, 1);    //출력할 년도, 월로 설정

year = cal.get(Calendar.YEAR);    //변화된 년, 월
month = cal.get(Calendar.MONTH) + 1;

List <NoticeDataBean> list = (List <NoticeDataBean>)request.getAttribute("calNoticeList");
List <ReceiveMsg> msg = (List <ReceiveMsg>)request.getAttribute("receiveMsgList");
%>
<!-- calendar -->
<style>
	.btns>div {padding:0 0.5em;}
	.btn_content>.col-xs-6 {padding:0;}
	.new_num {font-size:1.4em; font-weight:bold;}
	.panel-heading {position:relative;}
	.btn-more {display:inline-block; position:absolute; top:0.7em; right:0.7em; color:#31708f;}
	.btn-more>a, .btn-more>a:hover, .btn-more>a:active, .btn-more>a:visited, .btn-more>a:active {color:#31708f; font-size:0.9em;}
	.info_area>div {padding:0 0.5em;}
	.panel-primary a {color:#337ab7;}
	.panel-primary a:hover {color:#23527c;}
	
	.notice_area .panel-body {position:relative;}
	.notice_area ul {position:relative; list-style:none; padding:0; margin:0; overflow:hidden; height:1.4em;}
	.notice_area .btns {position:relative; display:block; float:right; width:2em; top:-0.5em;}
	.notice_area .btns a {position:absolute; top:0; right:0; color:#999;}
	.notice_area .btns a:hover {color:#555;}
	.notice_area .btns a.next {top:1em;}
	.notice_list li {position:absolute; top:-1.4em; left:0; width:100%; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}
	.notice_list li.on {display:block; top:0; lefth:0;}
	
	.calendar_container {width:100%; margin:0 auto; padding:0;}
	.calendar_days p {font-size:0.8em; margin:0;}
	.calendar_days p.date {margin-bottom:0.3em;}
	.calendar_days td {min-height:100px !important;}
	
	.ellipsis {overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}
	
	.delivery_panel .panel-body {background:url('../images/delivery_bar_bg.png') no-repeat 0 0; background-size:100% 100%; padding:2.5em 2em;}
	.progress {height:10px; overflow:visible; margin:2em 0; background:url('../images/bar_bg.png') repeat-y 100% 100%; background-size:contain; background-position-x:-1px;}
	.progress-bar {position:relative; border-radius:4px 0 0 4px; background-color:#366886;}
	.delivery_tag {display:block; position:absolute; top:-2.2em; right:-2.5em; width:4em; height:2.5em; font-size:0.8em; background:url('../images/icon_truck.png') no-repeat; background-size:contain; background-position:0 0; overflow:hidden; text-indent:-1em;}
	
	/* map */
	.contact{
		position:relative;
		min-height:250px;
	}
	.list a{
		display:block;
		color:#444;
		overflow:hidden;
		text-overflow: ellipsis;
		white-space:nowrap;
	}
	.desc{
		width:140px;
		color:#999;
		padding-left:3em;
	}
	.contact.active .desc{display:none;}
	.contact .list{
		position:absolute;
		bottom:0.5em;
		right:0.5em;
		margin-left:10px;
		width:140px;
		color:#999;
	}
	.contact .list ul{
		display:none;
		position:absolute;
		bottom:0;
		right:0;
		background-color:#fff;
		list-style:none;
		padding:1em;
		margin:0;
	}
	.contact.seoul .list ul.seoul{display:block;}
	.contact.gangwon .list ul.gangwon{display:block;}
	.contact.cc_namdo .list ul.cc_namdo{display:block;}
	.contact.cc_bukdo .list ul.cc_bukdo{display:block;}
	.contact.gs_namdo .list ul.gs_namdo{display:block;}
	.contact.gs_bukdo .list ul.gs_bukdo{display:block;}
	.contact.jl_namdo .list ul.jl_namdo{display:block;}
	.contact.jl_bukdo .list ul.jl_bukdo{display:block;}
	.contact.jeju .list ul.jeju{display:block;}
	.contact .list ul li{
		margin-bottom:8px;
		height:14px;
		line-height:14px;
	}
	.contact .list ul li a{
		display:inline-block;
		padding-right:19px;
		height:14px;
		line-height:14px;
		color:#279ba1;
		white-space:nowrap;
		background:url("../images/contact_map_arrow.gif") no-repeat right top;
	}
	.contact .map{
		position:absolute;
		top:2em;
		left:0.5em;
		width:140px;
		height:143px;
		background:url('../images/contact_map.gif') no-repeat 0 0;
	}
	.contact .map a{
		display:block;
		position:absolute;
		width:24px;
		height:24px;
		z-index:10;
	}
	.contact .map a.seoul{top:17px; left:40px;}
	.contact .map a.gangwon{top:11px; left:67px;}
	.contact .map a.cc_namdo{top:45px; left:35px;}
	.contact .map a.cc_bukdo{top:37px; left:54px;}
	.contact .map a.gs_namdo{top:82px; left:67px;}
	.contact .map a.gs_bukdo{top:52px; left:79px;}
	.contact .map a.jl_namdo{top:96px; left:34px;}
	.contact .map a.jl_bukdo{top:69px; left:39px;}
	.contact .map a.jeju{top:124px; left:26px;}
	.contact .map .map_view{
		position:absolute;
		top:0;
		left:0;
		width:140px;
		height:143px;
		background:url("../images/contact_map.gif") no-repeat;
	}
	.contact.seoul .map .map_view{background-image:url("../images/contact_map_seoul.gif");}
	.contact.gangwon .map .map_view{background-image:url("../images/contact_map_gangwon.gif");}
	.contact.cc_namdo .map .map_view{background-image:url("../images/contact_map_cc_namdo.gif");}
	.contact.cc_bukdo .map .map_view{background-image:url("../images/contact_map_cc_bukdo.gif");}
	.contact.gs_namdo .map .map_view{background-image:url("../images/contact_map_gs_namdo.gif");}
	.contact.gs_bukdo .map .map_view{background-image:url("../images/contact_map_gs_bukdo.gif");}
	.contact.jl_namdo .map .map_view{background-image:url("../images/contact_map_jl_namdo.gif");}
	.contact.jl_bukdo .map .map_view{background-image:url("../images/contact_map_jl_bukdo.gif");}
	.contact.jeju .map .map_view{background-image:url("../images/contact_map_jeju.gif");}
</style>

<script>
	$(document).ready(function(){
		/* map */
		var list = $("#store_list");
		var store_area = list.find(".map a");
		
		store_area.click(function(e){
			e.preventDefault();
			var location = $(this).attr("class");
			list.attr("class","contact");
			list.addClass("active "+location);
		});
		
		/* notice */
		var notice_list = $(".notice_list>li");
		var notice_prev = $(".notice_area .prev");
		var notice_next = $(".notice_area .next");
		var notice_active_idx = notice_list.filter(".on").index();
		var notice_list_max = notice_list.length-1;
		var timer;
		var auto = true;
		var speed = 3000;
		notice_list.first().addClass("on");
		//prev
		notice_prev.click(function(e){
			e.preventDefault();
			var notice_active_idx = notice_list.filter(".on").index();
			var index = (notice_active_idx - 1 < 0) ? notice_list_max : notice_active_idx - 1;
			
			notice_list.eq(notice_active_idx).css({"top":"0"}).animate({"top":"1.4em"},{"queue":false});
			notice_list.eq(index).css({"top":"-1.4em"}).animate({"top":"0"},{"queue":false});
			notice_list.removeClass("on");
			notice_list.eq(index).addClass("on");
		});
		
		//next
		notice_next.click(function(e){
			e.preventDefault();
			var notice_active_idx = notice_list.filter(".on").index();
			var index = (notice_active_idx + 1 > notice_list_max) ? 0 : notice_active_idx + 1;
			
			notice_list.eq(notice_active_idx).css({"top":"0"}).animate({"top":"-1.4em"},{"queue":false});
			notice_list.eq(index).css({"top":"1.4em"}).animate({"top":"0"},{"queue":false});
			notice_list.removeClass("on");
			notice_list.eq(index).addClass("on");
		});
		
		if(auto) timer = setInterval(auto_roll, speed);
		
		$(".notice_area .panel-body").bind({
			'mouseenter': function(){
				if(!auto) return false;
				clearInterval(timer);
				auto = false;
			},
			'mouseleave': function(){
				timer = setInterval(auto_roll, speed);
				auto = true;
			}
		})
		 
		/* delivery-bar */
    var nowDate = new Date();
    var nowDay = nowDate.getDay();
   	var nowHour = nowDate.getHours();
   	//var nowHour = 19;
    var nowLocation = ((nowHour-3)-(Math.round(nowHour/3))-1)*10;
   	if(nowDay==1 || nowDay==3 || nowDay==5) {
    	var tg = $("#soda .progress-bar, #juice .progress-bar");
    	if(nowHour > 6 && nowHour <= 21){
    		tg.css({"width":nowLocation+"%"});
    		tg.attr("aria-valuenow",nowLocation);
    	}	else if(nowHour > 21) {
       	tg.css({"width":"100%","border-radius":"4px"});
       	tg.attr("aria-valuenow",100);
       }
    }
    if(nowDay==2 || nowDay==4 || nowDay==6) {
    	var tg = $("#drink .progress-bar, #milk .progress-bar");
    	if(nowHour > 6 && nowHour <= 21){
    		tg.css({"width":nowLocation+"%"});
    		tg.attr("aria-valuenow",nowLocation);
    	}	else if(nowHour > 21) {
       	tg.css({"width":"100%","border-radius":"4px"});
       	tg.attr("aria-valuenow",100);
       }
    }
		
		/* function */
		function auto_roll(){
			var notice_active_idx = notice_list.filter(".on").index();
			var index = (notice_active_idx + 1 > notice_list_max) ? 0 : notice_active_idx + 1;
			
			notice_list.eq(notice_active_idx).css({"top":"0"}).animate({"top":"-1.4em"},{"queue":false});
			notice_list.eq(index).css({"top":"1.4em"}).animate({"top":"0"},{"queue":false});
			notice_list.removeClass("on");
			notice_list.eq(index).addClass("on");
		}
		
	})
</script>
<!-- main-container -->
<div class="container main_container">
	<div class="col-lg-6">
		<!-- Quick Menu -->
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">Quick Menu</h3>
			</div>
		</div>
		<div class="row btns">
			<!-- btn_block -->
			<div class="col-sm-3">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row btn_content">
							<div class="col-xs-6 btn_icon">
								<i class="fa fa-comments fa-3x"></i>
							</div>
							
							<div class="col-xs-6 text-right">
								<div id="mgsNewNum" class="new_num"><span>${ count }</span></div>
								<div class="text-right">New!</div>
							</div>
							
						</div>
					</div>
					<a href="<c:url value="/message/receiveMsgList" />"> 
						<div class="panel-footer">
							<span class="pull-left">쪽지보기</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			<!-- // btn_block -->
			
			<!-- btn_block -->
			<div class="col-sm-3">
				<div class="panel panel-green">
					<div class="panel-heading">
						<div class="row btn_content">
							<div class="col-xs-6 btn_icon">
								<i class="fa fa-truck fa-3x"></i>
							</div>
							<div class="col-xs-6 text-right" style="min-height:3.3em;">
								<div class="new_num"></div>
								<div class="text-right"></div>
							</div>
						</div>
					</div>
					<a href="<c:url value="/delivery/deliveryState" />">
						<div class="panel-footer">
							<span class="pull-left">배송현황</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			<!-- // btn_block -->
			
			<!-- btn_block -->
			<div class="col-sm-3">
				<div class="panel panel-yellow">
					<div class="panel-heading">
						<div class="row btn_content">
							<div class="col-xs-6 btn_icon">
								<i class="fa fa-shopping-cart fa-3x"></i>
							</div>
							<div class="col-xs-6 text-right">
								<div class="new_num"><span>${ order_count }</span></div>
								<div class="text-right">New!</div>
							</div>
						</div>
					</div>
					<c:if test="${ memId ne 'admin' }">
					<a href="<c:url value="/order/orderList?o_sender=${memId}"/>">
					<div class="panel-footer">
							<span class="pull-left">발주서조회</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
					</c:if>
					<c:if test="${ memId eq 'admin' }">
					<a href="<c:url value="/order/allOrders" />"> 
						<div class="panel-footer">
							<span class="pull-left">발주서조회</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
					</c:if>
				</div>
			</div>
			<!-- // btn_block -->
			
			<!-- btn_block -->
			<div class="col-sm-3">
				<div class="panel panel-red">
					<div class="panel-heading">
						<div class="row btn_content">
							<div class="col-xs-6 btn_icon">
								<i class="fa fa-tasks fa-3x"></i>
							</div>
							<div class="col-xs-6 text-right" style="min-height:3.3em;">
								<div class="new_num"></div>
								<div class="text-right"></div>
							</div>
						</div>
					</div>
					<a href="<c:url value="/" />">
						<div class="panel-footer">
							<span class="pull-left">재고조회</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			<!-- // btn_block -->
		</div>
		<!-- // Quick Menu -->
		
		
		<div class="row info_area">
			<!-- delivery -->
			<div class="col-md-7">
				<div class="panel panel-info panel-marsher delivery_panel">
					<div class="panel-heading">
						<i class="fa fa-truck"></i>
						<span>정기배송정보</span>
						<span class="btn-more"><a href="<c:url value="/delivery/deliveryInfo" />">더보기 ▶</a></span>
					</div>
					<div class="panel-body">
						<div id="soda" class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%">
							    <div class="delivery_tag">탄산</div>
							</div>
						</div>
						<div id="drink" class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%">
							    <div class="delivery_tag">주류</div>
							</div>
						</div>
						<div id="juice" class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%">
							    <div class="delivery_tag">쥬스</div>
							</div>
						</div>
						<div id="milk" class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%">
							    <div class="delivery_tag">우유</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- // delivery -->
			<!-- store -->
			<div class="col-md-5">
				<div class="panel panel-info panel-marsher">
					<div class="panel-heading">
						<i class="fa fa-map-marker"></i>
						<span>매장찾기</span>
						<span class="btn-more"><a href="<c:url value="/member/info.do?st_id=manager1" />">더보기 ▶</a></span></span>
					</div>
					<div id="store_list" class="panel-body contact">
						<div class="map">
							<a class="seoul" href="#" title="경기"></a>
							<a class="gangwon" href="#" title="강원"></a>
							<a class="cc_namdo" href="#" title="충청남도"></a>
							<a class="cc_bukdo" href="#" title="충청북도"></a>
							<a class="gs_namdo" href="#" title="경상남도"></a>
							<a class="gs_bukdo" href="#" title="경상북도"></a>
							<a class="jl_namdo" href="#" title="전라남도"></a>
							<a class="jl_bukdo" href="#" title="전라북도"></a>
							<a class="jeju" href="#" title="제주"></a>
							<div class="map_view"></div>
						</div>
						<div class="list">
							<p class="desc">
								지도 영역을<br />클릭해 주세요.
							</p>
							<ul class="seoul">
								<li><a href="<c:url value="/member/info.do?st_id=manager1" />">서울 강남점</a></li>
							</ul>
							<ul class="gangwon">
								<li><a href="<c:url value="/member/info.do?st_id=manager2" />">춘천 약사명점</a>
							</ul>
							<ul class="cc_namdo">
								<li><a href="<c:url value="/member/info.do?st_id=manager3" />">대전 은행점</a></li>
							</ul>
							<ul class="cc_bukdo">
								<li>
									조회된 매장이<br />
									없습니다.
								</li>
							</ul>
							<ul class="gs_namdo">
								<li><a href="<c:url value="/member/info.do?st_id=manager5" />">부산 서면점</a></li>
							</ul>
							<ul class="gs_bukdo">
								<li>
									조회된 매장이<br />
									없습니다.
								</li>
							</ul>
							<ul class="jl_namdo">
								<li><a href="<c:url value="/member/info.do?st_id=manager4" />">광주 충장로점</a></li>
							</ul>
							<ul class="jl_bukdo">
								<li>
									조회된 리조트가<br />
									없습니다.
								</li>
							</ul>
							<ul class="jeju">
								<li>
									조회된 매장이<br />
									없습니다.
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- // store -->
		</div>
	</div>
	
	<div class="calendar_area col-lg-6">
		<!-- notice -->
		<div class="row notice_area">
			<div class="panel panel-info panel-marsher">
				<div class="panel-heading">
					<i class="fa fa-check-square-o"></i>
					<span>공지사항</span>
					<span class="btn-more"><a href="<c:url value="/notice/noticeList" />">더보기 ▶</a></span>
				</div>
				<div class="panel-body row">
					<ul class="notice_list col-sm-10 ellipsis">
						<c:forEach var="list" items="${calNoticeList}">
						<li><a href="<c:url value="/login/calendarView?calendar_date=${list.calendar_date}" />">[이벤트]${list.no_title}</a></li>
						</c:forEach>
					</ul>
					<div class="btns col-sm-2">
						<a href="#" class="prev"><i class="fa fa-caret-square-o-up"></i></a>
						<a href="#" class="next"><i class="fa fa-caret-square-o-down"></i></a>
					</div>
				</div>
			</div>
		</div>
		<!-- // notice -->
		<!-- calendar -->
		<div class="row calendar_area">
			<div class="panel panel-info panel-marsher">
				<div class="panel-heading">
					<i class="fa fa-calendar"></i>
					<span>이벤트 확인하기</span>
					<span class="btn-more"><a href="<c:url value="/notice/noticeList" />">더보기 ▶</a></span>
				</div>
				<div class="panel-body">
					<div class="container calendar_container">
						<table width="100%" border="0">
							<tr>
								<td align="center" height="10"><font color="6D98B4">
										<H4>
											<b><%=year%>년 <%=month%>월</b>
										</H4>
								</font></td>
							</tr>
						</table>

						<table width=100% " height="10" border="1" cellpadding="2"
							cellspacing="1" bordercolor="6D98B4" borderRadius="5px">
							<tr height="40">
								<td align="center" bgcolor="#D9EDF7"><font color="red">일</font></td>
								<td align="center" bgcolor="#D9EDF7">월</td>
								<td align="center" bgcolor="#D9EDF7">화</td>
								<td align="center" bgcolor="#D9EDF7">수</td>
								<td align="center" bgcolor="#D9EDF7">목</td>
								<td align="center" bgcolor="#D9EDF7">금</td>
								<td align="center" bgcolor="#D9EDF7"><font color="366886">토</font></td>
							</tr>

							<%
								String colorclass = "";
								Calendar firstDayOfMonth = Calendar.getInstance();
								firstDayOfMonth.set(Calendar.YEAR, cal.get(Calendar.YEAR));
								firstDayOfMonth.set(Calendar.MONTH, cal.get(Calendar.MONTH));
								firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);

								int count = 0;
								for (int i = 2 - firstDayOfMonth.get(Calendar.DAY_OF_WEEK); i <= firstDayOfMonth
										.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {

									count++;

									if (year == cal.get(Calendar.YEAR) && month == (cal.get(Calendar.MONTH) + 1)
											&& i == cal.get(Calendar.DAY_OF_MONTH)) {

										colorclass = " ";
									} else {
										if (count == 1) {

											colorclass = "class=red";
										} else if (count == 7) {

											colorclass = " class=blue ";
										} else {
											colorclass = " ";
										}
									}

									if (i <= 0) {
										out.print("&nbsp;");
									} else {
							%>
							<td
								style='text-align: left; width: 100px; height: 50px; padding: 5px'><%=i%><br>
								</a> <%
 	int resYear = 0;
 			int resMonth = 0;
 			int resDay = 0;
 			String Date = "";
 			String title = "";

 			for (int j = 0; j < list.size(); j++) {
 				resDay = Integer.parseInt(list.get(j).getCalendar_date().substring(8, 10)); //2017-01-10
 				resMonth = Integer.parseInt(list.get(j).getCalendar_date().substring(5, 7));
 				resYear = Integer.parseInt(list.get(j).getCalendar_date().substring(0, 4));

 				Date = list.get(j).getCalendar_date();
 				title = list.get(j).getNo_title();

 				// 현재 달력에 표시중인 날짜와 같다면 데이터 뿌리기
 				if (resDay == i & resMonth == month & resYear == year) {
 					out.print(
 							"<font color='366886' size='1em'><strong><a onclick=location.href='calendarView?calendar_date="
 									+ Date + "' style='cursor: pointer;'>" + title
 									+ "</a></strong></font></td>");
 					list.remove(j);
 				} else {
 					out.print("<font color='" + colorclass + "'>&nbsp;</font></td>");
 				}
 				break;
 			}

 		}
 %></td>
							<%
								if (count == 7) {
							%>
							</tr>
							<tr align='right'>
								<%
									count = 0;
										}
									}
									Calendar lastDayOfMonth = Calendar.getInstance();
									lastDayOfMonth.set(Calendar.YEAR, cal.get(Calendar.YEAR));
									lastDayOfMonth.set(Calendar.MONTH, cal.get(Calendar.MONTH));
									lastDayOfMonth.set(Calendar.DAY_OF_MONTH, firstDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
									for (int j = lastDayOfMonth.get(Calendar.DAY_OF_WEEK); j < Calendar.SATURDAY; j++) {
										out.print("<td align=\"center\">&nbsp;</td>");
									}
								%>
							</tr>
						</table>
					</div>
				</div> 
			</div>
		</div>
		<!-- // calendar -->
	</div>
</div>
<!-- // main-container -->