package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_004_DeleteLeadInLeafTaps extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		excelFileName="TC_004_DeleteLeadInLeafTaps";
		testcaseName="TC_004_DeleteLeadInLeafTaps";
		testcaseDec="Delete the existing Lead in the leaftaps application";
		browser="chrome";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void deleteLeadInLeafTaps(String username,String password,String fname)
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
		.captureFirstResultingLeadId()
		.clickFirstResultingLeadId()
		.clickDeleteButton()
		.clickFindLeads()
		.enterCapturedFirstResultingLeadId()
		.clickFindLeadsButton()
		.VerifyExceptionalMessage();
	}
}
