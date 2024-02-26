package Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssistiveIdentyPopUp {
	
	@FindBy (xpath = "//div[@aria-labelledby='Assistive Identification']//i")
	private WebElement closeAssist ;
	
	@FindBy (xpath = "//button[text()='Yes, Continue']")
	private WebElement yesContinueButton ;
	
	public AssistiveIdentyPopUp(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnCloseAssist() {
		closeAssist.click();
	}
	
	public void ClickOnYesContinueButton() {
		yesContinueButton.click();
	}
	
}
