package pages;

import static org.testng.Assert.assertThrows;

import java.awt.event.KeyEvent;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import utils.BaseAction;

public class MainPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

//——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
//	构造方法
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

//——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
//	页面对象
	// 主页面＋号
	public AndroidElement btn_add() throws InterruptedException {
		return driver.findElementsByClassName("android.widget.Button").get(0);
	}

	// 系统
	public AndroidElement btn_system() {
		return driver.findElementByAccessibilityId("系统\n所有人");
	}

	// 通知中心
	public AndroidElement btn_notice() {
		return driver.findElementByAccessibilityId("喧\n小喧喧\n通知中心");
	}

	// 选择联系人
	public AndroidElement btn_cl() {
		return driver.findElementByAccessibilityId("联系人\n联系人\n第 3 个标签，共 4 个");
	}

	// 选择聊天
	public AndroidElement btn_chat() {
		return driver.findElementByAccessibilityId("聊天\n聊天\n第 1 个标签，共 4 个");
	}

	// 选择讨论组
	public AndroidElement btn_group() {
		return driver.findElementByAccessibilityId("讨论组\n讨论组\n第 2 个标签，共 4 个");
	}

	// 选择我的
	public AndroidElement btn_mine() {
		return driver.findElementByAccessibilityId("我的\n我的\n第 4 个标签，共 4 个");
	}

	// 查看个人信息-----需使用当前登录用户的AccessibilityId
	public AndroidElement btn_reveal() {
		return driver.findElementByAccessibilityId("张\n张益龙\n  @zyl\nhttp://10.7.90.215:11443");
	}

	// 发起聊天-选择admin
	public AndroidElement btn_admin() {
		return driver.findElementByAccessibilityId("A\nadmin");

	}
	public AndroidElement btn_admin1() {
		return driver.findElementByAccessibilityId("A\nadmin\n[离线]");

	}

	// 发起聊天-选择张益龙
	public AndroidElement btn_zyl() {
		return driver.findElementByAccessibilityId("张\n张益龙");
	}
	public AndroidElement btn_zyl1() {
		return driver.findElementByAccessibilityId("张\n张益龙\n[在线]");
	}
	// 发起聊天-选择娇
	public AndroidElement btn_jiao() {
		return driver.findElementByAccessibilityId("娇\n娇");
	}
	public AndroidElement btn_jiao1() {
		return driver.findElementByAccessibilityId("娇\n娇\n[离线]");
	}
	// 发起聊天-选择龙
	public AndroidElement btn_long() {
		return driver.findElementByAccessibilityId("龙\n龙");
	}
	public AndroidElement btn_long1() {
		return driver.findElementByAccessibilityId("龙\n龙\n[离线]");
	}

	// 发起聊天-选择Long
	public AndroidElement btn_Long() {
		return driver.findElementByAccessibilityId("L\nlong");
	}
	public AndroidElement btn_Long1() {
		return driver.findElementByAccessibilityId("L\nlong\n[离线]");
	}

	// 发起聊天-开聊
	public AndroidElement btn_begin() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
		// return driver.findElementByClassName("android.widget.Button");
	}
	//选择输入框
	public AndroidElement btn_input() {
		return driver.findElementByXPath("//*[@text='发送消息']");
	}
	// 创建群聊-名称
	public AndroidElement btn_name() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText");
	}	
	// 群发-发送按钮
	public AndroidElement btn_sent() {
		return driver.findElementByAccessibilityId("发送");
	}
	//群聊-创建
	public AndroidElement btn_create() {
		return driver.findElementByAccessibilityId("创建");
	}

	// 显示菜单
	public AndroidElement btn_show() {
		return driver.findElementByAccessibilityId("显示菜单");
	}

	// 显示菜单-收藏
	public AndroidElement btn_collect() {
		return driver.findElementByXPath("//*[@content-desc='收藏']");
	}

	// 显示菜单-取消收藏
	public AndroidElement btn_dcollect() {
		return driver.findElementByXPath("//*[@content-desc='取消收藏']");
	}

	// 显示菜单-资料
	public AndroidElement btn_data() {
		return driver.findElementByXPath("//*[@content-desc='资料']");
	}

	// 复制
	public AndroidElement btn_copy() {
		return driver.findElementByAccessibilityId("复制");
	}

	// 粘贴
	public AndroidElement btn_tie() {
		return driver.findElementByAccessibilityId("粘贴");
	}

	// 分享
	public AndroidElement btn_share() {
		return driver.findElementByAccessibilityId("分享...");
	}

	// 撤回
	public AndroidElement btn_recall() {
		return driver.findElementByAccessibilityId("撤回");
	}

	// 转发
	public AndroidElement btn_transmit() {
		return driver.findElementByAccessibilityId("转发");
	}
	//群聊-查看成员
	public AndroidElement btn_member() {
		return driver.findElementByAccessibilityId("成员列表");
	}
	//群聊-重命名
	public AndroidElement btn_reName() {
		return driver.findElementByAccessibilityId("重命名");
	}
	//群聊-选中
	public AndroidElement btn_live() {
		return driver.findElementByAccessibilityId("群\n生活群");
	}
	public AndroidElement btn_work() {
		return driver.findElementByAccessibilityId("群\n工作群");
	}
	//群聊-输入新名字
	public AndroidElement btn_inNewname() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText");
	}
	//返回按钮
	public AndroidElement btn_back() {
		return driver.findElementByAccessibilityId("返回");
	}
