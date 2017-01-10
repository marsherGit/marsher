package spring.message;

import java.util.List;


public interface MsgService {
	/*받은쪽지 리스트*/
	public List<ReceiveMsg> receiveMsg_list();
	public int receiveMsg_count();
	/*보낸쪽지 리스트*/
	public List<SendMsg> sendMsg_list();
	public int sendMsg_count();
	/*쪽지 쓰기*/
	public int inputMsg(SendMsg message);
	/*받은쪽지 보기*/
	public ReceiveMsg getReceiveMsg(int re_num) throws Exception;
	/*보낸쪽지 보기*/
	public SendMsg getSendMsg(int se_num) throws Exception;
	/*받은쪽지 삭제*/
	public int deleteReceive(int re_num);
	/*보낸쪽지 삭제*/
	public int deleteSend(int se_num);

}
