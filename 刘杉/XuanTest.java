package com.example.xuanxuantest;


import android.util.Log;
import android.view.KeyEvent;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Test;

public class XuanTest extends BaseTest{
    //测试收藏
    @Test
    public void test01() throws InterruptedException {
        mDevice.findObject(By.desc("聊天\n聊天\n第 1 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("X\nxsh\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //测试取消收藏
    @Test
    public void test02() throws InterruptedException {
        mDevice.findObject(By.desc("X\nxsh\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);

    }
    //测试向联系人发送消息
    @Test
    public void test03() throws InterruptedException {
        mDevice.findObject(By.desc("聊天\n聊天\n第 1 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("X\nxsh\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(2000);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_1);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //创建讨论组
    @Test
    public void test04() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject(By.desc("创建聊天")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("A\nadmin")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("X\nxsh")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("L\nlzy")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("Z\nzyh")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().className("android.widget.Button").index(2)).click();
        Thread.sleep(3000);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_S,1);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("创建")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //讨论组重命名
    @Test
    public void test05() throws InterruptedException {
        mDevice.findObject(By.desc("群\nA")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("重命名")).click();
        Thread.sleep(2000);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_L,1);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("重命名")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //测试从聊天对话框查看联系人资料
    @Test
    public void test06() throws InterruptedException {
        mDevice.findObject(By.desc("聊天\n聊天\n第 1 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("X\nxsh\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("资料")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);

    }
    //收藏讨论组
    @Test
    public void test07() throws InterruptedException {
        mDevice.findObject(By.desc("讨论组\n讨论组\n第 2 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("群\nL")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //取消收藏讨论组
    @Test
    public void test08() throws InterruptedException {
        mDevice.findObject(By.desc("群\nL")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //测试查看讨论组成员列表
    @Test
    public void test9() throws InterruptedException {
        mDevice.findObject(By.desc("群\nL")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("成员列表")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //从联系人发起聊天
    @Test
    public void test10() throws InterruptedException {
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("X\nxsh\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("开聊")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(2000);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_1);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }


}
