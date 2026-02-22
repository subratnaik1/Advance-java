package com.exam.blc;

public class Discount 
{
     public static double calculateDiscount(double billAmount)
     {
    	 double am=0;
    	 if(billAmount>=5000) {
    		 return am=billAmount- billAmount*0.20;}
    	 else if(billAmount>=3000) {
    		 return am=billAmount- billAmount*0.15;}
    	 else if(billAmount>=1000) {
    		 return am=billAmount- billAmount*0.10;}
    	 else {
    		 return am=billAmount- billAmount*0.5;}
     }
}
