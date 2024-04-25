package tests.hws.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.hws.config.ApplicationManager;


public class BaseTest {
    //static WebDriver driver;
    static ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", Browser.CHROME.browserName()));
    @BeforeSuite
    public static void startBrowser() {
        app.init();
    }

    @AfterSuite
    public static void tearDown() {
        app.quit();
    }

}
