package com.howtodoinjava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.howtodoinjava.entity.EmployeeEntity;
import com.howtodoinjava.service.EmployeeManager;

@Controller
public class EditEmployeeController {
	
	@Autowired
	private EmployeeManager employeeManager;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(@ModelAttribute(value="employee") EmployeeEntity employee, ModelMap map) 
	{
		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployees());
		
		return "editEmployeeList";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value="employee") EmployeeEntity employee, BindingResult result) 
	{
		List<Integer> listIds = new ArrayList<Integer>();
		List<EmployeeEntity> listEmp = employeeManager.getAllEmployees();
		
		for (EmployeeEntity emp : listEmp) {
			listIds.add(emp.getId());
		}
		if( listIds.contains(employee.getId()) ) {
			employeeManager.updateEmployee(employee);
		} else {
			System.out.println("insert Employee");
			employeeManager.addEmployee(employee);
		}
		return "redirect:/";
	}

	
	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
	{
		employeeManager.deleteEmployee(employeeId);
		return "redirect:/";
	}

	
	@RequestMapping("view/{employeeId}")
	public String viewEmplyee(@PathVariable("employeeId") Integer employeeId, ModelMap map)
	{
		map.addAttribute("employee", employeeManager.getEmployee(employeeId));
		map.addAttribute("employeeList", employeeManager.getAllEmployees());
		return "editEmployeeList";
	}

	
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}
}
