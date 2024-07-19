package com.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.Entity.User;
import com.demo.Repository.UserRepository;
import com.demo.Service.UserService;
import com.demo.exception.UserNotFoundException;

@Component
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if (!user.equals(null)) {
			User entity = userRepo.save(user);
			logger.info("The User Save successfully with id {}", entity.getId());
			return entity;
		} else {
			logger.error("The user is null");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public User updateUser(User user, Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			User user1 = optionalUser.get();
			user1.setEmail(user.getEmail());
			user1.setUsername(user.getUsername());
			user1.setUserRole(user.getUserRole());
			User savedUser = userRepo.save(user1);
			return savedUser;
		}
		logger.error("The user does not exists with id : {}", id);
		throw new UserNotFoundException(id);
	}

	@Override
	public void deleteUser(Long id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			userRepo.delete(optionalUser.get());
			logger.info("The user with id : {} deleted successfully.", id );
			return;
		}
		logger.error("The user does not exists with id : {}", id);
		throw new UserNotFoundException(id);
	}

	@Override
	public User findUser(Long id) throws UserNotFoundException{
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			logger.info("The user with id : {}.", user.toString());
			return user;
		}
		logger.error("The user does not exists with id : {}", id);
		throw new UserNotFoundException(id);
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUser = userRepo.findAll();
		return allUser;
	}

}
