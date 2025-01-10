package com.syr.zen.employer_service.controllers;

import java.lang.reflect.InvocationTargetException;
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
import com.syr.zen.employer_service.dto.Employer;
import com.syr.zen.employer_service.dto.Login;
import com.syr.zen.employer_service.repositories.entities.EmployerEntity;
import com.syr.zen.employer_service.services.EmployerService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "/employer")
public class EmployerController {

	@Autowired
	EmployerService employerService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login loginData) {
		boolean employer = employerService.login(loginData.getEmail(), loginData.getPassword());
		if (employer == true) {
			return ResponseEntity.ok("success");
		} else {
			return ResponseEntity.ok("failure");
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<Employer> signup(@RequestBody Employer employer)
			throws IllegalAccessException, InvocationTargetException {
		EmployerEntity emEntity = new EmployerEntity();
		BeanUtils.copyProperties(emEntity, employer);
		return ResponseEntity.ok(employerService.signup(emEntity));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployerEntity> getEmployerById(@PathVariable Integer id) {

		Optional<EmployerEntity> employer = employerService.getEmployerById(id);
		return employer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployer(@PathVariable Integer id) {
		employerService.deleteEmployer(id);
		return ResponseEntity.ok().build();
	}
}
