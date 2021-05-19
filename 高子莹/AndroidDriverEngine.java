
package com.www.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidDriverEngine {

	AndroidDriver<AndroidElement> driver;
	AndroidTouchAction action;

	public AndroidDriverEngine(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		action = new AndroidTouchAction(driver);

	}

	public AndroidKey[] transform_input(String input) {
		char[] getin = input.toCharArray();
		int i = 0;
		Map<Character, AndroidKey> map = new HashMap<>();
//		键盘内容存储
		String letter = "abcdefghijklmnopqrstuvwxyz0123456789.";
		char[] code = letter.toCharArray();
		AndroidKey[] letters = { AndroidKey.A, AndroidKey.B, AndroidKey.C, AndroidKey.D, AndroidKey.E, AndroidKey.F,
				AndroidKey.G, AndroidKey.H, AndroidKey.I, AndroidKey.J, AndroidKey.K, AndroidKey.L, AndroidKey.M,
				AndroidKey.N, AndroidKey.O, AndroidKey.P, AndroidKey.Q, AndroidKey.R, AndroidKey.S, AndroidKey.T,
				AndroidKey.U, AndroidKey.V, AndroidKey.W, AndroidKey.X, AndroidKey.Y, AndroidKey.Z, AndroidKey.DIGIT_0,
				AndroidKey.DIGIT_1, AndroidKey.DIGIT_2, AndroidKey.DIGIT_3, AndroidKey.DIGIT_4, AndroidKey.DIGIT_5,
				AndroidKey.DIGIT_6, AndroidKey.DIGIT_7, AndroidKey.DIGIT_8, AndroidKey.DIGIT_9, AndroidKey.PERIOD };

		while (i < code.length) {
			map.put(code[i], letters[i]);
			i++;
		}
//		输入字符转化成相应键值
		AndroidKey[] result = new AndroidKey[getin.length];
		for (int k = 0; k < getin.length; k++) {
			result[k] = map.get(getin[k]);
		}

		return result;
	}

/**
 * 清除内容
 * 
 * @param webElement
 */
	public void clean(AndroidElement aElement) {
		int length = aElement.getText().length();
		for (int i = 0; i < length; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.DEL));
		}
	}

	/**
	 * 输入
	 * @throws InterruptedException 
	 */
	public void sendkeys(String send){
		for (AndroidKey s : transform_input(send)) {
			driver.pressKey(new KeyEvent(s));
		}

	}

	/**
	 * 点击
	 */
	public void click(AndroidElement element) {
		element.click();
	}

	/**
	 * 
	 * 长按
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
	 * 
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
