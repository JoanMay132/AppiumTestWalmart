package org.joanmayAcademy.ios.tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.joanmayAcademy.PageObjects.ios.AlertViewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;





public class iOSBasics extends iOSBaseTestServer{
	
	@Test
	public void IOSBasicsTest() throws InterruptedException {
		
		// xpath, classname IOS, IOSClassCHain, IOSPredicatesString, accesibilityID, ID
		AlertViewsPage alertViewsPage = homePage.selectAlertViews();

		//xpath is too low en ios
		//xpath - XML language - App source
		// Below we use IOSClassChain

		alertViewsPage.fillTextLabel("Hello");
		
		String actualMessage = alertViewsPage.getConfirmMessage();

		AssertJUnit.assertEquals(actualMessage, "A message should be a short, complete sentence.");
	
	}

}
