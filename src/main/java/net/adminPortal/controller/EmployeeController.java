package net.adminPortal.controller;

import java.util.HashMap;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.adminPortal.entity.Employee;
import net.adminPortal.exception.ResourceNotFoundException;
import net.adminPortal.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	// get all employees
		@GetMapping("/employees")
		public List<Employee> getEmployeeList(){
			return employeeRepository.findAll();
		}

		// create employee rest api
		@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}

		// get employee by id rest api
		@GetMapping("/employees/{employeeId}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
			Employee employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id :" + employeeId));
			return ResponseEntity.ok(employee);
		}

		// update employee rest api

		@PutMapping("/employees/{employeeId}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employeeDetails){
			Employee employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id :" + employeeId));

			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmail(employeeDetails.getEmail());

			Employee updatedEmployee = employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}

		// delete employee rest api
		@DeleteMapping("/employees/{employeeId}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long employeeId){
			Employee employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id :" + employeeId));

			employeeRepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
