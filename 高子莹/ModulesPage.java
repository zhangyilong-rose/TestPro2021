package com.www.pages;

import java.util.Random;

import com.www.utils.AndroidDriverEngine;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ModulesPage {

	AndroidDriver<AndroidElement> driver;
	AndroidDriverEngine dEngine;

	public ModulesPage(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		this.driver = driver;
		this.dEngine = new AndroidDriverEngine(driver);
//		���е�¼
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
	}

//	�����Ա�������Ա�б��
//	��Աadmin
	public AndroidElement user_admin() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'admin')]");
	}

//	user1
	public AndroidElement user_user1() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'user1')]");
	}

//	user5
	public AndroidElement user_user5() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'user5')]");
	}

//	xiaoming
	public AndroidElement user_xiaoming() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'xiaoming')]");
	}

//	zhangsan
	public AndroidElement user_zhangsan() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'����')]");
	}

//	liumeng
	public AndroidElement user_liumeng() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'����')]");
	}

//	wangxiao
	public AndroidElement user_wangxiao() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'����')]");
	}

//	zhangteng
	public AndroidElement user_zhangteng() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'����')]");
	}

//	hujing
	public AndroidElement user_hujing() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'����')]");
	}

//	hanhan
	public AndroidElement user_hanhan() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'����')]");
	}

	/**
	 * ������ģ��
	 */
	public AndroidElement module_group() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'������')]");
	}

//	������
//	public 

	/**
	 * ��ϵ��ģ��
	 */
	public AndroidElement module_contect() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'��ϵ��')]");
	}

//	����
	public AndroidElement begin_chat() {
		return driver.findElementByAccessibilityId("����");
	}

//	�ղ�
	public AndroidElement collect() {
		return driver.findElementByAccessibilityId("ȡ���ղ�");
	}

//	ȡ���ղ�
	public AndroidElement cancel_coll() {
		return driver.findElementByAccessibilityId("�ղ�");
	}

//	����
	public AndroidElement get_back() {
		return driver.findElementByAccessibilityId("����");
	}

	/**
	 * �ҵ�ģ��
	 */
	public AndroidElement module_mine() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'�ҵ�')]");
	}

//	ע��
	public AndroidElement logout() {
		return driver.findElementByAccessibilityId("ע��");
	}

//	ȷ��ע��
	public AndroidElement logout_surebutton() {
		return driver.findElementByAccessibilityId("ȷ��");
	}

//	ȡ��ע��
	public AndroidElement logout_cancelbutton() {
		return driver.findElementByAccessibilityId("ȡ��");
	}

//	������Ƭ
	public AndroidElement personal() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'����')]");
	}

//	��ʾ�˵�
	public AndroidElement menu() {
		return driver.findElementByAccessibilityId("��ʾ�˵�");
	}

//	����
	public AndroidElement detail() {
		return driver.findElementByAccessibilityId("����");
	}

//	�ر�
	public AndroidElement colse() {
		return driver.findElementByAccessibilityId("�ر�");
	}

	/**
	 * ��������
	 */

//	��ȡ�����û�
	public AndroidElement[] getalluser() {
		click(module_contect());
		AndroidElement[] user = { user_admin(), user_user1(), user_user5(), user_xiaoming(), user_zhangsan(),
				user_liumeng(), user_wangxiao(), user_zhangteng(), user_hujing() };

		return user;
	}

//	��ѡһ���û�
	public void chooseuser() {
		Random random = new Random();
		int len = getalluser().length;
		int num;
		int index = random.nextInt(len);
		click(getalluser()[index]);
		num = index + 1;
		System.out.println(index);
		System.out.println("ѡ����û�Ϊ��" + num + "��");
	}

//	���
	public void click(AndroidElement element) {
		dEngine.click(element);
	}

//	����������ģ��
	public void enter_group() {
		click(module_group());
	}

//	������ϵ��ģ��
	public void enter_contect() {
		click(module_contect());
	}

//	��һ����ϵ����Ϊ�Ǳ�
	public void collect_user() throws InterruptedException {
		enter_contect();
		Thread.sleep(2000);
		chooseuser();
		Thread.sleep(2000);
		if (collect() != null) {
			click(collect());
		}
	}

//	�Ǳ���ϵ��ȡ����������ȡ����
	public void cancelcoll_user() throws InterruptedException {
		enter_contect();
		Thread.sleep(2000);
		chooseuser();
		Thread.sleep(2000);
		if (collect() == null) {
			click(cancel_coll());
		}
	}

//	����Ự
	public void startchat() throws InterruptedException {
		click(module_contect());
		Thread.sleep(2000);
		chooseuser();
		Thread.sleep(2000);
		click(begin_chat());
	}

//	�����ҵ�ģ��
	public void enter_mine() {
		click(module_mine());
	}

//	���ע��
	public void click_logout() {
		enter_mine();
		click(logout());
	}

}
