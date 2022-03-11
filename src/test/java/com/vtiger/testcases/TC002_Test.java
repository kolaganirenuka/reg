package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.objectrepo.Createorg;
import com.vtiger.objectrepo.Home;
import com.vtiger.objectrepo.Orginfo;

import vtiger.generics.Baseclass;



public class TC002_Test extends Baseclass{
	@Test(groups={"regression"})
	public void create_org_Test() throws Throwable {
		Home homepage= new Home(driver);
		homepage.getOrglink().click();
		Orginfo orginfopage = new Orginfo(driver);
		orginfopage.getCreateorgimg().click();
		Createorg createorgpage=new Createorg(driver);
		String orgname=jv.fakecompanyName();
		createorgpage.getOrgname().sendKeys(orgname);
		createorgpage.getOrgsavebtn().click();
		Thread.sleep(3000);
		homepage.getOrglink().click();
		Thread.sleep(2000);
		orginfopage.getSearchtxtbox().sendKeys(orgname);
		WebElement orgd = orginfopage.getOrgtypesdd();
		webutil.selectfromdd(orgd,"accountname");
		orginfopage.getSearchorgbtn().click();
		Thread.sleep(2000);
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		Thread.sleep(2000);
		Assert.assertEquals(value, orgname);
	}
	@Test(groups={"smoke"})
	public void create_empty_org_Test() throws Throwable {
		Home homepage= new Home(driver);
		homepage.getOrglink().click();

		Orginfo orginfopage = new Orginfo(driver);
		orginfopage.getCreateorgimg().click();
		Createorg createorgpage=new Createorg(driver);
		createorgpage.getOrgsavebtn().click();
		Thread.sleep(3000);
		String text = webutil.gettextfromalert(driver);
		System.out.println(text);
		webutil.dismissAlert(driver);
	}
}
