package org.joanmayAcademy.PageObjects.android;


import org.joanmayAcademy.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FormPage extends AndroidActions{
	
	AndroidDriver driver; // Global object
	// Creating a constructor
	public FormPage(AndroidDriver driver) {
		super(driver); //call constructor
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // 
		
	}
	
	// driver.findElement(By.className("android.widget.EditText")).sendKeys("Joan");
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement nameField;
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	// Male option
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	// Selecting country
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;
	
	// Selecting button
		@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
		private WebElement shopButton;
		
	// Setting name field
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	} 
	// Choosing between male or female options
	public void setGender(String gender) 
	{
		if (gender.contains("female")) {
			femaleOption.click();
		} else {
			maleOption.click();
		}
	}
	// ------------------------------------

	// Setting country selection 
	public void setCountrySelection(String countryName) {
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	}
	
	public ProductCatalogue submitForm() {
		shopButton.click();
		return new ProductCatalogue(driver);

	}
	
	public void setActivity() {
		
		    Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		    ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
		}
	
	


}
