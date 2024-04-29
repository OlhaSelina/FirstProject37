package tests.hws.helpers;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class BaseHelper {
    WebDriver driver;
    static Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }


    protected WebElement findElementBase(By by) {
        System.out.println("Locator: findElement: " + by.toString());
        return driver.findElement(by);
    }
    protected void clickBase(By by){
        findElementBase(by).click();
    }
    protected String getTextBaseByLocator(By by) {
        return findElementBase(by).getText().trim();
    }

    protected void typeText(String text, By by) {
        WebElement element = findElementBase(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  String takeScreenshot(){
        logger.info("start screenshot");
        File tmp  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen" + System.currentTimeMillis()
                +".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getPath();
    }

    protected String getTextBaseByElement(WebElement el) {
        return el.getText().trim();
    }
}
