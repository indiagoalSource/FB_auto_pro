package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
	
	@FindBy (xpath = "//div[@class='identify_yourself_block']//div")
	private WebElement textMessage ;
	
	@FindBy (xpath = "//input[@id='identify_email']")
	private WebElement WrongemailorPhoneNum ;
	
	@FindBy (xpath = "//input[@id='identify_email']")
	private WebElement correctEmailorPhoneNum ;
	
	@FindBy (xpath = "//a[text()='Cancel']")
	private WebElement cancelButton ;
	
	@FindBy (xpath = "//button[@id='did_submit']")
	private WebElement searchButton ;
	
	@FindBy (xpath = "//a[text()='Close']")
	private WebElement closeButton ;
	
	@FindBy (xpath = "//form[@id='identify_yourself_flow']/div/div[2]//div[1]//div[1]")
	private WebElement errorMsgTitle ;
	
	@FindBy (xpath = "//form[@id='identify_yourself_flow']/div/div[2]//div[1]//div[2]")
	private WebElement errorMsg ;
	
//	@FindBy (xpath = "//div[@id='header_block']//div")
	@FindBy (xpath = "(//div[@id='initiate_interstitial']//h2)[2]")
	private WebElement headerMsg ;
	
	WebDriver driver ;
	
	public ForgotPassword(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String getTextMessage() {
		
		return textMessage.getText();
		//System.out.println(textMessage.getText());
	}
	
	public void sendWrongEmailOrPhone() {
		
		WrongemailorPhoneNum.sendKeys("abcd@gmailsdfdf.com");
	}
	public void sendCorrectEmailAndPhone() {
		
		correctEmailorPhoneNum.sendKeys("indgoal09@yahoo.com");
	}
	
	public String clickOnCancelButton() {
		
		cancelButton.click();
		return driver.getCurrentUrl();
	}
	
	public void clickOnSearchButton() {
		
		searchButton.click();
	}
	
	public void clickOnCloseButton() {
		
		closeButton.click();
	}
	public String getErrorTitle() {
		
		return errorMsgTitle.getText();
	}
	public String getErrorMsg() {
		
		return errorMsg.getText();
	}
	public String getHeaderMsg() {
		
		return headerMsg.getText();
	}

}
