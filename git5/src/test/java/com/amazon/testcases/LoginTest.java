package com.amazon.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.Baseclass;
import com.amazon.pages.Homepage;
import com.amazon.pages.Loginpage;
import com.amazon.utilities.Testutil;;

public class LoginTest extends Baseclass {
	 
	 public LoginTest() {
		 super();
	
	 }
	 
	 Homepage hm;
	 Loginpage lg;
	

	 @BeforeMethod
	 public void setup() {
		initialization();
		hm = new Homepage();
		lg = new Loginpage();
	}
	
	@Test(priority = 2)
	public void LoginToApplication() throws InterruptedException, IOException {
		hm.login();
		lg.LogintoAmazon(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(4000);
		Testutil.takeScreenshotAtEndOfTest("user logged in");
	}
	
}
