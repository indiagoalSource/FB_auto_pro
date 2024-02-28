package testNgPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Page.ForgotPassword;
import Page.LoginPage;
import Utils.Utility;
import browserSelect.Base;

public class VerifyForgotPasswordFunctionality extends Base{
	
	WebDriver driver ;
	LoginPage loginPage ;
	ForgotPassword forgotPassword ;
	String testID ;
	static ExtentTest test ;
	static ExtentHtmlReporter reporter ;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	
	@BeforeClass
	public void CreatePOMObjects() {
		
		loginPage = new LoginPage(driver);
		forgotPassword = new ForgotPassword(driver);
		
	}
	
	
	@BeforeMethod
	public void openLoginPage() {
		
		driver.get("https://www.facebook.com/");
		loginPage.clickOnForgotPassword();
	}
	
	@Test (priority = 1)
	public void verifyTextOnForgotPasswordPage() {
		
		//testID ="T001";
		//test id changes 
		testID = "T0010";
		String actualMsg = forgotPassword.getTextMessage();
		String expectedMsg = "Please enter your email address or mobile number to search for your account.";

		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test(priority = 2)
	public void verifyCancelButtonOnForgotPasswordPage() {
		testID ="T002";
		String actualURL = forgotPassword.clickOnCancelButton();
		String expectedURL = "https://www.facebook.com/login.php";
		
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority = 3)
	public void verifySearchButtonFunctionalityWithWrongId() throws InterruptedException {
		testID ="T003";
		forgotPassword.sendWrongEmailOrPhone();
		forgotPassword.clickOnSearchButton();
		Thread.sleep(2000);
		String actualErrorMsgTitle = forgotPassword.getErrorTitle();
		String expectedErrorMsgTitle = "No search results";
		String actualErrorMsg = forgotPassword.getErrorMsg();
		String expectedErrorMsg = "Your search did not return any results. Please try again with other information.";
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualErrorMsgTitle, expectedErrorMsgTitle);
		soft.assertEquals(actualErrorMsg, expectedErrorMsg);
		soft.assertAll();
		
	}
	
	@Test(priority = 4)
	public void verifySearchButtonFunctionalityWithCorrectId() throws InterruptedException {
		testID ="T004";
		forgotPassword.sendCorrectEmailAndPhone();
		forgotPassword.clickOnSearchButton();
		Thread.sleep(2000);
		String actualHeaderMsg = forgotPassword.getHeaderMsg();
		String expectedHeaderMsg = "Log in to Facebook";

		Assert.assertEquals(actualHeaderMsg, expectedHeaderMsg);
		
	}
	

	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(driver, testID);
		}
		
		
		// application logOut code 
	}
	
	@AfterClass
	public void clearObjects() {
		
		loginPage = null ;
		forgotPassword = null ;
	}
	
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
		driver = null ;
		System.gc();
	}
	
}
