package mj.Notice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class NoticeServiceImpl implements NoticeService {
	
	NoticeDAO dao;
	
	public void setDao(NoticeDAO dao) {
		this.dao = dao;
	}
	
	// noticeList
	@Override
	public List<Object> noticeList(int startRow,int endRow) {
		List<Object> result = null;
		result = dao.noticeList(startRow,endRow);

		return result;

	}
	
	// noticeWritePro
	public int insert(NoticeDataBean notice) {
		int check = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map.put("no_num", notice.getNo_num());
			map.put("no_title", notice.getNo_title());
			map.put("no_content", notice.getNo_content());
			map.put("calendar_date", notice.getCalendar_date());
			map.put("no_date", notice.getNo_date());
			
			check = dao.insert("notice.noticeWrite", map);
			System.out.println(notice);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return check;
	}
	
	public int noticeListCount(){
		return dao.noticeListCount();
	}
	
	public NoticeDataBean getNotice(String no_num) {
		NoticeDataBean list = null;
		
		try {
			list = dao.getNotice(no_num);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}
	
	public NoticeDataBean getNotice2(String no_num) {
		NoticeDataBean list = null;
		
		try {
			list = dao.getNotice2(no_num);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}
	
	public int updateNotice(NoticeDataBean notice, String no_num) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("no_num", notice.getNo_num());
		map.put("no_title", notice.getNo_title());
		map.put("no_content", notice.getNo_content());
		map.put("calendar_date", notice.getCalendar_date());
		map.put("no_date", notice.getNo_date());
		
		dao.updateNotice(map);
		
		return 1;
	}
	
	public int deleteNotice(int no_num) {
		int check = dao.deleteNotice(no_num);
		
		return check;
		
	}
	
}
