package base;


import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;


public class InitAppium {
	public static AndroidDriver<WebElement> driver;
	

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName","Android Emulator");
		desiredCapabilities.setCapability("platformName","Android");
		desiredCapabilities.setCapability("platformVersion","5.1.1");
		desiredCapabilities.setCapability("appPackage", "com.cnezsoft.xxm");
		desiredCapabilities.setCapability("appActivity", "com.cnezsoft.xxm.MainActivity");
		desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("automationName", "UIAutomator2");

		
		driver = new AndroidDriver<WebElement>(
				new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
	}
		

	
	@AfterClass
	public void tearDown() {
	  driver.quit();
  }

}
