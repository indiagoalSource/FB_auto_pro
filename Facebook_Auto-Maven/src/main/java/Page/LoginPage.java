package Page;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy (xpath = "//input[@id='email']") 
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password ;
	
	@FindBy (xpath = "//button[@name='login']")
	private WebElement loginButton ;
	
	@FindBy (xpath = "(//div[@id='passContainer']//a//div)[2]")
	private WebElement showPassword ;
	
	@FindBy (xpath = "//a[text()='Forgotten password?']")
	private WebElement forgotPassword ;
	
	@FindBy (xpath = "//a[text()='Create new account']")
	private WebElement createNewAcc ;
	
	@FindBy (xpath = "//a[@title='Show more languages']")
	private WebElement moreLaguage ;
	
	@FindBy (xpath = "//div[@id='email_container']//div[2]")
	private WebElement textMsgAfterLogin ;
	
	@FindBy (xpath = "//div[@id='reg_error_inner']")
	private WebElement msgAfterWrongSignUpinfo ;
	
	private WebDriver driver ;
		
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void sendUserName(String data) {
		
		userName.sendKeys(data);
	}
	
	public void sendPassword(String data) {
		
		password.sendKeys(data);
	}
	
	public void clickOnLoginButoon( ) {
		
		loginButton.click();
	}
	
	public void clickOnShowPassword() {
		
		showPassword.click();
	}
	
	public void clickOnForgotPassword() {
		
		forgotPassword.click();
	}
	
	public void clickOnCreateNewAcc() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(createNewAcc));
		
		createNewAcc.click();
	}
	
	public void LogintoProfile() {
		
		userName.sendKeys("abcd@abcdsffsajdh.com");
		password.sendKeys("123456789");
		loginButton.click();
	}
	
	public void clickOnMoreLaguage() {
		
		moreLaguage.click();
	}
	public String getTextMsgAfterLogin() {
		
		return textMsgAfterLogin.getText();
	}
	public String getMsgAfterWrongSignUpinfo() {
		
		return msgAfterWrongSignUpinfo.getText();
	}
	
}
