package com.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.Entity.User;
import com.demo.exception.UserNotFoundException;

@Service
public interface UserService {
	public User addUser(User user) throws Exception;
	public User updateUser(User user, Long id) throws UserNotFoundException;
	public void deleteUser(Long id) throws UserNotFoundException;
	public User findUser(Long id);
	public List<User> getAllUser();
}
