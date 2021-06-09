package com.www.test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.www.dataProvider.ExcelDataProvider;
import com.www.pages.ChatPage;
import com.www.utils.BaseDriver;

public class ChatPageTest extends BaseDriver {
	ChatPage chatPage;

	@DataProvider(name = "data")
	public Object[][] searchData(Method method) throws IOException {
		Object[][] objects = null;
		if (method.getName() == "rename" || method.getName() == "cancelrename") {
			objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet7");
		} else if (method.getName() == "sendtext") {
			objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet8");
		}
		return objects;
	}

	@BeforeClass
	public void ChatPagetest() throws InterruptedException {
		chatPage = new ChatPage(driver);
	}

//	用例17、收藏该聊天组
	@Test(priority = 1)
	public void collection() throws InterruptedException {
		chatPage.click(chatPage.display_menu());
		Thread.sleep(2000);
		chatPage.click(chatPage.collect());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

//	用例18、取消收藏
	@Test(priority = 2)
	public void cancel_collection() throws InterruptedException {
		chatPage.click(chatPage.display_menu());
		Thread.sleep(2000);
		chatPage.click(chatPage.cancel_collect());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

/*
 * 用例19-22
 * 	对讨论组进行重命名
 */
	@Test(priority = 3, dataProvider = "data")
	public void rename(String newname) throws InterruptedException {
		chatPage.rename_send(newname);
		Thread.sleep(2000);
		chatPage.click(chatPage.sure_rename());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

/*
 * 用例23
 * 	重命名过程中选择取消
 */
	@Test(priority = 4, dataProvider = "data")
	public void cancelrename(String newname) throws InterruptedException {
		chatPage.rename_send(newname);
		Thread.sleep(2000);
		chatPage.click(chatPage.cancel_rename());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

/*
 * 用例24-27：特殊符号 常用文本 空白文本  长文本
 * 	发送不同形式内容长度的文本
 */
	@Test(priority = 5, dataProvider = "data")
	public void sendtext(String text) throws InterruptedException {
		chatPage.sendchat(text);
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}
	
//	用例28 查看成员列表
	@Test(priority = 6)
	public void view_members() throws InterruptedException {
		chatPage.click(chatPage.display_menu());
		Thread.sleep(2000);
		chatPage.click(chatPage.member());
		Thread.sleep(5000);
		chatPage.click(chatPage.getback());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

}
