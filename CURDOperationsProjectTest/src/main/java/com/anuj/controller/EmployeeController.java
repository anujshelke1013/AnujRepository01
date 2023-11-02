package com.anuj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.entity.Employee;
import com.anuj.service.IEmployeeManagement;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeManagement empService;
	
	@PostMapping("/regsister")
	public ResponseEntity<String> enrollEmployee(@RequestBody Employee employee){
		try {
			String resultMsg = empService.registerEmployee(employee);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Problem in Employee Registration",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayEmployees(){
		try {
			List<Employee> list = empService.fetchAllEmployee();
			return new ResponseEntity<List<Employee>>(list,HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			return new ResponseEntity<String>("Problem in Fetching Employee",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/edit")
	public ResponseEntity<String> editEmployee(@RequestBody Employee employee){
		try {
			String resultMsg = empService.updateEmployee(employee);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String>  removeEmployee(@PathVariable("id") Integer id){
		try {
		//use service
		String  msg=empService.deleteEmployee(id);
		 return  new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>(e.getMessage(),
					                                                                HttpStatus.NOT_FOUND);
		}
		
	}
}
