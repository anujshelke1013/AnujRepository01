package com.anuj.service;

import java.util.List;

import com.anuj.entity.Employee;
import com.anuj.exception.EmployeeNotFoundException;

public interface IEmployeeManagement {
	
	public String registerEmployee(Employee employee) ;
	
	public List<Employee> fetchAllEmployee();
	
	public String updateEmployee(Employee employee) throws EmployeeNotFoundException;
	
	public String deleteEmployee(Integer emplId) throws EmployeeNotFoundException;
	

}
