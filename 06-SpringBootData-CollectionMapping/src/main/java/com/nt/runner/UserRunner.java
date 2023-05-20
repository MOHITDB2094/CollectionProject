package com.nt.runner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.User;
import com.nt.repo.UserRepo;
@Component
public class UserRunner implements CommandLineRunner {

	@Autowired
	UserRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		user.setUsername("Stupid Mohit");
		user.setRoles(Arrays.asList("Son", "Single","Alone"));
		Map<Integer, String> access = new HashMap<Integer, String>();
		access.put(1, "Son");
		access.put(2, "Dev");
		access.put(3, "Alone");
		user.setRoleAccess(access);
		
		System.out.println(repo.save(user));
		
	}

}
