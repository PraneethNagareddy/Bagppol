package com.enshire.bagpool.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageService {
	
	public List<Thread> getThreads(String userName){
		List<Thread> userThreads = new ArrayList<Thread>();
		
		return userThreads;
	}
}
