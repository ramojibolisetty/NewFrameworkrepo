package com.voya.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import com.voya.data.Base;
import com.voya.data.ExcelDataObject;
import com.voya.pageobjects.GitHubHomePage;
import com.voya.utilities.TestUtil;


public class GitHubHomePageTestCase3 extends Base{
	 
	@BeforeClass
	public void setup() throws IOException, InterruptedException 
	{
		driver = BrowserInitialization();
		ExcelDataObject obj = new ExcelDataObject();
		setUp(this.getClass().getSimpleName(), obj);
	}
	
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void GitHubHomeTestcase3(ExcelDataObject dt) throws InterruptedException, IOException
	{   
		TestUtil.LoadDriverWindow();
		
		GitHubHomePage hp= new GitHubHomePage(driver);
        hp.HomepageTest(dt);
		
		TestUtil.DeleteCookies();
	}
	
	
	@AfterClass
	public void teardown()
	{
		TestUtil.DriverQuit();
	}

}
