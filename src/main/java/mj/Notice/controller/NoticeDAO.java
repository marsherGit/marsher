package mj.Notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import mj.Store.service.memberDataBean;


public class NoticeDAO extends SqlSessionDaoSupport {
	
	// noticeList
	public List<Object> noticeList(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> noticeList = getSqlSession().selectList("notice.noticeList", map);
		System.out.println(noticeList.size());
		return noticeList;
		
	}
	
	public int noticeListCount() {
		int count = getSqlSession().selectOne("notice.noticeListCount", Integer.class); 
		return count;
	}
	
	// noticeWritePro
	public int insert(String string, Map<String, Object> list){
		int check = getSqlSession().insert(string, list);
		return check;
	}
	
	public NoticeDataBean getNotice(String no_num) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("no_num", no_num);
		
		NoticeDataBean getNotice = getSqlSession().selectOne("notice.getNotice", map);
		return getNotice;
	}
	
	public NoticeDataBean getNotice2(String no_num) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("no_num", no_num);
		
		NoticeDataBean getNotice2 = getSqlSession().selectOne("notice.getNotice2", map);
		return getNotice2;
	}
	
	public int updateNotice(Map<String, Object> map) {
		getSqlSession().update("notice.updateNotice", map);
		return 1;
	}
	
	// noticeDelete
		public int deleteNotice(int no_num) {
			int check = getSqlSession().delete("notice.deleteNotice", no_num);
			return check;
		}

	
}
