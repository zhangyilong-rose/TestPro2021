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
		AndroidElement a1 = driver.findElementByAndroidUIAutomator("text(\"服务器\")");
		dEngine.click(a1);
		dEngine.sendkeys("10.7.90.194");
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
	}

	/**
	 * 页面操作元素合集
	 * 
	 */

//	创建聊天
	public AndroidElement creatchat() {
		return driver.findElementByAccessibilityId("创建聊天");
	}

//	用户admin
	public AndroidElement user_admin() {
		return driver.findElementByAccessibilityId("A\nadmin");
	}

//	用户user1
	public AndroidElement user_user1() {
		return driver.findElementByAccessibilityId("U\nuser1");
	}

//	用户user5
	public AndroidElement user_user5() {
		return driver.findElementByAccessibilityId("U\nuser5");
	}

//	用户xiaoming
	public AndroidElement user_xiaoming() {
		return driver.findElementByAccessibilityId("X\nxiaoming");
	}

//	用户张三
	public AndroidElement user_zhangsan() {
		return driver.findElementByAccessibilityId("张\n张三");
	}

//	用户刘梦
	public AndroidElement user_liumeng() {
		return driver.findElementByAccessibilityId("刘\n刘梦");
	}

//	用户王潇
	public AndroidElement user_wangxiao() {
		return driver.findElementByAccessibilityId("王\n王潇");
	}

//	用户张腾
	public AndroidElement user_zhangteng() {
		return driver.findElementByAccessibilityId("张\n张腾");
	}

//	用户胡静
	public AndroidElement user_hujing() {
		return driver.findElementByAccessibilityId("胡\n胡静");
	}

//	创建
	public AndroidElement create() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
	}

//	讨论组命名
	public AndroidElement name() {
		return driver.findElementByAndroidUIAutomator("text(\"输入讨论组名称\")");
	}

//	确认创建
	public AndroidElement surebutton() {
		return driver.findElementByAccessibilityId("创建");
	}

//	返回主页
	public AndroidElement getback() {
		return driver.findElementByAccessibilityId("返回");
	}

//	系统消息——小喧喧
	public AndroidElement xuanxuan() {
		return driver.findElementByAccessibilityId("喧\n小喧喧\n通知中心");
	}

//	讨论组——系统
	public AndroidElement system() {
		return driver.findElementByAccessibilityId("系统\n所有人");
	}

	/**
	 * 操作方法
	 * 
	 * @throws InterruptedException
	 * 
	 */

//	后退
	public void back() {
		dEngine.click(getback());
	}

//	点击
	public void click(AndroidElement element) {
		dEngine.click(element);
	}

//	输入名称
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

//	随机挑选用户生成讨论组  通过传入参数挑选用户个数
	public void buildgroup(String num, String name) throws InterruptedException {
		int n = Integer.valueOf(num);
		int[] chosen = new int[n];
		int len = getalluser().length;
		int count;
		Random random = new Random();
		AndroidElement[] list = getalluser();

		System.out.println("用户个数：" + len);
		System.out.println("需要挑选的用户数：" + n);
//		click(creatchat());//此处无法点击
		Thread.sleep(2000);
		boolean result = false;
		for (int w = 0; w < n; w++) {
			chosen[w] = len + 1;
		}
//		通过传参规定讨论组人数
		for (int i = 0; i < n; i++) {
			result = false;
			count = random.nextInt(len);
			System.out.println("随机选择需进行判断是否重复的索引值：" + count);
//			设置当随机选择的用户相同时进行更改
			while (result != true) {
				if (judgethesame(count, chosen)) {
					System.out.println("索引值重复需重新选择");
					count = random.nextInt(len);
					result = false;
				} else {
					result = true;
					break;
				}
			}
			System.out.println("最终采用的索引值： " + count);
			chosen[i] = count;
			click(list[count]);
			Thread.sleep(2000);
		}
//		click(create());
//		Thread.sleep(2000);
//		thename(name);
//		Thread.sleep(2000);
//		click(surebutton());
//		Thread.sleep(2000);

//		返回主页面
		click(getback());
		Thread.sleep(2000);
	}

}
