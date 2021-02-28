package com.voya.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import com.voya.data.Base;
import com.voya.pageobjects.GitHubSignIn;
import com.voya.utilities.TestUtil;


public class GitHubSignInTestCase1 extends Base{
	
	
	@BeforeClass
	public void setup() throws IOException, InterruptedException 
	{
		driver = BrowserInitialization();
        log.info("++++++Browser Initiated++++");
		
	}
	
	@Test
	public void SigninLinktestcase1() throws IOException, InterruptedException
	{
		TestUtil.LoadDriverWindow();
		
		GitHubSignIn lg1 = new GitHubSignIn(driver);
		lg1.sign();
		
		TestUtil.DeleteCookies();
    }
	
	
	@AfterClass
	public void teardown()
	{
		TestUtil.DriverQuit();
	}

}
