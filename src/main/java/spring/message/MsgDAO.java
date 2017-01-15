package spring.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MsgDAO extends SqlSessionDaoSupport {

	// ���� ���� ����Ʈ
	public List<Object> receiveMsg_list(int startRow,int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);		
		List<Object> receiveMsg_list = getSqlSession().selectList("message.getReceiveMsgList", map);
		return receiveMsg_list;
	}

	// ���� ���� ī��Ʈ
	public int receiveMsg_count(String memId) {
		int count = getSqlSession().selectOne("message.getReceiveMsgCount", memId);
		return count; 
	}

	// ���� ���� ����Ʈ
	public List<Object> sendMsg_list(int startRow,int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);	
		List<Object> sendMsg_list = getSqlSession().selectList("message.getSendMsgList",map);
		return sendMsg_list;
	}

	// ���� ���� ī��Ʈ
	public int sendMsg_count(String memId) {
		int count = getSqlSession().selectOne("message.getSendMsgCount", memId);
		return count;
	}

	// inputSeMsg
	public int inputSeMsg(SendMsg message) {
		int check = -1;
		check = getSqlSession().insert("message.insertSe", message);
		return check;
	}

	// inputReMsg
	public int inputReMsg(ReceiveMsg message) {
		int check = -1;
		check = getSqlSession().insert("message.insertRe", message);
		return check;
	}

	// receiveMsgContent
	public ReceiveMsg getReceiveMsg(int num) {
		ReceiveMsg getReceiveMsg = getSqlSession().selectOne("message.getReceiveMsg", num);
		return getReceiveMsg;
	}

	// sendMsgContent
	public SendMsg getSendMsg(int num) {
		SendMsg getSendMsg = getSqlSession().selectOne("message.getSendMsg", num);
		return getSendMsg;
	}

	// deleteReceive
	public int deleteReceive(int num) {
		int check = getSqlSession().delete("message.deleteReceive", num);
		return check;
	}

	// deleteSend
	public int deleteSend(int num) {
		int check = getSqlSession().delete("message.deleteSend", num);
		return check;
	}

	// updateSeCheckDate
	public int updateSeCheckDate(int num) {
		int check = -1;
		check = getSqlSession().update("message.updateSeDate", num);
		return check;
	}

	// updateReCheckDate
	public int updateReCheckDate(int num) {
		int check = -1;
		check = getSqlSession().update("message.updateReDate", num);
		return check;
	}
	
	public int newMsg_count() {
		int count = getSqlSession().selectOne("message.getNewMsgCount", Integer.class);
		return count;
	}

}
