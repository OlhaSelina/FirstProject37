package tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocatorsCss {
    WebDriver driver;  // объявляем переменную до всех методов

    @BeforeClass  // запустить до начала  тестов ( работает только в классе, в котором это прописали)
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://demowebshop.tricentis.com/");

    }

    @AfterClass // запускает после тестов ( работает только в классе, в котором это прописали)
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testCSS(){
        // by id  == By.id("topcartlink")
        WebElement byID = driver.findElement(By.cssSelector("#topcartlink"));

        // by class == By.className("header-logo")
        WebElement  byClass = driver.findElement(By.cssSelector(".header-logo"));

        //by Name (или с любым аттрибутом)
        // Attibute: in DOM:: attributeName="attributeValue"
        // [attributeName ='attributeValue']
        WebElement byAttrNameAndValue = driver.findElement(By.cssSelector("[type='text/css']"));

        // поиск по частичным значениям аттрибута
        WebElement byAttrName = driver.findElement(By.cssSelector("[type]"));

        WebElement byAttrNameAndPartValue = driver.findElement(By.cssSelector("[type*='t/css']"));

        WebElement byAttrNameAndStartWithInValue = driver.findElement(By.cssSelector("[type^='text/c']"));

        WebElement byAttrNameAndOverWithValue = driver.findElement(By.cssSelector("[type$='ss']"));

        // by tag
        WebElement byTag = driver.findElement(By.cssSelector("div"));

        // by tag and class
        // <tagName class="classValue"> Text </tagName>
        // tagName.classValue

        WebElement byTagAndClassValue = driver.findElement(By.cssSelector("div.header"));

        // by tag and 2 class
        // tagName.classValue1.classValue2
        //TODO пример

        // by tag and id  and class
        // div#flyout-cart.flyout-cart
        WebElement byTagIdValueAndClassValue = driver.findElement(By.cssSelector("div#flyout-cart.flyout-cart"));

        // by tag, id and attribut
        WebElement byTagIdAndAttribut = driver.findElement(By.cssSelector("input#small-searchterms[type='text']"));
    }

}
