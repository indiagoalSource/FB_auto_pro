package Page;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utils.Utility;

public class CreateNewAccount {
	
	@FindBy (xpath = "//input[@aria-label='First name']")
	private WebElement firstName ;
	
	@FindBy (xpath = "//input[@aria-label='Surname']")
	private WebElement surname ;
	
	@FindBy (xpath = "//input[@aria-label='Mobile number or email address']")
	private WebElement mobileOrEmailAdd ;
	
	@FindBy (xpath = "//input[@aria-label='New password']")
	private WebElement newPassword ;
	
	@FindBy (xpath = "//select[@id='day']")
	private WebElement selectDay ;
	
	@FindBy (xpath = "//select[@id='month']")
	private WebElement selectMonth ;
	
	@FindBy (xpath = "//select[@id='year']")
	private WebElement selectYear ;
	
	@FindBy (xpath = "(//input[@name='sex'])[1]")
	private WebElement selectGenderFemale ;
	
	@FindBy (xpath = "(//input[@name='sex'])[2]")
	private WebElement selectGenderMale ;
	
	@FindBy (xpath = "(//input[@name='sex'])[3]")
	private WebElement selectGenderCustom ;
	
	@FindBy (xpath = "(//button[text()='Sign Up'])[1]")
	private WebElement signUpButton;
	
	@FindBy (xpath = "//select[@aria-label='Select your pronoun']")
	private WebElement selectPronoun ;
	
	@FindBy (xpath = "//input[@name='custom_gender']")
	private WebElement enterCustomeGender ;
	
		
	public CreateNewAccount(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void sendFirstName(String data) throws EncryptedDocumentException, IOException {
		
		firstName.sendKeys(data);
	}
	
	public void sendSurname(String data) {
		
		surname.sendKeys(data);
	}
	
	public void sendMobileOrEmail(String data) {
		
		mobileOrEmailAdd.sendKeys(data);
	}
	
	public void sendNewPassword(String data) {
		
		newPassword.sendKeys(data);
	}
	
	public void selectDate() {
		
		Select sel = new Select(selectDay);
		sel.selectByVisibleText("9");
		Select sel1 = new Select(selectMonth);
		sel1.selectByVisibleText("Nov");
		Select sel2 = new Select(selectYear);
		sel2.selectByVisibleText("1986");
		
	}
	
	public void clickOnFemale() {
		
		selectGenderFemale.click();
	}
	
	public void clickOnMale() {
		
		selectGenderMale.click();
	}
	
	public void clickOnCustom() {
		
		selectGenderMale.click();
	}
	
	public void clickOnSignUp() throws InterruptedException {
		
		signUpButton.click();
		Thread.sleep(4000);
	}
	
	public void selectDropPronoun() {
		
		Select sel3 = new Select(selectPronoun);
		sel3.selectByVisibleText("He: \"Wish him a happy birthday!\"");
	}
	
	public void sendCustomeGender() {
		
		enterCustomeGender.sendKeys("this is me");
	}
	
	
}
