package com.java.spring.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.Service.ProductService;
import com.java.spring.beans.Employee;


@RestController
@RequestMapping("/Employee")
public class EmployeeRestController {
	
	@Autowired
	ProductService productService;

	 static private List<Employee> empList = new ArrayList<Employee>();
	
	static {
		System.out.println( "Employee rest Controller loaded..");
		empList.add(new Employee(111, "AAA", "Pune", 3233.4, "aaa@gmail.com"));
		empList.add(new Employee(222, "BBB", "Mumbai", 4231.4, "bbb@gmail.com"));
		empList.add(new Employee(333, "CCC", "Hingoli", 3432.4, "ccc@gmail.com"));
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<Employee> getListOfEmployee() {
//		System.out.println("Hello world to rest");
//		HashMap<String,Object> model = new HashMap<String, Object>();
//		model.put("sBean",new Employee());
		return empList;
	}
	
//	@PostMapping("/saveEmployee")
//	public String saveEmployee(@ModelAttribute("empBean") Employee empBean) {
//		
//		return "Employee details saved....";
//	}
//	
//	@GetMapping("/")
//	public List<Employee> printString() {
////		return "Print String method called";
//		return empList;
//	}
}
