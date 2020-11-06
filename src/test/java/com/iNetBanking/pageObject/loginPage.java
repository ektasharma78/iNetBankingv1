package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginPage {
	//creating a constuctor and initiate pagefactory
	WebDriver ldriver;
	public loginPage(WebDriver rdriver){
		ldriver=rdriver;
	  PageFactory.initElements(rdriver, this);
	}
@FindBy(name="uid")                  //@CacheLookup, as the name suggests helps us control when to cache a WebElement and when not to.                                     //This annotation, when applied over a WebElement, instructs Selenium to keep a cache of the WebElement instead of searching for the WebElement every time from the WebPage. 
                                             //This helps us save a lot of time.
@CacheLookup
WebElement txtUserName;

@FindBy(name="password")                 
@CacheLookup
WebElement txtPassword;

@FindBy(name="btnLogin")               

WebElement btnLogin;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
@CacheLookup
WebElement linkLogOut;


public void setUserName(String username) {
	txtUserName.sendKeys(username);
	
}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
	
}
public void clickSubmit( ) {
	btnLogin.click();
	
}

public void clickLogout() {
	linkLogOut.click();
}


}


