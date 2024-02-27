package testNgPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Page.CreateNewAccount;
import Page.LoginPage;
import Utils.Utility;
import browserSelect.Base;


public class VerifyLoginAndCreteNewAccFunctionality extends Base{
	
	WebDriver driver ;
	LoginPage loginPage ;
	CreateNewAccount createNewAccount ;
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
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	public void createPOMObject() {
		
		loginPage = new LoginPage(driver);
		createNewAccount = new CreateNewAccount(driver);
	}
	
	
	@BeforeMethod
	public void openLogInPageOnApplication() {
		
		driver.get("https://www.facebook.com/");
	}
	
	@Test (priority =1)
	public void verifyLoginFunctionality() throws EncryptedDocumentException, IOException {
		testID = "T101";
		loginPage.sendUserName(Utility.getExcelData("my2ndsheet", 1, 4));
		loginPage.sendPassword(Utility.getExcelData("my2ndsheet", 1, 5));
		loginPage.clickOnLoginButoon();
		String actualTextMsg = loginPage.getTextMsgAfterLogin();
		String expectedTextMsg = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		
		Assert.assertEquals(actualTextMsg, expectedTextMsg);
	}
	
	@Test (priority =2)
	public void creatNewAccFormFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		testID = "T102";
		loginPage.clickOnCreateNewAcc();
		Thread.sleep(2000);
		
		//String data = Utility.getExcelData("my1stsheet", 0, 0);
		
		createNewAccount.sendFirstName(Utility.getExcelData("my2ndsheet", 1, 0));
		createNewAccount.sendSurname(Utility.getExcelData("my2ndsheet", 1, 1));
		createNewAccount.sendMobileOrEmail(Utility.getExcelData("my2ndsheet", 1, 2));
		createNewAccount.sendNewPassword(Utility.getExcelData("my2ndsheet", 1, 3));
		createNewAccount.selectDate();
		createNewAccount.clickOnMale();
		createNewAccount.clickOnSignUp();
		Thread.sleep(4000);
		String actualMsgAfterWrongSignUpinfo = loginPage.getMsgAfterWrongSignUpinfo();
		String expectedMsgAfterWrongSignUpinfo = "";
		
		Assert.assertEquals(actualMsgAfterWrongSignUpinfo, expectedMsgAfterWrongSignUpinfo);
		
	}
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(driver, testID);
		}
		
		// logOut code
		
	}
	
	@AfterClass
	public void clearObjects() {
		
		loginPage = null ;
		createNewAccount = null ;
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
		driver = null;
		System.gc();
	}
	
}
