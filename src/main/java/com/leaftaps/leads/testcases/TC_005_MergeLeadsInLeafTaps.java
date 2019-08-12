package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_005_MergeLeadsInLeafTaps extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		excelFileName="TC_005_MergeLeadsInLeafTaps";
		testcaseName="TC_005_MergeLeadsInLeafTaps";
		testcaseDec="Merge the two available leads in the leaftaps application";
		browser="chrome";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void mergeLeadInLeafTaps(String username,String password,String fname)
	{
		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickMergeLeads()
		.clickFirstIcon()
		.switchToChildWindow(1)
		.enterFirstNameInChildWindow(fname)
		.clickFindLeadsButtonInChildWindow()
		.captureFirstResultingLeadIdInChildWindow()
		.clickFirstResultingLeadId()
		.switchToParentWindow()
		.clickSecondIcon()
		.switchToChildWindow(1)
		.enterFirstNameInChildWindow(fname)
		.clickFindLeadsButtonInChildWindow()
		.captureSecondResultingLeadIdInChildWindow()
		.clickSecondResultingLeadIdInChildWindow()
		.switchToParentWindow()
		.clickMergeButton()
		.acceptAlertInMergeWindow()
		.clickFindLeads()
		.enterCapturedFirstResultingLeadId()
		.clickFindLeadsButton()
		.VerifyExceptionalMessage();
	}
}
