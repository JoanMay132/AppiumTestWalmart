package org.joanmayAcademy.PageObjects.ios;

import org.joanmayAcademy.utils.iOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViewsPage extends iOSActions{

	IOSDriver driver; // Global object
	// Creating a constructor
	public AlertViewsPage(IOSDriver driver) {
		super(driver); //call constructor
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // 
		
	}
	
	//driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")).click();
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
	private WebElement textEntry;

	//driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"Horizontal scroll bar, 1 page\"`][4]")).sendKeys("Joan");
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Horizontal scroll bar, 1 page\"`][4]")
    private WebElement textEntryMenu;
  	
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement okButton;
	
	//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel' ")).click();
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel' ")
    private WebElement confirmMenuItem;
	
	//String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message' ")).getText();
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message' ")
	private WebElement message;
	
	//driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Confirm'")
	private WebElement submitButton;


	
	public void fillTextLabel(String name) {
		textEntry.click();
		textEntryMenu.sendKeys(name);
		okButton.click();
	}
	
	public String getConfirmMessage() {
		confirmMenuItem.click();
		return message.getText();
	}

}
