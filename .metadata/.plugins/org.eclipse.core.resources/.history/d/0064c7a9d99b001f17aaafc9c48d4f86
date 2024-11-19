package rahulAcademy.Appium.eCommerceTests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import rahulAcademy.Appium.BaseTestServer;

public class eCommerce_Tc_3 extends BaseTestServer {

	@Test
	public void TotalAmountTest() throws InterruptedException {
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Joan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		//Select country Argentina
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Selecting 2 items for adding to the cart
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		// You can do it in this way
//		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		// Waiting until next page is fully loaded
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		
		// Adding total amount of prices
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		
		// Sum items
		double totalSum = 0;
		for(int i=0; i<count; i++) {
			String amountString = productPrices.get(i).getText();
			
			//$160.08  // substring method is used to remove the dollar $
			double price = getFormattedAmount(amountString);
			totalSum = totalSum + price; //160.97 + 120 = 280.97
			System.out.println(totalSum);
		}
		
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double displayFormattedSum = getFormattedAmount(displaySum);
		
		Assert.assertEquals(totalSum, displayFormattedSum);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressGesture(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		//Hybrid - Google page
	}


}
