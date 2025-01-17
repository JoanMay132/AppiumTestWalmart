package org.joanmayAcademy.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import java.util.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import net.bytebuddy.jar.asm.TypeReference;


public abstract class AppiumUtils {

	 // Global object
	// Creating a constructor

	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble( amount.substring(1));
		return price;
	}
	
//	public static List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{
//		// new File(System.getProperty("user.dir") + "//src//test//java//org//joanmayAcademy//testData//eCommerce.json")
//		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath), "UTF-8");
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		List<HashMap<String,String>> data=mapper.readValue(jsonContent, 
//				
//				new TypeReference<List<HashMap<String,String>>>(){
//			   });
//		return data;
//	}	
//	
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));

	}
}
