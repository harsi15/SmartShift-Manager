package com.syr.zen.shift_service.controllers;

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

import com.syr.zen.shift_service.dto.DropShift;
import com.syr.zen.shift_service.dto.Event;
import com.syr.zen.shift_service.dto.EventSheet;
import com.syr.zen.shift_service.repositories.entities.FinalEventSheetEntity;
import com.syr.zen.shift_service.repositories.entities.ShiftEntity;
import com.syr.zen.shift_service.services.ShiftService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "/shift")
public class ShiftController {

	@Autowired
	ShiftService shiftService;

	@PostMapping("/addshifts")
	public ResponseEntity<Event> addShifts(@RequestBody Event event)
			throws IllegalAccessException, InvocationTargetException {
		ShiftEntity shEntity = new ShiftEntity();
		BeanUtils.copyProperties(shEntity, event);
		return ResponseEntity.ok(shiftService.addShift(shEntity));
	}

	@PostMapping("/signupShift")
	public ResponseEntity<EventSheet> signupShift(@RequestBody EventSheet signupEvent) throws IllegalAccessException, InvocationTargetException {
		FinalEventSheetEntity fnEntity = new FinalEventSheetEntity();
		BeanUtils.copyProperties(fnEntity, signupEvent);
		return ResponseEntity.ok(shiftService.signupShift(fnEntity));
	}

	@GetMapping
	public ResponseEntity<List<Event>> getAllShifts() {
		return ResponseEntity.ok(shiftService.getAllShifts());
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<ShiftEntity> getShiftById(@PathVariable Integer eventId) {
		Optional<ShiftEntity> event = shiftService.getShiftsById(eventId);
		return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{eventId}")
	public ResponseEntity<Void> deleteShift(@PathVariable Integer eventId) {
		shiftService.deleteShift(eventId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/dropShift")
	public ResponseEntity<Void> dropShift(@RequestBody DropShift dropShift) {
		shiftService.dropShift(dropShift);
		return ResponseEntity.ok().build();
	}
}