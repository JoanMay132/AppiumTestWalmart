package rahulAcademy.Appium.eCommerceTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import rahulAcademy.Appium.BaseTestServer;

public class eCommerce_Tc_1 extends BaseTestServer {

	@Test
	public void FillFormTest() throws InterruptedException {
		
//		driver.findElement(By.className("android.widget.EditText")).sendKeys("Joan");
//		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		//Select country Argentina
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mexico\"));")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Validating toastMessages
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		Thread.sleep(4000);
	}
}
