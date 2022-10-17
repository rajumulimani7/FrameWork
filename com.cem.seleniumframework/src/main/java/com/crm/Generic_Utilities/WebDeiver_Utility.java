package com.crm.Generic_Utilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDeiver_Utility {
	
	/**
	 * wait for page to load before indentifying any sychonized element in dom
	 * @param driver
	 * @author Raju
	 */
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	public void waitForExplicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	public void switchToWindow(WebDriver driver,String PartialWindowTitle ) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it = allwh.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle)) {
				break;
			}
		}
		
	}
	public void switchToAlertAccpect(WebDriver driver) {
	driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}
	public void select(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
		
	}
	public void moveMouse(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void rightClick(WebDriver driver) {
		Actions a1=new Actions(driver);
		a1.contextClick().perform();
		}
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
public void closeTheBrowser(WebDriver driver) {
	driver.close();
}
public void parentBrowser(WebDriver driver, String parent) {
	driver.switchTo().frame(parent);
}
}




























