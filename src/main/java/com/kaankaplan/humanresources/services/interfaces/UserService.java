package com.kaankaplan.humanresources.services.interfaces;

import java.util.List;

import com.kaankaplan.humanresources.models.User;

public interface UserService {
	
	List<User> getallUsers(int pageNo, int pageSize);
	
	User getUserById(int userId);
	
	User getUserByEmail(String email);
	
	void add(User user);
	
	void delete(int userId);
	
	void update(User user);
}
