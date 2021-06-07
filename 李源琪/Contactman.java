package pages;

import java.awt.List;
import java.io.IOException;

import org.seleniumhq.jetty9.security.UserStore;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import  base.ExcelDataProvider;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Reiterating;
import net.bytebuddy.asm.Advice.Return;
import utils.BaseAction;

public class Contactman {

	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	public Contactman(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}
	
	public AndroidElement ConnectPerson() {
		return  driver.findElementByXPath("//*[contains(@content-desc,'联系人')]");
	}
	public AndroidElement clientA() {
//		return  driver.findElementByAccessibilityId("A\nadmin\n[离线]");
		return driver.findElementByXPath("//*[contains(@content-desc,'admin')]");
	}
	public AndroidElement client1() {
//		return  driver.findElementByAccessibilityId("李\n李源琪1\n[离线]");
		return driver.findElementByXPath("//*[contains(@content-desc,'李源琪1')]");
	}
	public AndroidElement client2() {
//		return  driver.findElementByAccessibilityId("李\n李源琪2\n[在线]");
		return driver.findElementByXPath("//*[contains(@content-desc,'李源琪2')]");
	}
	public AndroidElement client3() {
//		return  driver.findElementByAccessibilityId("李\n李源琪3\n[离线]");
		return driver.findElementByXPath("//*[contains(@content-desc,'李源琪3')]");
	}
	public AndroidElement client4() {
//		return  driver.findElementByAccessibilityId("李\n李源琪4\n[离线]");
		return driver.findElementByXPath("//*[contains(@content-desc,'李源琪4')]");
	}
	public AndroidElement client5() {
//		return  driver.findElementByAccessibilityId("李\n李源琪5\n[离线]");
		return driver.findElementByXPath("//*[contains(@content-desc,'李源琪5')]");
	}
	public AndroidElement back() {
		return  driver.findElementByAccessibilityId("返回");
	}
	public AndroidElement Button_collect() {
		return  driver.findElementByAccessibilityId("取消收藏");
	}
	public AndroidElement DisButton_collect() {
		return  driver.findElementByAccessibilityId("收藏");
	}
	public AndroidElement Button_startcaht() {
		return  driver.findElementByAccessibilityId("开聊");
	}

	public void searchA() throws InterruptedException {
		action.click(ConnectPerson());
		Thread.sleep(2000);
		action.click(clientA());
		Thread.sleep(2000);
		action.click(Button_collect());
		Thread.sleep(2000);
		action.click(DisButton_collect());
		Thread.sleep(2000);
		action.click(Button_startcaht());
		Thread.sleep(2000);
		action.click(back());
		action.click(back());
	}
	public void search1() throws InterruptedException {
		Thread.sleep(2000);
		action.click(client1());
		Thread.sleep(2000);
		action.click(Button_collect());
		Thread.sleep(2000);
		action.click(DisButton_collect());
		Thread.sleep(2000);
		action.click(Button_startcaht());
		Thread.sleep(2000);
		action.click(back());
		action.click(back());
	}
	public void search2() throws InterruptedException {
		action.click(ConnectPerson());
		Thread.sleep(2000);
		action.click(client2());
		Thread.sleep(2000);
		action.click(back());
	}
	public void search3() throws InterruptedException {

		Thread.sleep(2000);
		action.click(client3());
		Thread.sleep(2000);
		action.click(Button_collect());
		Thread.sleep(2000);
		action.click(DisButton_collect());
		Thread.sleep(2000);
		action.click(Button_startcaht());
		Thread.sleep(2000);
		action.click(back());
		action.click(back());
	}
	public void search4() throws InterruptedException {
		Thread.sleep(2000);
		action.click(client4());
		Thread.sleep(2000);
		action.click(Button_collect());
		Thread.sleep(2000);
		action.click(DisButton_collect());
		Thread.sleep(2000);
		action.click(Button_startcaht());
		Thread.sleep(2000);
		action.click(back());
		action.click(back());
	}
	public void search5() throws InterruptedException {
		Thread.sleep(2000);
		action.click(client5());
		Thread.sleep(2000);
		action.click(Button_collect());
		Thread.sleep(2000);
		action.click(DisButton_collect());
		Thread.sleep(2000);
		action.click(Button_startcaht());
		Thread.sleep(2000);
		action.click(back());
		action.click(back());
	}
}
