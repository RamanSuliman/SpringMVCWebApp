package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import database.Employee;
import jakarta.validation.Valid;

@Controller
public class UserLoginController 
{	
	@RequestMapping("login")
	public ModelAndView getLoginPage()
	{
		ModelAndView view = new ModelAndView("login/login");
		return view;
	}
	
	@RequestMapping(value="submitLoginForm", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(@RequestParam Map<String, String> parameter)
	{
		ModelAndView view = new ModelAndView("result_mesasge");
		String username = parameter.get("username");
		String password = parameter.get("password");
		view.addObject("message", "Nice! <br><br> Username: " + username + " password: " + password);
		return view;
	}
	
	@RequestMapping(value="submitLoginNew", method = RequestMethod.POST)
	public String submitLoginForm(HttpServletRequest request, Model model)
	{
		//Read the provided from data
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String msg = "";
		String pageType = "";
		
		if(name.equalsIgnoreCase("Raman") && pass.equalsIgnoreCase("Raman"))
		{
			msg = "Hello " + name + "!";
			pageType = "index";
		}
		else
		{
			msg = "Sorry " + name + ", you entered an incorrect password.";
			pageType = "errorPage";
		}
			
		model.addAttribute("message", msg);
		return pageType;
	}

	@RequestMapping("{pathvariabletest}/whatever.html")
	public ModelAndView pathVariable(@PathVariable Map<String, String> variables)
	{
		//Define the view .jsp page name.
		ModelAndView view = new ModelAndView("HelloPage");
		view.addObject("welcomeMessage","Hi this message is from Raman -->" + variables.get("pathvariabletest") + " folder");
		return view;
	}
	
	
	/* #################################################### */
	
	@RequestMapping("/Enhancedlogin")
	public String getLoginForm(Model model)
	{
		model.addAttribute("user", new Employee());
		return "login/login";
	}
	
	@RequestMapping("/submitEnhancedForm")
	public String getLoginResults(@Valid @ModelAttribute("user") Employee user, BindingResult resultBinder, Model model)
	{
		System.out.println(resultBinder.hasErrors());
		if(resultBinder.hasErrors())
			return "login/login";
		model.addAttribute("message", "Hey " + user.getName() + " welcome! <br> Pass: " + user.getPassword());
		return "/login/result_message";
	}
	
}
