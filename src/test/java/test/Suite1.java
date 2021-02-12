package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suite1 {
@Test (priority=1)
public void register() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://magento.com");
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("register")).click();
	driver.findElement(By.id("firstname")).sendKeys("Jerin");
	driver.findElement(By.id("lastname")).sendKeys("Iqbal");
	driver.findElement(By.id("email_address")).sendKeys("jeriniqbal@gmail.com");

	Select cp=new Select(driver.findElement(By.id("company_type")));
	cp.selectByIndex(3);
	//Select country=new Select(driver.findElement(By.id("country")));
	//country.deselectByVisibleText("USA");





	driver.findElement(By.id("password")).sendKeys("10122001Ji");
	driver.findElement(By.id("password-confirmation")).sendKeys("10122001Ji");

	
	
	if (!driver.findElement(By.id("agree_terms")).isSelected())

	driver.findElement(By.id("agree_terms")).click();
}

@Test (priority=2)
public void login() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	driver.get("http://magento.com");
    driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
    driver.findElement(By.id("email")).sendKeys("jeriniqbal@gmail.com");
    driver.findElement(By.id("pass")).sendKeys("10122001Ji");
    driver.findElement(By.id("send2")).click();
Thread.sleep(5000);

System.out.println(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText());
}


}


