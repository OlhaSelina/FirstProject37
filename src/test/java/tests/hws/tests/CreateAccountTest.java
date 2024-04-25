package tests.hws.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.hws.dto.UserDTO;

public class CreateAccountTest extends BaseTest{
    @AfterMethod
    public void methodPostConditions(){
        app.getUserHelper().clickLogoutBtn();
    }

    @Test
    public void positiveRegistrationTest() {
        app.getUserHelper().clickRegisterLink();
        UserDTO userDTO = new UserDTO()
                .setFirstName("siuhfouwhe")
                .setLastName("sgfr")
                .setEmail("3sdkfjkj@kdsfj.com")
                .setPassword("123456Aa$")
                .setConfirmPassword("123456Aa$");
        app.getUserHelper().newRegister(userDTO);
        app.getUserHelper().pause(3000);

        String actualRes = app.getUserHelper().getEmailRegisterLinkText();
        System.out.println(actualRes);
        Assert.assertEquals(actualRes, "3sdkfjkj@kdsfj.com");
    }
}
