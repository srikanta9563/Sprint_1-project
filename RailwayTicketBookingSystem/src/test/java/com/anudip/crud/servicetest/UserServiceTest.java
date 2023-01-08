package com.anudip.crud.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.anudip.crud.entity.User;
import com.anudip.crud.repository.UserRepository;
import com.anudip.crud.service.UserService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService cs;
	@MockBean
	private UserRepository crepo;
	//testing save user method
	@Test
	public void testSaveUser() {
		User c= new  User();
		c.setUid(1);
		c.setFname("owashim");
		c.setLname("chowdhury");
		c.setEmail("sdhg@gmail.com");
		c.setUphone(987564421);
		
		Mockito.when(crepo.save(c)).thenReturn(c);
		assertThat(cs.saveUser(c)).isEqualTo(c);		
	}
	//testing get all user method
	@Test
	public void testGetAllUser() {
		User c1= new  User();
		c1.setUid(2);
		c1.setFname("go");
		c1.setLname("chowdhury");
		c1.setEmail("sdhg@gmail.com");
		c1.setUphone(987564421);
		
		User c2= new  User();
		c2.setUid(3);
		c2.setFname("sam");
		c2.setLname("roy");
		c2.setEmail("sam@gmail.com");
		c2.setUphone(54861321);
		List<User> al=new ArrayList<>();
		al.add(c1);
		al.add(c2);
		Mockito.when(crepo.findAll()).thenReturn(al);
		assertThat(cs.getAllUser()).isEqualTo(al);
		
		
	}
	//testing update method
	@Test
	public void testUpdateUser() {
		User c3= new  User();
		c3.setUid(4);
		c3.setFname("rahul");
		c3.setLname("chowdhury");
		c3.setEmail("rahul@gmail.com");
		c3.setUphone(89764421);
		
		Optional<User> ca=Optional.of(c3);
		User ua=ca.get();
		Mockito.when(crepo.findById(4)).thenReturn(ca);
		
		ua.setUphone(56789043);
		Mockito.when(crepo.save(ua)).thenReturn(ua);
		assertThat(cs.updateUserById(ua, 4)).isEqualTo(ua);
	}
	

}
