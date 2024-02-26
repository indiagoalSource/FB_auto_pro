package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.CreateNewAccount;
import Page.LoginPage;

public class TestClass3 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amol\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnCreateNewAcc();
		
		Thread.sleep(2000);
		CreateNewAccount createNewAccount = new CreateNewAccount(driver);
	//	createNewAccount.sendFirstName();
//		createNewAccount.sendSurname();
//		createNewAccount.sendMobileOrEmail();
//		createNewAccount.sendNewPassword();
		createNewAccount.selectDate();
		createNewAccount.clickOnMale();
		createNewAccount.clickOnSignUp();
		
		
		
		
	}

}
