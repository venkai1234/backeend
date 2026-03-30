package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Student;
import com.klu.service.StudentManager;

@RestController
@RequestMapping("/dbcrud")
@ResponseBody
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController 
{
	@Autowired
	StudentManager sm;
	@PostMapping("/insert")
	@ResponseBody
	//http://localhost:8080/dbcrud/insert
	public String insert(@RequestBody Student s2)
	{
		return sm.insertData(s2);
	}
	@GetMapping("/getall")
	@ResponseBody
	public List<Student> getAll()
	{
		return sm.getAllData();
	}
	@GetMapping("/getbyid/{sid}")
	@ResponseBody
	public Student getById(@PathVariable Long sid)
	{
		return sm.getDataById(sid);
	}
	//http://localhost:8080/dbcrud/updateall/2
	@PutMapping("/updateall/{sid}")
	@ResponseBody
	public String updateAllData(@PathVariable Long sid,@RequestBody Student s5) 
	{
		return sm.updateAllData(sid, s5);
	}
	//http://localhost:8080/dbcrud/updatename/2?sname=pavan
	@PatchMapping("/updatename/{sid}")
	@ResponseBody
	public String updateName(@PathVariable Long sid,@RequestParam String sname) 
	{
		return sm.updateName(sid, sname);
	}
	//http://localhost:8080/dbcrud/deletebyId/2
	@DeleteMapping("deletebyId/{sid}")
	@ResponseBody
	public String deleteById(@PathVariable Long sid)
	{
		return sm.deleteData(sid);
	}
	

}
