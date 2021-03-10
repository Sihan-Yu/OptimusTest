package login;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests{
    @Test
    public void testSuccessfulLogin(){
        String actualUrl = "https://10.199.28.206:44332/Optimus/Home/Index#/";
        String expectUrl = dashboardPage.getDashboardUrl();
        assertEquals(expectUrl, actualUrl);
    }
}
