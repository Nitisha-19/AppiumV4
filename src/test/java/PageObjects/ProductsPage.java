package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BasePage
{

	public ProductsPage(AndroidDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//LOCATORS
	//Page Title
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/toolbar_title\")") WebElement ProductPageTitle;
	
	//Products
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName") List<WebElement> items; 
	
	//Add to Cart
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart") List<WebElement> AddToCart;
	
	//View Cart icon
	@AndroidFindBy(id = "com.androidsample.generalstore:id/counterText") WebElement Cart;
	
	//ACTION METHODS
	//get page Title
	
	public String getProductPageTitle()
	{
		return ProductPageTitle.getText();
	}
	
	//Click Add to Cart
	
	public void ClickAddToCart()
	{
				
		for(int i =0; i<items.size(); i++)
			
		{
			String productName = items.get(i).getText();
			if (productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				AddToCart.get(i).click();
				break;
			}
		}
		
	}
	
	
	//View Cart
	public void ClickCart()
	{
		Cart.click();
	}
	

}
