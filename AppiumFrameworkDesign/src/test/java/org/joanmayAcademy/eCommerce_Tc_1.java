package org.joanmayAcademy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class eCommerce_Tc_1 extends MobileBaseTestServer {
	
	@BeforeMethod
	public void preSetUp() {
		// screen to home page
		// Script to direct into a specific view of the apk
		
		// Changing the activity is really important!!!
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
		    "intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity" //SplashActivity works
		));
		
	}

	@Test
	public void FillForm_ErrorValidationTest() throws InterruptedException {
		
//		driver.findElement(By.className("android.widget.EditText")).sendKeys("Joan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		//Select country Argentina
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Validating toastMessages
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMessage, "Please enter your name");
		Thread.sleep(4000);
	}
	

	@Test
	public void FillForm_HappyPathTest() throws InterruptedException {
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Joan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		//Select country Argentina
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Validating toastMessages
		AssertJUnit.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);

		
	}
}
