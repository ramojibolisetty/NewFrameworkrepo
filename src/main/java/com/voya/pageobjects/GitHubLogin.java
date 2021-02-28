package com.voya.pageobjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.voya.data.Base;
import com.voya.data.ExcelDataObject;
import com.voya.utilities.TestUtil;

public class GitHubLogin extends Base {
	
	WebDriver driver;
	
	public GitHubLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='HeaderMenu-link no-underline mr-3']")
	public WebElement Sign_in;
	
	@FindBy(xpath="//input[@id='login_field']")
	public WebElement login_field;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='commit']")
	public WebElement commit;
	
	
	public void Githublogintest(ExcelDataObject dt) throws IOException, InterruptedException
	{
		click(Sign_in);
		TestUtil.captureScreenshot();
		type(login_field, dt.Username);
		wait(2);
		type(password, dt.Password);
		wait(2);
		TestUtil.captureScreenshot();
		Assert.assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
		click(commit);	
	}
	
}
