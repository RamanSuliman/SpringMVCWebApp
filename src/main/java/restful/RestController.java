package restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/rest")
public class RestController 
{
	@RequestMapping("/hello")
	public String getHello()
	{
		return "Hello from Raman";
	}
	
	
}
