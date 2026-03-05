package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;


public class FinalPurchasePage extends BasePage{

	public FinalPurchasePage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//LOCATORS
	@FindBy(name = "q") WebElement browsertext;
	
	
	//ACTION METHODS
	public void setText() {
		browsertext.sendKeys("CloudBerry QA Bootcamp");
		browsertext.sendKeys(Keys.ENTER);

		}
	
	
}