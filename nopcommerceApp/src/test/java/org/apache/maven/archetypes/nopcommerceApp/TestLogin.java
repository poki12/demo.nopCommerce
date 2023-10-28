package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;



public class TestLogin extends TestBase{
	
	public LoginPage loginPage;
	
  @Test
  public void test_login() {
	  

	  
	  String pageName = driver.getTitle();
	  logger.info("Login validation started......");
	  if(pageName.equals("Dashboard / nopCommerce administration"))
	  {
		  Assert.assertTrue(true);
		  logger.info("Login test passed");
	  }
	  else
	  {
		  try {
			captureScreen(driver,"test_login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  logger.warn("Login test failed");
		  Assert.assertTrue(false);
		  
	  }
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  logger.info("Prepare Login test");
	  
	  loginPage = new LoginPage(driver);
	  loginPage.setUsername(username);
	  logger.info("Entered username");
	  loginPage.setPassword(password);
	  logger.info("Entered password");
	  loginPage.clickSubmit();
	   
  }
  
  @AfterMethod
  public void afterMethod()
  {
	  logger.info("Login test Completed");
  }


}
