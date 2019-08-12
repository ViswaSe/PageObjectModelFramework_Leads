package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class SubFindLeadsPage extends ProjectSpecificMethods{
	
	public SubFindLeadsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//label[contains(text(),'First name')]/following::input[1])")
	WebElement eleFirstName;
	public SubFindLeadsPage enterFirstNameInChildWindow(String fname)
	{
		clearAndType(eleFirstName, fname);
		return this;
	}
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	public SubFindLeadsPage clickFindLeadsButtonInChildWindow()
	{
		click(eleFindLeadsButton);
		return this;
	}
	
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")
	WebElement eleFirstResultingLeadId;
	public SubFindLeadsPage captureFirstResultingLeadIdInChildWindow()
	{
		firstResultingLeadId=getElementText(eleFirstResultingLeadId);
		return this;
	}
	
	public SubFindLeadsPage clickFirstResultingLeadId()
	{
		clickWithNoSnap(eleFirstResultingLeadId);
		return this;
	}
	
	public MergeLeadsPage switchToParentWindow()
	{
		switchToWindow(0);
		return new MergeLeadsPage();
	}
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a[1]")
	WebElement eleSecondResultingLeadId;
	public SubFindLeadsPage captureSecondResultingLeadIdInChildWindow()
	{
		secondResultingLeadId=getElementText(eleSecondResultingLeadId);
		return this;
	}
	
	public SubFindLeadsPage clickSecondResultingLeadIdInChildWindow()
	{
		clickWithNoSnap(eleSecondResultingLeadId);
		return this;
	}

}
