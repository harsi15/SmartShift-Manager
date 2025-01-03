package com.syr.zen.employee_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.syr.zen.employee_service.repositories.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	@Query(value = "SELECT * FROM employee e WHERE e.mailId = :mailId", nativeQuery = true)
	EmployeeEntity findByMailId(String mailId);

	@Query(value = "SELECT * FROM employee e WHERE e.verification_of_passwd is null", nativeQuery = true)
	List<EmployeeEntity> findAllUnverified();

	@Modifying
	@Query(value = "UPDATE employee e SET e.verification_of_passwd = :passwd WHERE e.id = :id", nativeQuery = true)
	void verifyEmployees(String id, String passwd);
}
