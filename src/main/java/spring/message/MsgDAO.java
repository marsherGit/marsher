package spring.message;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MsgDAO extends SqlSessionDaoSupport {

	// ���� ���� ����Ʈ
	public List<ReceiveMsg> receiveMsg_list() {
		List<ReceiveMsg> receiveMsg_list = getSqlSession().selectList("message.getReceiveMsgList");
		return receiveMsg_list;
	}

	// ���� ���� ī��Ʈ
	public int receiveMsg_count() {
		int count = getSqlSession().selectOne("message.getReceiveMsgCount", Integer.class);
		return count;
	}

	// ���� ���� ����Ʈ
	public List<SendMsg> sendMsg_list() {
		List<SendMsg> sendMsg_list = getSqlSession().selectList("message.getSendMsgList");
		return sendMsg_list;
	}

	// ���� ���� ī��Ʈ
	public int sendMsg_count() {
		int count = getSqlSession().selectOne("message.getSendMsgCount", Integer.class);
		return count;
	}

	// inputMsg
	public int inputMsg(SendMsg message) {
		int check = -1;
		check = getSqlSession().insert("message.insert", message);
		return check;
	}

	// receiveMsgContent
	public ReceiveMsg getReceiveMsg(int re_num) {
		ReceiveMsg getReceiveMsg = getSqlSession().selectOne("message.getReceiveMsg", re_num);
		return getReceiveMsg;
	}

	// sendMsgContent
	public SendMsg getSendMsg(int se_num) {
		SendMsg getSendMsg = getSqlSession().selectOne("message.getSendMsg", se_num);
		return getSendMsg;
	}

	// deleteReceive
	public int deleteReceive(int re_num) {
		int check = getSqlSession().delete("message.deleteReceive", re_num);
		return check;
	}

	// deleteSend
	public int deleteSend(int se_num) {
		int check = getSqlSession().delete("message.deleteSend", se_num);
		return check;
	}

}
