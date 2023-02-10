package yandex.scooter.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseChrome {
    static WebDriver driver;
    //на будущее, разобраться как работать с несколькими браузерами в этом случае, создавать отдельно базовые классы для каждого браузера или есть что то посимпатичнее
    @BeforeClass
    public static void setupApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Before //каждый раз перед началом каждого теста переходим на домашнюю страницу
    public void goToMainPage()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @AfterClass
    public static void closeApplication()
    {
        driver.quit();
    }
}
