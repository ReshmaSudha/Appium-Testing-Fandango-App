package com.qa.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
//library used to create the path to APK
import java.io.File;



//library used to find elements (by id, class, xpath etc)
import org.openqa.selenium.By;

//library for web element
import org.openqa.selenium.WebElement;

//libraries for configuring Desired Capabilities
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//library for test methods
import org.junit.*;

//library for Appium drivers
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class LocationTest {

	private static AndroidDriver driver;
	//public static String SearchText = "The Martian";
	public static String SearchText = "%@oo";

	// set up appium
	@Before
	public void setUp(){
		try {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/Contact");
		File app = new File(appDir, "com.fandango.6.1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "ANDROID");
		capabilities.setCapability(CapabilityType.VERSION, "5.0.2");
		capabilities.setCapability("deviceName", "0715f73d2a14333a");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.fandango");
		capabilities.setCapability("appActivity", ".Fandango");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void Test() 
	{
		try {
			searchMovies(SearchText);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchMovies(String searchMov) throws Exception {
		driver.findElement(By.id("com.fandango:id/btn_search")).click();
		driver.findElement(By.id("com.fandango:id/txt_search_hint")).sendKeys(searchMov);
		Thread.sleep(20000);
		driver.tap(1, 380, 478, 1);	
		Thread.sleep(20000);
		driver.findElement(By.id("com.fandango:id/theaterMiles")).click();
	}
}
