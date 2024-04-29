package tests.hws.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
        app.getItemHelper().pause(1500);
        app.getItemHelper().closeAllert();
        app.getItemHelper().pause(2000);
        app.getItemHelper().clickShoppingCart();


        Assert.assertEquals(
                app.getDriver().findElement(
                        By.xpath("//a[@class='product-name']")).getText().trim(), "14.1-inch Laptop");

    }
}
