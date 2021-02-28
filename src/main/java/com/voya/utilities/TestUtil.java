package com.voya.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;
import com.voya.data.Base;
import com.voya.data.BaseExcelDataObject;


public class TestUtil extends Base {
	
	public static String screenshotPath;
	public static String screenshotName;
	public static String excelpath;
	public static String OS = System.getProperty("os.name").toLowerCase();

	public static void LoadDriverWindow() {

		try {
		if (prop.getProperty("env").equals("INTG")) {
			driver.get(prop.getProperty("test_INTG_url"));
		} else {
			driver.get(prop.getProperty("test_ACCP_url"));
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit.wait")),TimeUnit.SECONDS);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void DeleteCookies()
	{
		try {
		driver.manage().deleteAllCookies();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void DriverQuit()
	{
		try {
			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String captureScreenshot() throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String screenshotName = d.toString().replace(":","_").replace(" ","_") + ".jpg";
		String dest="";
		if(isWindows())
		{
			dest= System.getProperty("user.dir")+"\\target\\surefire-reports\\Screenshots\\"+ screenshotName;
		}
		else
		{
			dest= System.getProperty("user.dir")+"/target/surefire-reports/Screenshots/"+ screenshotName;
		}
		
		FileUtils.copyFile(srcFile, new File(dest));
		
		return dest;
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	@DataProvider(name="dp")
	public static Object[][] getData(Method M)
	{
		Object[][] testdata = new Object[dtobj.size()][1];
		for(int i =0; i<dtobj.size();i++)
		{
			testdata[i][0]=dtobj.get(i);
		}
			
		return testdata;
		
	}

	public static List<? extends BaseExcelDataObject > Generate(String sheetName)
	{
		List<? extends BaseExcelDataObject> people=null;
		
		try {
			
			excelpath = getTestData();
			System.out.println("path="+excelpath);
			PoijiOptions options = PoijiOptionsBuilder.settings().sheetName(sheetName).build();
			people=Poiji.fromExcel(new File(excelpath), baseExcelDataObject.getClass(), options);
		
		    }
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return people;
		
	}
	
	private static String findpath(String file) 
	{
		File f = null;
		String path = "";
		try
		{
			ClassLoader classloader= ClassLoader.getSystemClassLoader();
			f = new File(classloader.getResource(file).getFile());
		}	
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		if(f!=null)
		{
			path = f.getAbsolutePath();
		}	
		return path;
	}
	
	public static String getTestData()
	{	
			if (prop.getProperty("env").equals("INTG")) 
			{
				return findpath(prop.getProperty("test_data_INTG"));
			} 
			
			else 
			{
				return findpath(prop.getProperty("test_data_ACCP"));
			}	
	}

	

}
