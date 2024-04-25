package tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class StartProjectTest {
    @Test   //называется анотация
    public void openGooglePage() {
        //WebDriver driver = new ChromeDriver(); запуск для Хрома
        //WebDriver driver = new FirefoxDriver();  // запуск для Фаерфокс

        ChromeOptions chromeOptions = new ChromeOptions(); //--------- запуск через Вебдрайвер
        chromeOptions.addArguments("--lang=en"); // открывать страницу на английском
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        //--------- ----------  самый лучший вариант for Chrome

        /* FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("intl.accept_languages", "en");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(firefoxOptions);*/
        //_------------------------------ for   Firefox

        driver.navigate().to("https://www.google.com/");
        System.out.println("we open google");

        try {   //только для дебага такое пишут, но не в проекте автотеста
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // WebElement element = driver.findElement(By.xpath("//img[@alt='Google']"));  только для первого элемента
        List <WebElement> elements = driver.findElements(By.xpath("//img[@alt='Google']")); // получение списка елементов которые ищем

        //----- работа со стрелками в браузере влевом верхнем углу
       // driver.navigate().refresh();
      //  driver.navigate().forward();
      //  driver.navigate().back();

       String url =  driver.getCurrentUrl(); // получить текущий url
        System.out.println(url);


        Assert.assertFalse(elements.isEmpty());  //проверяем , что список не пустой
       // Assert.assertTrue(elements.size()>0);
       // Assert.assertTrue(!elements.isEmpty());
        // - все три асерта проверяют одно и тоже



        driver.quit(); // закрывает браузер и чистит куки
    }
}
