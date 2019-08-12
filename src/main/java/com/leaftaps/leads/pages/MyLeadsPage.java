package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods{
	
	public MyLeadsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	public CreateLeadPage clickCreateLead()
	{
		click(eleCreateLead);
		return new CreateLeadPage();
	}
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	public FindLeadsPage clickFindLeads()
	{
		click(eleFindLeads);
		return new FindLeadsPage();
	}

	@FindBy(linkText="Merge Leads")
	WebElement eleMergeLeads;
	public MergeLeadsPage clickMergeLeads()
	{
		click(eleMergeLeads);
		return new MergeLeadsPage();
	}
}
