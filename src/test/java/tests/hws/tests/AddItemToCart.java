package tests.hws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddItemToCart extends BaseTest {

    @BeforeClass
    public void preconditions() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(user);
    }

    @AfterClass
    public  void  methodPostConditions(){
        app.getUserHelper(). clickLogoutBtn();
    }

    @Test
    public void addItemToCart() {
        app.getItemHelper().clickAddItemToCard();
    }
}
