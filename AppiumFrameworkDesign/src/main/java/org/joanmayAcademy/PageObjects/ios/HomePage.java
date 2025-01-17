package org.joanmayAcademy.PageObjects.ios;

import org.joanmayAcademy.utils.iOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends iOSActions{

	IOSDriver driver; // Global object
	// Creating a constructor
	public HomePage(IOSDriver driver) {
		super(driver); //call constructor
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // 
		
	}
	
	//driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
	@iOSXCUITFindBy(accessibility = "Alert Views")
	private WebElement alertViews;
	
	public AlertViewsPage selectAlertViews() {
		alertViews.click();
		return new AlertViewsPage(driver);
	}

}
