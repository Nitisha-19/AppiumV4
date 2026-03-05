package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage
{
	//Constructor
	public HomePage(AndroidDriver driver)
		{
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	//Locators
	
	
	//Country dropdown
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/spinnerCountry\")") WebElement Country;
	
	//Your Name
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Your Name\")") WebElement YourName;
	

	//Name 
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField") WebElement Name1;
	
	//Gender - Male
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")") WebElement GenderMale;
	
	//Gender - Female
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")") WebElement GenderFemale;
	
	//Lets Shop Button
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")") WebElement LetsShop;
	
	//ToastPage
	
	
	//Action Methods
	
	public String VerifyName()
	{
		//System.out.println("Hi");
		return YourName.getText();
	}
	
	
	public void SelectCountry()
	{
		Country.click();
	}	
	
	
	public void EnterName(String name)
	{
		Name1.sendKeys(name);
	}
	
	public void ClickGender(String Gender)
	{
		if (Gender == "Male")
		{
			GenderMale.click();
		}
		else
		{
			GenderFemale.click();
		}
	}
	
		
	public void ClickLetsShop()
	{
		LetsShop.click();
	}
}
