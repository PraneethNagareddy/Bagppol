package com.enshire.bagpool.dao;

import java.util.List;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.enshire.bagpool.beans.Packet;
import com.enshire.bagpool.beans.Pool;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class PoolDAO {
	private static PoolDAO instance = null;
	private MongoDatabase db;
	private PoolDAO(){
		MongoClient mongoClient = new MongoClient( );
		db = mongoClient.getDatabase("local");;
	}

	public static PoolDAO getInstance(){
		if(instance == null)
			instance = new PoolDAO();
		return instance;
	}
	
	
	
	public void savePacket(Pool pool){
		MongoCollection collection = db.getCollection( "packets" );
		Document doc = new Document("user_name",pool.getUserName())
							.append("from", pool.getFrom())
							.append( "to", pool.getTo())
							.append( "date", pool.getDate())
							.append("description", pool.getDescription())
							.append("type", pool.getType())
							.append("count", pool.getCount())
							.append("unit", pool.getUnits())
							.append("meeting_location", pool.getMeetingLocation())
							.append("via", pool.getVia());
	}
	
	public String getPacket(String id){
		ObjectId oId= new ObjectId(id);
		BasicDBObject obj = new BasicDBObject(); 
		obj.append("_id", id); 
		BasicDBObject query = new BasicDBObject();
		query.putAll((BSONObject)query);
		MongoCollection collection = db.getCollection( "packets" );
		FindIterable iterable = collection.find(query);
		MongoCursor<Document> cursor = iterable.iterator();
		if(cursor.hasNext())
			return cursor.next().toJson();
		else
			return null;
	}
	
	public String getAllPackets(){
		String documents = "[";
		MongoCollection collection = db.getCollection( "packets" );
		FindIterable iterable = collection.find();
		MongoCursor<Document> cursor = iterable.iterator();
		if(cursor.hasNext())
			documents += cursor.next().toJson() + ",\n"; 
		return documents+"]";
	}
}
