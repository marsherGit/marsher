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
	public List<ReceiveMsg> receiveMsg_list(){
		List<ReceiveMsg> receiveMsg_list =dao.receiveMsg_list();
		return receiveMsg_list;
	}
	//���� ���� ī��Ʈ 
	public int receiveMsg_count(){
		return dao.receiveMsg_count();
	}
	//���� ���� ����Ʈ
	public List<SendMsg> sendMsg_list(){
		List<SendMsg> sendMsg_list =dao.sendMsg_list();
		return sendMsg_list;
	}
	//���� ���� ī��Ʈ 
	public int sendMsg_count(){
		return dao.sendMsg_count();
	}
	//���� ������
	public int inputMsg(SendMsg message){
		int check = dao.inputMsg(message);
		return 0;
	}
	//���� ���� ���� 
	public ReceiveMsg getReceiveMsg(int re_num) throws Exception{
		return dao.getReceiveMsg(re_num);
	}
	//���� ���� ����
	public SendMsg getSendMsg(int se_num) throws Exception{
		return dao.getSendMsg(se_num);
	}
	//���� ���� ����
	public int deleteReceive(int re_num){
		int check = dao.deleteReceive(re_num);
		return check;
	}
	//���� ���� ����
	public int deleteSend(int se_num){
		int check = dao.deleteSend(se_num);
		return check;
	}

}
