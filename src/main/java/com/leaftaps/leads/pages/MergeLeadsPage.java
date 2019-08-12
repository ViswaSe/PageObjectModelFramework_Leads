package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.ProjectSpecificMethods;

public class MergeLeadsPage extends ProjectSpecificMethods{
	
	public MergeLeadsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Lookup']")
	WebElement eleFirstIcon;
	public MergeLeadsPage clickFirstIcon()
	{
		click(eleFirstIcon);
		return this;
	}
	
	public SubFindLeadsPage switchToChildWindow(int windowIndex)
	{
		switchToWindow(windowIndex);
		return new SubFindLeadsPage();
	}
	
	@FindBy(xpath="(//img[@alt='Lookup'])[2]")
	WebElement eleSecondIcon;
	public MergeLeadsPage clickSecondIcon()
	{
		click(eleSecondIcon);
		return this;
	}
	
	@FindBy(linkText="Merge")
	WebElement eleMergeButton;
	public MergeLeadsPage clickMergeButton()
	{
		clickWithNoSnap(eleMergeButton);
		return this;
	}
	
	public ViewLeadPage acceptAlertInMergeWindow()
	{
		acceptAlert();
		return new ViewLeadPage();
	}

}
