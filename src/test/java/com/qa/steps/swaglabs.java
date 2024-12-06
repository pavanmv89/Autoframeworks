package com.qa.steps;


import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.page.model.Screenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class swaglabs {
public WebDriver driver;
Logger log=Logger.getLogger(swaglabs.class.getName());
	@Given("user launch appln")
	public void user_launch_appln() {
	   WebDriverManager.chromedriver().config();
	    driver=new ChromeDriver();
	   driver.get("https://www.saucedemo.com/");
	   driver.manage().window().maximize();
	}
	@Given("enter username and password")
	public void enter_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id='user-name']/following::input[1]")).sendKeys("secret_sauce");
	}
	@When("user click on submit")
	public void user_click_on_submit() {
		driver.findElement(By.xpath("//*[@id='user-name']/following::input[2]")).click();
	}
	@Then("user landed on appln")
	public void user_landed_on_appln() {
		try {
		Wait<WebDriver> wait=new FluentWait<>(driver)
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(2))
		.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("app_logo"))));
		
		
File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(file, new File(System.getProperty("user.dir").concat("\\Reports\\ss.png")));
		} catch (Exception e) {
			log.info("exzc "+e.getMessage());
		}
		
}
	}
