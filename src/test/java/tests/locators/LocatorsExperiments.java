package tests.locators;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;
import java.util.List;

public class LocatorsExperiments {
    @Test
    public void testLocators1() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        // надо написать задержку для того, чтоб сайт успел загрузиться
        // implicit waiting
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // каждые  секунду проверяет появился ли элемент ( делает в ечении 30 сек пока не появится элемент или не закончится время)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // ждет 30 сек для загрузки страницы

        driver.navigate().to("https://ilcarro.web.app/search");

        // by ID
        WebElement elementCityID = driver.findElement(By.id( "city"));
        System.out.println(elementCityID.getAttribute("type"));

        // by className
        WebElement elementPhoneClass = driver.findElement(By.className("telephone"));
        System.out.println(elementPhoneClass.getText());

        // by LinkText -> full text

        WebElement elementPhoneText = driver.findElement(By.linkText("866-720-5721"));
        System.out.println(elementPhoneText.getAttribute("class"));

        // by tagName
        List<WebElement> listDrives = driver.findElements(By.tagName("div"));
        WebElement firstDiv = listDrives.get(0);
        System.out.println(firstDiv.getAttribute("class"));

        // или можно сразу одной строчкой
        System.out.println(driver.findElements(By.tagName("div")).get(0).getAttribute("class"));

        // partialLinkText  - по части текста
        WebElement elementPhonePartialText = driver.findElement(By.partialLinkText("720-5721"));
        System.out.println(elementPhonePartialText.getAttribute("class"));

        // TODO by Name ( по атрибуту)
       // driver.findElement(By.name("error")); например


        driver.quit();
    }
}
