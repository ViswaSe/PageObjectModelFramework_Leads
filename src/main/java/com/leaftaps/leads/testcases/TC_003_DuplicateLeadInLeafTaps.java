package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_003_DuplicateLeadInLeafTaps extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		excelFileName="TC_003_DuplicateLeadInLeafTaps";
		testcaseName="TC_003_DuplicateLeadInLeafTaps";
		testcaseDec="Create a Duplicate Lead with existing values in the leaftaps application";
		browser="chrome";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void duplicateLeadInLeafTaps(String username,String password,String fname)
	{
		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickFindLeads()
		.enterFirstNameInFindLeads(fname)
		.clickFindLeadsButton()
		.captureFirstResultingLeadName()
		.clickFirstResultingLeadName()
		.clickEditButton()
		.clickUpdateButton()
		.verifyFirstName(firstResultingLeadName);
	}
}
