package com.www.pages;

import java.util.Random;

import com.www.utils.AndroidDriverEngine;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MainPage {

	AndroidDriverEngine dEngine;
	AndroidDriver<AndroidElement> driver;

	public MainPage(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		this.driver = driver;
		this.dEngine = new AndroidDriverEngine(driver);
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
	}

	/**
	 * ҳ�����Ԫ�غϼ�
	 * 
	 */

//	��������
	public AndroidElement creatchat() {
		return driver.findElementByAccessibilityId("��������");
	}

//	�û�admin
	public AndroidElement user_admin() {
		return driver.findElementByAccessibilityId("A\nadmin");
	}

//	�û�user1
	public AndroidElement user_user1() {
		return driver.findElementByAccessibilityId("U\nuser1");
	}

//	�û�user5
	public AndroidElement user_user5() {
		return driver.findElementByAccessibilityId("U\nuser5");
	}

//	�û�xiaoming
	public AndroidElement user_xiaoming() {
		return driver.findElementByAccessibilityId("X\nxiaoming");
	}

//	�û�����
	public AndroidElement user_zhangsan() {
		return driver.findElementByAccessibilityId("��\n����");
	}

//	�û�����
	public AndroidElement user_liumeng() {
		return driver.findElementByAccessibilityId("��\n����");
	}

//	�û�����
	public AndroidElement user_wangxiao() {
		return driver.findElementByAccessibilityId("��\n����");
	}

//	�û�����
	public AndroidElement user_zhangteng() {
		return driver.findElementByAccessibilityId("��\n����");
	}

//	�û�����
	public AndroidElement user_hujing() {
		return driver.findElementByAccessibilityId("��\n����");
	}

//	����
	public AndroidElement create() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
	}

//	����������
	public AndroidElement name() {
		return driver.findElementByAndroidUIAutomator("text(\"��������������\")");
	}

//	ȷ�ϴ���
	public AndroidElement surebutton() {
		return driver.findElementByAccessibilityId("����");
	}

//	������ҳ
	public AndroidElement getback() {
		return driver.findElementByAccessibilityId("����");
	}

//	ϵͳ��Ϣ����С����
	public AndroidElement xuanxuan() {
		return driver.findElementByAccessibilityId("��\nС����\n֪ͨ����");
	}

//	�����顪��ϵͳ
	public AndroidElement system() {
		return driver.findElementByAccessibilityId("ϵͳ\n������");
	}

	/**
	 * ��������
	 * 
	 * @throws InterruptedException
	 * 
	 */

//	����
	public void back() {
		dEngine.click(getback());
	}

//	���
	public void click(AndroidElement element) {
		dEngine.click(element);
	}

//	��������
	public void thename(String send) {
		dEngine.sendkeys(send);
	}

	public AndroidElement[] getalluser() {
		click(creatchat());
		AndroidElement[] user = { user_admin(), user_user1(), user_user5(), user_xiaoming(), user_zhangsan(),
				user_liumeng(), user_wangxiao(), user_zhangteng(), user_hujing() };

		return user;
	}

	public boolean judgethesame(int num, int[] list) {
		int len = list.length;
		for (int i = 0; i < len; i++) {
			if (num == list[i]) {
				return true;
			}
		}
		return false;
	}

//	�����ѡ�û�����������  ͨ�����������ѡ�û�����
	public void buildgroup(String num, String name) throws InterruptedException {
		int n = Integer.valueOf(num);
		int[] chosen = new int[n];
		int len = getalluser().length;
		int count;
		Random random = new Random();
		AndroidElement[] list = getalluser();

		System.out.println("�û�������" + len);
		System.out.println("��Ҫ��ѡ���û�����" + n);
//		click(creatchat());//�˴��޷����
		Thread.sleep(2000);
		boolean result = false;
		for (int w = 0; w < n; w++) {
			chosen[w] = len + 1;
		}
//		ͨ�����ι涨����������
		for (int i = 0; i < n; i++) {
			result = false;
			count = random.nextInt(len);
			System.out.println("���ѡ��������ж��Ƿ��ظ�������ֵ��" + count);
//			���õ����ѡ����û���ͬʱ���и���
			while (result != true) {
				if (judgethesame(count, chosen)) {
					System.out.println("����ֵ�ظ�������ѡ��");
					count = random.nextInt(len);
					result = false;
				} else {
					result = true;
					break;
				}
			}
			System.out.println("���ղ��õ�����ֵ�� " + count);
			chosen[i] = count;
			click(list[count]);
			Thread.sleep(2000);
		}
		click(create());
		Thread.sleep(2000);
		thename(name);
		Thread.sleep(2000);
		click(surebutton());
		Thread.sleep(2000);

//		������ҳ��
		click(getback());
		Thread.sleep(2000);
	}

}
