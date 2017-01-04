package factory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("factoryService")
public class FactoryServiceImpl implements FactoryService {
	@Autowired
	FactoryDao dao;

	/* factoryInfo.jsp */
	public ArrayList<FactoryCommand> allFactory() {
		
		List<FactoryCommand> factoryList = new ArrayList<FactoryCommand>();
		factoryList = dao.allFactory();
		
		return  (ArrayList<FactoryCommand>) factoryList;
	} //end allMem()
	
	/* factoryInput.jsp */
	@Override
	public int inputFactory(FactoryCommand command) {
		int check = dao.inputFactory(command);
		return check;
	}
	
	
	public void setDao(FactoryDao dao) {
		this.dao = dao;
	}
}
