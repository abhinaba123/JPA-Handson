package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;

@Service
public class DepartmentService 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	public Department get(Integer id)
	{
		return departmentRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Department dep)
	{
		departmentRepository.save(dep);
	}
}
