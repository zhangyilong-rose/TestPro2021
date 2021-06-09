package com.www.test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.www.dataProvider.ExcelDataProvider;
import com.www.pages.MainPage;
import com.www.utils.BaseDriver;

public class MainPageTest extends BaseDriver {

	MainPage mainpage;

	@DataProvider(name = "data")
	public Object[][] searchData(Method method) throws IOException {
		Object[][] objects = null;
		if (method.getName() == "creategroup_3") {
			objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet3");
		} else if (method.getName() == "creategroup_4") {
			objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet4");
		}
		 else if (method.getName() == "creategroup_5") {
				objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet5");
			}
		 else if (method.getName() == "creategroup_6") {
				objects = ExcelDataProvider.getTestDataByExcel("E://data.xls", "Sheet6");
			}
		return objects;
	}

	@BeforeClass
	public void MainPageTest() throws InterruptedException {
		mainpage = new MainPage(driver);
	}

//	����6���������������飬�����˶Ի���
	@Test(priority = 2)
	public void creategroup_2() throws InterruptedException {
		mainpage.click(mainpage.creatchat());
		Thread.sleep(2000);
		mainpage.click(mainpage.user_zhangsan());
		Thread.sleep(2000);
		mainpage.click(mainpage.create());
		Thread.sleep(2000);
		mainpage.click(mainpage.getback());
		Assert.assertEquals(mainpage.creatchat().isDisplayed(),true);
	}

/*
 * 	����7-10
 * 	�����������˵�������
 */
	@Test(priority = 3, dataProvider = "data")
	public void creategroup_3(String num, String name) throws InterruptedException {
			mainpage.buildgroup(num, name);
			Assert.assertEquals(mainpage.creatchat().isDisplayed(),true);
	}

/*
 * ����11-13
 * 	�����������˵�������
 */
	@Test(priority = 4, dataProvider = "data")
	public void creategroup_4(String num,String name) throws InterruptedException {
		mainpage.buildgroup(num, name);
		Assert.assertEquals(mainpage.creatchat().isDisplayed(),true);
	}
	
/*
 * ����14-15
 * 	��������������
 */
	@Test(priority = 5, dataProvider = "data")
	public void creategroup_5(String num,String name) throws InterruptedException {
		mainpage.buildgroup(num, name);
		Assert.assertEquals(mainpage.creatchat().isDisplayed(),true);
	}
	
/*
 * ����16
 * 	��������������
 */
	@Test(priority = 6, dataProvider = "data")
	public void creategroup_6(String num,String name) throws InterruptedException {
		mainpage.buildgroup(num, name);
		Assert.assertEquals(mainpage.creatchat().isDisplayed(),true);
	}
	
	
}
