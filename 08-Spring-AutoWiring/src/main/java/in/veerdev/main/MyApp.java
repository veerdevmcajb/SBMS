package in.veerdev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.veerdev.beans.ShoppingCart;
import in.veerdev.config.AppConfig;

public class MyApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ShoppingCart bean = context.getBean(ShoppingCart.class);
		bean.placeOrder();
	}
}
