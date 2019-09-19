package com.amazon.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.base.Baseclass;
import com.amazon.pages.Homepage;
import com.amazon.pages.Signuppage;
import com.amazon.utilities.Testutil;

public class SignupTest extends Baseclass {
		 
		 public SignupTest() {
			 super();
		
		 }
		 
		 String sheetName = prop.getProperty("singupsheetname");
		 Homepage hm;
		 Signuppage signup;
		
		@BeforeMethod
		public void setup() {
			initialization();
			hm = new Homepage();
			signup = new Signuppage();
			
		}
		
		@DataProvider
		public Object[][] getAmazonSignupData(){
			Object data[][] = Testutil.getTestData(sheetName);
			return data;
		}
		
		@Test(priority = 1, dataProvider = "getAmazonSignupData")
		public void Register(String Customername, String Email, String Password, String Passcheck) 
				throws IOException, InterruptedException {
			hm.signup();
			signup.customername(Customername,Email,Password,Passcheck);
			Thread.sleep(4000);
			Testutil.takeScreenshotAtEndOfTest(Customername+" "+"Data");
			signup.submit();
			Thread.sleep(4000);
			Testutil.takeScreenshotAtEndOfTest(Customername+" "+"Result");
		}
		
	}


