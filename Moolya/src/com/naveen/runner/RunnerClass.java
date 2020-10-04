package com.naveen.runner;

import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveen.base.BaseClass;
import com.naveen.pom.POMClass;

public class RunnerClass extends BaseClass {
	
	
  @Test(invocationCount=1)
  public void test() throws MalformedURLException, InterruptedException
  {
	  POMClass pom= new POMClass(driver);
	  
	  pom.enterEmailId();
	  pom.enterPswd();
	  pom.enterProductName();
	  pom.enterProductDetailScreen();
  }

}
