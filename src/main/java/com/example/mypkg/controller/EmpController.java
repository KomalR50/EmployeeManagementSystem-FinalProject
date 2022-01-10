package com.example.mypkg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mypkg.entity.Employee;
import com.example.mypkg.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "Index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session)
	{
	    System.out.println(e);
	    
	    service.addEmp(e);
	    session.setAttribute("msg", "Employee Added Successfully..");	
	    return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		Employee e=service.getEmpById(id);
		
	    m.addAttribute("emp",e);	
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Employee Data Updated Successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee Data Deleted Successfully..");
		return "redirect:/";
	}
}
