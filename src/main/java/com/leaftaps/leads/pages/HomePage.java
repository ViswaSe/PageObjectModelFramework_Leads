package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="CRM/SFA")
	WebElement eleCRMSFALink;
	public MyHomePage clickCrmsfa()
	{
		click(eleCRMSFALink);
		return new MyHomePage();
	}
	
	
}
