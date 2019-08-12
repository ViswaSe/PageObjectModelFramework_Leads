package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement eleUserName;
	public LoginPage enterUserName(String username)
	{
		clearAndType(eleUserName, username);
		return this;
	}
	
	@FindBy(id="password")
	WebElement elePassword;
	public LoginPage enterPassword(String password)
	{
		clearAndType(elePassword, password);
		return this;
	}
	
	@FindBy(className="decorativeSubmit")
	WebElement eleLoginButton;
	public HomePage clickLogin()
	{
		click(eleLoginButton);
		return new HomePage();
	}

}
