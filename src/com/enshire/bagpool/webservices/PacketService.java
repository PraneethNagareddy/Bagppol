package com.enshire.bagpool.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacketService {

	
	@RequestMapping(value="/secure/postPacket", method = RequestMethod.POST)
	public boolean createPacket(@RequestParam(value="user_name") String userName,
								@RequestParam(value="from") String from,
								@RequestParam(value="to") String to,
								@RequestParam(value="date") String date,
								@RequestParam(value="units") String units,
								@RequestParam(value="count") String count,
								@RequestParam(value="description") String description){
		
		
		return false;
		
	}
}
