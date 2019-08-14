package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_002_EditLeadInLeafTaps extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		excelFileName="TC_002_EditLeadInLeafTaps";
		testcaseName="TC_002_EditLeadInLeafTaps";
		testcaseDec="Editing the available Lead in the leaftaps application";
		browser="chrome";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void editLeadInLeafTaps(String username,String password,String fname,String updatedName)
	{
		System.out.println("Edit lead test case");
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
		.clickEditButton()
		.updateFirstName(updatedName)
		.clickUpdateButton()
		.verifyFirstName(updatedName);	
	}
}
