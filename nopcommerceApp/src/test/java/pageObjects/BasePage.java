package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver lDriver;
	
	public BasePage(WebDriver rDriver) {
		
		this.lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
		
	}

}
