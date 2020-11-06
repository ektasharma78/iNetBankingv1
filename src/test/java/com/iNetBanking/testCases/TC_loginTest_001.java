package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.loginPage;

public class TC_loginTest_001 extends BaseClass{
@Test	
public void loginTest() throws InterruptedException {
driver.get(baseURL);

log.info("URL is opened");
loginPage lp= new loginPage(driver);
lp.setUserName(username);
log.info("username is entered");

lp.setPassword(password);

log.info("pwd is entered");

lp.clickSubmit();
if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
{
	Assert.assertTrue(true);
	log.info("Login test passed");
}
else {
	Assert.assertTrue(false);
	log.info("Login test failed");
	System.out.println("ScreenShot taken");
}
}
}
