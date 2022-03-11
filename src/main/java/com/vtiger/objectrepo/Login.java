package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement usertxtbox;
	@FindBy(name="user_password")
	private WebElement pwdtxtbox;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	public WebElement getUsertxtbox() {
		return usertxtbox;
	}
	public WebElement getPwdtxtbox() {
		return pwdtxtbox;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
