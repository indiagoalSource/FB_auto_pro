package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Module.AssistiveIdentyPopUp;
import Page.ForgotPassword;
import Page.LoginPage;

public class TestClass1 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amol\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
//		loginPage.sendUserName();
//		loginPage.sendPassword();
		loginPage.clickOnLoginButoon();
		
//		AssistiveIdentyPopUp assistiveIdentyPopUp = new AssistiveIdentyPopUp(driver);
//		assistiveIdentyPopUp.ClickOnCloseAssist();
//		
//		loginPage.clickOnForgotPassword();
//		
//		ForgotPassword forgotPassword = new ForgotPassword(driver);
//		forgotPassword.getTextMessage();
//		forgotPassword.sendEmailOrPhone();
//		forgotPassword.clickOnSearchButton();
//		forgotPassword.clickOnCancelButton();
		
		
		
	}

}
