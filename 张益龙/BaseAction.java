package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
public class BaseAction {
	public AndroidDriver<AndroidElement> driver;
	public AndroidTouchAction action;

	public BaseAction(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		action = new AndroidTouchAction(driver);

	}

	/**
	 * @param by
	 */
	public void click(By by) {
		driver.findElement(by).click();
	}

	public void click(WebElement elemnet) {
		elemnet.click();
	}

	/**
	 * 输入
	 * 
	 * @param by
	 * @param value
	 */
	public void type(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);

	}

	public void type(WebElement element, String context) {
		
		element.click();
		clearText(context);
		//字符串分割匹配
		char[] message=context.toCharArray();
		int length=message.length;
		System.out.println(length);
		for (int i = 0; i < message.length; i++) {
			if(String.valueOf(message[i]).equals("a")) {
				driver.pressKey(new KeyEvent(AndroidKey.A));
			}if(String.valueOf(message[i]).equals("b")) {
				driver.pressKey(new KeyEvent(AndroidKey.B));
			}if(String.valueOf(message[i]).equals("c")) {
				driver.pressKey(new KeyEvent(AndroidKey.C));
			}if(String.valueOf(message[i]).equals("d")) {
				driver.pressKey(new KeyEvent(AndroidKey.D));
			}if(String.valueOf(message[i]).equals("e")) {
				driver.pressKey(new KeyEvent(AndroidKey.E));
			}if(String.valueOf(message[i]).equals("f")) {
				driver.pressKey(new KeyEvent(AndroidKey.F));
			}if(String.valueOf(message[i]).equals("g")) {
				driver.pressKey(new KeyEvent(AndroidKey.G));
			}if(String.valueOf(message[i]).equals("h")) {
				driver.pressKey(new KeyEvent(AndroidKey.H));
			}if(String.valueOf(message[i]).equals("i")) {
				driver.pressKey(new KeyEvent(AndroidKey.I));
			}if(String.valueOf(message[i]).equals("j")) {
				driver.pressKey(new KeyEvent(AndroidKey.J));
			}if(String.valueOf(message[i]).equals("k")) {
				driver.pressKey(new KeyEvent(AndroidKey.K));
			}if(String.valueOf(message[i]).equals("l")) {
				driver.pressKey(new KeyEvent(AndroidKey.L));
			}if(String.valueOf(message[i]).equals("m")) {
				driver.pressKey(new KeyEvent(AndroidKey.M));
			}if(String.valueOf(message[i]).equals("n")) {
				driver.pressKey(new KeyEvent(AndroidKey.N));
			}if(String.valueOf(message[i]).equals("o")) {
				driver.pressKey(new KeyEvent(AndroidKey.O));
			}if(String.valueOf(message[i]).equals("p")) {
				driver.pressKey(new KeyEvent(AndroidKey.P));
			}if(String.valueOf(message[i]).equals("q")) {
				driver.pressKey(new KeyEvent(AndroidKey.Q));
			}if(String.valueOf(message[i]).equals("r")) {
				driver.pressKey(new KeyEvent(AndroidKey.R));
			}if(String.valueOf(message[i]).equals("s")) {
				driver.pressKey(new KeyEvent(AndroidKey.S));
			}if(String.valueOf(message[i]).equals("t")) {
				driver.pressKey(new KeyEvent(AndroidKey.T));
			}if(String.valueOf(message[i]).equals("u")) {
				driver.pressKey(new KeyEvent(AndroidKey.U));
			}if(String.valueOf(message[i]).equals("v")) {
				driver.pressKey(new KeyEvent(AndroidKey.V));
			}if(String.valueOf(message[i]).equals("w")) {
				driver.pressKey(new KeyEvent(AndroidKey.W));
			}if(String.valueOf(message[i]).equals("x")) {
				driver.pressKey(new KeyEvent(AndroidKey.X));
			}if(String.valueOf(message[i]).equals("y")) {
				driver.pressKey(new KeyEvent(AndroidKey.Y));
			}if(String.valueOf(message[i]).equals("z")) {
				driver.pressKey(new KeyEvent(AndroidKey.Z));
			}if(String.valueOf(message[i]).equals("0")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
			}if(String.valueOf(message[i]).equals("1")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
			}if(String.valueOf(message[i]).equals("2")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
			}if(String.valueOf(message[i]).equals("3")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
			}if(String.valueOf(message[i]).equals("4")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
			}if(String.valueOf(message[i]).equals("5")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
			}if(String.valueOf(message[i]).equals("6")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
			}if(String.valueOf(message[i]).equals("7")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
			}if(String.valueOf(message[i]).equals("8")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
			}if(String.valueOf(message[i]).equals("9")) {
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
			}
		}
	}

	    public void clearText(String text) {
	    	int len=text.length();
	        //光标定位到文末
	    	while(len>0) {
	    	driver.pressKey(new KeyEvent(AndroidKey.DEL));
	    	len--;
	    	}
	}

	/**
	 * 长按
	 * 
	 * @param element
	 */
	public void longPress(WebElement element) {
		LongPressOptions longPressOptions = LongPressOptions.longPressOptions();
		longPressOptions.withElement(ElementOption.element(element));
		action.longPress(longPressOptions).release().perform();
	}

	/**
	 * 坐标点的滑动
	 * 
	 * @param fromOption
	 * @param toOption
	 */
	public void slide(PointOption fromOption, PointOption toOption) {
		action.press(fromOption).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(toOption)
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}

	/**
	 * 元素间的滑动
	 * 
	 * @param fromEle
	 * @param toEle
	 */
	public void slide(WebElement fromEle, WebElement toEle) {

		slide(ElementOption.element(fromEle), ElementOption.element(toEle));
	}

	/**
	 * 长按拖动
	 * 
	 * @param element
	 */
	public void dragAndSlide(AndroidElement element) {

		LongPressOptions longPressOptions = LongPressOptions.longPressOptions();
		longPressOptions.withElement(ElementOption.element(element));

		action.longPress(longPressOptions).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(100, element.getLocation().getY()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}
/**
 * 多点触控功能实现
 * @param x1
 * @param y1
 * @param x2
 * @param y2
 * @param x3
 * @param y3
 */
	public void multiTouch(int x1, int y1, int x2, int y2, int x3, int y3) {
		MultiTouchAction multiAction = new MultiTouchAction(driver);
		AndroidTouchAction action1 = new AndroidTouchAction(driver);
		AndroidTouchAction action2 = new AndroidTouchAction(driver);
		AndroidTouchAction action3 = new AndroidTouchAction(driver);
		AndroidTouchAction action4 = new AndroidTouchAction(driver);
		AndroidTouchAction action5 = new AndroidTouchAction(driver);

		action1.longPress(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();
		action2.longPress(PointOption.point(x2, y2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();
		action3.longPress(PointOption.point(x3, y3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();

		multiAction.add(action1).add(action2).add(action3).add(action4).add(action5).perform();
	}
/**
 * 返回Toast的文本信息
 */
	public String getToast() {
		return driver.findElementByXPath("//*[@class='android.widget.Toast']").getText();
	}
}
