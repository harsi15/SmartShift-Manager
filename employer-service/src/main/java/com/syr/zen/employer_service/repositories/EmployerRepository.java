package com.syr.zen.employer_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.syr.zen.employer_service.repositories.entities.EmployerEntity;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerEntity, Integer> {

	@Query(value = "SELECT passwd FROM employer e WHERE e.email = :email", nativeQuery = true)
	String findByEmail(String email);

}
