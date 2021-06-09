package testcase;



import java.io.IOException;

import javax.swing.text.ChangedCharSetException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import base.ExcelDataProvider;
import pages.Contactman;

public class ConnectmanTest extends BaseDriver{
	Contactman contactman;
	@BeforeClass
	public void login() {
		contactman=new Contactman(driver);
	}

	@Test(priority =1)
	public void test_searchA() throws InterruptedException {
		contactman.searchA();
	}
	@Test(priority =2)
	public void test_search1() throws InterruptedException {
		contactman.search1();
	}
	@Test(priority =3)
	public void test_search2() throws InterruptedException {
		contactman.search2();
	}
	@Test(priority =4)
	public void test_search3() throws InterruptedException {
		contactman.search3();
	}
	@Test(priority =5)
	public void test_search4() throws InterruptedException {
		contactman.search4();
	}
	@Test(priority =6)
	public void test_search5() throws InterruptedException {
		contactman.search5();
	}
}
