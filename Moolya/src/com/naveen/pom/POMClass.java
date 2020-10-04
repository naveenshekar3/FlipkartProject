package com.naveen.pom;



import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveen.base.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class POMClass extends BaseClass {
	
	
    public POMClass(AppiumDriver<WebElement> driver){
    	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @FindBy(id="com.flipkart.android:id/btn_mlogin")
    private WebElement signinBtn;
    

    @FindBy(id="mobileNo")
    private WebElement emailEditTxt;
    
    @FindBy(id="com.google.android.gms:id/cancel")
    private WebElement noneOfTheAboveBtn;   

    @FindBy(id="btn_msignup")
    private WebElement signinContinueBtn;
   
    @FindBy(id="et_password")
    private WebElement pwsdEdittxt;
    
    @FindBy(id="btn_msignup")
    private WebElement signinFinalBtn;
    
    @FindBy(id="search_widget_textbox")
    private WebElement searchTxtBox;
    
    @FindBy(id="search_autoCompleteTextView")
    private WebElement searchPrdctEditTxt;
    
    @FindBy(xpath="//android.widget.RelativeLayout[@index='0']")
    private List<WebElement> searchResult;
    
    @FindBy(xpath="//android.widget.TextView[contains(@text,'₹')]/..")
    private List<WebElement> productFromList;
    
    @FindBy(xpath="//android.widget.TextView[@text='BUY NOW']")
    private WebElement buyBtn;

    
    
    public void enterEmailId()
    {
    	click(signinBtn);
    	click(emailEditTxt);
    	if(noneOfTheAboveBtn.isDisplayed())
    	{
    		click(noneOfTheAboveBtn);
    	}
    	sendKeys(emailEditTxt, "mcnaveen0@gmail.com");
    	click(signinContinueBtn);
    }
    
    public void enterPswd()
    {
    	sendKeys(pwsdEdittxt, "password123");
    	click(signinFinalBtn);
    }
    
    public void enterProductName()
    {
    	click(searchTxtBox);
    	sendKeys(searchPrdctEditTxt, "iPhone 11");
    	clickFromList(searchResult, 1);
    	
    }
    
    public void enterProductDetailScreen() throws InterruptedException
    {
//    	Thread.sleep(10000);
    	driver.runAppInBackground(Duration.ofSeconds(5));
    	Thread.sleep(5000);
//    	try {
//    		System.out.println("Search result......."+searchResult.get(0).isDisplayed() );	
//    	}
//    	catch(Exception e)
//    	{
//    		System.out.println("present....");
//    	}
    	//waitForTheElementNotDisplayed(searchResult.get(0));
    	System.out.println("Testing for........------"+ driver.getContext());
    	clickFromList(productFromList, 0);
    	
    	click(buyBtn);
    }
    
    
    
    
    
    
    
    
    
    

}
