package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.exception.StudentNotFoundExceptionn;
import com.klu.model.Student;
import com.klu.repository.StudentRepository;
@Service
public class StudentManager 
{
	@Autowired
	StudentRepository sr;
	public String insertData(Student s1)
	{
		sr.save(s1);
		return "insertion was done successfully";
	}
	public List<Student> getAllData()
	{
		return sr.findAll();
	}
	public Student getDataById(Long sid)
	{
		Optional<Student> s2=sr.findById(sid);
		if(s2.isPresent())
		{
			return s2.get();
		}
		else
		{
			throw new StudentNotFoundExceptionn("Student Records not exist:"+sid);
		}
	}
	public String updateAllData(Long sid,Student s2)
	{
		Optional<Student> s3=sr.findById(sid);
		if(s3.isPresent())
		{
			Student s4=s3.get();
			s4.setSname(s2.getSname());
			s4.setSdept(s2.getSdept());
			sr.save(s4);
			return "Data was updated Successfully";
		}
		else
		{
			throw new StudentNotFoundExceptionn("Student Records not exist:"+sid);
		}
	}
	public String updateName(Long sid,String sname)
	{
	 Optional<Student> s2=sr.findById(sid);
	 if(s2.isPresent())
	 {
		 Student s3=s2.get();
		 s3.setSname(sname);
		 sr.save(s3);
		 return "Name filed was updated successfully";		 
	 }
	 else
	 {
		 throw new StudentNotFoundExceptionn("Student Records not exist:"+sid);
	 }
	 
	}
	public String deleteData(Long sid)
	{
		 Optional<Student> s2=sr.findById(sid);
		 if(s2.isPresent())
		 {
			 sr.deleteById(sid);
			 return "data was deleted successfully";
		 }
		 else
		 {
			 throw new StudentNotFoundExceptionn("Student Records not exist:"+sid);
		 }
		
	}
	

}
