package com.syr.zen.shift_service.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syr.zen.shift_service.dto.DropShift;
import com.syr.zen.shift_service.dto.Event;
import com.syr.zen.shift_service.dto.EventSheet;
import com.syr.zen.shift_service.repositories.FinalEventSheetRepository;
import com.syr.zen.shift_service.repositories.ShiftRepository;
import com.syr.zen.shift_service.repositories.entities.FinalEventSheetEntity;
import com.syr.zen.shift_service.repositories.entities.ShiftEntity;

@Service
@Transactional
public class ShiftService {
	@Autowired
	private ShiftRepository shiftRepository;

	@Autowired
	private FinalEventSheetRepository fnEvtSheetRepository;

	public Event addShift(ShiftEntity event) {
		ShiftEntity shEntity = new ShiftEntity();
		shEntity = shiftRepository.save(event);
		Event evt = new Event();
		BeanUtils.copyProperties(shEntity, evt);
		return evt;
	}

	public void deleteShift(Integer eventId) {
		shiftRepository.deleteById(eventId);
	}

	public Optional<ShiftEntity> getShiftsById(Integer eventId) {
		return shiftRepository.findById(eventId);
	}

	public List<Event> getAllShifts() {
		List<ShiftEntity> shEntity = new ArrayList<>();
		List<Event> result = new ArrayList<>();
		shEntity = shiftRepository.findAll();
		for (Object source : shEntity) {
			Event target = new Event();
			BeanUtils.copyProperties(source, target);
			result.add(target);
		}
		return result;
	}

	public void dropShift(DropShift dropShift) {
		fnEvtSheetRepository.dropShift(dropShift.getEmpId(), dropShift.getEventId());

	}

	public EventSheet signupShift(FinalEventSheetEntity fnEntity) {
		FinalEventSheetEntity entity = new FinalEventSheetEntity();
		Integer count = fnEvtSheetRepository.searchOnEventId(fnEntity.getEventId());
		Integer countOg = shiftRepository.searchOnEventId(fnEntity.getEventId());
		if(count==null) {
			count = 1;
		}else {
			count = count + 1;
		}
		
		if (count < countOg) {

			fnEntity.setCount(count);
			fnEntity.setTimeStamp((new Timestamp(System.currentTimeMillis()).toString()));

			entity = fnEvtSheetRepository.save(fnEntity);
			EventSheet evt = new EventSheet();
			BeanUtils.copyProperties(entity, evt);
			return evt;
		} else {
			return new EventSheet();
		}

	}
}
