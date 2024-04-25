package tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeworkDemowebshop {
    @Test
    public  void demowebshopTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.navigate().to("https://demowebshop.tricentis.com");

        WebElement elementNotificationsID = driver.findElement(By.id( "dialog-notifications-success"));
        System.out.println(elementNotificationsID.getAttribute("title"));

        driver.navigate().to("https://demowebshop.tricentis.com/jewelry");

        System.out.println(driver.findElement(By.xpath("//select[@id='products-orderby']")).getAttribute("name"));

        driver.navigate().to("https://demowebshop.tricentis.com/apparel-shoes");
        System.out.println(driver.findElement(By.linkText("Custom T-Shirt")).getAttribute("href"));

        driver.quit();
    }
}
