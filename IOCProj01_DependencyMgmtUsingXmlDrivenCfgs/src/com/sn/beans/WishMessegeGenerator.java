package com.sn.beans;

import java.time.LocalTime;

public class WishMessegeGenerator {
	private LocalTime time;
	
	public  WishMessegeGenerator(){
		IO.println("WishMessegeGenerator ::0-param constructor");
	}
	public void setTime(LocalTime time) {
		IO.println("WishMessageGenerator.setTime(-)");
		this.time=time;
	}
	public String showWishMessage(String user) {
		IO.println("WishMessageGenerator.showWishMessage()");
		int hour=time.getHour();
		if(hour<12) {
			return "good morning : "+user;
		}
		else if(hour<16) {
			return "good afternoon : "+user;
		}
		else if(hour<20) {
			return "good evening : "+user;
		}
		else {
			return "good Night : "+user;
		}
		
		
	}
}
