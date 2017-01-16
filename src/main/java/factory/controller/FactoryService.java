package factory.controller;

import java.util.ArrayList;

public interface FactoryService {
	public ArrayList<FactoryCommand> allFactory();				//factoryInfo

	public int inputFactory(FactoryCommand command, String contextRoot);			//factoryInput
	
}
