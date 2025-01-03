package com.syr.zen.employee_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syr.zen.employee_service.dto.Employee;
import com.syr.zen.employee_service.repositories.EmployeeRepository;
import com.syr.zen.employee_service.repositories.entities.EmployeeEntity;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeEntity login(String email, String password) {
		EmployeeEntity emEntity = new EmployeeEntity();
		emEntity = employeeRepository.findByMailId(email);
		if (emEntity.getPasswd().equals(password)) {
			return emEntity;
		}
		return emEntity;
	}

	public Employee signup(EmployeeEntity employee) {
		EmployeeEntity emEntity = new EmployeeEntity();
		emEntity = employeeRepository.save(employee);
		Employee emp = new Employee();
		BeanUtils.copyProperties(emEntity, emp);
		return emp;
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	public Optional<EmployeeEntity> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	public Employee updateEmployee(EmployeeEntity employee) {
		EmployeeEntity emEntity = new EmployeeEntity();
		emEntity = employeeRepository.save(employee);
		Employee emp = new Employee();
		BeanUtils.copyProperties(emEntity, emp);
		return emp;
	}

	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> emEntity = new ArrayList<>();
		List<Employee> result = new ArrayList<>();
		emEntity = employeeRepository.findAll();
		for (Object source : emEntity) {
			Employee target = new Employee();
			BeanUtils.copyProperties(source, target);
			result.add(target);
		}
		return result;
	}

	public List<Employee> getAllUnverifiedEmployees() {
		List<EmployeeEntity> emEntity = new ArrayList<>();
		List<Employee> result = new ArrayList<>();
		emEntity = employeeRepository.findAllUnverified();
		for (Object source : emEntity) {
			Employee target = new Employee();
			BeanUtils.copyProperties(source, target);
			result.add(target);
		}
		return result;
	}

	public void verifyEmployees(String id, String email) {
		EmployeeEntity emEntity = employeeRepository.findByMailId(email);
		employeeRepository.verifyEmployees(id, emEntity.getPasswd());
		
	}
}
