package com.iNetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iNetBanking.testCases.BaseClass;


	

public class Repoting extends BaseClass implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public  ExtentReports extent ;
     public  ExtentTest test;
	
     public void onTestStart(ITestResult result) {
 		//before each test case
 		test = extent.createTest(result.getMethod().getMethodName());
 	}
 	public void onTestSuccess(ITestResult result) {
 		test.log(Status.PASS, "Test Case:"+result.getMethod().getMethodName()+"is passed");
 	}

 	public void onTestFailure(ITestResult result) {
 		test.log(Status.FAIL, "Test Case:"+result.getMethod().getMethodName()+"is failed");
 		test.log(Status.FAIL, result.getThrowable());
 		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyy hh-mm-ss");
 		Date date =new Date();
 		String actualDate =format.format(date);
 		String screenshotPath=
 				//"C:Ekta docs\\Study\\Java\\EclipseProjects\\training.insuranceCalculator\\Reports\\ScreenShots\\"+actualDate+ ".jpeg";
 		"C:\\Ekta docs\\Study\\Java\\EclipseProjects\\iNetBankingV1\\Reports\\ScreenShots\\ScreenShots_"+actualDate+ ".png";
 		File destination= new File(screenshotPath);
 		try {
 			FileUtils.copyFile(src, destination);
 		} catch (IOException e) {
 			
 			e.printStackTrace();
 		}
 		try {
 			test.addScreenCaptureFromPath(screenshotPath, "Test Case failure screenshots");
 		} catch (IOException e) {
 		
 			e.printStackTrace();
 		}
 		System.out.println("ScreenShot taken");
 	}

 	public void onTestSkipped(ITestResult result) {
 		
 	}

 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
 		
 	}

 	public void onTestFailedWithTimeout(ITestResult result) {
 		
 	}

 	public void onStart(ITestContext context) {
 		//setUp method call
 		
 			SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
 			Date date = new Date();
 			String actualDate = format.format(date);
 			String reportPath=
 		"C:\\Ekta docs\\Study\\Java\\EclipseProjects\\iNetBankingV1\\Reports\\ExecutionReport_"+actualDate+ ".html";
 			
 			ExtentSparkReporter sparkReport= new ExtentSparkReporter(reportPath);

 			 extent = new ExtentReports();
 			 extent.attachReporter(sparkReport);
 			 extent.setSystemInfo("HostName", "LocalHost");
 			extent.setSystemInfo("Environment", "QA");
 			extent.setSystemInfo("user", "Sharma");
 			sparkReport.config().setDocumentTitle("iNetBanking Test Report");
 			sparkReport.config().setTheme(Theme.DARK);
 			sparkReport.config().setReportName("Functional TestReport");
 			
 		    
 		}
 

 	public void onFinish(ITestContext context) {
 		//close extent
 		extent.flush();
 	}
}

		
		

