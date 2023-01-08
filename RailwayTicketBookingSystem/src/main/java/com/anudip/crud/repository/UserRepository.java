package com.anudip.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.crud.entity.User;

// user repo extending JpaRepository
public interface UserRepository extends JpaRepository<User, Integer>{
	//custom query search by first name
	@Query("select u from User u where u.fname = ?1")
	List<User> getFname(String fname);
	//custom query search by last name
	@Query("select u from User u where u.lname = ?1")
	List<User> getLname(String lname);
	//custom query search by phone
	@Query("select u from User u where u.uphone = ?1")
	User getPhone(long uphone);
}
