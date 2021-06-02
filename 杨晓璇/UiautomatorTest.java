package com.uiautomator;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.provider.Contacts.Intents.UI;

public class UiautomatorTest extends UiAutomatorTestCase {
	public void testDemo() {
		UiObject serverObject= new UiObject(new UiSelector().text("服务器"));
		serverObject.click();
		serverObject.setText("http://192.168.80.129:11443");
		UiObject userObject= new UiObject(new UiSelector().text("账号"));
		userObject.click();
		userObject.setText("aaa");
		UiObject passwordObject= new UiObject(new UiSelector().text("密码"));
		passwordObject.click();
		passwordObject.setText("123456");
		UiObject inObject= new UiObject(new UiSelector().className("android.widget.Button"));
		inObject.click();
		sleep(3000);
	}
	public void testAdd() {
		UiObject addObject= new UiObject(new UiSelector().className("android.widget.Button"));
		addObject.click();
		UiObject user1Object= new UiObject(new UiSelector().description("admin"));
		user1Object.click();
		UiObject user2Object= new UiObject(new UiSelector().description("哈哈哈"));
		user2Object.click();
		UiObject sureObject= new UiObject(new UiSelector().className("android.widget.Button").index(2));
		sureObject.click();
		UiObject groupnameObject= new UiObject(new UiSelector().text("输入讨论组名称"));
		groupnameObject.setText("讨论组1");
		UiObject setuoObject= new UiObject(new UiSelector().description("创建"));
		setuoObject.click();
		sleep(3000);
	}
	public void testCollect() {
		UiObject menuObject= new UiObject(new UiSelector().description("显示菜单"));
		menuObject.click();
		UiObject collectObject= new UiObject(new UiSelector().description("收藏"));
		collectObject.click();
		sleep(3000);
	}
	public void testList() {
		UiObject menuObject= new UiObject(new UiSelector().description("显示菜单"));
		menuObject.click();
		UiObject listObject= new UiObject(new UiSelector().description("成员列表"));
		listObject.click();
		UiObject backObject= new UiObject(new UiSelector().className("android.widget.Button"));
		backObject.click();
		sleep(3000);
	}
	public void testRename() {
		UiObject menuObject= new UiObject(new UiSelector().description("显示菜单"));
		menuObject.click();
		UiObject renameObject= new UiObject(new UiSelector().description("成员列表"));
		renameObject.click();
		UiObject nameObject= new UiObject(new UiSelector().className("android.widget.EditText"));
		nameObject.clearTextField();
		nameObject.setText("一个讨论组");
		UiObject button1Object= new UiObject(new UiSelector().description("重命名"));
		button1Object.click();
		sleep(3000);
	}
	public void testSendtext() {
		UiObject sendtextObject= new UiObject(new UiSelector().text("发送消息"));
		sendtextObject.click();
		sendtextObject.setText("你们好");
		UiObject sendObject= new UiObject(new UiSelector().description("发送"));
		sendObject.click();
		sleep(3000);
	}
	public void testSendmore1() {
		UiObject sendmoreObject= new UiObject(new UiSelector().description("发送其他内容"));
		sendmoreObject.click();
		UiObject pictureObject= new UiObject(new UiSelector().description("照片"));
		pictureObject.click();
		UiObject thepictureObject= new UiObject(new UiSelector().className("android.widget.LinearLayout"));
		thepictureObject.click();
		sleep(3000);
	}
	public void testSendmore2() {
		UiObject sendmoreObject= new UiObject(new UiSelector().description("发送其他内容"));
		sendmoreObject.click();
		UiObject takepictureObject= new UiObject(new UiSelector().description("拍照"));
		takepictureObject.click();
		UiObject takeObject= new UiObject(new UiSelector().description("快门"));
		takeObject.click();
		UiObject finishObject= new UiObject(new UiSelector().description("完成"));
		finishObject.click();
		sleep(3000);
	}
	public void testCancollert() {
		UiObject menuObject= new UiObject(new UiSelector().description("显示菜单"));
		menuObject.click();
		UiObject cancelObject= new UiObject(new UiSelector().description("取消收藏"));
		cancelObject.click();
		sleep(3000);
	}
	public void testView() {
		UiObject viewObject= new UiObject(new UiSelector().className("android.widget.ImageView"));
		viewObject.click();
		sleep(3000);
	}
	public void testBack() {
		UiObject backObject= new UiObject(new UiSelector().description("返回"));
		backObject.click();
		sleep(3000);
	}
	public void testPersonal() {
		UiObject personalObject= new UiObject(new UiSelector().className("android.view.View").index(3));
		personalObject.click();
		UiObject centreObject= new UiObject(new UiSelector().className("android.view.View").index(0));
		centreObject.click();
		UiObject gobackObject= new UiObject(new UiSelector().description("返回"));
		gobackObject.click();
		sleep(3000);
	}
	public void testCancel() {
		UiObject cancelObject= new UiObject(new UiSelector().description("注销"));
		cancelObject.click();
		UiObject cancelsureObject= new UiObject(new UiSelector().description("确认"));
		cancelsureObject.click();
		sleep(3000);
	}
}

