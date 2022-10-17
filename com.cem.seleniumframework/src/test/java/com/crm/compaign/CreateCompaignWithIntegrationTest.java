package com.crm.compaign;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDeiver_Utility;
import com.crm.ObjectRepository.CompaignCreationPage;
import com.crm.ObjectRepository.CompaignInfo;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaignWithIntegrationTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void createCompaignWithIntegrationTest() throws IOException {
		/*String key = "webdriver.chrome driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);*/
		//WebDriver driver=new ChromeDriver();
		File_Utility fl=new File_Utility();
		//driver.manage().window().maximize();
	    WebDeiver_Utility w1=new WebDeiver_Utility();
	    w1.maximize(driver);
	    WebDeiver_Utility w3=new WebDeiver_Utility();
	    w3.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//File_Utility fl=new File_Utility();
		/*String url = fl.getPropertyKryValue("url");
		String username = fl.getPropertyKryValue("un");
		String password = fl.getPropertyKryValue("pw");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.login(username, password);*/
		
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
         
		HomePage h=new HomePage(driver);
        h.more();
        h.campaigns();
		//driver.findElement(By.xpath("//a[@href='javascript:;']")).click();
		//driver.findElement(By.name("Campaigns")).click();
        CompaignCreationPage ccp=new CompaignCreationPage(driver);
        ccp.createCompaignpage();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		Java_Utility ju=new Java_Utility();
		int rannum = ju.getRanDomNum();
		Excel_Utility eu=new Excel_Utility();
		String data = eu.grtExcelValue("Sheet1", 0, 2)+rannum;
		/*FileInputStream fi=new FileInputStream("./workbook.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(2);
		String data = cell.getStringCellValue()+rannum;	*/
		ccp.Compaignnametextfild(data);
		System.out.println(data);
		
		//driver.findElement(By.name("campaignname")).sendKeys(data);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String parent = driver.getWindowHandle();
		WebDeiver_Utility wb=new WebDeiver_Utility();
		wb.switchToWindow(driver, "Account&actions");
		driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[1]")).click();
	/*System.out.println(driver.getTitle());
		Set<String> all = driver.getWindowHandles();
		for( String w:all)
		{
			driver.switchTo().window(w);
			if(parent.contains(w))
			{
				continue;
			}
			else 
			    {
				driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[1]")).click();
				}*/
		//w1.switchToFrame(driver, parent);
			driver.switchTo().window(parent);
			ccp.savebutton();
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			CompaignInfo ci=new CompaignInfo(driver);
			ci.validationOfPage(data);
		/*	String src = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(src.contains(data)) {
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}*/
			h.signout(driver);
		/*	WebDeiver_Utility w2=new WebDeiver_Utility();
			WebElement traget = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			w2.moveMouse(driver, traget);
			//Actions a=new Actions(driver);
		//	a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();*/
			w1.closeTheBrowser(driver);
			//driver.close();
		}						

	}


