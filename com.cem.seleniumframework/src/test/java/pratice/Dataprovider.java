package pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	@Test(dataProvider = "dataProvider_test")
	public void companyDetails(String name,String phnum,String email) throws InterruptedException {
		String key= "webdriver.chrome driver";
	 	String value="./chromedriver.exe";
	 	System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(phnum);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();
		Thread.sleep(2000);
		
		
		
		
	}
	@DataProvider
	public Object[][] dataProvider_test(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="AAA";
		objArr[0][1]="8277777633";
		objArr[0][2]="rrarrar@gmail.com";
		
		objArr[1][0]="BBB";
		objArr[1][1]="8277777625";
		objArr[1][2]="rrarr@gmail.com";
		
		objArr[2][0]="CCC";
		objArr[2][1]="8277777785";
		objArr[2][2]="rra@gmail.com";
		return objArr;
		
		
	}

}
