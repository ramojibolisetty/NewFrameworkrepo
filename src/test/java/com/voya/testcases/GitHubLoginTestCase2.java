package com.voya.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import com.voya.data.Base;
import com.voya.data.ExcelDataObject;
import com.voya.pageobjects.GitHubLogin;
import com.voya.utilities.TestUtil;


public class GitHubLoginTestCase2 extends Base{
	 
	@BeforeClass
	public void setup() throws IOException, InterruptedException 
	{
		driver = BrowserInitialization();
		ExcelDataObject obj = new ExcelDataObject();
		setUp(this.getClass().getSimpleName(), obj);			
	}
		
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void GitHublogintestcase2(ExcelDataObject dt) throws IOException, InterruptedException
	{   
		TestUtil.LoadDriverWindow();
		
		GitHubLogin gl2= new GitHubLogin(driver);
		gl2.Githublogintest(dt);

		TestUtil.DeleteCookies();
    }
	
	@AfterClass
	public void teardown()
	{
		TestUtil.DriverQuit();
	}

}
