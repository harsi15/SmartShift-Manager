package com.syr.zen.employee_service.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syr.zen.employee_service.dto.Employee;
import com.syr.zen.employee_service.dto.Login;
import com.syr.zen.employee_service.dto.Verification;
import com.syr.zen.employee_service.repositories.entities.EmployeeEntity;
import com.syr.zen.employee_service.services.EmployeeService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/login")
	public ResponseEntity<EmployeeEntity> login(@RequestBody Login loginData) {
		return ResponseEntity.ok(employeeService.login(loginData.getEmail(), loginData.getPassword()));
		
	}

	@PostMapping("/signup")
	public ResponseEntity<Employee> signup(@RequestBody Employee employee)
			throws IllegalAccessException, InvocationTargetException {
		EmployeeEntity emEntity = new EmployeeEntity();
		BeanUtils.copyProperties(emEntity, employee);
		return ResponseEntity.ok(employeeService.signup(emEntity));
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Integer id) {
		Optional<EmployeeEntity> employee = employeeService.getEmployeeById(id);
		return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/unverified")
	public ResponseEntity<List<Employee>> getAllUnverifiedEmployees() {
		return ResponseEntity.ok(employeeService.getAllUnverifiedEmployees());
	}
	
	@PostMapping("/verify")
	public ResponseEntity<Void> verifyEmployees(@RequestBody Verification verificationData) {
		employeeService.verifyEmployees(verificationData.getId(),verificationData.getEmail());
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().build();
	}
}
