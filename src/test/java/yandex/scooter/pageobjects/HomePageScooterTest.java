package yandex.scooter.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;

public class HomePageScooterTest {
    WebDriver driver;
    // тест аккордеона в Chrome
    @Test
    public void clickAccordeonButtonChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objLoginPage = new HomePageScooter(driver);
        objLoginPage.scrollToElement(objLoginPage.getAccordeonButton());
        objLoginPage.clickButton(objLoginPage.getAccordeonButton());
        String accordeonText = objLoginPage.getElementText(objLoginPage.getAccordeonText());
        MatcherAssert.assertThat(accordeonText, is ("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
    }

    // тест аккордеона в Firefox
    @Test
    public void clickAccordeonButtonFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objLoginPage = new HomePageScooter(driver);
        objLoginPage.scrollToElement(objLoginPage.getAccordeonButton());
        objLoginPage.clickButton(objLoginPage.getAccordeonButton());
        String accordeonText = objLoginPage.getElementText(objLoginPage.getAccordeonText());
        MatcherAssert.assertThat(accordeonText, is ("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
    }

    @After
    public void teardown() {
        // Закрываем браузер после каждого теста
        driver.quit();
    }
}