package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BasePage{

	public CartPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//LOCATORS
	//Page Title
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.androidsample.generalstore:id/toolbar_title\")") WebElement CartTitle;
	//ProductName
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")") WebElement ProductName;
	
	//Checkbox
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")") WebElement Checkbox;
	
	//Visit Website to Complete Purchase Button
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnProceed\")") WebElement BtnToWeb;
	
	//Terms and Conditions
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.androidsample.generalstore:id/termsButton\")") WebElement TermsAndConditions;
	
	//Alert Title
	@AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle") WebElement AlertTitle;
	
	//ACTION METHODS
	//Verify Cart Page Title
	public String VerifyCartTitle()
	{
		return CartTitle.getText();
	}
	
	//Get Added Product Name
	public String GetProductName()
	{
		return ProductName.getText();
	}
	
	public void ClickCheckbox()
	{
		Checkbox.click();
	}
	
	public void LongPressTermsAndConditions()
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) TermsAndConditions).getId(),
			    "duration", 5000
			));
	}
	
	public String VerifyAletTitle()
	{
		return AlertTitle.getText();
	}
	
	
	public void TestBtnToWeb() throws InterruptedException
	{
		BtnToWeb.click();
		Thread.sleep(15000);
	}
}
