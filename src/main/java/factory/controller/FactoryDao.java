package factory.controller;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class FactoryDao extends SqlSessionDaoSupport {
	
	/* factoryInfo.jsp */
	public ArrayList<FactoryCommand> allFactory() {
		
		List<FactoryCommand> facotryList = new ArrayList<FactoryCommand>();
		facotryList = getSqlSession().selectList("factory.allFactory");
		
		return  (ArrayList<FactoryCommand>) facotryList;
		
	}
	
	/* factoryInput.jsp */
	public int inputFactory(FactoryCommand command) {
		int check = -1;
		check = getSqlSession().insert("factory.insertFactory", command);
		return check;
	}

}
