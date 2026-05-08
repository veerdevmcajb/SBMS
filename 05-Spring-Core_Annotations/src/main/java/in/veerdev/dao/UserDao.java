package in.veerdev.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public UserDao() {
		System.out.println("UserDao :: Constructer");
	}
	
	public String getNameById(int id) {
		if(id==100) {
			return "John";
		}else {
			return "Smith";
		}
	}
}
