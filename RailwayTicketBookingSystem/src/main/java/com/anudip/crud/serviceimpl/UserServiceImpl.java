package com.anudip.crud.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anudip.crud.entity.User;
import com.anudip.crud.exception.UserNotFoundException;
import com.anudip.crud.repository.UserRepository;
import com.anudip.crud.service.UserService;

@Service
// implementing all method of user service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository urepo;
	
	//saving user details using save() of jpaRepository
	@Override
	public User saveUser(User user) {
		
		return urepo.save(user);
		
	}
	// fetching all user details using finalAll() of JpaRepository
	@Override
	public List<User> getAllUser() {
		
		return urepo.findAll();
	}
	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public User getUserById(int uid) {
	
		return urepo.findById(uid).orElseThrow(() -> new UserNotFoundException("no user exists in table"));
	}

	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
	//& update any contact details of user
	@Override
	public User updateUserById(User user, int uid) {
		User newuser = urepo.findById(uid).orElseThrow(() -> new UserNotFoundException("no user exists in table"));

		// updated value
		newuser.setEmail(user.getEmail());
		newuser.setUphone(user.getUphone());
		
		urepo.save(newuser);
		return newuser;
	}

	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
// delete enter user id
	@Override
	public void deleteUserById(int uid) {
		
		urepo.findById(uid).orElseThrow(() -> new UserNotFoundException("no user exists in table"));
		urepo.deleteById(uid);
		

	}
	//fetching user details by fname
	@Override
	public List<User> getFname(String fname) {
		
		return urepo.getFname(fname);
	}
	//fetching user details by lname

	@Override
	public List<User> getLname(String lname) {
		
		return urepo.getLname(lname);
	}
	//fetching user details by user phone

	@Override
	public User getPhone(long uphone) {
		
		return urepo.getPhone(uphone);
	}

}
