package com.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions option;
    public static FileInputStream file;
    public static String Projectpath=System.getProperty("user.dir"); //project path
    public BaseClass() throws Exception {
		
		//String path=System.getProperty("D:\\\\Software\\\\Vishal\\\\PhonePay\\\\com.OpenMRS\\\\src\\\\main\\\\java\\\\com\\\\QA\\\\Properties\\\\config.properties");
		
		try {
			String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\QA\\Properties\\config.properties";
			FileInputStream file = new FileInputStream(path);
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		catch (IOException e) {

			e.printStackTrace();
		}
	}
	    public static void initilizbrowser() throws Throwable {
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")){
			//WebDriverManager.chromedriver().setup();
			option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		else if (browsername.equals("firefox")){
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("OpenMRS"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
