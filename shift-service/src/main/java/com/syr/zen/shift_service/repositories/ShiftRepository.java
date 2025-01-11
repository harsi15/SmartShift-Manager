package com.syr.zen.shift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.syr.zen.shift_service.repositories.entities.ShiftEntity;

@Repository
public interface ShiftRepository extends JpaRepository<ShiftEntity, Integer> {

	@Query(value = "select number_of_employee from eventdetails e where e.event_id = :eventId", nativeQuery = true)
	Integer searchOnEventId(Integer eventId);

}
