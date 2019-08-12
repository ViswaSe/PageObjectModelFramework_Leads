package com.leaftaps.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.leaftaps.utils.ExcelUtils;

public class ProjectSpecificMethods extends SeMethods{

	@DataProvider(name="fetchData")
	public Object[][] getData()
	{
		return ExcelUtils.readExcelData(excelFileName);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		node=test.createNode(testcaseName);
		startApp(browser,url);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		quit();
	}
}
