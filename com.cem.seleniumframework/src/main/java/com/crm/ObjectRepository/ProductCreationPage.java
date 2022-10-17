package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage {

	public ProductCreationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement plusbutt;
	
	@FindBy(name="productname")
	private WebElement ProductName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutt;
	
	@FindBy(xpath="(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement deletebutt;

	public WebElement getPlusbutt() {
		return plusbutt;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getDeletebutt() {
		return deletebutt;
	}

	public WebElement getSavebutt() {
		return savebutt;
	}
	
	public void productorganizationpage() {
		plusbutt.click();
	}
	public void productnametextfild(String data) {
		ProductName.sendKeys(data);
	}
	public void savebutton() {
		savebutt.click();
	}
	
	public void deleteButton() {
		deletebutt.click();
	}
	
	
	
	
	
	
	
	
}
