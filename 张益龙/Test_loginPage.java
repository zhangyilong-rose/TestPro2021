package testcase;

import java.io.IOException;

import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.LoginPage;
import utils.ExcelDataProvider;

public class Test_loginPage extends BaseDriver{
	LoginPage loginPage;
	@BeforeClass
	public  void initPage() {
		loginPage=new LoginPage(driver);
	}
	
//登录模块
	//数驱动模式
//	@DataProvider(name = "login")
//	public Object[][] data1() throws IOException{
//		ExcelDataProvider excel=new ExcelDataProvider();
//		return excel.getTestDataByExcel("data//data.xlsx", "Sheet1");
//	}
//	@Test(dataProvider = "login",description = "登录")
	@Test
	public void testLogin() throws InterruptedException {
		Thread.sleep(3000);
		//loginPage.login_fail("http://10.7.90.215:11443","zyl1","123456");
	}
}
