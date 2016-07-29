package com.enshire.bagpool.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enshire.bagpool.beans.Message;

public class MessagesDAO {

	private Map<String,List<Message>> inboxMap = new HashMap<String,List<Message>>();
	private Map<String,List<Message>> sentMap = new HashMap<String,List<Message>>();
	
	public List<Message> getMessagesOf(String userName){
		return inboxMap.get(userName);
	}

	public void saveMessage(Message message){
		List<Message> sentList = sentMap.get(message.getFrom());
		List<Message> inboxList = inboxMap.get(message.getTo());
		if(inboxList == null) {
			inboxList = new ArrayList<Message>();
		}
		if(sentList == null) {
			sentList = new ArrayList<Message>();
		}
		sentList.add(message);
		inboxList.add(message);
		inboxMap.put(message.getTo(), inboxList);
		sentMap.put(message.getFrom(), inboxList);
	}
	
	public List<Thread> getThreads(String userName){
		List<Thread> list = new ArrayList<Thread>();
		
		//list.add();
		return list;
	}
}
