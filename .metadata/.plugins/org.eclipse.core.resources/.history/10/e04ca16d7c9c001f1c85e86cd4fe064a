package rahulAcademy.Appium.eCommerceTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulAcademy.Appium.MobileBaseTestServer;

public class MobileBrowserTest extends MobileBaseTestServer {

	@Test
	public void BrowserTest() throws InterruptedException {
//		driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("Olas");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.xpath("(//a[@routerlink='/products'])[1]")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)",""); // Scroll
		String text = driver.findElement(By.cssSelector("a[href='/angularAppdemo/products/3']")).getText();
		Assert.assertEquals(text, "Devops");
	
		Thread.sleep(3000);
	}
}
