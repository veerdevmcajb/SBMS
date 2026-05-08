package in.veerdev;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.cglib.proxy.Factory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		
//		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Bean.xml");
//		Employee bean = ctxt.getBean(Employee.class);
	
		Resource resource = new ClassPathResource("Bean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Employee emp1 = (Employee)Factory.getBean(emp1);
		
		System.out.println("Employee1 " + emp1);
	}
	
}
