package com.iNetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	readConfig ReadConfig = new readConfig();
	
public String baseURL=ReadConfig.getApplicationURL();
public String username=ReadConfig.getUserName();
public String password=ReadConfig.getPassWord();
public static WebDriver driver;
public static Logger log;
@Parameters("browser")
@BeforeClass
public void setUp(String br) {
	if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",ReadConfig.getChromePath() );
		driver= new ChromeDriver();	
	}else if (br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",ReadConfig.getfirefoxpath() );
		driver= new FirefoxDriver();		
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(baseURL);
  log =Logger.getLogger("iNetBankingV1");
  //Layout layout = new PatternLayout("%d{yyyy-MM-dd hh:mm} %p :%c[%M] %m %n");
  //Appender app=new ConsoleAppender(layout);
  //log.addAppender(app);
  //PropertyConfigurator.configure("log4j.properties"); 
}

@AfterClass
public void tearDown() {
	driver.quit();
}
public String randomstring() {
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return generatedstring;
	}
public String randomNum() {
	String generatedstring2=RandomStringUtils.randomAlphanumeric(4);
	return generatedstring2;
}
}
