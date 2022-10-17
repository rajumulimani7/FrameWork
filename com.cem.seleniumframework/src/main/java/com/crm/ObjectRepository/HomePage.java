package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utilities.WebDeiver_Utility;

public class HomePage {
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgnbutt;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement prodbutt;
	
	@FindBy(name="productname")
	private WebElement proname;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactbutt;
	
	@FindBy(xpath="//a[@href='javascript:;']")
	private WebElement morebutt;
	
	@FindBy(name="Campaigns")
	private WebElement campbutt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminbutt;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutbutt;
	
	
	//getter methods
	public WebElement getOrgnbutt() {
		return orgnbutt;
	}

	public WebElement getProname() {
		return proname;
	}

	public WebElement getProdbutt() {
		return prodbutt;
	}
	  
	public WebElement getContactbutt() {
		return contactbutt;
	}
	public WebElement getMorebutt() {
		return morebutt;
	}

	public WebElement getAdminbutt() {
		return adminbutt;
	}

	public WebElement getSignoutbutt() {
		return signoutbutt;
	}

	public WebElement getCampbutt() {
		return campbutt;
	}
	//business logic
	
	public void  organiz() {
		orgnbutt.click();
	}

	public void product() {
		prodbutt.click();
	}
	public void ProductName(String productdata) {
		prodbutt.sendKeys(productdata);
	}
	public void contact() {
		contactbutt.click();
	}
	public void more() {
		morebutt.click();
	}
	public void campaigns() {
		campbutt.click();
	}
	public void signout(WebDriver driver) {
		WebDeiver_Utility wlib=new WebDeiver_Utility();
		wlib.moveMouse(driver, adminbutt);
		
	}

}
