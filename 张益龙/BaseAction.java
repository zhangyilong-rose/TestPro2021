package com.example.testxuan;

import android.view.KeyEvent;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

public class BaseAction {
    static UiDevice mDevice;
    public void click(UiObject2 element){
        element.click();
    }
    public void clear(String text){
        int len=text.length();
        while (len>0){
            mDevice.pressKeyCode(KeyEvent.KEYCODE_BACK);
            len--;
        }
    }
    public void type(UiObject2 element,String context){
        element.click();
        clear(context);
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
            } if (String.valueOf(message[i]).equals("h")){
                mDevice.pressKeyCode(KeyEvent.KEYCODE_H);
            } if (String.valueOf(message[i]).equals("i")){
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
