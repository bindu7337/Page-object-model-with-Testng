package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Baseclass;
import com.amazon.testcases.BuyProductTest;


public class Homepage extends Baseclass {
	
	
	//By HelloSignin = By.xpath("//*[contains(text(),'Hello. Sign in')]");
	
	@FindBy (linkText = "Start here.")
	WebElement Signup;
	
	@FindBy (partialLinkText = "Sign in")
	WebElement Login;
	
	@FindBy (id = "twotabsearchtextbox")
	WebElement searchbox;
	
	@FindBy (xpath = "//*[@value='Go']")
	WebElement searchgo;
		
	
	@FindBy (id = "nav-cart")
	WebElement cart;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public Signuppage signup() {
		Signup.click();
		return new Signuppage();
	}
	
	public Loginpage login() {
		Login.click();
		return new Loginpage();
	}
	
	public void Search(String product) {
		searchbox.sendKeys(product);
		searchgo.click();
		//return new BuyProductTest();
		
	}
	
	public WebElement Cart() {
		cart.click();
		return cart;
	}
	
	
	
}
