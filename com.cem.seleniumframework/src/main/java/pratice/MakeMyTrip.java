package pratice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		String key= "webdriver.chrome driver";
	 	String value="./chromedriver.exe";
	 	System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		driver.manage().window().maximize();
		FileInputStream fis=new FileInputStream("./makemytrip.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
         driver.get(url);
         FileInputStream fi=new FileInputStream("./book2.xlsx");
        Workbook book = WorkbookFactory.create(fi);
        String from = book.getSheet("Makemytrip").getRow(0).getCell(0).getStringCellValue();
        String too = book.getSheet("Makemytrip").getRow(0).getCell(1).getStringCellValue();
        System.out.println("data "+from+" "+too);
        driver.findElement(By.id("fromCity")).sendKeys(from);
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);
       driver.findElement(By.id("toCity")).sendKeys(too);
       r.keyPress(KeyEvent.VK_DOWN);
       Thread.sleep(2000);
       r.keyPress(KeyEvent.VK_ENTER);
       driver.findElement(By.xpath("//label[@for='departure']")).click();
       driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
       Thread.sleep(2000);
       String month = "October 2022";
       String date = "12";
       
        driver.findElement(By.xpath("//div[text()='"+month+"']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click(); 
        driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[2]")).click();
        
        String month1 = "November";
       String date1 = "4";
        
        driver.findElement(By.xpath("//div[text()='"+month1+"']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date1+"']")).click();
          /* driver.findElement(By.xpath("//p[text()='30']")).click();
       driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[2]")).click();
       driver.findElement(By.xpath("(//p[text()='4'])[2]")).click();
       driver.findElement(By.xpath("//a[text()='Search']")).click();
       Thread.sleep(2000);*/
        driver.findElement(By.xpath("//label[@for='travellers']")).click();
        
        String a = "6";
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-cy='adults-"+a+"']")).click();
        String b = "1";
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-cy='children-"+b+"']")).click();
        String c = "1";
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-cy='infants-"+c+"']")).click();
        
        driver.findElement(By.xpath("//button[text()='APPLY']")).click();
        
      
    
        
        
        
        
        
        
	}

}
