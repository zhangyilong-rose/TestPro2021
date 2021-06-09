package com.example.xuanxuantest;

import android.app.Instrumentation;
import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;


public class BaseTest {
    public UiDevice mDevice;
    Instrumentation mInstrumentation;
    @Before
    public void starUp() throws RemoteException, InterruptedException {
        mInstrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(mInstrumentation);
        boolean status = mDevice.isScreenOn();
        if (!status) {
            mDevice.wakeUp();
        }
        mDevice.pressHome();
        mDevice.findObject(By.text("喧喧")).click();
        Thread.sleep(2000);
    }

}
