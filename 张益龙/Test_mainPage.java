package testcase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;

import javax.accessibility.AccessibleAction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.MainPage;
import utils.ExcelDataProvider;

public class Test_mainPage extends BaseDriver {
	MainPage mainPage;

	@BeforeClass
	public void Open() {
		mainPage = new MainPage(driver);
	}

	// 生成随机数字和字母的信息
	public String getStringRandom(int length) {
		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 97 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	// 发起单人会话
	@Test(priority = 1)
	public void test1() throws InterruptedException {
		mainPage.begin_talk("admin", getStringRandom(5));

	}

	@Test(priority = 2)
	public void test2() throws InterruptedException {
		mainPage.begin_talk("long", getStringRandom(5));
	}

	@Test(priority = 3)
	public void test3() throws InterruptedException {
		mainPage.begin_talk("娇", getStringRandom(5));
	}

	@Test(priority = 4)
	public void test4() throws InterruptedException {
		mainPage.begin_talk("龙", getStringRandom(5));
	}

	// 通过数据驱动方式获取多人对话的名字和发起聊天人的发送信息内容
//	@DataProvider(name = "talk")
//	public Object[][] data1() throws IOException {
//		ExcelDataProvider excel = new ExcelDataProvider();
//		return excel.getTestDataByExcel("data//data.xlsx", "Sheet2");
//	}
//
//	@Test(dataProvider = "talk", description = "多人聊天",priority = 5)
//	public void test5(String name1, String name2, String name, String message6) throws InterruptedException {
//		mainPage.begin_talks(name1, name2, name, message6);
//	}

	// 群发消息-----聊天对话框
	@Test(priority = 6)
	public void test6() throws InterruptedException {
		mainPage.all_sent(getStringRandom(6));
	}

	// 收藏好友------聊天对话框
	@Test(priority = 7)
	public void test7() throws InterruptedException {
		mainPage.one_collect("admin");
	}

	// 取消收藏----聊天对话框
	@Test(priority = 8)
	public void test8() throws InterruptedException {
		mainPage.del_collect("admin");
	}

	// 展示个人信息----聊天对话框
	@Test(priority = 9)
	public void test9() throws InterruptedException {
		mainPage.show_details("admin");
	}

	// 复制信息----先发送再复制发送的信息
	@Test(priority = 10)
	public void test10() throws InterruptedException {
		mainPage.copy(getStringRandom(6));
	}

	// 转发信息----先发送再转发
	@Test(priority = 11)
	public void test11() throws InterruptedException {
		mainPage.transmit(getStringRandom(6));
	}

	// 撤回信息----先发送再撤回
	@Test(priority = 12)
	public void test12() throws InterruptedException {
		mainPage.recall(getStringRandom(6));
	}

	// 查看个人信息
	@Test(priority = 13)
	public void test13() throws InterruptedException {
		mainPage.showMine();
	}

	// 查看好友个人信息
	@Test(priority = 14)
	public void test14() throws InterruptedException {
		mainPage.showFriend("admin");
	}

	@Test(priority = 15)
	public void test15() throws InterruptedException {
		mainPage.showFriend("张益龙");
	}

	@Test(priority = 16)
	public void test16() throws InterruptedException {
		mainPage.showFriend("娇");
	}

	@Test(priority = 17)
	public void test17() throws InterruptedException {
		mainPage.showFriend("龙");
	}

	@Test(priority = 18)
	public void test18() throws InterruptedException {
		mainPage.showFriend("long");
	}

	// 收藏群聊
	@Test(priority = 19)
	public void test19() throws InterruptedException {
		mainPage.collectGroup("生活群");
	}

	// 取消收藏的群聊
	@Test(priority = 20)
	public void test20() throws InterruptedException {
		mainPage.dcollectGroup("生活群");
	}

	// 查看群聊成员
	@Test(priority = 21)
	public void test21() throws InterruptedException {
		mainPage.checkMumber("生活群");
	}

//	群聊重命名
	@Test(priority = 22)
	public void test22() throws InterruptedException {
		mainPage.rename("工作群", "work");
	}
}
