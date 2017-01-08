package mj.Notice.controller;

import java.util.List;

public interface NoticeService {
	
	public List<Object> noticeList(int startRow,int endRow);				// noticeList
	public int insert(NoticeDataBean notice);                         		// noticeWritePro 
	public int noticeListCount();
	public NoticeDataBean getNotice(String no_num);			// noticeContent
	public NoticeDataBean getNotice2(String no_num);						// noticeUpdateForm
	public int updateNotice(NoticeDataBean notice, String no_num);   		// noticeUpdatePro
	public int deleteNotice(int no_num);									// noticeDeletePro
	
}
