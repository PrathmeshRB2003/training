package com.pb.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pb.entity.Employee;
import com.pb.util.EmployeeNotFoundException;
public interface EmployeeService {
	
	public String save(Employee e);
	public Employee fetch(int id) throws EmployeeNotFoundException;
	public List <Employee> list();
	public String remove(int id) throws EmployeeNotFoundException;
	public List<Employee> fetchAllJoinedUntil(LocalDate d);
	public List<Employee> fetchAllJoinedBetween(LocalDate s,LocalDate e);
	public List<Employee> fetchAllJob(String job);

	public List<Employee> fetchAllByHireDate(LocalDate hireDate);

	
	
	
	
}


