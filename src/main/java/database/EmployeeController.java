package database;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * This class gets the spring-dispatcher-servlet.xml file to get the instance of EmployeeController and
 * call the saveEmployee() method.
 */

@Controller
public class EmployeeController 
{
	@Autowired
	private ApplicationContext context;
	@Autowired
	private EmployeeDao database; // Will inject an instance from the XML file  
	
	/* Return the add new employee form */
	@RequestMapping("addEmployee")
	public String addEmployee(Model model)
	{
		//Command model attribute is used if the ModelAttribute form attribute is not defined.
		model.addAttribute("command", new Employee());
		return "Employee/addForm";
	}
	
	/* Receive the employee object with form submission and save it to the database */
	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		database.saveEmployee(employee);
		// Redirect the view single employee page and pass the model data.
		return "redirect:/listEmployees";
	}
	
	/* List employees in model object  */
	@RequestMapping("/listEmployees")
	public String viewEmployee(Model model)
	{
		List<Employee> employees = database.getAllEmployees();
		model.addAttribute("list", employees);
		return "Employee/DisplayEmployeesData";
	}
	
	/* Return the edit form based on the given employee id in the URL. */
	@RequestMapping("/editForm/{id}")
	public String getEditForm(@PathVariable int id, Model model)
	{
		Employee employee = database.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "Employee/editForm";
	}
	
	/* On employee edit submission, save the new update */
	@RequestMapping(value="/saveEdit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("employee") Employee employee)
	{
		System.out.println(employee.getId());
		database.updateEmployee(employee);
		return "redirect:/listEmployees";
	}
	
	/* Remove an employee by given id in the URL */
	@RequestMapping(value="/deleteEmployee/{id}", method = RequestMethod.GET)
	public String removeEmployee(@PathVariable("id") int id)
	{
		System.out.println("Id: " + id);
		database.deleteEmployeeByID(id);
		return "redirect:/listEmployees";
	}
	
	
	/* Create Pagination */
	@RequestMapping(value="/pagination/{pageId}")
	public String pagination(@PathVariable int pageId, Model model)
	{
		int totalPerPage = 5;
		if(totalPerPage == 1) {}
		else
			pageId = (pageId - 1) * totalPerPage + 1;
		System.out.println(pageId);
		List<Employee> employees = database.getEmployeesByPage(pageId, totalPerPage);
		model.addAttribute("list", employees);
		return "Employee/DisplayEmployeesData";
	}
	
	
	
	/* #################################################################### */
	
	
	@RequestMapping("saveEmployee")
	public ModelAndView saveEmployee()
	{
		//ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring-dispatcher-servlet.xml");
		//employeeController = (EmployeeController) context.getBean("employeeController");
		
		int counter = 0;
		for(int i = 0; i < 5; i++)
			counter += database.saveEmployee(new Employee(2444, "Raman", 40000));
		
		int status = database.deleteEmployee(new Employee(2442, "Raman", 40000));
		int status1 = database.deleteEmployee(new Employee(500, "Raman", 40000));
		
		//boolean isInserted = employeeController.saveEmployeeByPreparedStatement(new Employee(6700, "Aras", 34563));
	
		ModelAndView view = new ModelAndView("DatabaseFeedback");

		view.addObject("state", 
				"Number of employees inserted " + counter + ".<br>" +
				"Number of employees removed " + status + ".<br>"+
						"Check removed: " + status1 + ".<br>"+
				"Has prepared statment worked? ");
		return view;
	}
	
	@RequestMapping("loadData")
	public ModelAndView loadEmployeeInfo()
	{
		//EmployeeController employeeController = (EmployeeController) context.getBean("employeeController");
		ModelAndView view = new ModelAndView("DisplayEmployeesData");
		
		List<Employee> employees = database.getAllEmployees();
		StringBuilder collection = new StringBuilder();
		System.out.println(employees.size());
		
		for(Employee employee : employees)
		{
			collection.append("ID: " + employee.getId() + "<br>" +
							"Name: " + employee.getName() + "<br>" + 
							"Salary: " + employee.getSalary() + "<br><br>"); 
		}
		view.addObject("employees", collection);
		return view;
	}
}
