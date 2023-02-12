package uploader;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController 
{
	@RequestMapping(value="/uploadFile", method = RequestMethod.POST)
	public String uploadFiles(@RequestParam CommonsMultipartFile file, HttpSession session, Model model)
	{
		String path = session.getServletContext().getRealPath("/");
		String name = file.getOriginalFilename();
		System.out.println(path + name);
		
		try {
			byte[] fileBytes = file.getBytes();
			BufferedOutputStream writer =  new BufferedOutputStream(new FileOutputStream("C:\\Users\\raman\\Videos\\" + name));
			writer.write(fileBytes);
			writer.flush();
			writer.close();
		}catch (Exception e) {
			System.out.println("Error occured in saving uploaded file.");
		}
		
		model.addAttribute("uploadState", "C:\\Users\\raman\\Videos\\" + name);
		model.addAttribute("imageName", "C:\\Users\\raman\\Videos\\" + name);
		return "uploader/results";
	}
	
	@RequestMapping("/uploadForm")
	public String getuploadForm()
	{
		return "uploader/uploadPage";
	}
}
