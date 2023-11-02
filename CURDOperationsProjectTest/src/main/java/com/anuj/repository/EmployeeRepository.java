package com.anuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
