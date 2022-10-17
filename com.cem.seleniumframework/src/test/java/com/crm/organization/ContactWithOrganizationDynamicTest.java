package com.crm.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.crm.Generic_Utilities.WebDeiver_Utility;
import com.crm.ObjectRepository.Contacts_Page;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactWithOrganizationDynamicTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void contactWithOrganizationDynamicTest() throws IOException {
		/*String key = "webdriver.chrome driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();*/
		File_Utility fl=new File_Utility();
		WebDeiver_Utility wu=new WebDeiver_Utility();
		WebDeiver_Utility w1=new WebDeiver_Utility();
		Excel_Utility eu=new Excel_Utility();
		WebDeiver_Utility wb=new WebDeiver_Utility();
		WebDeiver_Utility wu1=new WebDeiver_Utility();
		
		wu.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		w1.maximize(driver);
		//driver.manage().window().maximize();
		
		
	
	/*	String url = fl.getPropertyKryValue("url");
		String username = fl.getPropertyKryValue("un");
		String password = fl.getPropertyKryValue("pw");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.login(username, password);*/
		
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		HomePage h=new HomePage(driver);
		h.contact();
 
		//driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		String data = eu.grtExcelValue("Sheet1", 0, 0);
		String data1 = eu.grtExcelValue("Sheet2", 0, 1);
		String data2 = eu.grtExcelValue("Sheet1", 0, 0);
		/*FileInputStream fi=new FileInputStream("./workbook.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet2");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(0);
		String first = cell.getStringCellValue();
		String second = book.getSheet("Sheet2").getRow(0).getCell(1).getStringCellValue();
		String orgName = book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println("data="+first+" "+second);*/
		Contacts_Page cp=new Contacts_Page(driver);
		cp.FirstNameTextFild(data);
		cp.LastNameTextFild(data1);
		cp.AddOrganizationButt();
		
		/*driver.findElement(By.name("firstname")).sendKeys(data);
		driver.findElement(By.name("lastname")).sendKeys(data1);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();*/
		String pw = driver.getWindowHandle();
		
			wb.switchToWindow(driver, "Account&actions");
		/*Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it = allwh.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			if(driver.getTitle().contains("Account&actions"))
			{
				break;
			}
		}*/
			cp.SearchTextFild(data2);
			//cp.ContainsText();
		//driver.findElement(By.id("search_txt")).sendKeys(data2+Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'"+data2+"')]")).click();
		driver.switchTo().window(pw);
		cp.SaveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		OrganizationInfo oi=new OrganizationInfo(driver);
		oi.validationOfPage(data);
		/*String src = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(src.contains(data)) {
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		h.signout(driver);
		/*WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu1.moveMouse(driver, target);
				
		//Actions a=new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();*/
		wb.closeTheBrowser(driver);
		//driver.close();
			
		
		
		
	}

}
