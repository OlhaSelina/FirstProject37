package tests.hws.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.hws.dto.UserDTO;
import tests.hws.utils.DataProviders;

import java.util.Random;

public class CreateAccountTest extends BaseTest{
    @AfterMethod
    public void methodPostConditions(){
        app.getUserHelper().clickLogoutBtn();

    }

    @Test
    public void positiveRegistrationTest() {
        Random random = new Random();
        String firstName = "J" + String.valueOf(random.nextInt(10000));
        String lastName = "K" + String.valueOf(random.nextInt(10000));
        String email = "Kdfbg" + String.valueOf(random.nextInt(100) + "@gmaiil.com");
        String password = String.valueOf(random.nextInt(1000000) + "AD@!");
        String confirmPassword = password;

        app.getUserHelper().clickRegisterLink();
        UserDTO userDTO = new UserDTO()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword);
        app.getUserHelper().newRegister(userDTO);
        app.getUserHelper().pause(3000);

        String actualRes = app.getUserHelper().getEmailRegisterLinkText();
        System.out.println(actualRes);
        Assert.assertEquals(actualRes, email);

    }

    @Test(dataProvider = "createNewAccountCSVFile", dataProviderClass = DataProviders.class)

    public void positiveCreateNewAccountCSV(UserDTO userDTO){
        app.getUserHelper().clickRegisterLink();
        app.getUserHelper().newRegister(userDTO);
        app.getUserHelper().pause(2000);

        String actualRes = app.getUserHelper().getEmailRegisterLinkText();
        System.out.println(actualRes);
        Assert.assertEquals(actualRes, userDTO.getEmail());
    }
}
