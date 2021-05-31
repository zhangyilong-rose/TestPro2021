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
//		进行登录
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
	}

//	点击成员（点击成员列表后）
//	成员admin
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
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'张三')]");
	}

//	liumeng
	public AndroidElement user_liumeng() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'刘梦')]");
	}

//	wangxiao
	public AndroidElement user_wangxiao() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'王潇')]");
	}

//	zhangteng
	public AndroidElement user_zhangteng() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'张腾')]");
	}

//	hujing
	public AndroidElement user_hujing() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'胡静')]");
	}

//	hanhan
	public AndroidElement user_hanhan() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'韩涵')]");
	}

	/**
	 * 讨论组模块
	 */
	public AndroidElement module_group() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'讨论组')]");
	}

//	讨论组
//	public 

	/**
	 * 联系人模块
	 */
	public AndroidElement module_contect() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'联系人')]");
	}

//	开聊
	public AndroidElement begin_chat() {
		return driver.findElementByAccessibilityId("开聊");
	}

//	收藏
	public AndroidElement collect() {
		return driver.findElementByAccessibilityId("取消收藏");
	}

//	取消收藏
	public AndroidElement cancel_coll() {
		return driver.findElementByAccessibilityId("收藏");
	}

//	返回
	public AndroidElement get_back() {
		return driver.findElementByAccessibilityId("返回");
	}

	/**
	 * 我的模块
	 */
	public AndroidElement module_mine() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'我的')]");
	}

//	注销
	public AndroidElement logout() {
		return driver.findElementByAccessibilityId("注销");
	}

//	确认注销
	public AndroidElement logout_surebutton() {
		return driver.findElementByAccessibilityId("确认");
	}

//	取消注销
	public AndroidElement logout_cancelbutton() {
		return driver.findElementByAccessibilityId("取消");
	}

//	个人名片
	public AndroidElement personal() {
		return driver.findElementByXPath("//android.view.View[contains(@content-desc,'韩涵')]");
	}

//	显示菜单
	public AndroidElement menu() {
		return driver.findElementByAccessibilityId("显示菜单");
	}

//	关于
	public AndroidElement detail() {
		return driver.findElementByAccessibilityId("关于");
	}

//	关闭
	public AndroidElement colse() {
		return driver.findElementByAccessibilityId("关闭");
	}

	/**
	 * 方法集合
	 */

//	获取所有用户
	public AndroidElement[] getalluser() {
		click(module_contect());
		AndroidElement[] user = { user_admin(), user_user1(), user_user5(), user_xiaoming(), user_zhangsan(),
				user_liumeng(), user_wangxiao(), user_zhangteng(), user_hujing() };

		return user;
	}

//	任选一名用户
	public void chooseuser() {
		Random random = new Random();
		int len = getalluser().length;
		int num;
		int index = random.nextInt(len);
		click(getalluser()[index]);
		num = index + 1;
		System.out.println(index);
		System.out.println("选择的用户为第" + num + "个");
	}

//	点击
	public void click(AndroidElement element) {
		dEngine.click(element);
	}

//	进入讨论组模块
	public void enter_group() {
		click(module_group());
	}

//	进入联系人模块
	public void enter_contect() {
		click(module_contect());
	}

//	将一名联系人设为星标
	public void collect_user() throws InterruptedException {
		enter_contect();
		Thread.sleep(2000);
		chooseuser();
		Thread.sleep(2000);
		if (collect() != null) {
			click(collect());
		}
	}

//	星标联系人取消（若是则取消）
	public void cancelcoll_user() throws InterruptedException {
		enter_contect();
		Thread.sleep(2000);
		chooseuser();
		Thread.sleep(2000);
		if (collect() == null) {
			click(cancel_coll());
		}
	}

//	发起会话
	public void startchat() throws InterruptedException {
		click(module_contect());
		Thread.sleep(2000);
		chooseuser();
		Thread.sleep(2000);
		click(begin_chat());
	}

//	进入我的模块
	public void enter_mine() {
		click(module_mine());
	}

//	点击注销
	public void click_logout() {
		enter_mine();
		click(logout());
	}

}
