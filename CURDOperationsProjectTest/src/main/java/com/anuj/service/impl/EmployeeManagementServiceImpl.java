package com.anuj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.entity.Employee;
import com.anuj.exception.EmployeeNotFoundException;
import com.anuj.repository.EmployeeRepository;
import com.anuj.service.IEmployeeManagement;
@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagement {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public String registerEmployee(Employee employee) {
		Integer empId = empRepo.save(employee).getId();

		return "Employee is Register with Employee ID::"+empId;
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		List<Employee> list = empRepo.findAll();
		list.sort((e1,e2)->e1.getId().compareTo(e2.getId()));
		return list;
	}

	@Override
	public String updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> optional = empRepo.findById(employee.getId());
	
		if(optional.isPresent()) {
			empRepo.save(employee);
			return employee.getId()+" Employee is Updated";
		}else {
			throw new EmployeeNotFoundException(employee.getId()+" Employee Not Found");
		}
		
	}

	@Override
	public String deleteEmployee(Integer emplId) throws EmployeeNotFoundException {
		Optional<Employee> optional = empRepo.findById(emplId);
		
		if(optional.isPresent()) {
			empRepo.delete(optional.get());
			return emplId+ "Employee is Deleted";
		}else {
			throw new EmployeeNotFoundException(emplId+" Employee Not Found");
		}
	}

}
