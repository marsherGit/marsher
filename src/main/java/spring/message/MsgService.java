package spring.message;

import java.util.List;


public interface MsgService {
	/*�������� ����Ʈ*/
	public List<ReceiveMsg> receiveMsg_list();
	public int receiveMsg_count();
	/*�������� ����Ʈ*/
	public List<SendMsg> sendMsg_list();
	public int sendMsg_count();
	/*���� ����*/
	public int inputMsg(SendMsg message);
	/*�������� ����*/
	public ReceiveMsg getReceiveMsg(int re_num) throws Exception;
	/*�������� ����*/
	public SendMsg getSendMsg(int se_num) throws Exception;
	/*�������� ����*/
	public int deleteReceive(int re_num);
	/*�������� ����*/
	public int deleteSend(int se_num);

}
