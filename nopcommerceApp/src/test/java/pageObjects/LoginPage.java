package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {
   
	
	
	public LoginPage(WebDriver rDriver)
	{
		super(rDriver);
	}
	
	@FindBy(how = How.XPATH, using="//input[@class='email']")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(how=How.XPATH, using="//input[@class='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using="//input[@class='button-1 login-button']")
	@CacheLookup
	WebElement submitButton;
	
	@FindBy(how= How.XPATH, using="//div[@class='navbar-custom-menu']//ul[@class='nav navbar-nav']//li[3]//a[@href='/logout']")
	@CacheLookup
	WebElement logoutButton;
	
	public void setUsername(String name)
	{
		this.txtUsername.clear();
		this.txtUsername.sendKeys(name);
	}
	
	public void setPassword(String password)
	{
		this.txtPassword.clear();
		this.txtPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		this.submitButton.click();
	}
	
	public void clickLogout()
	{
		this.logoutButton.click();
	}
}
