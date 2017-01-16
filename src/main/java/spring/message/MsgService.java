package spring.message;

import java.util.List;


public interface MsgService {
	/*�������� ����Ʈ*/
	public List<Object> receiveMsg_list(int startRow,int endRow);
	public int receiveMsg_count(String memId);
	/*�������� ����Ʈ*/
	public List<Object> sendMsg_list(int startRow,int endRow);
	public int sendMsg_count(String memId);
	/*���� ����*/
	public int inputSeMsg(SendMsg seMessage);
	public int inputReMsg(int num);
	/*�������� ����*/
	public ReceiveMsg getReceiveMsg(int num) throws Exception;
	/*�������� ����*/
	public SendMsg getSendMsg(int num) throws Exception;
	/*�������� ����*/
	public int deleteReceive(int num);
	/*�������� ����*/
	public int deleteSend(int num);
	
	public int updateSeCheckDate(int num);
	public int updateReCheckDate(int num);
	
	public int newMsg_count();
	public int maxNum();
	

}
