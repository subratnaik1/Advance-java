package com.sn.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sn.beans.WishMessegeGenerator;

public class DependencyManagementTest {
	
	public static void main(String[] args) {
		System.out.println("Methode execution started!!!");
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext
				("/src/com/sn/cfgs/applicationContext.xml");
		Object obj=ctx.getBean("wmg");
		
		WishMessegeGenerator generator=(WishMessegeGenerator)obj;
		String result=generator.showWishMessage("subrat");
		IO.println(result);
		ctx.close();
		
	}

}
