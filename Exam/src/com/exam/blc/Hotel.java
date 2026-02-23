package com.exam.blc;

public class Hotel{	
public static double calculateTotalAmount(double roomRate, int days)
{
	 double am=0;
	 if(days>=1 && days <=2) {
		 return am=roomRate-roomRate*0.0;}
	 else if(days>=3 && days <=4) {
		 return am=roomRate-roomRate*0.15;}
	 else if(days>=5 && days <=9) {
		 return am=roomRate-roomRate*0.10;}
	 else {
		 return am=roomRate-roomRate*0.5;}
}
}
