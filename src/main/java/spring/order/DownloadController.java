package spring.order;

import java.io.File;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.ApplicationContextAware;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware {
	private WebApplicationContext context = null;

	@RequestMapping("/file")
	public ModelAndView download() throws Exception {
		File downloadFile = getFile();
		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	private File getFile() {
		String path = context.getServletContext().getRealPath("/WEB-INF/Ό³Έν.txt");
		return new File(path);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
}
