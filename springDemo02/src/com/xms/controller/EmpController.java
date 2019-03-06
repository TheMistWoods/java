package com.xms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xms.dao.EmpDAO;
import com.xms.entity.Emp;


@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Resource
	private EmpDAO empDAO;
	
	@RequestMapping("/findAll.do")
	public String findAll(Model model){
		
		List<Emp> emps = empDAO.findAll();
		model.addAttribute("emps", emps);
		
		return "emp/emplist";
	}
	
	@RequestMapping("/toUpdate.do")
	public String toUpdate(int empno,Model model){
		
		Emp emp = empDAO.findByEmpno(empno);
		model.addAttribute("emp", emp);
		
		return "emp/update";
	}
	
	@RequestMapping("/update.do")
	public String update(Emp emp){
		
		empDAO.update(emp);
		
		return "redirect:findAll.do";
	}
	
	@RequestMapping("toAdd.do")
	public String toAdd(){
		
		return "emp/add";
	}
	
	@RequestMapping("/add.do")
	public String add(Emp emp){
		
		empDAO.save(emp);
		
		return "redirect:findAll.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(int empno){
		
		empDAO.delete(empno);
		
		return "redirect:findAll.do";
	}
}
