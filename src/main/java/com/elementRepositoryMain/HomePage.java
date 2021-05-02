package com.elementRepositoryMain;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage {

	@FindBys({
		@FindBy(xpath = "//button[@class='close cm-notification-close ']")
	})
	private List<WebElement> notification;

	@FindBy(xpath = "//i[@class='ty-icon-down-micro ty-account-info__user-arrow']")
	private WebElement accountInfoDD;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signoutBTN;
	
	public WebElement getAccountInfoDD() {
		return accountInfoDD;
	}

	public WebElement getSignoutBTN() {
		return signoutBTN;
	}

	public List<WebElement> getNotification() {
		return notification;
	}
	
}
