package com.tyss.ProjectFrameworkHMS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.ProjectFrameworkHMS.lib.GenericLib;

public class SigninPage {

	WebDriver driver;
	 
	@FindBy(xpath="//a[@href='hms/admin']")
	private WebElement adminbtn;

	@FindBy(name="username")
	private WebElement usernametxtbox;

	@FindBy(name="password")
	private WebElement pwdtxtbox;
	@FindBy(name="submit")
	private WebElement loginbtn;

	public SigninPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void doLogin(String username,String password)
	{
		GenericLib.clickElement(driver, adminbtn, "Click Here");
		GenericLib.enterText(driver, usernametxtbox,username,"Username Textbox");
		GenericLib.enterText(driver, pwdtxtbox, password, "Password Textbox");
		GenericLib.clickElement(driver, loginbtn, "LoginBtn");
	}
	public String getSignInPage() {
		return driver.getTitle();
	}


}
