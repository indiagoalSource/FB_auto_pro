package Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoreLaguagePopUp {
	
	@FindBy (xpath = "//a[@title='Show more languages']")
	private WebElement moreLaguageButton ;
	
	@FindBy (xpath = "(//a[text()='English (US)'])[1]")
	private WebElement selectEnglishUs ;
	
	
	public MoreLaguagePopUp(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMoreLaguageButton() {
		moreLaguageButton.click();
	}
	
	public void clickOnSelectEnglishUs() {
		
		selectEnglishUs.click();
	}
	

}
