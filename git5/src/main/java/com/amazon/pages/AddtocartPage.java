package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Baseclass;

public class AddtocartPage extends Baseclass {

	@FindBy (id = "mbc-buybutton-addtocart-1-announce")
	WebElement addtocart;
	
	public AddtocartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addcart() {
		addtocart.click();
	}
}
