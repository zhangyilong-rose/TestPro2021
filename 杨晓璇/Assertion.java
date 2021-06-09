package base;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LITP on 2016/9/21.
 */

public class Assertion {


    public static boolean flag = true;                      //�Ƿ��д���

    public static List<Error> errors = new ArrayList<>();    //���󼯺�

    /**
     * ��ֵ֤�Ƿ����
     * @param actual ��һ��ֵ
     * @param expected Ҫ�Աȵ�ֵ
     */
    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }


    /**
     * ��ֵ֤�Ƿ����
     * @param actual ��һ��ֵ
     * @param expected Ҫ�Աȵ�ֵ
     * @param message ����ʱ�����ʾ��Ϣ
     */
    public static void verifyEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }
}