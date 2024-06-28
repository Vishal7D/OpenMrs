package com.QA.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy (id="username") 
	private WebElement user_name;
	
	@FindBy (id="password") 
	private WebElement pwd;
	
	@FindBy (xpath ="//ul[@ id ='sessionLocation']//li") 
	private List<WebElement> locations;

	@FindBy (xpath="//input[@ id = 'loginButton']") 
	private WebElement logn_button;
	
	@FindBy (xpath="//div[@ class='logo']/a/img") 
	private WebElement logo;
	
	public LoginPage(WebDriver rdriver) {
		
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	public String username(String name) {
		user_name.sendKeys(name);
		return name;
	}
	
	public void password(String pass) {
		pwd.sendKeys(pass);
	}
	public void selectOption(String opt) {
		for(WebElement wb :locations) {
			if(wb.getText().equals(opt)) {
				wb.click();
			}
			
		}
	}
	public String Gettitle() {
		return driver.getTitle();
	}
	 public void Login_Button() {
		 logn_button.click();
	 }
	public HomePage Navigate_to_homepage(String name, String pass, String opt ) {
		user_name.sendKeys(name);
		pwd.sendKeys(pass);
		
		for(WebElement wb :locations) {
			if(wb.getText().equals(opt)) {
				wb.click();
			}
			
		}
		logn_button.click();
		return new HomePage();
	}
}
