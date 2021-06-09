package pages;

import org.apache.poi.sl.usermodel.Background;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MinePage {

	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	public MinePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}
	
	public AndroidElement mine() {
		return driver.findElementByXPath("//*[contains(@content-desc,'我的')]");
	}
	public AndroidElement Userlist() {
		return  driver.findElementByAccessibilityId("显示菜单");
	}
	public AndroidElement About() {
		return  driver.findElementByAccessibilityId("关于");
	}
	public AndroidElement me() {
		return driver.findElementByXPath("//*[contains(@content-desc,'李\n李源琪2')]");
	}
	public AndroidElement logout() {
		return  driver.findElementByAccessibilityId("注销");
	}
	public AndroidElement shutdown() {
		return  driver.findElementByAccessibilityId("关闭");
	}
	public AndroidElement confirm() {
		return  driver.findElementByAccessibilityId("确认");
	}
	public AndroidElement login() {
		return  driver.findElementByAccessibilityId("登录");
	}
	public AndroidElement back() {
		return  driver.findElementByAccessibilityId("返回");
	}
	
	public void showList() throws InterruptedException {
		action.click(mine());
		Thread.sleep(2000);
		action.click(Userlist());
		Thread.sleep(2000);
		action.click(About());
		Thread.sleep(2000);
		action.click(shutdown());
		Thread.sleep(2000);
	}
	
	public void showme() throws InterruptedException {
		action.click(me());
		Thread.sleep(2000);
		action.click(back());
		Thread.sleep(2000);
	}
	public void Logout() throws InterruptedException {
		action.click(logout());
		Thread.sleep(2000);
		action.click(confirm());
		Thread.sleep(5000);
		action.click(login());
		Thread.sleep(2000);
	}
}
