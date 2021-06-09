package base;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageAppium {
	public AndroidDriver<AndroidElement> driver; 
	BaseAction action;
	public PageAppium(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action = new BaseAction(driver);
	}
	

	public AndroidElement chat1() {
		return driver.findElementByXPath("//android.view.View[@content-desc=\"�� С���� ֪ͨ����\"]");
	}
	public AndroidElement chat2() {
		return driver.findElementByXPath("//android.view.View[@content-desc=\"ϵͳ ������\"]");
	}
	public AndroidElement chat3() {
		return driver.findElementByAndroidUIAutomator("new UiSelector().className("+"android.view.View"+").index(2)");
	}
	public AndroidElement chatCreate() {
		return driver.findElementByAccessibilityId("��������");
	}
	public AndroidElement chatName() {
		return driver.findElementByClassName("android.widget.EditText");
	}
	public AndroidElement groupName() {
		return driver.findElementByAccessibilityId("Ⱥ ������");
	}
	public AndroidElement add1() {
		return driver.findElementByXPath("//android.view.View[@content-desc=\"A admin\"]");
	}
	public AndroidElement add2() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"�� ����\"])[1]");
	}
	public AndroidElement add3() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"�� ����\"])[2]");
		
	}
	public AndroidElement add4() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"�� ����\"])[3]");		
	}
	public AndroidElement add5() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"�� ����\"])[4]");
		
	}
	public AndroidElement add6() {
		return driver.findElementByXPath("(//android.view.View[@content-desc=\"�� ����1\"])");
		
	}
	public AndroidElement delete1() {
		return driver.findElementByXPath("(android.widget.Button[@content-desc=\"ɾ��\"])[1]");
	}
	public AndroidElement delete2() {
		return driver.findElementByXPath("(android.widget.Button[@content-desc=\"ɾ��\"])");
	}
	public AndroidElement group1() {
		return driver.findElementByClassName("��Ա�б�");
	}
	public AndroidElement group2() {
		return driver.findElementByClassName("������");
	}
	public AndroidElement button() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement button1() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
	}
	public AndroidElement button2() {
		return driver.findElementByAccessibilityId("��ʾ�˵�");
	}
	public AndroidElement button3() {
		return driver.findElementByAccessibilityId("�ղ�");
	}
	public AndroidElement button4() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement button5() {
		return driver.findElementByAccessibilityId("ȡ���ղ�");
	}
	public AndroidElement button6() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement button7() {
		return driver.findElementByAccessibilityId("���� ���� �� 1 ����ǩ���� 4 ��");
	}
	public AndroidElement button8() {
		return driver.findElementByAccessibilityId("������ ������ �� 2 ����ǩ���� 4 ��");
	}
	public AndroidElement button9() {
		return driver.findElementByAccessibilityId("��ϵ�� ��ϵ�� �� 3 ����ǩ���� 4 ��");
	}
	public AndroidElement button10() {
		return driver.findElementByAccessibilityId("�ҵ� �ҵ� �� 4 ����ǩ���� 4 ��");
	}
	public AndroidElement button11() {
		return driver.findElementByAccessibilityId("ע��");
	}
	public AndroidElement button12() {
		return driver.findElementByAccessibilityId("ȷ��");
	}
	public AndroidElement send() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement editText() {
		return driver.findElementByClassName("android.widget.EditText");
	}
	public AndroidElement sendMore() {
		return driver.findElementByAccessibilityId("������������");
	}
	public AndroidElement picture() {
		return driver.findElementByClassName("android.widget.ImageView");
	}
	public AndroidElement transmit() {
		return driver.findElementByAccessibilityId("ת��");
	}
	public AndroidElement photograph() {
		return driver.findElementByAccessibilityId("��Ƭ");
	}
	public AndroidElement takePicture() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement imageView() {
		return driver.findElementByAccessibilityId("android.widget.ImageView");
	}
	public AndroidElement shutter() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement cancel() {
		return driver.findElementByAccessibilityId("ȡ��");
	}
	public AndroidElement finish() {
		return driver.findElementByAccessibilityId("���");
	}
	public AndroidElement takeAgain() {
		return driver.findElementByAccessibilityId("��������");
	}
	public AndroidElement withdrawButton() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement copyButton() {
		return driver.findElementByAccessibilityId("����");
	}
	public AndroidElement share() {
		return driver.findElementByAccessibilityId("����...");
	}
	public AndroidElement toBaidu() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ResolverDrawerLayout/android.widget.ListView/android.widget.LinearLayout[1]");
	}
	public AndroidElement issue() {
		return driver.findElementById("com.baidu.searchbox:id/ugc_publish");
	}
	public AndroidElement close() {
		return driver.findElementById("com.baidu.searchbox:id/ugc_publish_cancel");
	}
	public AndroidElement nonSave() {
		return driver.findElementById("com.baidu.searchbox:id/dialog_message_content");
	}
	//����
	//����
	public void  enterChat1() throws InterruptedException {
		action.clickElement(chat1());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void  enterChat2() throws InterruptedException {
		action.clickElement(chat2());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void  enterChat3() throws InterruptedException {
		action.clickElement(chat3());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	//������
	public void createChat1() throws InterruptedException {
		action.clickElement(chatCreate());
		Thread.sleep(3000);
		action.clickElement(add1());
		Thread.sleep(3000);
		action.clickElement(add2());
		Thread.sleep(3000);
		action.clickElement(button1());
		Thread.sleep(3000);
		action.input(chatName(), "������1");
		Thread.sleep(3000);
		action.clickElement(button());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void createChat2() throws InterruptedException {
		action.clickElement(chatCreate());
		Thread.sleep(3000);
		action.clickElement(add1());
		Thread.sleep(3000);
		action.clickElement(add2());
		Thread.sleep(3000);
		action.clickElement(add3());
		Thread.sleep(3000);
		action.clickElement(add1());
		Thread.sleep(3000);
		action.clickElement(button1());
		Thread.sleep(3000);
		action.input(chatName(), "������2");
		Thread.sleep(3000);
		action.clickElement(button());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void createChat3() throws InterruptedException {
		action.clickElement(chatCreate());
		Thread.sleep(3000);
		action.clickElement(add1());
		Thread.sleep(3000);
		action.clickElement(add2());
		Thread.sleep(3000);
		action.clickElement(add3());
		Thread.sleep(3000);
		action.clickElement(delete1());
		Thread.sleep(3000);
		action.clickElement(button1());
		Thread.sleep(3000);
		action.input(chatName(), "������3");
		Thread.sleep(3000);
		action.clickElement(button());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void createChat4() throws InterruptedException {
		action.clickElement(chatCreate());
		Thread.sleep(3000);
		action.clickElement(add1());
		Thread.sleep(3000);
		action.clickElement(add2());
		Thread.sleep(3000);
		action.clickElement(delete1());
		Thread.sleep(3000);
		action.clickElement(delete2());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void createChat5() throws InterruptedException {
		action.clickElement(add1());
		Thread.sleep(3000);
		action.clickElement(button1());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void checkNumbers() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(button2());
		Thread.sleep(3000);
		action.clickElement(group1());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void collection() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(button2());
		Thread.sleep(3000);
		action.clickElement(button3());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void cancelCollection() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(button2());
		Thread.sleep(3000);
		action.clickElement(button5());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void rename() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(button2());
		Thread.sleep(3000);
		action.clickElement(group2());
		Thread.sleep(3000);
		action.clearText(editText());
		Thread.sleep(3000);
		action.input(editText(), "������2");
		Thread.sleep(3000);
		action.clickElement(group2());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	//����
	public void chat() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(editText());
		Thread.sleep(3000);
		action.input(editText(), "���Ǻ�");
		Thread.sleep(3000);
		action.clickElement(send());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void sendPicture1() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(sendMore());
		Thread.sleep(3000);
		action.clickElement(photograph());
		Thread.sleep(3000);
		action.clickElement(picture());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void sendPicture2() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(sendMore());
		Thread.sleep(3000);
		action.clickElement(takePicture());
		Thread.sleep(3000);
		action.clickElement(shutter());
		Thread.sleep(3000);
		action.clickElement(finish());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void sendPicture3() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(sendMore());
		Thread.sleep(3000);
		action.clickElement(takePicture());
		Thread.sleep(3000);
		action.clickElement(shutter());
		Thread.sleep(3000);
		action.clickElement(cancel());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void sendPicture4() throws InterruptedException {
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(sendMore());
		Thread.sleep(3000);
		action.clickElement(takePicture());
		Thread.sleep(3000);
		action.clickElement(shutter());
		Thread.sleep(3000);
		action.clickElement(takeAgain());
		Thread.sleep(3000);
		action.clickElement(shutter());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	//����
	public void transmit1() throws InterruptedException {
		action.clickElement(chat1());
		Thread.sleep(3000);
		action.longPressElement(chat3());
		Thread.sleep(3000);
		action.clickElement(transmit());
		Thread.sleep(3000);
		action.clickElement(groupName());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void withdraw() throws InterruptedException {
		action.clickElement(chat1());
		Thread.sleep(3000);
		action.clickElement(withdrawButton());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
		action.clickElement(issue());
		Thread.sleep(3000);
	}
	public void copy() throws InterruptedException {
		action.clickElement(chat1());
		Thread.sleep(3000);
		action.clickElement(copyButton());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	public void shareNews() throws InterruptedException {
		action.clickElement(chat1());
		Thread.sleep(3000);
		action.longPressElement(chat3());
		Thread.sleep(3000);
		action.clickElement(share());
		Thread.sleep(3000);
		action.clickElement(toBaidu());
		Thread.sleep(3000);
		
		
	}
	public void cancelAccount() throws InterruptedException {
		action.clickElement(button10());
		Thread.sleep(3000);
		action.clickElement(button11());
		Thread.sleep(3000);
		action.clickElement(button12());
		Thread.sleep(3000);
		action.clickElement(close());
		Thread.sleep(3000);
		action.clickElement(nonSave());
		Thread.sleep(3000);
		action.clickElement(button6());
		Thread.sleep(3000);
	}
	
}
