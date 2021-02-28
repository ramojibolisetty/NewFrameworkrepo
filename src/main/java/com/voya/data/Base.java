package com.voya.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.voya.utilities.TestUtil;
import com.voya.utilities.WebEventListener;

public class Base {
	
 public static WebDriver driver;
 public static Properties prop;
 public static EventFiringWebDriver e_driver;
 public static WebEventListener eventListener;
 public static List<BaseExcelDataObject>dtobj=null;
 public static BaseExcelDataObject baseExcelDataObject = null;
 public static Logger log = Logger.getLogger(Base.class.getName());
 public static WebDriver wait;
 
 public void setUp(String testCaseName, BaseExcelDataObject baseExcelDataObject) throws IOException
 {
	this.baseExcelDataObject = baseExcelDataObject;
	try
	{
		this.setUp(testCaseName);
	}
   catch(Exception e)
	{
	   e.printStackTrace();
	}
 }
 
 public WebDriver BrowserInitialization() throws IOException, InterruptedException 
 {
	 
	 prop = new Properties();
	 FileInputStream fis = new FileInputStream("C:\\Users\\91917\\NewFramework\\src\\test\\resources\\properties\\config.properties");
	 prop.load(fis);
	 String browswername = prop.getProperty("browser");
	 
	 if(browswername.contains("chrome")) 
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\91917\\Downloads\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	 }
	 
	 else if(browswername.contains("ie")) 
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\91917\\Downloads\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	 }
	 
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	 
	return driver;
	 
 }
 
    @SuppressWarnings("unchecked")
	public void setUp(String testCaseName) throws IOException
    {
    	
    	try
    	{
    		dtobj=(List<BaseExcelDataObject>) TestUtil.Generate(testCaseName);
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    
	public static void click(WebElement element) throws IOException
	{
		try
		{
			element.click();
			log.info("Element "+element+"Clicked Sucessfully!!!");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void type(WebElement element, String value) throws IOException
	{
		try
		{
			element.sendKeys(value);
			
			log.info("Element "+element+" entered with value >>" + value );
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void wait(int time) throws IOException, InterruptedException
	{
			Thread.sleep(time*(long) 1000);
	}

}
