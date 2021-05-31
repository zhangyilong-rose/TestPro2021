package cases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.InitAppium;
import base.PageAppium;

public class Page extends InitAppium{
	
		
		PageAppium pageAppium;
		@BeforeClass
		public void login() {
			pageAppium = new PageAppium(driver);
		}
		@Test(priority = 1)
		public void test_enterChat1() throws InterruptedException {
			pageAppium.enterChat1();
		}
		@Test(priority = 2)
		public void test_enterChat2() throws InterruptedException {
			pageAppium.enterChat2();
		}
		@Test(priority = 3)
		public void test_enterChat3() throws InterruptedException {
			pageAppium.enterChat3();
		}
		@Test(priority = 4,dataProvider="search")
		public void test_createChat1() throws InterruptedException {
			pageAppium.createChat1();
		}
		@Test(priority = 5,dataProvider="search")
		public void test_createChat2() throws InterruptedException {
			pageAppium.createChat2();
		}
		@Test(priority = 6,dataProvider="search")
		public void test_createChat3() throws InterruptedException {
			pageAppium.createChat3();
		}
		@Test(priority = 7,dataProvider="search")
		public void test_createChat4() throws InterruptedException {
			pageAppium.createChat4();
		}
		@Test(priority = 8,dataProvider="search")
		public void test_createChat5() throws InterruptedException {
			pageAppium.createChat5();
		}
		@Test(priority = 9)
		public void test_checkNumbers() throws InterruptedException {
			pageAppium.checkNumbers();
		}
		@Test(priority = 10)
		public void test_collection() throws InterruptedException {
			pageAppium.collection();
		}
		@Test(priority = 11)
		public void test_cancelCollection() throws InterruptedException {
			pageAppium.cancelCollection();
		}
		@Test(priority = 12)
		public void test_rename() throws InterruptedException {
			pageAppium.rename();
		}
		@Test(priority = 13)
		public void test_chat() throws InterruptedException {
			pageAppium.chat();
		}
		@Test(priority = 14)
		public void test_sendPicture1() throws InterruptedException {
			pageAppium.sendPicture1();
		}
		@Test(priority = 15)
		public void test_sendPicture2() throws InterruptedException {
			pageAppium.sendPicture2();
		}
		@Test(priority = 16)
		public void test_sendPicture3() throws InterruptedException {
			pageAppium.sendPicture3();
		}
		@Test(priority = 17)
		public void test_sendPicture4() throws InterruptedException {
			pageAppium.sendPicture4();
		}
		@Test(priority = 18)
		public void test_transmit1() throws InterruptedException {
			pageAppium.transmit1();
		}
		@Test(priority = 19)
		public void test_withdraw() throws InterruptedException {
			pageAppium.withdraw();
		}
		@Test(priority = 20)
		public void test_copy() throws InterruptedException {
			pageAppium.copy();
		}
		@Test(priority = 21)
		public void test_cancelAccount() throws InterruptedException {
			pageAppium.cancelAccount();
		}
		@Test(priority = 22)
		public void test_shareNews() throws InterruptedException {
			pageAppium.shareNews();
		}
}

