package tests.hws.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemHelper extends BaseHelper{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }


    public void clickAddItemToCard() {
        driver.findElement(By.cssSelector("div.item-box:nth-child(3) .buttons input[type='button']")).click();
    }

    public void clickShoppingCart(){
        driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();

    }
    public void closeAllert(){
        driver.findElement(By.xpath("//span[@class='close']"));
    }

}
