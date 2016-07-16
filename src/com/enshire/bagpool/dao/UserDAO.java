package com.enshire.bagpool.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enshire.bagpool.beans.User;

public class UserDAO {
	private static Map<String,User> userMap = new HashMap<String,User>();

	public UserDAO(){
		userMap.put("praneeth", new User("praneeth","praneeth","Reddy","praneeth"));
	}

	public User login(String userName, String password) {
		User user = userMap.get(userName);		
		if (user!= null &&
				user.getPassword().equals(password))
			return user;
		return new User("dummy","dummy","dummy","dummy");
	}
	public User getDetails(String userName){
		return userMap.get(userName);
	}
	public boolean register(User user) {
		userMap.put(user.getUserName(),user);
		return true;
	}

	public boolean isUserNameAvailable(String userName) {
		return !userMap.containsKey(userName);
	}
	
}
