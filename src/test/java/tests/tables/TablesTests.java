package tests.tables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
public class TablesTests {
    static WebDriver driver;

    @BeforeSuite
    public static void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void tablePositiveTest() {
        // return table
        // //table[@id='customers']

        //return Canada
        // xpath: //table[@id='customers']//tr[8]//td[3]
        // css selectors:
        // tr:nth-child(8) td:nth-child(3)
        //tr:nth-child(8) td:last-child -> Canada

        WebElement canadaRow = driver.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        System.out.println(canadaRow.getText());

        // xpath: //table[@id='customers']//tr[4]//td
        // css selector: 4 tr: tr:nth-child(4) td    all td

        List<WebElement> allColumnsInOneRow = driver.findElements(By.cssSelector("tr:nth-child(4) td"));

        for(WebElement el : allColumnsInOneRow) {
            System.out.println(el.getText());
        }

    }
}
