package in.veerdev;

import java.lang.reflect.Field;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		Class<?> clz = Class.forName("in.veerdev.User");
		
	Object object = clz.getDeclaredConstructor().newInstance();
	
	User u =(User) object;
	
	u.printAge();
	
	Field declaredField = clz.getDeclaredField("age");
	
	declaredField.setAccessible(true);
	declaredField.set(u, 20);
	u.printAge();
	}

}
