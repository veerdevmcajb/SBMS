package in.veerdev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.veerdev.config.AppConfig;
import in.veerdev.dao.StudentDao;
import in.veerdev.dto.Student;

public class MainApp {
	
	public static void main(String[] args) {
		
		ApplicationContext cotext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		StudentDao bean = cotext.getBean(StudentDao.class);
		
		Student s = new Student();
		s.setId(102);
		s.setName("Natha");
		s.setCity("Akola");
		
		bean.save(s);
		
		System.out.println("Data inserted...");
		
		
	}

}
