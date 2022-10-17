package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaignInfo {
	
	public CompaignInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;

	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
	}

	public void validationOfPage(String data) {
		if(succesfullMsg.getText().contains(data)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
	}
	
}
