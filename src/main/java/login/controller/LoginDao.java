package login.controller;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LoginDao extends SqlSessionDaoSupport {
	public String getArticle(String st_id) {
		return (String) getSqlSession().selectOne("loginMem.checkMem",st_id);
	}
}