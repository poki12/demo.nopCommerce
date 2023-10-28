package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import org.testng.Assert;


public class DDTestLogin extends TestBase{
	
	public LoginPage loginPage;

	
  @Test(dataProvider="dp")
  public void ddt_test_login(String data) {
	  
	  //get data from json file
	  
	  String  users[] = data.split(",");
	  String username = users[0];
	  String password = users[1];
	  String exp = users[2];
	  
	  List<String> status = new ArrayList<String>();
	  
	  loginPage.setUsername(username);
	  logger.info("Entered username");
	  loginPage.setPassword(password);
	  logger.info("Entered password");
	  loginPage.clickSubmit();
	  
	  String actTitle = driver.getTitle();
	  String expTitle = "Dashboard / nopCommerce administration";
	  
	  //positive testing
	  if(actTitle.equals(expTitle))
	  {
		  logger.info("Positive testing");
		  
		  if(exp.equals("Pass"))
		  {
			  loginPage.clickLogout();
			  status.add("Pass");
		  }
		  else if(exp.equals("Fail"))
		  {
			  loginPage.clickLogout();
			  status.add("Fail");
		  }
	  }
	  
	  //Negative testing
	  else if(!actTitle.equals(expTitle))
	  {
		  logger.info("Negative testing");
		  //if we can enter with wrong password
		  if(exp.equals("Pass"))
		  {
			  status.add("Fail");
		  }
		  //if we can't enter with wrong password
		  else if(exp.equals("Fail"))
		  {
			  status.add("Pass");
		  }
	  }
	  
	  logger.info("DDT validation started........");
	  for(String st : status)
	  {
		 // System.out.println(st);
		  //if negative and/or positive tests are passed
		  if(!st.equals("Fail"))
		  {
			  Assert.assertTrue(true);
			  logger.info("Data Driven Login Test passed");
		  }
		  
		  //if negative and/or positive tests are failed
		  else
		  {
			  try {
				captureScreen(driver,"ddt_test_login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  logger.warn("Data Driven Login Test failed");
			  Assert.assertTrue(false);
			  
		  }
	  }
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  logger.info("Prepare Data Driven Login test");
	  loginPage = new LoginPage(driver);
  }
  
  @AfterMethod
  public void afterMethod()
  {
	  logger.info("Data Driven Login  test Completed");
  }

 
  
  @DataProvider(name="dp")
  public String[] readJson()  throws IOException, ParseException
  {
	  JSONParser jsonParser = new JSONParser();
	  FileReader reader = new FileReader(".\\testdata\\testdata.json");
	  
	  Object obj = jsonParser.parse(reader);
	  JSONObject userLoginsJsonobj = (JSONObject)obj;
	  JSONArray userLoginsArray = (JSONArray)userLoginsJsonobj.get("userlogins");
	  
	  //Store JSON array data 
	  // into java array
	  
	  String arr[] = new String[userLoginsArray.size()];
	  for(int i=0; i < userLoginsArray.size(); i++ )
	  {
		  // Get index of any object
		  JSONObject users = (JSONObject)userLoginsArray.get(i);
		  String user = (String) users.get("username");
		  String pwd =  (String) users.get("password");
		  String exp =  (String) users.get("exp");
		  // fill data to array
		  arr[i] = user + "," + pwd + "," + exp;
	  }
	  return arr;
  }

}
