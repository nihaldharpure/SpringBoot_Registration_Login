package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public boolean registerUser(User user) {
		try {
		userRepo.save(user);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
