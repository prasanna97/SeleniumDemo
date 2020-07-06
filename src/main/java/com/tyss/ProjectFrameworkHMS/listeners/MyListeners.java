package com.tyss.ProjectFrameworkHMS.listeners;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.tyss.ProjectFrameworkHMS.lib.GenericLib;

public class MyListeners implements ITestListener  {

	public void onTestStart(ITestResult result) {
	    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy  hh-mm-ss");
	    String starttime=LocalDateTime.now().format(dtf);
	    Reporter.log("The Test Case " + result.getName() +" Started At :"+starttime);
	  }

	  
	  public void onTestSuccess(ITestResult result) {
	    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy  hh-mm-ss");
	    String endtime=LocalDateTime.now().format(dtf);
	    Reporter.log("The Test Case "+ result.getName() + "Completed At :" + endtime);
	  }

	  
	  public void onTestFailure(ITestResult result) {
	   DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy hh-mm-ss");
	   String endtime=LocalDateTime.now().format(dtf);
	   Reporter.log("The Test Case "+ result.getName() + " Failed At "+ endtime);
	   WebDriver driver=(WebDriver)result.getTestContext().getAttribute("driver");
	   GenericLib.saveScreenShot(driver, result.getName());
	  }

	  public void onStart(ITestContext context) {
	    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy hh-mm-ss");
	    String starttime=LocalDateTime.now().format(dtf);
	    Reporter.log("The Test suit started At :" + starttime);
	    
	  }

	  
	  public void onFinish(ITestContext context) {
	   DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy hh-mm-ss");
	   String endtime=LocalDateTime.now().format(dtf);
	   Reporter.log("The Test suit ended At : " + endtime);
	   
	  }


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


}
