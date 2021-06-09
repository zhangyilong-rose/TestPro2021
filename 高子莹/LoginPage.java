package com.www.pages;

import java.util.List;

import com.www.utils.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage {
	
	AndroidDriverEngine dEngine;
	AndroidDriver<AndroidElement> driver;
	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.dEngine = new AndroidDriverEngine(driver);
	}
	
	public List<AndroidElement> get(){
		List<AndroidElement> list = driver.findElementsByClassName("android.widget.EditText") ;
		return list;
	}
	
	public AndroidElement get_server(){
		return get().get(0);
//		return driver.findElementByAndroidUIAutomator("text(\"������\")");
	}
	
	public AndroidElement get_user() {
		return get().get(1);
//		return driver.findElementByAndroidUIAutomator("text(\"�˺�\")");
	}
	
	public AndroidElement get_pwd() {
		return get().get(2);
//		return driver.findElementByAndroidUIAutomator("text(\"����\")");
	}

	public AndroidElement get_login() {
		return driver.findElementByAccessibilityId("��¼");
	}

	
//	��������
	public void sendkey(String name){
		dEngine.sendkeys(name);
	}
	
	
//	��¼����ȫ�����
	public void clearall() {
		int i=0;
		while(i<3) {
			if(get().get(i) != null) {
				dEngine.click(get().get(i));
				dEngine.clean(get().get(i));
			}
			i++;
		}
	}
	
//	��¼
	public void login(String http,String user,String pwd) throws InterruptedException {
		click(get_server());
		Thread.sleep(2000);
		sendkey(http);
		Thread.sleep(2000);
		click(get_user());
		Thread.sleep(2000);
		sendkey(user);
		Thread.sleep(2000);
		click(get_pwd());
		Thread.sleep(2000);
		sendkey(pwd);
		Thread.sleep(2000);
		click(get_login());
		Thread.sleep(3000);
	}

//	���
	public void click(AndroidElement element) {
		dEngine.click(element);
	}
	
	
}
