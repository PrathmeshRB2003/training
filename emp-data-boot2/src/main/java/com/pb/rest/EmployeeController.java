package com.pb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pb.entity.Employee;
import com.pb.service.EmployeeService;
import com.pb.util.EmployeeNotFoundException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping(value = "/save", consumes = "application/json")
    public String saveEmployee(@RequestBody Employee employee) {
        return service.save(employee);
        
    }
    
    @GetMapping(value = "/fetch/{id}", produces = "application/json")
    public Employee fetchEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        return service.fetch(id);
    }
    
    @GetMapping(value = "/list", produces = "application/json")
    public List<Employee> listEmployees() {
        return service.list();
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        service.remove(id);
    }
  

    @GetMapping(value="/find/{dt}", produces= "application/json")
	public List<Employee> beforeDate(@PathVariable("dt") LocalDate dt){
		return service.fetchAllJoinedUntil(dt);
		
	}
	
	@GetMapping(value="/findbet/{dt1}/{dt2}", produces= "application/json")
	public List<Employee> betweendt(@PathVariable("dt1") LocalDate dt1,@PathVariable("dt2") LocalDate dt2 ){
		return service.fetchAllJoinedBetween(dt1, dt2);
	}
	
	@GetMapping(value = "/findByJob/{job}", produces = "application/json")
	public List<Employee> findByJob(@PathVariable("job") String job) {
	    return service.fetchAllJob(job);
	}

	@GetMapping(value = "/findByHireDate/{hireDate}", produces = "application/json")
	public List<Employee> findByHireDate(@PathVariable LocalDate hireDate) {
	    return service.fetchAllByHireDate(hireDate);
	}

    
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleException(EmployeeNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
   
}





	