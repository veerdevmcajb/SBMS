package com.beans;

public class DieselEngine implements IEngine{
	
	public DieselEngine() {
		System.out.println("DieselEngine :: Constructor");
	}
	
	@Override
	public int start() {
		System.out.println("Diesel Engine Started..");
		return 1;
	}

}
