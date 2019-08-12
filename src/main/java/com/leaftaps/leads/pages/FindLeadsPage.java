package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods{
	
	public FindLeadsPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//label[contains(text(),'First name')]/following::input[1])[3]")
	WebElement eleFirstName;
	public FindLeadsPage enterFirstNameInFindLeads(String fname)
	{
		clearAndType(eleFirstName, fname);
		return this;
	}
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	public FindLeadsPage clickFindLeadsButton()
	{
		clickWithNoSnap(eleFindLeadsButton);
		return this;
	}
	
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")
	WebElement eleFirstResultingLeadId;
	public FindLeadsPage captureFirstResultingLeadId()
	{
		firstResultingLeadId=getElementText(eleFirstResultingLeadId);
		return this;
	}
	
	public ViewLeadPage clickFirstResultingLeadId()
	{
		click(eleFirstResultingLeadId);
		return new ViewLeadPage();
	}
	
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]")
	WebElement eleFirstResultingLeadName;
	public FindLeadsPage captureFirstResultingLeadName()
	{
		firstResultingLeadName=getElementText(eleFirstResultingLeadName);
		return this;
	}
	
	public ViewLeadPage clickFirstResultingLeadName()
	{
		click(eleFirstResultingLeadName);
		return new ViewLeadPage();
	}
	
	@FindBy(xpath="//label[contains(text(),'Lead ID')]/following::input[1]")
	WebElement eleLeadId;
	public FindLeadsPage enterCapturedFirstResultingLeadId()
	{
		clearAndType(eleLeadId, firstResultingLeadId);
		return this;
	}
	
	@FindBy(xpath="//div[text()='No records to display']")
	WebElement eleExceptionalMessage;
	public FindLeadsPage VerifyExceptionalMessage()
	{
		verifyPartialText(eleExceptionalMessage,"No records");
		return this;
	}
	
}
