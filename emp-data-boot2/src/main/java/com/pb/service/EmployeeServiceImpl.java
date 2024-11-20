package com.pb.service;

import java.time.LocalDate;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.pb.entity.Employee;
import com.pb.repo.EmployeeRepository;
import com.pb.util.EmployeeNotFoundException;
 
@Service
public class EmployeeServiceImpl implements EmployeeService {
 
	@Autowired
	private EmployeeRepository repo;

 
	@Override
	public String save(Employee e) {
		repo.save(e);
		return ("Saved");
	}
 
	@Override
	public Employee fetch(int id) throws EmployeeNotFoundException {
		return repo.findById(id).orElseThrow(()-> new
				EmployeeNotFoundException("No employee with Id: "+id));
	}
 
	@Override
	public List<Employee> list() {
		return repo.findAll();
	}
	
	@Override
	public String remove(int id) throws EmployeeNotFoundException{
		if (!repo.existsById(id)) {
            throw new EmployeeNotFoundException("No employee with Id: " + id);
        }
		repo.deleteById(id);
		return ("deleted");
	}
	@Override
	public List<Employee> fetchAllJoinedUntil(LocalDate d) {
		return repo.findAllHiredBefore(d);
	}
 
	@Override
	public List<Employee> fetchAllJoinedBetween(LocalDate s, LocalDate e) {
		return repo.findAllHiredBetween(s, e);
	}
	@Override
	public List<Employee> fetchAllJob(String job) {
		return repo.findByJob(job);
	  
	}

	@Override
	public List<Employee> fetchAllByHireDate(LocalDate hireDate) {
		
		return repo.findByHireDate(hireDate);
	}

 
 
 
}








//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.pb.entity.Employee;
//import com.pb.repo.EmployeeRepository;
//import com.pb.util.EmployeeNotFoundException;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//	
//	@Autowired
//	private EmployeeRepository repo;
//
//	@Override
//	public String save(Employee e) {
//		repo.save(e);
//
//		return "saved.";
//		
//	}
//	 @Override
//		public Employee fetch(int id) throws EmployeeNotFoundException {
//			return repo.findById(id).orElseThrow(()-> new
//					EmployeeNotFoundException("No employee with Id: "+id));
//		}
//	 
//		@Override
//		public List<Employee> list() {
//			return repo.findAll();
//		}
//	 
//		@Override
//		public String remove(int id) {
//			repo.deleteById(id);
//			
//			return ("deleted");
//	 
//		}
//	 
//		@Override
//		public List<Employee> fetchAllJoinedUntil(LocalDate d) {
//			return repo.findAllHiredBefore(d);
//		}
//	 
//		@Override
//		public List<Employee> fetchAllJoinedBetween(LocalDate s, LocalDate e) {
//			return repo.findAllHiredBetween(s, e);
//		}
//
////	@Override
////	public List<Employee> fetchAllJoinedUntil(LocalDate d) {
////		// TODO Auto-generated method stub
////		return repo.findAllHiredBefore(d);
////	}
////
////	@Override
////	public List<Employee> fetchAllJoinedBetween(LocalDate s, LocalDate e) {
////		// TODO Auto-generated method stub
////		return repo.findAllHiredBetween(s,e);
////	}
//
//}
