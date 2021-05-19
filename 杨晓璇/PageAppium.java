package base;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageAppium {
	public AndroidDriver<AndroidElement> driver; 
	BaseAction action;
	public PageAppium(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action = new BaseAction(driver);
	}
	

	public AndroidElement chat1() {
		return driver.findElementByXPath("//android.view.View[@content-desc=\"喧 小喧喧 通知中心\"]");
	}
	public AndroidElement chat2() {
		return driver.findElementByXPath("//android.view.View[@content-desc=\"系统 所有人\"]");
	}
	public AndroidElement add() {
		return driver.findElementByXPath("//android.widget.Button[@content-desc=\"创建聊天\"]");
	}
	public AndroidElement add1() {
		return driver.findElementByXPath("//android.view.View[@content-desc=\"A admin\"]");
	}
	public AndroidElement add2() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"哈 哈哈\"])[1]");
	}
	public AndroidElement add3() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"哈 哈哈\"])[2]");
		
	}
	public AndroidElement add4() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"哈 哈哈\"])[3]");		
	}
	public AndroidElement add5() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"哈 哈哈\"])[4]");
		
	}
	public AndroidElement add6() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"哈 哈哈1\"])");
		
	}
	public AndroidElement button1() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
	}
		
		
}
