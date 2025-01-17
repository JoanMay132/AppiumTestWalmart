package org.joanmayAcademy;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import org.testng.AssertJUnit;
import java.time.Duration;


import org.joanmayAcademy.PageObjects.android.CartPage;
import org.joanmayAcademy.PageObjects.android.FormPage;
import org.joanmayAcademy.PageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class eCommerce_Tc_4 extends MobileBaseTestServer {
	

	@Test(dataProvider = "getData")
	public void TotalAmountTest(String name, String gender, String country) throws InterruptedException {
		// Creating object of first page // We can set this in the MobileBaseTestServer
		FormPage formPage = new FormPage(driver);
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		ProductCatalogue productCatalogue = formPage.submitForm();
	
		// Selecting 2 items for adding to the cart
		// Creating object for the class
		productCatalogue.addItemToCartByIndex(0); // Passing the cero index!
		productCatalogue.addItemToCartByIndex(0); // Passing the cero index!

		CartPage cartPage = productCatalogue.goToCartPage();
	
		// Waiting until next page is fully loaded
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		
		// Adding total amount of prices
	
		double totalSum = cartPage.getProductSum();
		// Assertion total amount
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		// EVERYTHING OK UNTIL HERE
		cartPage.acceptTermsConditons();
		cartPage.submitOrder();
		
		// Data provider
		
	
		
	}
	@BeforeMethod
	public void preSetUp() {
		// screen to home page
		// Script to direct into a specific view of the apk
		
		// Changing the activity is really important!!!
		formPage.setActivity();
		
	}


	@DataProvider
	public Object[][] getData() {
		// Creating two dimensional array
		return new Object[][] { { "Joan","female","Argentina"}, { "Pedro Picapiedra","male","Mexico"}};

	}
}
