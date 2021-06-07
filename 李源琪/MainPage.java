package pages;


import javax.swing.event.AncestorEvent;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;
public class MainPage {
//一对一聊天框功能
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}
	/*
	 * （页面对象）
	 */
	
	//创建聊天
	//xpath://android.widget.Button[@content-desc="创建聊天"]
	public AndroidElement btn_add() {
		return driver.findElementByAccessibilityId("创建聊天");
	}
	//xpath://android.view.View[@content-desc="李 李源琪4"]
	public AndroidElement btn_client4() {
		return driver.findElementByAccessibilityId("李\n李源琪4");
	}
	public AndroidElement btn_client3() {
		return driver.findElementByAccessibilityId("李\n李源琪3");
	}
	public AndroidElement btn_client5() {
		return driver.findElementByAccessibilityId("李\n李源琪5");
	}
	public AndroidElement btn_client1() {
		return driver.findElementByAccessibilityId("李\n李源琪1");
	}
	public AndroidElement btn_client() {
		return driver.findElementByAccessibilityId("A\nadmin");
	}
	public AndroidElement btn_define() {
		return driver.findElementByXPath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
	}

	//发送文字消息
	public AndroidElement dialog() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText");
	}
	
	public AndroidElement btn_send() {
		return driver.findElementByAccessibilityId("发送");
	}
	
	public AndroidElement CopyMess() {
		return driver.findElementByAccessibilityId("test1");
	}
	public AndroidElement view() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View");
	}
	public AndroidElement Copy() {
		return driver.findElementByXPath("//android.view.View[@content-desc=\"复制\"]");
	}		
	public AndroidElement Plaster() {
		return driver.findElementByAccessibilityId("粘贴");
	}
	public AndroidElement btn_Coll() {
		return driver.findElementByAccessibilityId("显示菜单");
	}
	public AndroidElement coll1() {
		return  driver.findElementByAccessibilityId("收藏");
	}
	public AndroidElement coll2() {
		return  driver.findElementByAccessibilityId("取消收藏");
	}
	public AndroidElement data() {
		return driver.findElementByAccessibilityId("资料");
	}
	public AndroidElement back() {
		return driver.findElementByAccessibilityId("返回");
	}
	public AndroidElement Hphoto() {
		return driver.findElementByAccessibilityId("李");
	}

	
	//页面对象
	
		private AndroidElement number1() {
			return driver.findElementByAccessibilityId("A\nadmin");
		}
		public AndroidElement number2() {
			return driver.findElementByAccessibilityId("李\n李源琪1");
		}
		public AndroidElement number3() {
			return driver.findElementByAccessibilityId("李\n李源琪3");
		}
		public AndroidElement group() {
			return driver.findElementByAccessibilityId("群\ntest");
		}
		public AndroidElement membernum() {
			return driver.findElementByAccessibilityId("成员列表");
		}
		public AndroidElement onedata() {
			return driver.findElementByAccessibilityId("李\n李源琪1\n[离线]");
		}
		public AndroidElement word() {
			return driver.findElementByXPath("//android.view.View[@content-desc=\"test\"]");
		}
		public AndroidElement exsend() {
			return driver.findElementByAccessibilityId("转发");
		}	
		public AndroidElement exsendObject() {
			return driver.findElementByAccessibilityId("李\n李源琪5\n[离线]");
		}
		public AndroidElement exitgr() {
			return driver.findElementByAccessibilityId("退出讨论组");
		}
		public AndroidElement confirm() {
			return driver.findElementByAccessibilityId("确认");
		}
		public AndroidElement share() {
			return driver.findElementByAccessibilityId("分享...");
		}
		public AndroidElement Baidu() {
			return 	driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView");
		}
		public AndroidElement sendS() {
			return 	driver.findElementById("com.baidu.searchbox:id/ugc_publish_header");
		}
	 /* 操作方法
	 */
	//创建对话框
	public void createChat(String username) throws InterruptedException {
		if (username.equals("admin")) {
			action.click(btn_add());
			Thread.sleep(2000);
			action.click(btn_client());
			Thread.sleep(2000);
			action.click(btn_define());
			Thread.sleep(1000);
			action.click(back());
			Thread.sleep(1000);
		}
	}
	public void createChat1(String username) throws InterruptedException {
		if (username.equals("李源琪1")) {
			action.click(btn_add());
			Thread.sleep(2000);
			action.click(btn_client1());
			Thread.sleep(2000);
			action.click(btn_define());
			Thread.sleep(1000);
			action.click(back());
			Thread.sleep(1000);
		}
	}
	public void createChat3(String username) throws InterruptedException {
		if (username.equals("李源琪3")) {
			action.click(btn_add());
			Thread.sleep(2000);
			action.click(btn_client3());
			Thread.sleep(2000);
			action.click(btn_define());
			Thread.sleep(1000);
			action.click(back());
			Thread.sleep(1000);
		}
	}
	public void createChat4(String username) throws InterruptedException {
		if (username.equals("李源琪4")) {
			action.click(btn_add());
			Thread.sleep(2000);
			action.click(btn_client4());
			Thread.sleep(2000);
			action.click(btn_define());
			Thread.sleep(1000);
			action.click(back());
			Thread.sleep(1000);
		}
	}
	public void createChat5(String username) throws InterruptedException {
		if (username.equals("李源琪5")) {
			action.click(btn_add());
			Thread.sleep(2000);
			action.click(btn_client5());
			Thread.sleep(2000);
			action.click(btn_define());
			Thread.sleep(2000);
		}
	}
	
	//收藏对话
	public void Collect() throws InterruptedException {
		action.click(btn_Coll());
		Thread.sleep(2000);
		action.click(coll1());
		Thread.sleep(2000);
	}
	//取消收藏
	public void Discollect() throws InterruptedException {
		action.click(btn_Coll());
		Thread.sleep(2000);
		action.click(coll2());
		Thread.sleep(2000);
	}
	//查看资料
	public void Search() throws InterruptedException {
		action.click(btn_Coll());
		Thread.sleep(2000);
		action.click(data());
		Thread.sleep(2000);
		action.click(back());
		Thread.sleep(2000);
	}
	//点击头像查看个人资料
	public void SearchH() throws InterruptedException {
		action.click(Hphoto());
		Thread.sleep(2000);
		action.click(back());
		Thread.sleep(2000);
	}
	//转发信息
	public void exSendMess1() throws InterruptedException {
		action.longPress(word());
		Thread.sleep(2000);
		action.click(exsend());
		Thread.sleep(2000);
		action.click(exsendObject());
		Thread.sleep(2000);
	}
	//群聊功能
	
	//收藏群聊
	public void CollectGroup() throws InterruptedException {
		action.click(back());
		Thread.sleep(2000);
		action.click(group());
		Thread.sleep(2000);
		action.click(btn_Coll());
		Thread.sleep(2000);
		action.click(coll1());
		Thread.sleep(2000);
	}
	//取消收藏
	public void disCollectGroup() throws InterruptedException {
		action.click(btn_Coll());
		Thread.sleep(2000);
		action.click(coll2());
		Thread.sleep(2000);
	}
	//查看成员列表
	public void searchMember() throws InterruptedException {
		action.click(btn_Coll());
		Thread.sleep(2000);
		action.click(membernum());
		Thread.sleep(2000);
		action.click(onedata());
		Thread.sleep(2000);
		action.click(back());
		Thread.sleep(2000);
		action.click(back());
		Thread.sleep(2000);
	}
	//转发信息
	public void exSendMess2() throws InterruptedException {
		action.longPress(word());
		Thread.sleep(2000);
		action.click(exsend());
		Thread.sleep(2000);
		action.click(exsendObject());
		Thread.sleep(2000);
	}
//	//退出群聊
//	public void exitGroup() throws InterruptedException {
//		action.click(btn_Coll());
//		Thread.sleep(2000);
//		action.click(exitgr());
//		Thread.sleep(2000);
//		action.click(confirm());
//		Thread.sleep(2000);
//	}


	
	
}	
