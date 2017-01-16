package spring.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MsgServiceImpl implements MsgService {
	@Autowired
	private MsgDAO dao; 
	
	public void setDao(MsgDAO dao) {
		this.dao = dao;
	}
	
	//���� ���� ����Ʈ
	public List<Object> receiveMsg_list(int startRow,int endRow){
		List<Object> receiveMsg_list =dao.receiveMsg_list(startRow, endRow);
		return receiveMsg_list;
	}
	//���� ���� ī��Ʈ 
	public int receiveMsg_count(String memId){
		return dao.receiveMsg_count(memId);
	}
	//���� ���� ����Ʈ
	public List<Object> sendMsg_list(int startRow,int endRow){
		List<Object> sendMsg_list =dao.sendMsg_list(startRow, endRow);
		return sendMsg_list;
	}
	//���� ���� ī��Ʈ 
	public int sendMsg_count(String memId){
		return dao.sendMsg_count(memId);
	}
	//���� ������
	public int inputSeMsg(SendMsg seMessage){
		int check = dao.inputSeMsg(seMessage);
		return 0;
	}
	public int inputReMsg(ReceiveMsg reMessage){
		int check = dao.inputReMsg(reMessage);
		return 0;
	}
	//���� ���� ���� 
	public ReceiveMsg getReceiveMsg(int num) throws Exception{
		return dao.getReceiveMsg(num);
	}
	//���� ���� ����
	public SendMsg getSendMsg(int num) throws Exception{
		return dao.getSendMsg(num);
	}
	//���� ���� ����
	public int deleteReceive(int num){
		int check = dao.deleteReceive(num);
		return check;
	}
	//���� ���� ����
	public int deleteSend(int num){
		int check = dao.deleteSend(num);
		return check;
	}
	
	public int updateSeCheckDate(int num){
		int check = dao.updateSeCheckDate(num);
		return 0;
	}
	public int updateReCheckDate(int num){
		int check = dao.updateReCheckDate(num);
		return 0;
	}
	
	public int newMsg_count(){
		return dao.newMsg_count();
	}

}
