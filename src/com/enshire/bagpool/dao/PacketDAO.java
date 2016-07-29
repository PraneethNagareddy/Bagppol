package com.enshire.bagpool.dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class PacketDAO {
	private static PacketDAO instance = null;
	private PacketDAO(){
		
	}
	public static PacketDAO getInstance(){
		if(instance == null)
			instance = new PacketDAO();
		return instance;
	}
	
	public static MongoDatabase getDatabase(){
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("bagpool");
		return db;
	}
	
	public void insertPacket(String userName,
							 String from, 
							 String to,
							 String date,
							 String units,
							 String count,
							 String description){

		getDatabase().getCollection("packet").insertOne(
		        new Document()
		        	.append("user_name", userName)
		            .append("from", from)
		            .append("to", to)
		            .append("date", date)
		            .append("units", units)
		            .append("count", count)
		            .append("description", description));
	}
	
	public void getPacket(){
		//BasicDBObject 	
	}
}
