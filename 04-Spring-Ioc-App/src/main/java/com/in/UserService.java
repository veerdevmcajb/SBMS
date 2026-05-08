package com.in;

public class UserService {

	private IpwdService pwdService;
	private IEmailService emailService;
	
	public UserService(IpwdService pwdService , IEmailService emailService) {
		this.pwdService = pwdService;
		this.emailService = emailService;
	}
	
	public void register(String name , String email, Long phno) {
		
		String randomPwd = pwdService.generateRandomPass(5);
		String subject ="Account Created";
		String body="Your Login Password " + randomPwd;
		
		boolean sendEmail = emailService.sendEmail(subject, body, email);
		
		if(sendEmail) {
			System.out.println("Account Created..");
		}else {
			System.out.println("Failed to create a Account");
		}
	}
	
}
