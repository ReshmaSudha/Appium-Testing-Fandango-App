package com.qa.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;


public class FandangoTest {

	private static AndroidDriver driver;
	public static String SearchText = "The Martian";

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
		Thread.sleep(10000);
		driver.findElement(By.id("com.fandango:id/btn_search")).click();
		driver.findElement(By.id("com.fandango:id/txt_search_hint")).sendKeys(searchMov);
		Thread.sleep(10000);
		driver.tap(1, 380, 478, 1);	
		Thread.sleep(5000);
		driver.findElement(By.id("com.fandango:id/theaterMiles")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.fandango:id/theaterMap")).click();
	}
	
	
	

}
