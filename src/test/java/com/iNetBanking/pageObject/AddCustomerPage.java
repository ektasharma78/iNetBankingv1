package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
WebDriver ldriver; //variable
public AddCustomerPage(WebDriver rdriver) { // creating constructor
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	
}
@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")

@CacheLookup
WebElement linkAddNewCustomer;

@FindBy(how=How.NAME,using="name")
@CacheLookup
WebElement txtCustomerName;

@FindBy(how=How.NAME,using="rad1")
@CacheLookup
WebElement rdGender;

@FindBy(how=How.ID_OR_NAME,using="dob")
@CacheLookup
WebElement txtdob;

@FindBy(how=How.NAME,using="addr")
@CacheLookup
WebElement txtaddress;

@FindBy(how=How.NAME,using="city")
@CacheLookup
WebElement txtcity;

@FindBy(how=How.NAME,using="state")
@CacheLookup
WebElement txtstate;

@FindBy(how=How.NAME,using="pinno")
@CacheLookup
WebElement txtPinNo;


@FindBy(how=How.NAME,using="telephoneno")
@CacheLookup
WebElement txttelephoneNo;


@FindBy(how=How.NAME,using="emailid")
@CacheLookup
WebElement txtemailid;

@FindBy(how=How.NAME,using="password")
@CacheLookup
WebElement txtpassword;

@FindBy(how=How.NAME,using="sub")
@CacheLookup
WebElement btnSubmit;

public void clickaddNewCustomer() {
	linkAddNewCustomer.click();	
}
public void txtCustomerName(String cName){
	txtCustomerName.sendKeys(cName);
}

public void customerGender(String cgender) {
	rdGender.click();
}

public void customerdob(String mm,String dd,String yy) {
	txtdob.sendKeys(mm);
	txtdob.sendKeys(dd);
	txtdob.sendKeys(yy);
}

public void customerAdd(String caddress) {
	txtaddress.sendKeys(caddress);
}
public void customerCity(String ccity) {
	txtcity.sendKeys(ccity);
}
public void customerState(String cstate) {
	txtstate.sendKeys(cstate);
}
public void customerPinNo(String cpinno) {
	txtPinNo.sendKeys(String.valueOf(cpinno));
}
public void customereTelPhone(String ctelphoneno) {
	txttelephoneNo.sendKeys(ctelphoneno);
}
public void customeremailid(String cemailid) {
	txtemailid.sendKeys(cemailid);
}
public void customerpwd(String cpassword) {
	txtpassword.sendKeys(cpassword);
}
public void custsubmit() {
	btnSubmit.click();	
}
}
