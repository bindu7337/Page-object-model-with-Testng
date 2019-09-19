package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.Baseclass;
import com.amazon.pages.Homepage;

public class Signuppage extends Baseclass {
		 
	@FindBy (id = "ap_customer_name")
	WebElement CustomerName;
	
	@FindBy (id = "ap_email")
	WebElement Email;
	
	@FindBy (id = "ap_password")
	WebElement Password;
	
	@FindBy (id = "ap_password_check")
	WebElement PasswordCheck;
	
	@FindBy (id = "continue")
	WebElement Submit;
	
	public Signuppage() {
		PageFactory.initElements(driver, this);
	}
	
	public void customername(String name, String email, String password, String passcheck) {
		CustomerName.sendKeys(name);
		Email.sendKeys(email);
		Password.sendKeys(password);
		PasswordCheck.sendKeys(passcheck);
	}
	
	public void submit() {
		Submit.click();
	}
}
		 
		 

