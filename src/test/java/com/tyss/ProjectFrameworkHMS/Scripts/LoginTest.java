package com.tyss.ProjectFrameworkHMS.Scripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tyss.ProjectFrameworkHMS.init.BaseLib;
import com.tyss.ProjectFrameworkHMS.init.IConstants;
import com.tyss.ProjectFrameworkHMS.lib.ExcelLib;
import com.tyss.ProjectFrameworkHMS.pages.DashBoardpage;
import com.tyss.ProjectFrameworkHMS.pages.SigninPage;


public class LoginTest extends BaseLib
{

//	@Test
//	public void TC_01() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
//	{
//		FileInputStream fis=new FileInputStream(IConstants.adminlogindata);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Sheet1");
//		String username = sh.getRow(1).getCell(1).getStringCellValue();
//		String password = sh.getRow(1).getCell(2).getStringCellValue();
//		Thread.sleep(2000);
//		 WebElement adminbutton = driver.findElement(By.xpath("//a[@href='hms/admin']"));
//		 Thread.sleep(2000);
//		 adminbutton.click();
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(2000);
//		}
	@Test
	public void TC_02() throws InterruptedException
	{
		SigninPage sip=new SigninPage(driver);
		String username=ExcelLib.getdata("Sheet1",1, 1, IConstants.adminlogindata);
		String password=ExcelLib.getdata("Sheet1",1,2,IConstants.adminlogindata);
		sip.doLogin(username, password);
		Reporter.log("Admin Dashboard is Login Sucessfully");
		DashBoardpage db=new DashBoardpage(driver);
		Assert.assertEquals(sip.getSignInPage(),ExcelLib.getdata("Sheet1", 1, 3,IConstants.adminlogindata));
		db.clickOnDoctors();
		Thread.sleep(3000);
		db.clickonAddDoctor();
		Thread.sleep(2000);
		Assert.assertEquals(sip.getSignInPage(),ExcelLib.getdata("Sheet1", 1, 4,IConstants.adminlogindata));
		String Docname=ExcelLib.getdata("Sheet1", 1, 5,IConstants.adminlogindata);
		String DocAddress=ExcelLib.getdata("Sheet1",1, 6,IConstants.adminlogindata);
		int Consultancefee=(int)ExcelLib.getdata1("Sheet1",1, 7, IConstants.adminlogindata);
		db.dropdown(Docname,DocAddress,Consultancefee);
		Thread.sleep(5000);
		}
	@Test
	public void TC_03() {
		SigninPage sip=new SigninPage(driver);
		String username=ExcelLib.getdata("Sheet1",1, 1, IConstants.adminlogindata);
		String password=ExcelLib.getdata("Sheet1",1,2,IConstants.adminlogindata);
		sip.doLogin(username, password);
		Reporter.log("Admin Dashboard is Login Sucessfully");
		DashBoardpage db=new DashBoardpage(driver);
		Assert.assertEquals(sip.getSignInPage(),ExcelLib.getdata("Sheet1", 1, 3,IConstants.adminlogindata));
		db.clickOnDoctors();
		//driver.findElements(By.xpath(""))
		
	}

}
