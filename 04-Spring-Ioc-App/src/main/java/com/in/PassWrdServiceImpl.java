package com.in;

public class PassWrdServiceImpl implements IpwdService {

	@Override
	public String generateRandomPass(int length) {
		
	System.out.println("Random Pass Generated..");
		return "H68HA45";
	}
}
