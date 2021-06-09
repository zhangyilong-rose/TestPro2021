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
		// �Զ�����������
		capabilities.setCapability("automationName", "Appium");
		// �ֻ�����ϵͳiOS, Android, or FirefoxOS
		capabilities.setCapability("platformName", "Android");
		// ָ�����Ի���ID��ͨ��adb devices��ȡ
		capabilities.setCapability("deviceName", "127.0.0.1:62001");
		// �ֻ�����ϵͳ�汾��
		capabilities.setCapability("platformVersion", "5.1.1");
		// app����
		capabilities.setCapability("appPackage", "com.cnezsoft.xxm");
		// app�������� Activity����
		capabilities.setCapability("appActivity", "com.cnezsoft.xxm.MainActivity");

		// ֧������
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
