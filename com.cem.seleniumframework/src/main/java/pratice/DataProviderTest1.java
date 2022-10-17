
package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataProviderTest1 {
	
	public void companyDetails() {
	 	String key= "webdriver.chrome driver";
	 	String value="./chromedriver.exe";
	 	System.setProperty(key, value);
	 	WebDriver driver=new ChromeDriver();
	 	driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	}

}
