package com.tyss.ProjectFrameworkHMS.lib;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.tyss.ProjectFrameworkHMS.init.IConstants;

public class GenericLib {

	public static String getPropData(String key)
	{
		String data="";
		try {
			FileInputStream fis=new FileInputStream(IConstants.propfilepath);
			Properties pro=new Properties();
			pro.load(fis);
			data=pro.getProperty(key);
		return data;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return data;
	}
	public static void clickElement(WebDriver driver,WebElement ele,String eleName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
		wait.until(ExpectedConditions.visibilityOf(ele)).click();
		Reporter.log("Clicked on "+ eleName);
		}
		catch(Exception e)
		{
			Reporter.log(eleName+" is not Displayed");
			Assert.fail();
		}
	}
	public static void saveScreenShot(WebDriver driver,String name)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy  hh-mm-ss");
		String currenttime=LocalDateTime.now().format(dtf);
		File src=ts.getScreenshotAs(OutputType.FILE);
		File desc=new File(IConstants.Screenshot + name +"" + currenttime + " _Failed.png");
	}
	public static void enterText(WebDriver driver, WebElement usernametxtbox, String username, String string) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
		wait.until(ExpectedConditions.visibilityOf(usernametxtbox)).sendKeys(username);
		Reporter.log("Entered Text \" "+username+" \" in the"+string);
		}
		catch(Exception e)
		{
			Reporter.log(string+" is not Displayed");
			  Assert.fail();
		}
		
	}
//		public static void enterText1(WebDriver driver, WebElement ConsultancefeeTxt, int consultancyfee,String string) {
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		try {
//		wait.until(ExpectedConditions.visibilityOf(ConsultancefeeTxt)).sendKeys(consultancyfee);
//		Reporter.log("Entered value \" "+consultancyfee+" \" in the"+ string);
//		}
//		catch(Exception e)
//		{
//			Reporter.log(string+" is not Displayed");
//			  Assert.fail();
//		}
//		
//	}
	
}
