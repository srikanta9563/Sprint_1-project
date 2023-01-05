package com.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
	@SequenceGenerator(sequenceName = "seq_id", allocationSize = 1, name = "seq_id")

	private Integer customerId;

	@NotBlank(message = "--You must enter your full Name-- ")
	@Column(length = 40)
	private String fullName;

	private String address;

	@Column(length = 25)
	@NotNull(message = "--please provide email column in postman api--")
	@NotBlank(message = "--You must enter your mail id in the given column--")
	@Email(message = "--Please provide proper mail id--")
	private String email;

	private long phone;

	private String gender;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cust")
	@JsonIgnoreProperties("cust")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Cart> itemList = new ArrayList<>();

}
