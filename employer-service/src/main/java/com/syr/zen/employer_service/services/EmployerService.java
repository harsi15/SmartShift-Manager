package com.syr.zen.employer_service.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syr.zen.employer_service.dto.Employer;
import com.syr.zen.employer_service.repositories.EmployerRepository;
import com.syr.zen.employer_service.repositories.entities.EmployerEntity;

@Service
@Transactional
public class EmployerService {
	@Autowired
	private EmployerRepository employerRepository;

	public boolean login(String email, String password) {

		String passwd = employerRepository.findByEmail(email);
		if (passwd.equals(password)) {
			return true;
		}
		return false;
	}

	public Employer signup(EmployerEntity employer) {
		EmployerEntity emEntity = new EmployerEntity();
		emEntity = employerRepository.save(employer);
		Employer emp = new Employer();
		BeanUtils.copyProperties(emEntity, emp);
		return emp;
	}

	public void deleteEmployer(Integer id) {
		employerRepository.deleteById(id);
	}

	public Optional<EmployerEntity> getEmployerById(Integer id) {
		return employerRepository.findById(id);
	}

}
