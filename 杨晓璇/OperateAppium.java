package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import static io.appium.java_client.android.AndroidKeyCode.BACKSPACE;
import static io.appium.java_client.android.AndroidKeyCode.KEYCODE_MOVE_END;


public class OperateAppium {

	public AndroidDriver<AndroidElement> driver;

    TouchAction touchAction;

    MultiTouchAction multiTouchAction;
;


    public OperateAppium(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }


    /**
	 * ��λ
	 * @param index
	 * @return
	 */
	public MobileElement getElementByIndex(int index){
		return driver.findElementByAndroidUIAutomator("new UiSelector().index("+index+")");
	}
	/**
	 * ���
	 * @param by
	 */
	public void clickElement(By by) {
		driver.findElement(by).click();
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	/**
	 *���� 
	 * @param by
	 * @param value
	 */
	public void input(By by,String value) {
		driver.findElement(by).click();
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	public void input(WebElement element,String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
	}
	
	/**
	 * ����Ԫ��
	 * @param element
	 */
	public void longPressElement(WebElement element) {
		TouchAction action = new TouchAction(driver);
		action.longPress(element);
		action.perform();
	}
	
	/**
     * ��������
     *
     * @param x
     * @param y
     */
	public void longPressElement(int x,int y) {
		TouchAction action = new TouchAction(driver);
		action.longPress(x,y);
		action.perform();
	}
	/**
	 *���ϻ���
	 */
	public void slideUp() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 2, y / 3 * 2, x / 2, y / 3 * 1, 1000);
	}
	
	/**
	 * ���»���
	 */
	public void slideDown() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 2, y / 3 * 2, x / 2, y / 3 * 2, 1000);
	}
	
	/**
	 * ���󻬶�
	 */
	public void slideLeft() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 6*5, y /2, x / 6*1, y / 2, 1000);
	}
	
	/**
	 * ���һ���
	 */
	public void slideRight() {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x / 4*1, y /2, x / 4*3, y / 2, 1000);
	}


    /**
     * ��������
     *
     * @param s
     */
    public void sleep(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ����ʵ��
     *
     * @return
     */
    public TouchAction getTouch() {
        if (touchAction == null) {
                return new TouchAction(driver);
            } else {
                return touchAction;
            }

    }


    /**
     * ��ȡ��㴥��ʵ��
     *
     * @return
     */
    public MultiTouchAction getMultiTouch() {
        if (multiTouchAction == null) {
        	return new MultiTouchAction(driver);
        } else {
            return multiTouchAction;
        }
    }

    /**
     * ������EditText��������
     *
     * @param str
     */
    public void inputManyText(String... str) {
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        for (int i = 0; i < str.length; i++) {
            textFieldsList.get(i).click();
            clearText(textFieldsList.get(i)); 
            textFieldsList.get(i).sendKeys(str[i]);
        }
    }


    /**
     * ���ĳ������
     *
     * @param x
     * @param y
     */
    public void press(int x, int y) {
    	driver.tap(1, x, y, 500);
      getTouch().tap(x, y).perform();
    }

    /**
     * ����ɾ��
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