package com.enshire.bagpool.webservices;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enshire.bagpool.beans.User;
import com.enshire.bagpool.dao.UserDAO;
import com.enshire.bagpool.interfaces.LoginRequired;
import com.enshire.bagpool.security.Authorizer;

@RestController
public class UserService {
	UserDAO userDAO = new UserDAO();
	private static Authorizer authorizer = new Authorizer();

	@RequestMapping(value="/login", method = RequestMethod.POST)
	@LoginRequired
	public String login(@RequestParam(value="user_name") String userName, @RequestParam(value="password") String password, HttpServletRequest request){
		 User user = userDAO.login(userName, password);
		 return authorizer.storeSession(user.getUserName());
	}
	
	@RequestMapping("/null")
	public User nulls(){
		return null;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(User user){
		if(userDAO.register(user)){
			return authorizer.storeSession(user.getUserName());
		}
		return "dummy";
	}
	
	@RequestMapping(value="/secure/isUsernameAvailable", method = RequestMethod.GET)
	public boolean isUsernameAvailable(@RequestParam(value="userName") String userName){
		return userDAO.isUserNameAvailable(userName);
	}
	
	@RequestMapping(value="/secure/getDetails", method = RequestMethod.POST)
	public User getDetails(@RequestParam(value="token_id") String tokenId){
		String userName = authorizer.authorize(tokenId);
		if (userName.equals("")) {
			return new User();
		}
		else{
			return userDAO.getDetails(userName);
		}
	}
}
