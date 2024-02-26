package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Module.MoreLaguagePopUp;
import Page.ForgotPassword;
import Page.LoginPage;

public class TestClass2 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\amol\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnForgotPassword();
		
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		forgotPassword.getTextMessage();
		forgotPassword.sendWrongEmailOrPhone();
		forgotPassword.clickOnSearchButton();
		forgotPassword.clickOnCloseButton();
		forgotPassword.clickOnCancelButton();
		
		MoreLaguagePopUp moreLaguagePopUp = new MoreLaguagePopUp(driver);
		moreLaguagePopUp.clickOnMoreLaguageButton();
		moreLaguagePopUp.clickOnSelectEnglishUs();
		
		
		
	}

}
