package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
{

	@RequestMapping("/")
	protected String getHomePage()
	{
		//Define the index.jsp page name.
		return "index";
	}
	
	@RequestMapping("/welcome.html")
	protected ModelAndView getHomePage2()
	{
		//Define the view .jsp page name.
		ModelAndView view = new ModelAndView("HelloPage");
		view.addObject("welcomeMessage","Hi this message is from Raman!");
		return view;
	}

}
