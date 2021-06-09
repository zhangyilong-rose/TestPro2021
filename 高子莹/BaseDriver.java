package com.www.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseDriver {

	public static AndroidDriver<AndroidElement> driver;

	@BeforeClass
	public void enter() throws MalformedURLException {
		DesiredCapabilities capabilities;
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		capabilities = new DesiredCapabilities();
		// 自动化测试引擎
		capabilities.setCapability("automationName", "Appium");
		// 手机操作系统iOS, Android, or FirefoxOS
		capabilities.setCapability("platformName", "Android");
		// 指定测试机的ID，通过adb devices获取
		capabilities.setCapability("deviceName", "127.0.0.1:62001");
		// 手机操作系统版本号
		capabilities.setCapability("platformVersion", "5.1.1");
		// app包名
		capabilities.setCapability("appPackage", "com.cnezsoft.xxm");
		// app中启动的 Activity名称
		capabilities.setCapability("appActivity", "com.cnezsoft.xxm.MainActivity");

		// 支持中文
//		capabilities.setCapability("unicodeKeyboard", "true");
//		capabilities.setCapability("resetKeyboard", "true");

		driver = new AndroidDriver<AndroidElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}


	@AfterClass
	public void out() {
		driver.quit();
	}
}
