package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignWithProduct {
	
	public CampaignWithProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
   
	@FindBy(name="campaignname")
	private WebElement cmpName;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement Selecttext;
	
	@FindBy(id="search_txt")
	private WebElement searchtextfild;
	 
	@FindBy(name="search")
	private WebElement searchbutt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutt;

	public WebElement getCmpName() {
		return cmpName;
	}

	public WebElement getSelecttext() {
		return Selecttext;
	}

	public WebElement getSearchtextfild() {
		return searchtextfild;
	}

	public WebElement getSearchbutt() {
		return searchbutt;
	}

	public WebElement getSavebutt() {
		return savebutt;
	}
	
	public void campaignname(String data) {
		cmpName.sendKeys(data);
	}
	public void Selecttextfild() {
		Selecttext.click();
	}
	public void Searchtext(String productdata) {
		searchtextfild.sendKeys(productdata);
	}
	public void Search() {
		searchbutt.click();
	}
	public void Savebutton() {
		savebutt.click();
	}
}
