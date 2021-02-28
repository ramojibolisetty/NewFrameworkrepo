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

public class GitHubHomePage extends Base{
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='HeaderMenu-link no-underline mr-3']")
	public WebElement Sign_in;
	
	@FindBy(xpath="//input[@id='login_field']")
	public WebElement login_field;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='commit']")
	public WebElement commit;
	
	@FindBy(xpath="//span[contains(text(),'Gitdemo')]")
    public WebElement Repository;
	
	public GitHubHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void HomepageTest(ExcelDataObject dt) throws IOException, InterruptedException
	{
		click(Sign_in);
		TestUtil.captureScreenshot();
		wait(1);
		Assert.assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
	    type(login_field, dt.Username);
	    type(password, dt.Password);
		TestUtil.captureScreenshot();
		wait(1);
		click(commit);	
		Assert.assertEquals(driver.getTitle(), "GitHub");
		click(Repository);
		Assert.assertEquals(driver.getTitle(), "ramojibolisetty/Gitdemo");	
	}
}

