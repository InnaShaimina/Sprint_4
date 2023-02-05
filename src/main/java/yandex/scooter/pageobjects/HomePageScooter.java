package yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageScooter {
    private WebDriver driver;
    // Кнопка «Заказать»
    private By orderButtonHeader = By.xpath("//button[@class='Button_Button__ra12g']"); //кнопка Заказать в хедере
    public By getOrderButtonHeader(){
        return orderButtonHeader;
    }
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//кнопка Заказать на Главной странице
    public By getOrderButton(){
        return orderButton;
    }
    private By accordeonButton = By.xpath("//div[@id='accordion__heading-0']");
    public By getAccordeonButton(){
        return accordeonButton;
    }
    private By accordeonText = By.xpath("//div[@id='root']//div[@class='Home_FourPart__1uthg']//div[@class='accordion']/div[1]/div[@role='region']");//текст раскрытого аккордеона
    public By getAccordeonText(){
        return accordeonText;
    }
    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }
    //метод, скроллящий страницу к указанному элементу
    public void scrollToElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //метод, пунькающий кнопочку
    public void clickButton(By elementLocator) {
        driver.findElement(elementLocator).click();
    }
    //метод, получающий и возвращающий текст элемента
    public String getElementText(By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }
}
