package vtiger.generics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.vtiger.objectrepo.Home;
import com.vtiger.objectrepo.Login;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {
	public WebDriver driver;
	public Fileutils fileutil = new Fileutils();
	public Webdriverutilities webutil = new Webdriverutilities();
	public Javautil jv = new Javautil();

	@BeforeSuite(groups = {"smoke,regression"})
	public void makeConnections() {
		System.out.println("Before Siute");
		System.out.println("data base connection");
	}
	@BeforeTest(groups = {"smoke,regresson"})
	public void beforeTest() 
	{
		System.out.println("==Before Test==");
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke,regression"})
	public void launchbrowser_driver_Initilize() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		String BROWSER=fileutil.readdataprop("Browser");
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();	
		}
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}

		driver.get(fileutil.readdataprop("Url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod(groups = {"smoke,regression"})
	public void logintoApp() throws Throwable {
		Login loginpage = new Login(driver);

		loginpage.getUsertxtbox().sendKeys(fileutil.readdataprop("UN"));

		loginpage.getPwdtxtbox().sendKeys(fileutil.readdataprop("PW"));

		loginpage.getLoginbtn().click();
	}

	@AfterMethod(groups = {"smoke,regression"})
	public void logoutFromApp()
	{

		Home homepage = new Home(driver);
		WebElement signoutimg1 = homepage.getSignoutimg();
		webutil.actionelement(driver, signoutimg1);

		homepage.getSignoutlink().click();
		System.out.println("Logout form App");
	}
	@AfterClass(groups = {"smoke,regression"})
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}


	@AfterTest(groups = {"smoke,regression"})
	public void aftertest() {
		System.out.println("after test");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite");
	}

}
