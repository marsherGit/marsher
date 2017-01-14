package factory.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public int inputFactory(FactoryCommand command, String contextRoot) {
		int fac_id = 0;
		fac_id = dao.maxFactory() + 1;
		
		MultipartFile fac_file = command.getFac_file();
		if(fac_file != null){
			String original_file_name = fac_file.getOriginalFilename();
			int pos = original_file_name.lastIndexOf(".");
			String original_extention = original_file_name.substring(pos);
			
			String stored_file_path = contextRoot + "saveFile\\";
			String stored_file_name = "factory" + fac_id;
			if(pos > 0) stored_file_name += original_extention;
			
			File stored_file = new File(stored_file_path + stored_file_name);
			try {
				fac_file.transferTo(stored_file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			command.setFac_image(stored_file_name);
		}
		command.setFac_id(fac_id);
		
		System.out.println(command);			//test code
		
		int check = dao.inputFactory(command);
		return check;
	}
	
	
	public void setDao(FactoryDao dao) {
		this.dao = dao;
	}
}
