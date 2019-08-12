package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_001_CreateLeadInLeafTaps extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		excelFileName="TC_001_CreateLeadInLeafTaps";
		testcaseName="TC_001_CreateLeadInLeafTaps";
		testcaseDec="Creating a Lead in the leaftaps application";
		browser="chrome";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void createLeadInLeafTaps(String username,String password,String cname,String fname,String lname)
	{
		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickCreateLead()
		.enterCompanyName(cname)
		.enterFirstName(fname)
		.enterLastName(lname)
		.selectSourceDropDown(2)
		.clickSubmit()
		.verifyFirstName(fname);
		
	}
}
