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
	
	//받은 쪽지 리스트
	public List<ReceiveMsg> receiveMsg_list(){
		List<ReceiveMsg> receiveMsg_list =dao.receiveMsg_list();
		return receiveMsg_list;
	}
	//받은 쪽지 카운트 
	public int receiveMsg_count(){
		return dao.receiveMsg_count();
	}
	//보낸 쪽지 리스트
	public List<SendMsg> sendMsg_list(){
		List<SendMsg> sendMsg_list =dao.sendMsg_list();
		return sendMsg_list;
	}
	//보낸 쪽지 카운트 
	public int sendMsg_count(){
		return dao.sendMsg_count();
	}
	//쪽지 보내기
	public int inputMsg(SendMsg message){
		int check = dao.inputMsg(message);
		return 0;
	}
	//받은 쪽지 보기 
	public ReceiveMsg getReceiveMsg(int re_num) throws Exception{
		return dao.getReceiveMsg(re_num);
	}
	//보낸 쪽지 보기
	public SendMsg getSendMsg(int se_num) throws Exception{
		return dao.getSendMsg(se_num);
	}
	//받은 쪽지 삭제
	public int deleteReceive(int re_num){
		int check = dao.deleteReceive(re_num);
		return check;
	}
	//보낸 쪽지 삭제
	public int deleteSend(int se_num){
		int check = dao.deleteSend(se_num);
		return check;
	}

}
