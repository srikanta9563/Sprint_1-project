package com.anudip.crud.service;

import java.util.List;
import com.anudip.crud.entity.User;

//abstract method for performing CRUD on user entity
public interface UserService {
	
	//saving details of user 
	User saveUser(User user);
	
	//getting all details of user 
	List<User> getAllUser();
	
	//getting details of user based on uid
	User getUserById(int uid);
	
	//getting details of user based on uid & change mentioned details 
	User updateUserById(User user, int uid);
	
	//getting details of user based on uid & delete mentioned user
	void deleteUserById(int uid);
	
	
	List<User> getFname(String fname);

	List<User> getLname(String lname);
	
	User getPhone(long uphone);

}
