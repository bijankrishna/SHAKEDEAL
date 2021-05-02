package com.elementRepositoryMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	@FindBy(xpath = "//div[@class='ty-account-info__title-txtx']")
	private WebElement loginBTN;

	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLoginBTN() {
		return loginBTN;
	}
	
}
