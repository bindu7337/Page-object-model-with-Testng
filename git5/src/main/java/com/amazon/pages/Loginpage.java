package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.base.Baseclass;

public class Loginpage extends Baseclass{

	@FindBy (id = "ap_email")
	WebElement Email;
	
	@FindBy (id = "continue")
	WebElement Continue;
	
	@FindBy (id = "ap_password")
	WebElement Password;
	
	@FindBy (id = "signInSubmit")
	WebElement Submit;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void LogintoAmazon(String email, String password) {
		Email.sendKeys(email);
		Continue.click();
		Password.sendKeys(password);
		Submit.click();
	}
	
}
