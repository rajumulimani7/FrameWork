package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaignCreationPage {

	public CompaignCreationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement plusbutt;
	
	@FindBy(name="campaignname")
	private WebElement CompaignName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutt;

	public WebElement getPlusbutt() {
		return plusbutt;
	}

	public WebElement getCompaignName() {
		return CompaignName;
	}

	public WebElement getSavebutt() {
		return savebutt;
	}
	
	
	public void createCompaignpage() {
		plusbutt.click();
	}
	public void Compaignnametextfild(String data) {
		CompaignName.sendKeys(data);
	}
	public void savebutton() {
		savebutt.click();
	}
	
	
	
	
}
