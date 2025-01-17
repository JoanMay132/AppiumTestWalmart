package org.joanmayAcademy.ios.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.joanmayAcademy.PageObjects.ios.HomePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTestServer {
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public HomePage homePage;
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		// code to start server
		
		//USABLE ON Windows
		
		//service = new AppiumServiceBuilder().withAppiumJS(new File("C:/Users/cjmd1/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
		//	.withIPAddress("127.0.0.1").usingPort(4723).build();	
		//service.start();
		
		//USABLE ON MAC
		service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();	
		service.start();
			
	     // IOSDriver
		// Appium code - Appium Server -> Mobile
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 16");
		
		options.setApp("/Users/joanmay/Library/Developer/Xcode/DerivedData/UIKitCatalog-gauswbftrkdhikgfoptsdgtslcml/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
		options.setPlatformVersion("18.0");
		// Appium webdriver  agent -> iOS App
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
	
		// AndroidDriver is configured on the top
		 driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 homePage = new HomePage(driver);
	}
	


	

	
	@AfterClass
	public void tearDownDriver() {
		//Quit the driver
		driver.quit();
		//stop server 
		service.stop();
	}
}
