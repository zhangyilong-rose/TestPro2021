package com.example.myapplication1;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.Configurator;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import junit.framework.TestSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseTest {
    static UiDevice mDevice;

    @BeforeClass
    public static void initDevice() throws RemoteException, UiObjectNotFoundException, InterruptedException {
//获取设备，连接模拟器
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Configurator config = Configurator.getInstance();
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }
        Thread.sleep(3000);

        mDevice.pressHome();
        mDevice.findObject(By.text("喧喧")).click();
        Thread.sleep(4000);
    }

    @Test()
    public void test_createChat() throws UiObjectNotFoundException, InterruptedException {
        UiObject2 button1 = mDevice.findObject(By.desc("创建聊天"));
        button1.click();
        Thread.sleep(2000);
        UiObject2 chatuser1 = mDevice.findObject(By.desc("A\nadmin"));
        chatuser1.click();
        Thread.sleep(2000);
        UiObject confirm = mDevice.findObject(new UiSelector()
                .className("android.widget.Button").index(2));
        confirm.click();
        Thread.sleep(2000);
    }

    @Test
    public void test_discollectchat() throws InterruptedException, UiObjectNotFoundException {
        UiObject2 user1 = mDevice.findObject(By.desc("A\nadmin\n[离线]"));
        user1.click();
        UiObject2 button2 = mDevice.findObject(By.desc("显示菜单"));
        button2.click();
        Thread.sleep(2000);
        UiObject2 collect = mDevice.findObject(By.desc("取消收藏"));
        collect.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }

    @Test
    public void test_collectchat() throws UiObjectNotFoundException, InterruptedException {
        UiObject2 user1 = mDevice.findObject(By.desc("A\nadmin\n[离线]"));
        user1.click();
        Thread.sleep(2000);
        UiObject2 button2 = mDevice.findObject(By.desc("显示菜单"));
        button2.click();
        Thread.sleep(2000);
        UiObject2 button3 = mDevice.findObject(By.desc("收藏"));
        button3.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_serchMess() throws InterruptedException, UiObjectNotFoundException {
        UiObject2 user1 = mDevice.findObject(By.desc("A\nadmin\n[离线]"));
        user1.click();
        Thread.sleep(2000);
        UiObject2 button2 = mDevice.findObject(By.desc("显示菜单"));
        button2.click();
        Thread.sleep(2000);
        UiObject2 button3 = mDevice.findObject(By.desc("资料"));
        button3.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }

    @Test
    public void test_searchbyphoto() throws UiObjectNotFoundException, InterruptedException {
        UiObject2 user1 = mDevice.findObject(By.desc("A\nadmin\n[离线]"));
        user1.click();
        Thread.sleep(2000);
        UiObject2 image = mDevice.findObject(By.desc("A"));
        image.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }

    @Test
    public void test_exSendMess1() throws UiObjectNotFoundException, InterruptedException {
        UiObject2 user1 = mDevice.findObject(By.desc("A\nadmin\n[离线]"));
        user1.click();
        Thread.sleep(2000);
        UiObject2 text = mDevice.findObject(By.desc("test"));
        text.click(3000);
        Thread.sleep(4000);
        UiObject2 exsend = mDevice.findObject(By.desc("转发"));
        exsend.click();
        Thread.sleep(2000);
        UiObject2 user2 = mDevice.findObject(By.desc("李\n李源琪5\n[离线]"));
        user2.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);


    }
    @Test
    public void test_disCollectGroup() throws InterruptedException {
        mDevice.findObject(By.desc("聊天\n聊天\n第 1 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("群\nuitest")).click();
        Thread.sleep(2000);
        UiObject2 button2 = mDevice.findObject(By.desc("显示菜单"));
        button2.click();
        Thread.sleep(2000);
        UiObject2 collect = mDevice.findObject(By.desc("取消收藏"));
        collect.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_CollectGroup() throws UiObjectNotFoundException, InterruptedException {
        mDevice.findObject(By.desc("聊天\n聊天\n第 1 个标签，共 4 个")).click();
        Thread.sleep(2000);
        UiObject2 groups = mDevice.findObject(By.desc("群\nuitest"));
        groups.click();
        Thread.sleep(2000);
        UiObject2 button2 = mDevice.findObject(By.desc("显示菜单"));
        button2.click();
        Thread.sleep(2000);
        UiObject2 button3 = mDevice.findObject(By.desc("收藏"));
        button3.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void searchMember() throws InterruptedException {
        UiObject2 groups = mDevice.findObject(By.desc("群\nuitest"));
        groups.click();
        Thread.sleep(2000);
        UiObject2 button2 = mDevice.findObject(By.desc("显示菜单"));
        button2.click();
        Thread.sleep(2000);
        UiObject2 members = mDevice.findObject(By.desc("成员列表"));
        members.click();
        Thread.sleep(2000);
        UiObject2 member1 = mDevice.findObject(By.desc("李\n李源琪3\n[离线]"));
        member1.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        UiObject2 member2 = mDevice.findObject(By.desc("李\n李源琪4\n[离线]"));
        member2.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_exSendMess2() throws UiObjectNotFoundException, InterruptedException{
        UiObject2 groups = mDevice.findObject(By.desc("群\nuitest"));
        groups.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("hello")).click(2000);
        UiObject2 exsend = mDevice.findObject(By.desc("转发"));
        exsend.click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("李\n李源琪5\n[离线]")).click();
        Thread.sleep(2000);
        UiObject2 button4 = mDevice.findObject(By.desc("返回"));
        button4.click();
        Thread.sleep(2000);

    }
    @Test
    public void test_showList() throws InterruptedException {
        mDevice.findObject(By.desc("我的\n我的\n第 4 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("关于")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("关闭")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_Logout() throws InterruptedException {
        mDevice.findObject(By.desc("我的\n我的\n第 4 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("注销")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("确认")).click();
        Thread.sleep(5000);
        mDevice.findObject(By.desc("登录")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_searchusrsA() throws InterruptedException {
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("A\nadmin\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("开聊")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_searchusrs1() throws InterruptedException {
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("李\n李源琪1\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("开聊")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_searchusrs2() throws InterruptedException {
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("李\n李源琪2\n[在线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_searchusrs3() throws InterruptedException {
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("李\n李源琪3\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("开聊")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_searchusrs4() throws InterruptedException {
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("李\n李源琪4\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("开聊")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test_searchusrs5() throws InterruptedException {
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("李\n李源琪5\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("开聊")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }

    @Test
    public void exitAllApp() throws RemoteException, UiObjectNotFoundException, InterruptedException {

        mDevice.pressBack();
    }



}
