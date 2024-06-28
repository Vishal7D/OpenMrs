package com.QA.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.Base.BaseClass;
import com.QA.Pages.LoginPage;

public class LoginTest extends BaseClass{
	
		LoginPage login;
		public LoginTest() throws Exception {
			
			super();
		}
		
		@BeforeMethod
		public void preRequsite() throws Throwable {
			initilizbrowser();
			login =  new LoginPage(driver);
		}
		@Test(priority=2)
		public void Succefullogin() {
			login.username(prop.getProperty("Usenameid"));
			login.password(prop.getProperty("Passwordid"));
			login.selectOption("Inpatient Ward");
			login.Login_Button();
			String Title = login.Gettitle();
			System.out.println(Title);
		}
		@Test(priority=1)
		public void Invalid_Usrnmepaswrd() {
			login.username("Qwarty");
			login.password("Pass");
			login.selectOption("Inpatient Ward");
			login.Login_Button();
			String Title = login.Gettitle();
			System.out.println(Title);
		}
}
