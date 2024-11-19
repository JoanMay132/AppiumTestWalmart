package rahulAcademy.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

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

public class BaseTestServer {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		// code to start server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:/Users/cjmd1/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();	
		service.start();
		
		//AndroidDriver , IOSDriver
		// Appium code - Appium Server -> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("JoanPixel");
		options.setChromedriverExecutable("C:\\Users\\cjmd1\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		options.setApp("C:\\Users\\cjmd1\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		
		// AndroidDriver is configured on the top
		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 1.0
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
		    "elementId", ((RemoteWebElement)firstImage).getId(),
		    "direction", direction,
		    "percent", 0.2
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
