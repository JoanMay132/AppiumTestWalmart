package org.joanmayAcademy.PageObjects.android;

import java.util.List;

import org.joanmayAcademy.utils.AndroidActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions {

	AndroidDriver driver; // Global object
	// Creating a constructor
	public ProductCatalogue(AndroidDriver driver) {
		super(driver); //call constructor
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // 
		
	}
	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart; // we use list to set a list of items "PLURAL"!
	
	// 	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	//Thread.sleep(2000);
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement buttonCart; 
	
	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
		
	}
	
	public CartPage goToCartPage() throws InterruptedException {
		buttonCart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
	
}