//——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
//	页面操作方法
	// 获取目的群聊/用户
	AndroidElement listView;
	List<MobileElement> list_view;

	// 获取到想要的element1
	public void get_item1(String name) throws InterruptedException {
		if (name.equals("admin")) {
			action.click(btn_admin());
			Thread.sleep(3000);
		}
		if (name.equals("张益龙")) {
			action.click(btn_zyl());
			Thread.sleep(3000);
		}
		if (name.equals("娇")) {
			action.click(btn_jiao());
			Thread.sleep(3000);
		}
		if (name.equals("龙")) {
			action.click(btn_long());
			Thread.sleep(3000);
		}
		if (name.equals("long")) {
			action.click(btn_Long());
			Thread.sleep(3000);
		}
	}
	public void get_item2(String name) throws InterruptedException {
		if (name.equals("admin")) {
			action.click(btn_admin1());
			Thread.sleep(3000);
		}
		if (name.equals("张益龙")) {
			action.click(btn_zyl1());
			Thread.sleep(3000);
		}
		if (name.equals("娇")) {
			action.click(btn_jiao1());
			Thread.sleep(3000);
		}
		if (name.equals("龙")) {
			action.click(btn_long1());
			Thread.sleep(3000);
		}
		if (name.equals("long")) {
			action.click(btn_Long1());
			Thread.sleep(3000);
		}
	}

	// +方式----发起聊天----单用户
	public void begin_talk(String name, String message) throws InterruptedException {
		action.click(btn_add());
		Thread.sleep(5000);
		get_item1(name);
		// 发起会话
		action.click(btn_begin());
		Thread.sleep(3000);
		action.type(btn_input(), message);
		action.click(btn_sent());
		Thread.sleep(2000);
		action.click(btn_back());
	}

	// +方式----发起聊天----两个用户
	public void begin_talks(String name1, String name2, String name, String message) throws InterruptedException {
		action.click(btn_add());
		Thread.sleep(3000);
		// 选择第一个用户
		get_item1(name1);
		// 选择第二个用户
		get_item1(name2);
		// 发起会话
		action.click(btn_begin());
		Thread.sleep(3000);
		action.type(btn_name(), name);
		Thread.sleep(2000);
		action.click(btn_create());
		Thread.sleep(2000);
		action.type(btn_input(), message);
		Thread.sleep(2000);
		action.click(btn_back());

	}

	// 群发消息
	public void all_sent(String message) throws InterruptedException {
		action.click(btn_chat());
		Thread.sleep(3000);
		action.click(btn_system());
		Thread.sleep(3000);
		action.type(btn_input(), message);
		Thread.sleep(3000);
		action.click(btn_sent());
		Thread.sleep(2000);
		action.click(btn_back());
	}

	// 收藏好友---聊天页
	public void one_collect(String name) throws InterruptedException {
		action.click(btn_chat());
		// Thread.sleep(3000);
		get_item2(name);
		action.click(btn_show());
		Thread.sleep(3000);
		action.click(btn_collect());
		action.click(btn_back());
	}

	// 取消收藏----聊天页
	public void del_collect(String name) throws InterruptedException {
		get_item2(name);
		Thread.sleep(2000);
		action.click(btn_show());
		Thread.sleep(3000);
		action.click(btn_dcollect());
		Thread.sleep(2000);
		action.click(btn_back());
	}

	// 展示个人资料----聊天页
	public void show_details(String name) throws InterruptedException {
		get_item2(name);
		action.click(btn_show());
		Thread.sleep(3000);
		action.click(btn_data());
		Thread.sleep(3000);
		action.click(btn_back());
		Thread.sleep(2000);
		action.click(btn_back());
	}

	// 复制功能
	public void copy(String message) throws InterruptedException {
		action.click(btn_chat());
		action.click(btn_system());
		action.type(btn_input(), message);
		Thread.sleep(2000);
		action.click(btn_sent());
		action.longPress(driver.findElementByAccessibilityId(message));
		Thread.sleep(2000);
		action.click(btn_copy());
		Thread.sleep(2000);
		action.longPress(btn_input());
		Thread.sleep(2000);
		action.click(btn_tie());
		Thread.sleep(2000);
		action.click(btn_sent());
		Thread.sleep(2000);
		action.click(btn_back());
	}

	// 转发功能
	public void transmit(String message) throws InterruptedException {
		action.click(btn_chat());
		action.click(btn_system());
		action.type(btn_input(), message);
		Thread.sleep(2000);
		action.click(btn_sent());
		Thread.sleep(2000);
		action.longPress(driver.findElementByAccessibilityId(message));
		//action.longPress(driver.findElementByAccessibilityId(message));
		Thread.sleep(2000);
		action.click(btn_transmit());
		Thread.sleep(2000);
		action.click(btn_system());
		Thread.sleep(2000);
		action.click(btn_back());
	}

	// 撤回功能
	public void recall(String message) throws InterruptedException {
		action.click(btn_chat());
		action.click(btn_system());
		action.type(btn_input(), message);
		Thread.sleep(2000);
		action.click(btn_sent());
		Thread.sleep(2000);
		action.longPress(driver.findElementByAccessibilityId(message));
		Thread.sleep(2000);
		action.click(btn_recall());
		Thread.sleep(2000);
		action.click(btn_back());
	
	}

	// 查看个人信息
	public void showMine() throws InterruptedException {
		action.click(btn_mine());
		Thread.sleep(2000);
		action.click(btn_reveal());
		Thread.sleep(2000);
		action.click(btn_back());
	}

	// 查看好友信息
	public void showFriend(String name) throws InterruptedException {
		action.click(btn_cl());
		get_item2(name);
		Thread.sleep(3000);
		action.click(btn_back());
		
	}

	// 收藏群聊
	public void collectGroup(String groupName) throws InterruptedException {
		Thread.sleep(2000);
		action.click(btn_group());
		Thread.sleep(2000);
		if (groupName.equals("生活群")) {
			action.click(btn_live());
		}if (groupName.equals("工作群")) {
			action.click(btn_work());
		}
		Thread.sleep(2000);
		action.click(btn_show());
		Thread.sleep(2000);
		action.click(btn_collect());
		Thread.sleep(2000);
		action.click(btn_back());
	}
	//取消收藏群聊
	public void dcollectGroup(String groupName) throws InterruptedException {
		Thread.sleep(2000);
		action.click(btn_group());
		Thread.sleep(2000);
		if (groupName.equals("生活群")) {
			action.click(btn_live());
		}if (groupName.equals("工作群")) {
			action.click(btn_work());
		}
		Thread.sleep(2000);
		action.click(btn_show());
		Thread.sleep(2000);
		action.click(btn_dcollect());
		Thread.sleep(2000);
		action.click(btn_back());
	}
	//查看群聊成员列表
	public void checkMumber(String groupName) throws InterruptedException {
		action.click(btn_group());
		Thread.sleep(2000);
		if (groupName.equals("生活群")) {
			action.click(btn_live());
		}if (groupName.equals("工作群")) {
			action.click(btn_work());
		}
		Thread.sleep(2000);
		action.click(btn_show());
		Thread.sleep(2000);
		action.click(btn_member());
		Thread.sleep(2000);
		action.click(btn_back());
		Thread.sleep(2000);
		action.click(btn_back());
		
	}
	//群聊重命名
	public void rename(String groupName,String newName) throws InterruptedException {
		action.click(btn_group());
		Thread.sleep(2000);
		if (groupName.equals("生活群")) {
			action.click(btn_live());
		}if (groupName.equals("工作群")) {
			action.click(btn_work());
		}
		action.click(btn_show());
		Thread.sleep(2000);
		action.click(btn_reName());
		action.type(btn_inNewname(),newName);
		Thread.sleep(2000);
		action.click(btn_reName());
		Thread.sleep(2000);
		action.click(btn_back());
	}
	
}
