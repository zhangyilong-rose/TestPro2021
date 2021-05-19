package cases;

import base.Assertion;
import base.InitAppium;
import operation.LoginOperate;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Login extends InitAppium {

    private LoginOperate loginOperate;


    @BeforeClass
    public void initDriver(){
        Assert.assertNotNull(driver);

    }

    /**
     * 测试帐号对应错误的密码
     */
    @Test(priority = 0)
    public void login1(){
    	boolean flag = loginOperate.login("http://192.168.80.129:11443","aaa","123321");
    	Assertion.verifyEquals(flag,true,"帐号密码格式不对是否登录成功");
    }

    /**
     * 测试帐号密码长度过长
     */
    @Test(priority = 1)
    public void login2(){
        boolean flag = loginOperate.login("http://192.168.80.129:11443","123456789qazwsxedcrfvtgbyhnujmikqwertyuioasdfghjkl","74128529638596564645656");
        Assertion.verifyEquals(flag,true,"帐号密码格式不对是否登录成功");
    }
    /**
     * 测试帐号密码长度过短
     */
    @Test(priority = 2)
    public void login3(){
        boolean flag = loginOperate.login("http://192.168.80.129:11443","l","1");
        Assertion.verifyEquals(flag,true,"帐号密码格式不对是否登录成功");
    }

    /**
     * 测试帐号密码为中文情况
     */
    @Test(priority = 3)
    public void login4(){
        boolean flag = loginOperate.login("http://192.168.80:11443","帐号","密码");
        Assertion.verifyEquals(flag,true,"帐号密码为中文是否登录成功");
    }



    /**
     * 测试帐号密码为空情况
     */
    @Test(priority = 4)
    public void login5(){
        boolean flag = loginOperate.login("http://192.168.80:11443","","");
        Assertion.verifyEquals(flag,true,"帐号密码为空是否登录成功");
    }


    /**
     * 测试服务器帐号密码正确情况
     */
    @Test(priority = 5)
    public void login6() {
        boolean flag = loginOperate.login("http://192.168.80:11443","aaa","123456");
        Assert.assertTrue(flag,"帐号密码对的情况登录");
    }
    /**
     * 测试帐号不存在
     */
    @Test(priority = 6)
    public void login7() {
        boolean flag = loginOperate.login("http://192.168.80:11443","zzz","123456");
        Assert.assertTrue(flag,"帐号密码对的情况登录");
    }
    
    /**
     * 测试服务器错误
     */
    @Test(priority = 7)
    public void login8() {
        boolean flag = loginOperate.login("http://192.168.80:11111","aaa","123456");
        Assert.assertTrue(flag,"帐号密码对的情况登录");
    }
    
    /**
     * 测试服务器为空
     */
    @Test(priority = 8)
    public void login9() {
        boolean flag = loginOperate.login("","aaa","123456");
        Assert.assertTrue(flag,"帐号密码对的情况登录");
    }
    
    /**
     * 测试服务器输入为中文
     */
    @Test(priority = 9)
    public void login10(){
        boolean flag = loginOperate.login("服务器","aaa","123456");
        Assertion.verifyEquals(flag,true,"帐号密码为空是否登录成功");
    }
}