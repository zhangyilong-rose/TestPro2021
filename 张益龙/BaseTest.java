package com.example.testxuan;

import android.os.RemoteException;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.Configurator;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseTest {
    static UiDevice mDevice;

    @BeforeClass
    public static  void initDvice() throws InterruptedException, RemoteException, UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }
        mDevice.pressHome();
        Thread.sleep(3000);
        mDevice.findObject(By.text("喧喧")).click();
//        mDevice.click(104,1149);
        Thread.sleep(3000);
    }
    @AfterClass
    public static void exit() throws RemoteException, UiObjectNotFoundException {
        mDevice.pressHome();
        mDevice.pressDelete();
        mDevice.pressRecentApps();
        UiObject app=new UiObject(new UiSelector().resourceId("com.android.systemui:id/task_view_thumbnail"));
        app.swipeRight(5);
    }

}