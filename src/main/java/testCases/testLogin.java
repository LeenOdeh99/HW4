package testCases;

import org.testng.annotations.Test;

import Pages.Cart;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class testLogin {
	
	WebDriver driver;
	Cart loginForm;
	Row [] data;
	
  @Test
  public void a() throws IOException, InterruptedException {
	  loginForm.test(0, data);
  }
  
  @Test
  public void b() throws InterruptedException {
	  loginForm.test(1, data);
  }
  
  @Test
  public void c() throws InterruptedException {
	  loginForm.test(2, data);
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException, InterruptedException {
	  ChromeOptions chromeOptions = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.get("https://devwcs.frontgate.com/ShoppingCartView");
	  WebElement advanced = driver.findElement(By.id("details-button"));
	  advanced.click();
	  
	  WebElement proceed = driver.findElement(By.id("proceed-link"));
	  proceed.click();
	  
	  loginForm = new Cart(driver);
	  data = loginForm.readExcel();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
