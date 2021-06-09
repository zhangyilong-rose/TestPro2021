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

//	����17���ղظ�������
	@Test(priority = 1)
	public void collection() throws InterruptedException {
		chatPage.click(chatPage.display_menu());
		Thread.sleep(2000);
		chatPage.click(chatPage.collect());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

//	����18��ȡ���ղ�
	@Test(priority = 2)
	public void cancel_collection() throws InterruptedException {
		chatPage.click(chatPage.display_menu());
		Thread.sleep(2000);
		chatPage.click(chatPage.cancel_collect());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

/*
 * ����19-22
 * 	�����������������
 */
	@Test(priority = 3, dataProvider = "data")
	public void rename(String newname) throws InterruptedException {
		chatPage.rename_send(newname);
		Thread.sleep(2000);
		chatPage.click(chatPage.sure_rename());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

/*
 * ����23
 * 	������������ѡ��ȡ��
 */
	@Test(priority = 4, dataProvider = "data")
	public void cancelrename(String newname) throws InterruptedException {
		chatPage.rename_send(newname);
		Thread.sleep(2000);
		chatPage.click(chatPage.cancel_rename());
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}

/*
 * ����24-27��������� �����ı� �հ��ı�  ���ı�
 * 	���Ͳ�ͬ��ʽ���ݳ��ȵ��ı�
 */
	@Test(priority = 5, dataProvider = "data")
	public void sendtext(String text) throws InterruptedException {
		chatPage.sendchat(text);
		Assert.assertEquals(chatPage.send().isDisplayed(),true);
	}
	
//	����28 �鿴��Ա�б�
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
