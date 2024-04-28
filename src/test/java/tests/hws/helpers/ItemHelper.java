package tests.hws.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void clickAddItemToCard() {
        driver.findElement(By.cssSelector("div.item-box:nth-child(3) .buttons input[type='button']")).click();
    }
}
