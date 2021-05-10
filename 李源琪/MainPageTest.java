package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import base.ExcelDataProvider;
import pages.MainPage1;
import pages.MainPage;

public class MainPageTest extends BaseDriver{

	MainPage mainPage;
	@BeforeClass
	public void login() {
		mainPage=new MainPage(driver);
	}
	
	@DataProvider(name="search")
	public Object[][] searchTestdemo() throws IOException{
		ExcelDataProvider data=new ExcelDataProvider();
		return data.getTestDataByExcel("F://demo//SHIXUNTwo//testword//Username.xlsx", "Sheet1");
	}
	@Test(priority = 1,dataProvider="search")
	public void test_createChat(String username) throws InterruptedException {
		mainPage.createChat(username);
	}
	@Test(priority = 2,dataProvider="search")
	public void test_createChat1(String username) throws InterruptedException {
		mainPage.createChat1(username);
	}
	@Test(priority = 3,dataProvider="search")
	public void test_createChat43(String username) throws InterruptedException {
		mainPage.createChat3(username);
	}
	@Test(priority = 4,dataProvider="search")
	public void test_createChat4(String username) throws InterruptedException {
		mainPage.createChat4(username);
	}
	@Test(priority = 5,dataProvider="search")
	public void test_createChat5(String username) throws InterruptedException {
		mainPage.createChat5(username);
	}
//	@Test(priority = 2)
//	public void test_sendMessage() throws InterruptedException {
//		mainPage.sendMessage("hello");
//	}
//	@Test(priority = 2)
//	public void test_CP() throws InterruptedException {
//		mainPage.copy();
//	}
	
	@Test(priority = 6)
	public void test_Collect() throws InterruptedException {
		mainPage.Collect();
	}
	@Test(priority = 7)
	public void test_DisCollect() throws InterruptedException {
		mainPage.Discollect();
	}
	@Test(priority = 8)
	public void test_searchData() throws InterruptedException {
		mainPage.Search();
	}
	@Test(priority = 9)
	public void test_searchDataH() throws InterruptedException {
		mainPage.SearchH();
		
	}
	@Test(priority = 10)
	public void test_exSendmess1() throws InterruptedException {
		mainPage.exSendMess2();
	}
	@Test(priority = 11)
	public void test_collectGroup() throws InterruptedException {
		mainPage.CollectGroup();
	}
	@Test(priority = 12)
	public void test_disCollect() throws InterruptedException {
		mainPage.disCollectGroup();
	}
	@Test(priority = 13)
	public void test_searchGroupData() throws InterruptedException {
		mainPage.searchMember();
	}
	@Test(priority = 14)
	public void test_exSendmess2() throws InterruptedException {
		mainPage.exSendMess1();
	}
//	@Test(priority = 10)
//	public void test_Sharemess() throws InterruptedException {
//		mainPage.ShareMess();
//	}
	@Test(priority = 15)
	public void test_exitGroup() throws InterruptedException {
		mainPage.exitGroup();
	}
}
