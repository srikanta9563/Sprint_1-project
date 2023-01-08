package com.anudip.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.crud.entity.TicketBookings;

public interface TicketBookingRepository extends JpaRepository<TicketBookings, Integer> {
	// custom query search by Train name
	@Query("select t from TicketBookings t where t.trainName= ?1")
	List<TicketBookings> getBookingsByTrainName(String trainName);

	// custom query search by starting Railway Station Name
	@Query("select t from TicketBookings t where t.fromRailwayStationName= ?1")
	List<TicketBookings> getBookingByStartingRailwayStation(String fromRailwayStationName);

}
