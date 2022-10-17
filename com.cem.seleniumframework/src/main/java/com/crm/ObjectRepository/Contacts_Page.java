package com.crm.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts_Page {
	
	public  Contacts_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactbutt;
	
	@FindBy(name="firstname")
	private WebElement firstnametextfild;
	
	@FindBy(name="lastname")
	private WebElement lastnametextfild;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement addorganizationbutt;
	
	@FindBy(id="search_txt")
	private WebElement searchtextfild;
	
	@FindBy(xpath="//a[contains(text()")
	private WebElement containstext;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutt;

	public WebElement getCreateContactbutt() {
		return createContactbutt;
	}

	public WebElement getFirstnametextfild() {
		return firstnametextfild;
	}

	public WebElement getLastnametextfild() {
		return lastnametextfild;
	}

	public WebElement getAddorganizationbutt() {
		return addorganizationbutt;
	}

	public WebElement getSearchtextfild() {
		return searchtextfild;
	}

	public WebElement getSavebutt() {
		return savebutt;
	}
	
	public WebElement getContainstext() {
		return containstext;
	}

	public void CreateContactButt() {
		createContactbutt.click();
	}
	public void FirstNameTextFild(String first) {
		firstnametextfild.sendKeys(first);
	}
	
	public void LastNameTextFild(String second) {
		lastnametextfild.sendKeys(second);
	}
	
	public void AddOrganizationButt() {
		addorganizationbutt.click();
	}
	
	public void SearchTextFild(String data2) {
		searchtextfild.sendKeys(data2+Keys.ENTER);
		
	}
	public void ContainsText() {
		containstext.click();
	}
	
	public void SaveButton() {
		savebutt.click();
	}

}
