package com.iNetBanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.AddCustomerPage;
import com.iNetBanking.pageObject.loginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	@Test
public void addNewCustomer() throws InterruptedException {
	loginPage lp=new loginPage(driver) ;
	lp.setUserName(username);
	log.info("username is provided");
	lp.setPassword(password);
	log.info("Password is provided");
	lp.clickSubmit();
	Thread.sleep(3000);
	driver.manage().window().maximize();
	AddCustomerPage addcust=new AddCustomerPage(driver);
	addcust.clickaddNewCustomer();  
	log.info("providing Customer details....");
	addcust.txtCustomerName("Savy");
	addcust.customerGender("male");
	addcust.customerdob("10", "15", "1985");
	Thread.sleep(3000);
	addcust.customerAdd("park Sreeet");
	addcust.customerCity("Pune");
	addcust.customerState("Maharashtra");
	addcust.customereTelPhone("456456789");
	addcust.customerPinNo("234567");
	String email=randomstring()+"@gmail.com";
	addcust.customeremailid(email);
	addcust.customerpwd("abcdef");
	addcust.custsubmit();
	Thread.sleep(3000);
	log.info("Validation started..");
	boolean res =driver.getPageSource().contains("Customer Registered Successfully!!");
	if(res==true) {
		Assert.assertTrue(true);
		log.info("test case is passed..");
	}
	else {
		log.info("test case is failed...");
		Assert.assertTrue(false);
		
	}
}
	
}
