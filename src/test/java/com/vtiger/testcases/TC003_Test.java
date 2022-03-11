package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.objectrepo.Contactinfo;
import com.vtiger.objectrepo.Createcontact;
import com.vtiger.objectrepo.Home;

import vtiger.generics.Baseclass;


public class TC003_Test extends Baseclass{
	@Test(groups = {"regression"})
	public void create_cont() throws Throwable {
		Home homepage=new Home(driver);
		homepage.getContactlink().click();
		Contactinfo contactinfo=new Contactinfo(driver);
		contactinfo.getCreatecontimg().click();

		Createcontact createcontactpage=new Createcontact(driver);
		WebElement elem = createcontactpage.getCreatecontsalutdd();
		webutil.selectfromdd(elem, "Mrs.");

		String fname = jv.fakefirstName();
		String lname = jv.fakelastName();
		createcontactpage.getCreatecontfntxb().sendKeys(fname);
		createcontactpage.getCreatecontlntxb().sendKeys(lname);

		createcontactpage.getCreatecontwinhandle().click();
		webutil.windowhandles(driver, "Accounts");
		String orgname="Renuka";
		createcontactpage.getCreatecontsearchorgnametxt().sendKeys(orgname);
		createcontactpage.getCreatecontsearchorgname().click();
		Thread.sleep(3000);
		createcontactpage.getCreatecontgetorgname().click();
		webutil.windowhandles(driver, "Administrator");
		Thread.sleep(3000);
		createcontactpage.getCreatecontsavebtn().click();
		homepage.getContactlink().click();
		Thread.sleep(3000);
		contactinfo.getContsearchlntxt().sendKeys(lname);
		WebElement insel = contactinfo.getContsearchlndd();
		webutil.selectfromdd(insel,"lastname" );
		Thread.sleep(3000);
		contactinfo.getContsearchbtn().click();
		Thread.sleep(2000);
		String ln = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		Assert.assertEquals(ln, orgname);

	}
	@Test(groups = {"smoke"})
	public void create_cont_withoutdata() {
		Home homepage=new Home(driver);
		homepage.getContactlink().click();
		Contactinfo contactinfo=new Contactinfo(driver);
		contactinfo.getCreatecontimg().click();
		Createcontact createcontactpage=new Createcontact(driver); 
		createcontactpage.getCreatecontsavebtn().click();

		String text = webutil.gettextfromalert(driver);
		System.out.println(text);
		webutil.dismissAlert(driver);
	}
}
