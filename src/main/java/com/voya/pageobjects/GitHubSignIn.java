package com.voya.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.voya.data.Base;
import com.voya.utilities.TestUtil;

public class GitHubSignIn extends Base {
	
	WebDriver driver;

	
	public GitHubSignIn(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='HeaderMenu-link no-underline mr-3']")
	public WebElement Sign_in;
	
	public void sign() throws IOException, InterruptedException
	{
		Assert.assertEquals(true, Sign_in.isDisplayed());
		TestUtil.captureScreenshot();
		Assert.assertEquals(driver.getTitle(), "The world’s leading software development platform · GitHub");
		click(Sign_in);
		wait(1);
		Assert.assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
		TestUtil.captureScreenshot();
	}
	

}
