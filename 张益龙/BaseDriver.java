package base;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseDriver {
	public AndroidDriver<AndroidElement> driver;
	@BeforeClass
	public void startUp() throws MalformedURLException, InterruptedException {
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "127.0.0.1:62001");
		cap.setCapability("appPackage", "com.cnezsoft.xxm"); 
		cap.setCapability("appActivity", ".MainActivity");
		cap.setCapability("noReset", true);//用来确保下一次点击是否能回到之前的状态，默认值未false会清空之前的操作
		driver = new AndroidDriver<AndroidElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	 @AfterClass
	 public void tearDown() throws InterruptedException {
		if (driver != null) {
			driver.quit();
		}
	 }

}
