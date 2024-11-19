package org.joanmayAcademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.joanmayAcademy.PageObjects.android.FormPage;
import org.joanmayAcademy.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBaseTestServer extends AppiumUtils{
	public FormPage formPage;
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	//public FormPage formPage;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		// code to start server
		
		// Windows configuration below
	//  service = new AppiumServiceBuilder().withAppiumJS(new File("C:/Users/cjmd1/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
		//	.withIPAddress("127.0.0.1").usingPort(4723).build();	
	//	service.start();
		
		//USABLE ON MAC
		service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();	
		service.start();
		
		//AndroidDriver , IOSDriver
		// Appium code - Appium Server -> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("JoanPixel");
		
		// Windows settings below
	//	options.setChromedriverExecutable("C:/Users/cjmd1/Downloads/chromedriver_win32/chromedriver.exe");

		// Here is for MAC
		options.setChromedriverExecutable("/Users/joanmay/Downloads/chromedriver-mac-arm64-2/chromedriver");
		// This below is just when is 100% in mobile browser!!!
		//options.setCapability("browserName", "Chrome"); 
		
		//USABLE ON MAC
//		options.setApp("/Users/joanmay/eclipse-workspace/AppiumRahutProject/Appium/src/test/java/resources/ApiDemos-debug.apk");
		options.setApp("/Users/joanmay/eclipse-workspace/AppiumRahutProject/Appium/src/test/java/resources/General-Store.apk");

		
		//options.setChromedriverExecutable("/Users/joanmay/Downloads/chromedriver-mac-arm64-2/chromedriver");
		//options.setCapability("browserName", "Chrome");
		// AndroidDriver is configured on the top
		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 formPage = new FormPage(driver);
	}
	
	public void LongPressGesture(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId()
						));
	}	
	public void scrollToEndAction() {
		
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				));
		}while(canScrollMore);
	
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	public void SwipeAction(WebElement firstImage, String direction) {
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		));
		
	}
	
	@AfterClass
	public void tearDownDriver() {
		//Quit the driver
		driver.quit();
		//stop server 
		service.stop();
	}
}
