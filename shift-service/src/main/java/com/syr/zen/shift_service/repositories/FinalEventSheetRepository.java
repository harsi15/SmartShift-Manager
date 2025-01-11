package com.syr.zen.shift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.syr.zen.shift_service.repositories.entities.FinalEventSheetEntity;

@Repository
public interface FinalEventSheetRepository extends JpaRepository<FinalEventSheetEntity, Integer> {

	@Modifying
	@Query(value = "DELETE FROM finaleventsheet f WHERE f.emp_id = :empId and f.event_id = :eventId", nativeQuery = true)
	void dropShift(Integer empId, Integer eventId);

	@Query(value = "select count from finaleventsheet f where f.event_id = :eventId order by f.timestamp desc limit 1", nativeQuery = true)
	Integer searchOnEventId(Integer eventId);

}
