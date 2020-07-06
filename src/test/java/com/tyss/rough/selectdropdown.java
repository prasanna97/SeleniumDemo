package com.tyss.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.tyss.ProjectFrameworkHMS.init.IConstants;

public class selectdropdown {

	static {
		System.setProperty("webdriver.chrome.driver","./Softwares/chromedriver.exe");
	}
	@Test
	public void TC_01() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(IConstants.adminlogindata);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		String username = sh.getRow(1).getCell(1).getStringCellValue();
		String password = sh.getRow(1).getCell(2).getStringCellValue();
		Thread.sleep(2000);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/hospital/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 WebElement adminbutton = driver.findElement(By.xpath("//a[@href='hms/admin']"));
		 Thread.sleep(2000);
		 adminbutton.click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		WebElement doctorsmenu = driver.findElement(By.xpath("//span[text()=' Doctors ']"));
		doctorsmenu.click();
		driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();
		Thread.sleep(2000);
		Select decspl=new Select(driver.findElement(By.name("Doctorspecialization")));
		decspl.selectByValue("Ayurveda");
		driver.close();
		}
	}

