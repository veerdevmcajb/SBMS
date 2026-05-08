package com.beans;

public class Car {

	private IEngine eng;
	
	Car(){
		System.out.println("Car :: Constructor");
	}
	
	Car(IEngine eng){
		this.eng=eng;
	}
	
	public void SetEng(IEngine eng) {
		this.eng=eng;
	}
	
	public void drive() {
		int start = eng.start();
		
		if(start >=1) {
			System.out.println("Journey Started..");
		}else {
			System.out.println("Wait...");
		}
		


	}
}
