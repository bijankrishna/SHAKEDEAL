package com.elementRepositoryMain;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(css = "input#email")
	private WebElement emailAddressTB;
	@FindBy(css = "input#password")
	private WebElement passwordTB;
	@FindBy(xpath = "//button[text()='LOG IN']")
	private WebElement loginBTN;
	
	public WebElement getEmailAddressTB() {
		return emailAddressTB;
	}
	
	public WebElement getPasswordTB() {
		return passwordTB;
	}
	public WebElement getLoginBTN() {
		return loginBTN;
	}
	
}
