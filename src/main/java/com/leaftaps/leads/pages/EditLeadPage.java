package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods {
	
	public EditLeadPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="updateLeadForm_firstName")
	WebElement eleFirstName;
	public EditLeadPage updateFirstName(String fname)
	{
		clearAndType(eleFirstName, fname);
		return this;
	}
	
	@FindBy(name="submitButton")
	WebElement eleUpdateButton;
	public ViewLeadPage clickUpdateButton()
	{
		click(eleUpdateButton);
		return new ViewLeadPage();
	}
	
	
}
