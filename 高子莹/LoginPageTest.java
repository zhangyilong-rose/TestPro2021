package com.www.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.www.dataProvider.ExcelDataProvider;
import com.www.pages.LoginPage;
import com.www.utils.BaseDriver;

import junit.framework.Assert;

public class LoginPageTest extends BaseDriver {

	LoginPage loginPage;

	@DataProvider(name = "data")
	public Object[][] searchdata(Method method) throws IOException {
		Object[][] objects = null;
		if (method.getName() == "falselogin") {
			objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet1");
		} else if (method.getName() == "correctlogin") {
			objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet2");
		}
		return objects;
	}

	@BeforeClass
	public void login() {
		loginPage = new LoginPage(driver);
	}

//	错误登录测试用例
	/*
	 * 用例 1、10.7.90.194 user5 123456 用户密码错误 
	 * 用例 2、 10.7.90.194 admin admin 管理员密码错误
	 * 用例 3、 10.7.90.194 xiaomin 123456 用户账号输入错误 
	 * 用例 4、 10.7.90.194 user4 123456 该用户不存在
	 */
	@Test(priority = 1, dataProvider = "data")
	public void falselogin(String http, String user, String pwd) throws InterruptedException {
		loginPage.login(http, user, pwd);
		loginPage.clearall();
		System.out.println(loginPage.get_login().getText());
		Assert.assertEquals(loginPage.get_pwd().isSelected(),false);
	}

//	 用例5、正确登录测试用例
	@Test(priority = 2, dataProvider = "data")
	public void correctlogin(String http, String user, String pwd) throws InterruptedException, MalformedURLException {
		loginPage.login(http, user, pwd);
		System.out.println(driver.findElementByAccessibilityId("聊天").getText());
		Assert.assertEquals(driver.findElementByAccessibilityId("聊天").isSelected(),false);
	}

}
