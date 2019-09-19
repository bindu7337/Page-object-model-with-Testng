package com.amazon.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.base.Baseclass;
import com.amazon.pages.AddtocartPage;
import com.amazon.pages.Homepage;
import com.amazon.pages.Loginpage;
import com.amazon.utilities.Testutil;

public class BuyProductTest extends Baseclass {
	
	public BuyProductTest() {
		
		super();
	}
	
	String sheetName = prop.getProperty("productsheetname");
	Homepage hm;
	Loginpage lg;
	AddtocartPage cr;
	
	 @BeforeMethod
	 public void setup() {
		initialization();
		hm = new Homepage();
		cr = new AddtocartPage();
		lg = new Loginpage();
	}
	
	 @DataProvider
	 public Object[][] getAmazonProductData(){
	 Object data[][] = Testutil.getTestData(sheetName);
	 return data;
		}
	 
	 
	 
	 @Test(priority = 3,dataProvider = "getAmazonProductData")
	 public void buyProducts(String Productname) throws IOException {
		 hm.login();
		 lg.LogintoAmazon(prop.getProperty("username"),prop.getProperty("password"));
		 hm.Search(Productname);
		 WebElement we2;
		// we1 = driver.findElement(By.xpath("(//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div)"));
		 List<WebElement> ls1 = driver.findElements(By.xpath("(//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div)"));
		 System.out.println(ls1.size());
		 for(int i=0;i<ls1.size();i++) {
			 we2 = ls1.get(i);
			 //String value1 = ls1.get(i).getText();
			// System.out.println(value1);
			 List<WebElement> ls2 = we2.findElements(By.xpath("div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));
			 for(int j=0;j<ls2.size();j++) {
				 String value2 = ls2.get(j).getText();
				 if(value2.matches(Productname)) {
					 System.out.println("matched");
					 ls2.get(j).click();
					 cr.addcart();
					 Testutil.takeScreenshotAtEndOfTest(Productname+" "+"added to cart");
					 
				 }
			 }
			 	
		 }
		 
	 }
	 
	 @Test(priority=4)
	 public void showcart() throws IOException, InterruptedException {
		 hm.login();
		 lg.LogintoAmazon(prop.getProperty("username"),prop.getProperty("password"));
		 hm.Cart();
		 Thread.sleep(3000);
		 Testutil.takeScreenshotAtEndOfTest("show cart");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 Testutil.takeScreenshotAtEndOfTest("show cart2");
		 
		 
	 }
		 
}
