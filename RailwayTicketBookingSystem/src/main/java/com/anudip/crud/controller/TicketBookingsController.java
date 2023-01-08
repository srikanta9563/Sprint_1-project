package com.anudip.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.crud.entity.TicketBookings;
import com.anudip.crud.service.TicketBookingsService;

@RestController
@RequestMapping("/booking")
public class TicketBookingsController {
	@Autowired
	private TicketBookingsService ts;

	// save booking details in db table using rest api PostMapping
	@PostMapping("/test")
	public ResponseEntity<TicketBookings> saveBookings(@Valid @RequestBody TicketBookings booking) {
		return new ResponseEntity<TicketBookings>(ts.saveBookings(booking), HttpStatus.CREATED);
	}

	// fetch booking details from db table using rest api GetMapping
	@GetMapping("/test")
	public List<TicketBookings> getAll() {
		return ts.getAllBookings();
	}

	// fetch booking details from db table using rest api GetMapping based on
	// booking id
	@GetMapping("/test/{bookingId}")
	public ResponseEntity<TicketBookings> getU(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<TicketBookings>(ts.getBookingsById(bookingId), HttpStatus.OK);
	}

	// delete booking details in db table using rest api PutMapping based on booking
	// id
	@DeleteMapping("/test/{bookingId}")
	public ResponseEntity<String> deleteUser(@PathVariable("bookingId") int bookingId) {
		ts.deleteBookingById(bookingId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	// fetch booking details by Train name
	@GetMapping("/test/{trainName}")
	public List<TicketBookings> getFname(@PathVariable String trainName) {
		return ts.getBookingsByTrainName(trainName);
	}

	// fetch booking details by from Railway Station
	@GetMapping("/test/{fromRailwayStationName}")
	public List<TicketBookings> getLname(@PathVariable String fromRailwayStationName) {
		return ts.getBookingByStartingRailwayStation(fromRailwayStationName);
	}

}
