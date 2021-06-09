package com.example.testxuan;

import android.text.method.Touch;
import android.util.Log;
import android.view.KeyEvent;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiCollection;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;


import org.junit.Test;

import java.security.Key;
import java.util.Random;

public class XuanTest extends BaseTest {
    @Test //检测喧喧聊天功能------群发
    public void test01() throws InterruptedException {
        String message=genRandomNum(6);
        mDevice.findObject(By.desc("系统\n所有人")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(3000);
        type(message);
        Thread.sleep(3000);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
    }
    @Test //检测喧喧聊天功能-------单用户聊天选项发起聊天
    public void test02() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.desc("聊天\n聊天\n第 1 个标签，共 4 个")).click();
        String message=genRandomNum(6);
        mDevice.findObject(By.desc("A\nadmin\n[离线]")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(3000);
        type(message);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
    }
    //通过+发起聊天----单用户
    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.desc("聊天\n聊天\n第 1 个标签，共 4 个")).click();
        String message=genRandomNum(5);
        mDevice.findObjects(By.clazz("android.widget.Button")).get(0).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("A\nadmin")).click();
        Thread.sleep(2000);
        mDevice.findObjects(By.clazz("android.widget.Button")).get(1).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(2000);
        type(message);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //通过+发起聊天---双用户----创建群聊
    //@Test
    public void test04() throws InterruptedException {
        String message=genRandomNum(5);
        mDevice.findObjects(By.clazz("android.widget.Button")).get(0).click();
        Thread.sleep(3000);
        mDevice.findObject(By.desc("A\nadmin")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("娇\n娇")).click();
        mDevice.findObjects(By.clazz("android.widget.Button")).get(1).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("输入讨论组名称")).click();
        type(message);
        mDevice.findObject(By.desc("创建")).click();
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(2000);
        type(message);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.desc("返回")).click();
    }
    //收藏取消好友
    @Test
    public void test05() throws InterruptedException {
        mDevice.findObject(By.desc("A\nadmin\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
    }
    //查看个人信息
    @Test
    public void test06() throws InterruptedException {
        Thread.sleep(3000);
        mDevice.findObject(By.desc("我的\n我的\n第 4 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("张\n张益龙\n  @zyl\nhttp://10.7.90.215:11443")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.desc("返回")).click();
        Thread.sleep(2000);
    }
    //收藏取消收藏-----群聊
    @Test
    public void test07() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.desc("讨论组\n讨论组\n第 2 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("群\n生活群")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("取消收藏")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();

    }
    //查看成员列表
    @Test
    public void test08() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.desc("讨论组\n讨论组\n第 2 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("群\n生活群")).click();
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
    //群聊重命名
    @Test
    public void test09() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.desc("讨论组\n讨论组\n第 2 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("群\n工作群")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("显示菜单")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("重命名")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("工作群, 工作群")).click();
       //删除输入框中原有的字符
        Thread.sleep(2000);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_DEL);
        Thread.sleep(2000);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_DEL);
        Thread.sleep(2000);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_DEL);
        Thread.sleep(2000);
        type("talk1");
        Thread.sleep(2000);
        mDevice.findObject(By.desc("重命名")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
    }
    //输入框-----复制+转发+撤回
    @Test
    public void test10() throws InterruptedException {
        Thread.sleep(2000);
        String message=genRandomNum(5);
        mDevice.findObject(By.desc("系统\n所有人")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(2000);
        type(message);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc(message)).click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("复制")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("发送消息")).click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("粘贴")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc(message)).click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("撤回")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.desc(message)).click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.desc("转发")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("A\nadmin\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
    }
    //通过联系人发起对话
    @Test
    public void test11() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.desc("联系人\n联系人\n第 3 个标签，共 4 个")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("A\nadmin\n[离线]")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("开聊")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("发送消息")).click();
        Thread.sleep(2000);
        type(genRandomNum(5));
        Thread.sleep(2000);
        mDevice.findObject(By.desc("发送")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.desc("返回")).click();
    }
    //生成随机字符串
    public  String genRandomNum(int pwd_len) {
        final int maxNum = 50;
        int i;
        int count = 0;
        char[] str = { 'a', 'b', 'c',  'd',  'e', 'f' ,'g',  'h',  'i',  'j',  'k',  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',  'z',  '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            i = Math.abs(r.nextInt(maxNum));

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }
    public void type(String context){
        //字符串分割匹配
        char[] message=context.toCharArray();
        int length=message.length;
        for (int i=0;i<length;i++){
            if (String.valueOf(message[i]).equals("0")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_0);
            } if (String.valueOf(message[i]).equals("1")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_1);
            } if (String.valueOf(message[i]).equals("2")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_2);
            } if (String.valueOf(message[i]).equals("3")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_3);
            } if (String.valueOf(message[i]).equals("4")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_4);
            } if (String.valueOf(message[i]).equals("5")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_5);
            } if (String.valueOf(message[i]).equals("6")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_6);
            } if (String.valueOf(message[i]).equals("7")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_7);
            } if (String.valueOf(message[i]).equals("8")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_8);
            } if (String.valueOf(message[i]).equals("9")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_9);
            } if (String.valueOf(message[i]).equals("a")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_A);
            } if (String.valueOf(message[i]).equals("b")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_B);
            } if (String.valueOf(message[i]).equals("c")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_C);
            } if (String.valueOf(message[i]).equals("d")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_D);
            } if (String.valueOf(message[i]).equals("e")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_E);
            } if (String.valueOf(message[i]).equals("f")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_F);
            } if (String.valueOf(message[i]).equals("g")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_G);
            }if (String.valueOf(message[i]).equals("h")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_H);
            }if (String.valueOf(message[i]).equals("i")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_I);
            } if (String.valueOf(message[i]).equals("j")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_J);
            } if (String.valueOf(message[i]).equals("k")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_K);
            } if (String.valueOf(message[i]).equals("l")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_L);
            } if (String.valueOf(message[i]).equals("m")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_M);
            } if (String.valueOf(message[i]).equals("n")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_N);
            } if (String.valueOf(message[i]).equals("o")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_O);
            } if (String.valueOf(message[i]).equals("p")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_P);
            } if (String.valueOf(message[i]).equals("q")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_Q);
            } if (String.valueOf(message[i]).equals("r")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_R);
            } if (String.valueOf(message[i]).equals("s")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_S);
            } if (String.valueOf(message[i]).equals("t")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_T);
            } if (String.valueOf(message[i]).equals("u")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_U);
            } if (String.valueOf(message[i]).equals("v")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_V);
            } if (String.valueOf(message[i]).equals("w")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_W);
            } if (String.valueOf(message[i]).equals("x")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_X);
            } if (String.valueOf(message[i]).equals("y")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_Y);
            } if (String.valueOf(message[i]).equals("z")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_Z);
            }
        }
    }

}
