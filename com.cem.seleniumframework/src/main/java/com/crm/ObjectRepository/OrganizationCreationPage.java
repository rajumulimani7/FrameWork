package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage {
 
	public OrganizationCreationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	//declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement plusbutt;
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutt;

	//getter method
	public WebElement getPlusbutt() {
		return plusbutt;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getSavebutt() {
		return savebutt;
	}
	
	//bussines logic
	public void createorganizationpage() {
		plusbutt.click();
	}
	public void Organizationametextfild(String data) {
		OrganizationName.sendKeys(data);
	}
	public void savebutton() {
		savebutt.click();
	}
	
	
	
	
	
	
	
	
	
}
