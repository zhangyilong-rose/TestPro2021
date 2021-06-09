package com.www.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.www.pages.ModulesPage;
import com.www.utils.BaseDriver;

public class ModulesPageTest extends BaseDriver {
	ModulesPage mPage;

	@BeforeClass
	public void modules() throws InterruptedException {
		mPage = new ModulesPage(driver);
	}

//	����29������������ģ��
	@Test(priority = 1)
	public void enter_group() {
		mPage.enter_group();
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}

//	����30��������ϵ��ģ�鲢��һ����ϵ����Ϊ�б���ϵ�� ������ϵ���б�
	@Test(priority = 2)
	public void contect_coll() throws InterruptedException {
		mPage.collect_user();
		Thread.sleep(2000);
		mPage.click(mPage.get_back());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}

//	����31������Ϊ�Ǳ���ϵ����ȡ�������أ�������ֱ�ӷ���
	@Test(priority = 3)
	public void contect_cancelcoll() throws InterruptedException {
		mPage.cancelcoll_user();
		Thread.sleep(2000);
		mPage.click(mPage.get_back());
		Thread.sleep(2000);
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}
	
//	����32��������һ����ϵ�˵ĻỰ
	@Test(priority = 4)
	public void start_chat() throws InterruptedException {
		mPage.startchat();
		Thread.sleep(8000);
		mPage.click(mPage.get_back());
		Thread.sleep(2000);
		mPage.click(mPage.get_back());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}

//	����33���򿪸�����Ƭ�󷵻�
	@Test(priority = 5)
	public void view_personal() throws InterruptedException {
		mPage.enter_mine();
		Thread.sleep(2000);
		mPage.click(mPage.personal());
		Thread.sleep(6000);
		mPage.click(mPage.get_back());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}
	
//	����34���鿴�������� ��ر�
	@Test(priority = 6)
	public void checkxuanxuan() throws InterruptedException {
		mPage.enter_mine();
		Thread.sleep(2000);
		mPage.click(mPage.menu());
		Thread.sleep(2000);
		mPage.click(mPage.detail());
		Thread.sleep(10000);
		mPage.click(mPage.colse());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}
	
//	����35�����ע����ȡ��
	@Test(priority = 7)
	public void cancel_logout() throws InterruptedException {
		mPage.click_logout();
		Thread.sleep(2000);
		mPage.click(mPage.logout_cancelbutton());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}
	
//	����36��ע��
	@Test(priority = 8)
	public void logout() throws InterruptedException {
		mPage.click_logout();
		Thread.sleep(2000);
		mPage.click(mPage.logout_surebutton());
		Assert.assertEquals(driver.findElementByAccessibilityId("��¼").isDisplayed(),true);
	}


}
