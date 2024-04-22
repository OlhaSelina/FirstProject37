package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork4 {
    WebDriver driver;
    @Test
    public void homework4(){


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://demowebshop.tricentis.com/");

        WebElement oneX = driver.findElement(By.xpath("//div[@id='newsletter-subscribe-block']"));
        WebElement twoX = driver.findElement(By.xpath("//a[contains(text(),'My account')]"));
        WebElement threeX = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        WebElement fourX = driver.findElement(By.xpath(" //input[@id='small-searchterms']"));

        driver.navigate().to("https://demowebshop.tricentis.com/jewelry");

        WebElement fiveX = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        WebElement sexX = driver.findElement(By.xpath("//strong[contains(text(),'Categories')]"));
        WebElement sevenX = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
        WebElement eightX = driver.findElement(By.xpath("//select[@id='products-viewmode']"));
        WebElement nineX = driver.findElement(By.xpath(" //strong[contains(text(),'Jewelry')]"));
        WebElement tenX = driver.findElement(By.xpath("//select[@id='products-pagesize']"));

        WebElement css1 = driver.findElement(By.cssSelector("input#small-searchterms[type='text']"));
        WebElement css2 = driver.findElement(By.cssSelector("[href='/tricentis']"));

        driver.navigate().to("https://demowebshop.tricentis.com/");
        WebElement css3 = driver.findElement(By.cssSelector("[class=\"search-box\"]"));
        WebElement css4 = driver.findElement(By.cssSelector("#pollanswers-2"));
        WebElement css5 = driver.findElement(By.cssSelector("#nivo-slider"));
        WebElement css6 = driver.findElement(By.cssSelector(" [href=\"/producttag/all\"]"));
        WebElement css7 = driver.findElement(By.cssSelector("#vote-poll-1"));
        WebElement css8 = driver.findElement(By.cssSelector("#small-searchterms"));
        WebElement css9 = driver.findElement(By.cssSelector("#newsletter-email"));
        WebElement css10 = driver.findElement(By.cssSelector("#pollanswers-3"));

        driver.quit();
    }
}
