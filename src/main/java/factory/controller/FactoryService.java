package factory.controller;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface FactoryService {
	public ArrayList<FactoryCommand> allFactory();				//factoryInfo

	public int inputFactory(FactoryCommand command, String contextRoot);			//factoryInput
	
}
