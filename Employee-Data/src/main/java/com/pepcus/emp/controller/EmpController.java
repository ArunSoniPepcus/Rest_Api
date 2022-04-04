package com.pepcus.emp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pepcus.emp.entity.EmpEntity;
import com.pepcus.emp.service.EmpService;

@Controller
public class EmpController {


	@Autowired
	private EmpService service;


	@GetMapping("/")
	public String home(Model addvalue) {
		
		List<EmpEntity> emp=service.getAllEmp();
		addvalue.addAttribute("empcontain",emp);
		return "index";
	}

	@GetMapping("/AddEmployee")
	public String addEmpForm() {
		return "add_emp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute EmpEntity empData, HttpSession session) {

		service.addEmp(empData);
		session.setAttribute("msg", "Employee Added Sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		EmpEntity e = service.getEmpById(id);
		m.addAttribute("emp", e);
		return "editEmp";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute EmpEntity e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/";
	}
}