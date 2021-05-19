package pages;


import base.PageAppium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class LoginPage extends PageAppium {

    public LoginPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	public AndroidElement text() {
		return driver.findElementByAndroidUIAutomator("new UiSelector().className("+"android.widget.EditText"+").index(0)");
	}
    public AndroidElement text1() {
		return driver.findElementByAndroidUIAutomator("new UiSelector().className("+"android.widget.EditText"+").index(1)");
	}
    public AndroidElement text2() {
		return driver.findElementByAndroidUIAutomator("new UiSelector().className("+"android.widget.EditText"+").index(2)");
	}
    public AndroidElement button() {
		return driver.findElementByClassName("android.widget.Button");
	}
    
	public boolean getIndexflag() {
		AndroidElement bu = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
		AndroidElement element = bu;
        return element != null;
	}

}