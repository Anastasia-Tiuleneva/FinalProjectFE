package MyPostsTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Authorization.AuthorizationPage;

import java.time.Duration;

public class AbstractTest {

    static WebDriver webDriver;

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));


        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @BeforeEach
    void initMainPage() throws InterruptedException {
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://test-stand.gb.ru/login"),
                "Страница не доступна");
        getWebDriver().findElement(By.cssSelector("input[type=text]")).click();
        getWebDriver().findElement(By.cssSelector("input[type=text]")).sendKeys("tiuleneva");
        getWebDriver().findElement(By.cssSelector("input[type=password]")).click();
        getWebDriver().findElement(By.cssSelector("input[type=password]")).sendKeys("b902d8ce62");
        getWebDriver().findElement(By.cssSelector("button[form=login]")).click();
        Thread.sleep(500);
        Assertions.assertTrue(true);

    }

    @AfterAll
    public static void exit(){

        if(webDriver !=null) webDriver.quit();
    }



    public WebDriver getWebDriver(){
        return this.webDriver;
    }
}
