package com.naveen.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class BaseClass {
	
	protected static AndroidDriver<WebElement> driver;
	
	@BeforeTest
	public AppiumDriver<WebElement> beforeRun() throws MalformedURLException
	{
		 DesiredCapabilities cap= new DesiredCapabilities();
		 cap.setCapability("deviceName", "emulator-5554");
		 cap.setCapability("platformName", "Android");
		 cap.setCapability("appPackage", "com.flipkart.android");
		 cap.setCapability("automationName", "UiAutomator2");
		 cap.setCapability("fullReset", true);
		 cap.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		 cap.setCapability("adbExecTimeout", 80000);
		 cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		  String path = System.getProperty("user.dir")+"/app/com.flipkart.android.apk";
		  cap.setCapability("app", path);
		  URL url= new URL("http://127.0.0.1:4723/wd/hub");
		  driver=new AndroidDriver<WebElement>(url,cap);
		  
		  return driver;
	}
	
	@AfterTest
	public void killServer() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	public void waitForTheElement(WebElement element)
	{
		try {
			Thread.sleep(3000);
			WebDriverWait wait=new WebDriverWait(driver,180);
			//wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("Wait is over ............");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	public void waitForTheElementNotDisplayed(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.invisibilityOf(element));
		System.out.println("Wait is over ............");
	}
	
	
	
	
	public void click(WebElement element)
	{
		waitForTheElement(element);
		element.click();
	}
	
	public void clickFromList(List<WebElement> elements, int index)
	{
		waitForTheElement(elements.get(index));
		
		System.out.println("Wait is over ............");
		elements.get(index).click();
	}
	
	public void clearAndSendKeys(WebElement element, String text)
	{
		waitForTheElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
	public void sendKeys(WebElement element, String text)
	{
		waitForTheElement(element);
		element.sendKeys(text);
		driver.hideKeyboard();
	}
	

}
