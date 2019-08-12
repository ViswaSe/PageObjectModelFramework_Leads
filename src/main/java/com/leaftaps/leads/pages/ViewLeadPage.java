package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	
	public ViewLeadPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFirstName;
	public ViewLeadPage verifyFirstName(String expectedText)
	{
		verifyExactText(eleFirstName, expectedText);
		return this;
	}
	
	@FindBy(linkText="Edit")
	WebElement eleEditButton;
	public EditLeadPage clickEditButton()
	{
		click(eleEditButton);
		return new EditLeadPage();
	}
	
	@FindBy(linkText="Delete")
	WebElement eleDeleteButton;
	public MyLeadsPage clickDeleteButton()
	{
		click(eleDeleteButton);
		return new MyLeadsPage();
	}
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	public FindLeadsPage clickFindLeads()
	{
		click(eleFindLeads);
		return new FindLeadsPage();
	}
	
}
