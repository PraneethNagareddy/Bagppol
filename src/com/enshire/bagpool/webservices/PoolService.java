package com.enshire.bagpool.webservices;

import org.springframework.web.bind.annotation.RestController;

import com.enshire.bagpool.beans.Pool;

@RestController
public class PoolService {

	
	public String getPools(String userName, String location){
		return location;
	}
	
	public String getPool(int id){
		return null;
	}
	
	public boolean savePool(Pool pool){
		return true;
	}
}
