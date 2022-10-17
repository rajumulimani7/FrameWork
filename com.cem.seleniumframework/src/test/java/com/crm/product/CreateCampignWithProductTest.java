package com.crm.product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDeiver_Utility;
import com.crm.ObjectRepository.CampaignWithProduct;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampignWithProductTest extends BaseClass {

	@Test(groups = {"regressionTest"})
	public void createCampignWithProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		/*String key = "webdriver.chrome driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();*/
		File_Utility fl=new File_Utility();
       /* WebDriver driver;
	    String BROWSER=fl.getPropertyKryValue("browser");
	    if(BROWSER.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();
	    }
	    else
	    {
	    	driver=new ChromeDriver();
	    }*/
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDeiver_Utility wu=new WebDeiver_Utility();
		wu.waitForPageLoad(driver);

		//File_Utility fl=new File_Utility();
	/*	String url = fl.getPropertyKryValue("url");
		String username = fl.getPropertyKryValue("un");
		String password = fl.getPropertyKryValue("pw");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.login(username, password);*/
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/

		//product data
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		Java_Utility ju=new Java_Utility();
		int rannum = ju.getRanDomNum();
		
		FileInputStream fis2=new FileInputStream("workbook.xlsx");

		Workbook book1=WorkbookFactory.create(fis2);

		Sheet sh1 = book1.getSheet("Sheet1");

		Row row1 = sh1.getRow(0);

		Cell cell = row1.getCell(0);

		String productdata = cell.getStringCellValue()+rannum;
		driver.findElement(By.name("productname")).sendKeys(productdata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Navigate to Campaign
		driver.findElement(By.linkText("More")).click();

		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();


		FileInputStream fis1=new FileInputStream("./workbook.xlsx");

		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String data = cel.getStringCellValue()+rannum;
		CampaignWithProduct cwp=new CampaignWithProduct(driver);
		cwp.campaignname(data);
		cwp.Selecttextfild();
		//driver.findElement(By.name("campaignname")).sendKeys(data);

		//driver.findElement(By.xpath("//img[@title='Select']")).click();
		//Window Switching
		WebDeiver_Utility wb=new WebDeiver_Utility();
		wb.switchToWindow(driver, "Account&actions");
		/*Set<String> allId = driver.getWindowHandles();
		Iterator<String> it=allId.iterator();
		while(it.hasNext())
		{
		String wid = it.next();
		driver.switchTo().window(wid);
		if(driver.getTitle().contains("Products&action"))
		{
		break;
		}}*/

        cwp.Searchtext(productdata);
        cwp.Search();
		//driver.findElement(By.id("search_txt")).sendKeys(productdata);
		//driver.findElement(By.name("search")).click();

		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
		//Switch back Window
		
		Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> it1=allId1.iterator();
		while(it1.hasNext())
		{
		String wid = it1.next();
		driver.switchTo().window(wid);
		if(driver.getTitle().contains("Campaigns&action"))
		{
		break;
		}}
        cwp.Savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(1000);
		
		
		String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();

		if(actData.contains(data))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
