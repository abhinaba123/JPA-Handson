package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(int id) 
	{
		return employeeRepository.findById(id).get();

	}
	
	@Transactional
	public void save(Employee emp) 
	{
		employeeRepository.save(emp);
		
	}
	
	
	@Transactional
	public List<Employee> getAllPermanentEmployees() 
	{
		return employeeRepository.getAllPermanentEmployees();
		
	}
	
	@Transactional
	public double getAvgSalary(int id) 
	{
		return employeeRepository.getAverageSalary(id);
	}

		
	@Transactional
	public List<Employee> getAllEmployeesNative()
	{
		return employeeRepository.getAllEmployeesNative();
	}

	
}
