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

//	用例29、进入讨论组模块
	@Test(priority = 1)
	public void enter_group() {
		mPage.enter_group();
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}

//	用例30、进入联系人模块并将一名联系人设为行表联系人 返回联系人列表
	@Test(priority = 2)
	public void contect_coll() throws InterruptedException {
		mPage.collect_user();
		Thread.sleep(2000);
		mPage.click(mPage.get_back());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}

//	用例31、若其为星标联系人择取消并返回，不是则直接返回
	@Test(priority = 3)
	public void contect_cancelcoll() throws InterruptedException {
		mPage.cancelcoll_user();
		Thread.sleep(2000);
		mPage.click(mPage.get_back());
		Thread.sleep(2000);
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}
	
//	用例32、发起与一名联系人的会话
	@Test(priority = 4)
	public void start_chat() throws InterruptedException {
		mPage.startchat();
		Thread.sleep(8000);
		mPage.click(mPage.get_back());
		Thread.sleep(2000);
		mPage.click(mPage.get_back());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}

//	用例33、打开个人名片后返回
	@Test(priority = 5)
	public void view_personal() throws InterruptedException {
		mPage.enter_mine();
		Thread.sleep(2000);
		mPage.click(mPage.personal());
		Thread.sleep(6000);
		mPage.click(mPage.get_back());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}
	
//	用例34、查看关于喧喧 后关闭
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
	
//	用例35、点击注销后取消
	@Test(priority = 7)
	public void cancel_logout() throws InterruptedException {
		mPage.click_logout();
		Thread.sleep(2000);
		mPage.click(mPage.logout_cancelbutton());
		Assert.assertEquals(mPage.module_contect().isDisplayed(),true);
	}
	
//	用例36、注销
	@Test(priority = 8)
	public void logout() throws InterruptedException {
		mPage.click_logout();
		Thread.sleep(2000);
		mPage.click(mPage.logout_surebutton());
		Assert.assertEquals(driver.findElementByAccessibilityId("登录").isDisplayed(),true);
	}


}
