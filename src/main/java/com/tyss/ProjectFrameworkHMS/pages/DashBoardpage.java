package com.tyss.ProjectFrameworkHMS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tyss.ProjectFrameworkHMS.lib.GenericLib;

public class DashBoardpage {
	WebDriver driver;
	@FindBy(xpath="//div[@class='item-inner']//span[text()=' Doctors ']")
	private WebElement doctor;
	@FindBy(xpath="//span[text()=' Add Doctor']")
	private WebElement adddoctorbtn;
	@FindBy(name="docname")
	private WebElement DocNameTxt;
	@FindBy(name="clinicaddress")
	private WebElement DocAddTxt;
	@FindBy(xpath="//input[@placeholder='Enter Doctor Consultancy Fees']")
	private WebElement ConsultancefeeTxt;
	public DashBoardpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnDoctors()
	{
		GenericLib.clickElement(driver, doctor,"Doctors");
	}
	public void clickonAddDoctor()
	{
		GenericLib.clickElement(driver, adddoctorbtn, "Add Doctor");
	}
	public String getTitle()
	{
		return driver.getTitle();
		
	}
	public  void dropdown(String Docname,String DocAddress,CharSequence[] Consultancefee)
	{
		Select decspl=new Select(driver.findElement(By.name("Doctorspecialization")));
		decspl.selectByValue("Ayurveda");
		GenericLib.enterText(driver, DocNameTxt,Docname , "DoctorsNamSe");
		GenericLib.enterText(driver, DocAddTxt, DocAddress, "Doctor Clinic Address");
		GenericLib.enterText1(driver, ConsultancefeeTxt, Consultancefee, "Consultance Fee");
		    
		
	}
	



}
