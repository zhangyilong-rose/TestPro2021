package com.www.pages;

import com.www.utils.AndroidDriverEngine;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ChatPage {
	AndroidDriver<AndroidElement> driver;
	AndroidDriverEngine dEngine;
	
	public ChatPage(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		this.driver = driver;
		this.dEngine = new AndroidDriverEngine(driver);
//		进行登录并进入聊天界面
		AndroidElement a1 = driver.findElementByAndroidUIAutomator("text(\"服务器\")");
		dEngine.click(a1);
		dEngine.sendkeys("10.7.90.194");
//		dEngine.sendkeys("10.7.88.190");
		Thread.sleep(2000);
		AndroidElement a2 = driver.findElementByAndroidUIAutomator("text(\"账号\")");
		dEngine.click(a2);
		dEngine.sendkeys("hanhan");
		Thread.sleep(2000);
		AndroidElement a3 = driver.findElementByAndroidUIAutomator("text(\"密码\")");
		dEngine.click(a3);
		dEngine.sendkeys("123456");
		Thread.sleep(2000);
		AndroidElement a4 = driver.findElementByAccessibilityId("登录");
		dEngine.click(a4);
		Thread.sleep(2000);
		AndroidElement a5 = driver.findElementByAccessibilityId("群\ngroup2");
		dEngine.click(a5);
		Thread.sleep(2000);
	}
	
	/**
	 * 页面操作元素合集
	 * 
	 */
//	显示菜单
	public AndroidElement display_menu() {
		return driver.findElementByAccessibilityId("显示菜单");
	}
	
//	收藏（点击菜单后）
	public AndroidElement collect() {
		return driver.findElementByAccessibilityId("收藏");
	}
	
//	取消收藏（点击菜单后）
	public AndroidElement cancel_collect() {
		return driver.findElementByAccessibilityId("取消收藏");
	}
	
//	成员列表（点击菜单后）
	public AndroidElement member() {
		return driver.findElementByAccessibilityId("成员列表");
	}
	
	
//	重命名
	public AndroidElement rename() {
		return driver.findElementByAccessibilityId("重命名");
	}
	
//	名称输入框
	public AndroidElement name_enter() {
		return driver.findElementByClassName("android.widget.EditText");
	}
	
//	取消重命名
	public AndroidElement cancel_rename() {
		return driver.findElementByAccessibilityId("取消");
	}
	
//	确定重命名
	public AndroidElement sure_rename() {
		return driver.findElementByAccessibilityId("重命名");
	}
	
//	聊天框
	public AndroidElement chatspace() {
		return driver.findElementByClassName("android.widget.EditText");
	}
	
//	发送
	public AndroidElement send() {
		return driver.findElementByAccessibilityId("发送");
	}
	
//	返回
	public AndroidElement getback() {
		return driver.findElementByAccessibilityId("返回");
	}
	
	
	/**
	 * 方法集合
	 */
//	清除内容
	public void clean(AndroidElement element) {
		dEngine.clean(element);
	}
	
//	输入内容
	public void sendkey(String new_name) {
		dEngine.sendkeys(new_name);
	}
	
//	点击
	public void click(AndroidElement element) {
		dEngine.click(element);
	}
	
//	重命名
	public void rename_send(String name) throws InterruptedException {
		click(display_menu());
		Thread.sleep(2000);
		click(rename());
		Thread.sleep(2000);
		clean(name_enter());
		Thread.sleep(2000);
		click(name_enter());
		Thread.sleep(2000);
		sendkey(name);
	}
	
//	发送文本
	public void sendchat(String text) throws InterruptedException {
		click(chatspace());
		Thread.sleep(2000);
		sendkey(text);
		Thread.sleep(2000);
		click(send());
	}
	
}
