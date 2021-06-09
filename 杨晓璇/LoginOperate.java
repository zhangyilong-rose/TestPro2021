package operation;



import base.OperateAppium;
import pages.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class LoginOperate extends OperateAppium {


	private LoginPage loginPage;

    AndroidDriver<AndroidElement> driver;

    public LoginOperate(AndroidDriver<AndroidElement> driver2){
        super(driver2);
        loginPage = new LoginPage(driver2);
        this.driver = driver2;
    }

    /**
     * �����ʺ�����
     * @param name �ʺ�
     * @param pass ����
     * @return �Ƿ�ɹ���¼����ҳ
     */
    public AndroidElement button() {
		AndroidElement bu = driver.findElementByClassName("android.widget.Button");
		return bu;
		
	}
    public boolean login(String server,String name,String pass){

        sleep(1000);
        inputManyText(server,name,pass);
        clickElement(button());
        return loginPage.getIndexflag();
    }


}

