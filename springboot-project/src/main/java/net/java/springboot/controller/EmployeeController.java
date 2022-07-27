package net.java.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.entity.Employee;
import net.java.springboot.exception.ResourceNotFoundException;
import net.java.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository EmployeeRepository;

	// get all 
	@GetMapping()
	public List<Employee> getAllEmployees() {
		return this.EmployeeRepository.findAll();
	}

	// get 
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable (value = "id") long EmployeeId) {
		return this.EmployeeRepository.findById(EmployeeId)
				.orElseThrow(() -> new ResourceNotFoundException("(HTTP 404)Employee not found with id" + EmployeeId));
	}

	// create 
	@PostMapping()
	public Employee createUser(@RequestBody Employee employee) {
		return this.EmployeeRepository.save(employee);
	}	
	
}
