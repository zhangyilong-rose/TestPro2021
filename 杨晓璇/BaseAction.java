package base;

import static io.appium.java_client.android.AndroidKeyCode.BACKSPACE;
import static io.appium.java_client.android.AndroidKeyCode.KEYCODE_MOVE_END;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseAction{
	
	public AndroidDriver<AndroidElement> driver; 
	BaseAction action;
	public BaseAction (AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action = new BaseAction(driver);
	}
	
	/**
	 * 定位
	 * @param index
	 * @return
	 */
	public MobileElement getElementByIndex(int index){
		return driver.findElementByAndroidUIAutomator("new UiSelector().index("+index+")");
	}
	/**
	 * 点击
	 * @param by
	 */
	public void clickElement(By by) {
		driver.findElement(by).click();
	}
	
	public void clickElement(AndroidElement element) {
		element.click();
	}
	/**
	 *输入 
	 * @param by
	 * @param value
	 */
	public void input(By by,String value) {
		driver.findElement(by).click();
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	public void input(AndroidElement element,String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
	}
	
	/**
	 * 长按元素
	 * @param element
	 */
	public void longPressElement(WebElement element) {
		TouchAction action = new TouchAction(driver);
		action.longPress(element);
		action.perform();
	}
	
	/**
	 *向上滑动
	 */
	public void slideUp() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 2, y / 3 * 2, x / 2, y / 3 * 1, 1000);
	}
	
	/**
	 * 向下滑动
	 */
	public void slideDown() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 2, y / 3 * 2, x / 2, y / 3 * 2, 1000);
	}
	
	/**
	 * 向左滑动
	 */
	public void slideLeft() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 6*5, y /2, x / 6*1, y / 2, 1000);
	}
	
	/**
	 * 向右滑动
	 */
	public void slideRight() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 4*1, y /2, x / 4*3, y / 2, 1000);
	}
	
	 /**
	  * 逐字删除
     *
     * @param element
     */
    public void clearText(AndroidElement element) {
        String text = element.getText();
        driver.pressKeyCode(KEYCODE_MOVE_END);
        for (int i = 0; i < text.length(); i++) {
            driver.pressKeyCode(BACKSPACE);
        }

    }
}
