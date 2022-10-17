package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(className="dvHeaderText")
	private WebElement succesfullMsg;



	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
	}
	
     
	public void validationOfPage(String data) {
		if(succesfullMsg.getText().contains(data)) {
			System.out.println("data is sucussfully created...pass");
		}
		else {
			System.out.println("data is not created...fail");
		}
	}
}
