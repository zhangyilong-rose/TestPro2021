package testcase;

import org.openqa.selenium.interactions.internal.BaseAction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.MinePage;

public class MinePageTest extends BaseDriver{

	MinePage minepage;
	@BeforeClass 
	public void login() {
		minepage=new MinePage(driver);
	}
	
	@Test(priority = 1)
	public void test_showList() throws InterruptedException {
		minepage.showList();
	}
	@Test(priority = 2)
	public void test_showme() throws InterruptedException {
		minepage.showme();
	}
	@Test(priority = 3)
	public void test_Logout() throws InterruptedException {
		minepage.Logout();
	}
}
