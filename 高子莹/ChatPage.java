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
//		���е�¼�������������
		AndroidElement a1 = driver.findElementByAndroidUIAutomator("text(\"������\")");
		dEngine.click(a1);
		dEngine.sendkeys("10.7.90.194");
//		dEngine.sendkeys("10.7.88.190");
		Thread.sleep(2000);
		AndroidElement a2 = driver.findElementByAndroidUIAutomator("text(\"�˺�\")");
		dEngine.click(a2);
		dEngine.sendkeys("hanhan");
		Thread.sleep(2000);
		AndroidElement a3 = driver.findElementByAndroidUIAutomator("text(\"����\")");
		dEngine.click(a3);
		dEngine.sendkeys("123456");
		Thread.sleep(2000);
		AndroidElement a4 = driver.findElementByAccessibilityId("��¼");
		dEngine.click(a4);
		Thread.sleep(2000);
		AndroidElement a5 = driver.findElementByAccessibilityId("Ⱥ\ngroup2");
		dEngine.click(a5);
		Thread.sleep(2000);
	}
	
	/**
	 * ҳ�����Ԫ�غϼ�
	 * 
	 */
//	��ʾ�˵�
	public AndroidElement display_menu() {
		return driver.findElementByAccessibilityId("��ʾ�˵�");
	}
	
//	�ղأ�����˵���
	public AndroidElement collect() {
		return driver.findElementByAccessibilityId("�ղ�");
	}
	
//	ȡ���ղأ�����˵���
	public AndroidElement cancel_collect() {
		return driver.findElementByAccessibilityId("ȡ���ղ�");
	}
	
//	��Ա�б�����˵���
	public AndroidElement member() {
		return driver.findElementByAccessibilityId("��Ա�б�");
	}
	
	
//	������
	public AndroidElement rename() {
		return driver.findElementByAccessibilityId("������");
	}
	
//	���������
	public AndroidElement name_enter() {
		return driver.findElementByClassName("android.widget.EditText");
	}
	
//	ȡ��������
	public AndroidElement cancel_rename() {
		return driver.findElementByAccessibilityId("ȡ��");
	}
	
//	ȷ��������
	public AndroidElement sure_rename() {
		return driver.findElementByAccessibilityId("������");
	}
	
//	�����
	public AndroidElement chatspace() {
		return driver.findElementByClassName("android.widget.EditText");
	}
	
//	����
	public AndroidElement send() {
		return driver.findElementByAccessibilityId("����");
	}
	
//	����
	public AndroidElement getback() {
		return driver.findElementByAccessibilityId("����");
	}
	
	
	/**
	 * ��������
	 */
//	�������
	public void clean(AndroidElement element) {
		dEngine.clean(element);
	}
	
//	��������
	public void sendkey(String new_name) {
		dEngine.sendkeys(new_name);
	}
	
//	���
	public void click(AndroidElement element) {
		dEngine.click(element);
	}
	
//	������
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
	
//	�����ı�
	public void sendchat(String text) throws InterruptedException {
		click(chatspace());
		Thread.sleep(2000);
		sendkey(text);
		Thread.sleep(2000);
		click(send());
	}
	
}
