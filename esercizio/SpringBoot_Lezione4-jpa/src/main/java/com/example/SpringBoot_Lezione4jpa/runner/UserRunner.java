package com.example.SpringBoot_Lezione4jpa.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.SpringBoot_Lezione4jpa.model.User;
import com.example.SpringBoot_Lezione4jpa.service.UserService;

@Component
public class UserRunner implements ApplicationRunner {
	
	@Autowired UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("UserRunner...");
		
//		User u = new User();
//		u.setName("Mario");
//		u.setLastname("Rossi");
//		u.setCity("Roma");
//		u.setAge(22);
//		u.setEmail("m.rossi@example.com");
//		
//		userService.insertUser(u);
		
//		List<User> userlist = userService.getAllUser();
//		userlist.forEach(u -> System.out.println(u));
		
//		User ul = userService.getUserByID(1l);
//		System.out.println(ul);
		
//		ul.setCity("Palermo");
//		userService.updateUser(ul);
		
//		userService.removeUser(ul);
		
		List<User> userlistbyage = userService.getAgeBetween(30, 50);
		userlistbyage.forEach(u -> System.out.println(u));
	}

}
