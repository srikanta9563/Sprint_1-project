package com.anudip.crud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Table(name = "booking_details") // table name
@Entity
public class TicketBookings {
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Train name cannot be blank")
	private String trainName;

	@Column(length = 30, nullable = false)
	@NotNull(message = "Train Number cannot be Null")
	private long trainNumber;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Railway Station Name cannot be blank")
	private String fromRailwayStationName;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Railway Station Name cannot be blank")
	private String toRailwayStationName;

	@Column(length = 10, nullable = false)
	@NotBlank(message = "date cannot be blank")
	private String date;

	@Column(length = 7, nullable = false)
	@NotNull(message = "departure time cannot be blank")
	private String departureTime;

	@Column(length = 5, nullable = false)
	@NotNull(message = "no of person cannot be blank")
	private int noOfPerson;

	@Column(length = 10, nullable = false)
	@NotNull(message = "Price cannot be blank")
	private double price;

	@Column(length = 10, nullable = false)
	@NotNull(message = "cannot be blank")
	private double totalPrice;

	// many mapping between ticketBookings and user.
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", referencedColumnName = "uid")
	@JsonBackReference
	private User user;
}
