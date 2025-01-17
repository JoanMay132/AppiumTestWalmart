package org.joanmayAcademy.PageObjects.android;

import java.util.List;

import org.joanmayAcademy.utils.AndroidActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	AndroidDriver driver; // Global object
	// Creating a constructor
	public CartPage(AndroidDriver driver) {
		super(driver); //call constructor
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // 
		
	}
	
	//List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptButton;
	
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	
	public List<WebElement> getProductsList() {
		return productList;
	}
	
	public double getProductSum() {
		int count = productList.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productList.get(i).getText();	
			Double price = Double.parseDouble( amountString.substring(1));
			totalSum = totalSum + price; // 160.97 + 120 = 280.97
		}
		
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble( amount.substring(1));
		return price;
	}
	
	public void acceptTermsConditons() {
		LongPressGesture(termsButton);
		acceptButton.click();
	}
	
	public void submitOrder() {
		checkBox.click();
		proceedButton.click();
	}

}
