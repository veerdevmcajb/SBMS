package in.veerdev.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class Motor {

	public Motor() {
		System.out.println("Motor :: COnstructor");
	}
	
	@PostConstruct
	public void start() {
		System.out.println("Motor started..");
	}
	
	public void doWork() {
		System.out.println("Motor Working...");
	}
	
	@PreDestroy
	public void stop() {
		System.out.println("Motor Stop...");
	}
}
