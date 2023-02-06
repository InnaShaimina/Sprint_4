package yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageScooter {
    private WebDriver driver;
    private By pageHeader = By.xpath("//div[@class='Order_Header__BZXOb']"); //заголовок страницы
    public By getPageHeader(){
        return pageHeader;
    }
    private By modalWindowHeader = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']"); //заголовок модального окна
    public By getModalWindowHeader(){
        return modalWindowHeader;
    }
    private By nameField = By.xpath("//input[@placeholder='* Имя']"); //поле ввода имени
    public By getNameField(){
        return nameField;
    }
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']"); //поле ввода фамилии
    public By getSurnameField(){
        return surnameField;
    }
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); //поле ввода адреса
    public By getAddressField(){
        return addressField;
    }
    private By subwayStationField = By.xpath("//input[@placeholder='* Станция метро']"); // поле ввода станции метро
    public By getSubwayStationField(){
        return subwayStationField;
    }
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); //поле ввода телефона
    public By getPhoneField(){
        return phoneField;
    }
    private By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // кнопки "Далее" и "Заказать"
    public By getNextButton(){
        return nextButton;
    }
    private By yesOrderButton = By.xpath("//button[contains(text(),'Да')]");
    public By getYesOrderButton(){
        return yesOrderButton;
    }
    private By  dateOfOrderArrivalField= By.xpath("//input[@placeholder='* Когда привезти самокат']");// поле ввода даты заказа
    public By getDateOfOrderArrivalField(){
        return dateOfOrderArrivalField;
    }
    private By longivityOfOrderField = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]");//поле ввода продолжительности срока аренды
    public By getLongivityOfOrderField(){
        return longivityOfOrderField;
    }
    private By scooterColorField = By.xpath("/html//input[@id='grey']"); // выбор радиокнопки
    public By getScooterColorField(){
        return scooterColorField;
    }
    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
    }
    //метод, получающий и возвращающий текст элемента
    public String getElementText(By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }
    //метод, устанавливающий значение для простых инпутов
    public void setSimpleInputField(By elementLocator, String textValue) {
        driver.findElement(elementLocator).sendKeys(textValue);
    }
    //метод, получающий и возвращающий value элемента
    public String getFieldValue() {
        return driver.findElement(nameField).getAttribute("value");
    }
    //метод, выбирающий значение из дропдауна
    public void setSelectInputField(By elementLocator, String listValue) {
        driver.findElement(elementLocator).click();
        String stationLocator = "//*[text()='" + listValue + "']";
        driver.findElement(By.xpath(stationLocator)).click();
    }
    //метод задающий ожидание до загрузки заголовка страницы
    public void waitForOrderPageScooterData() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(pageHeader).getText() != null
                && !driver.findElement(pageHeader).getText().isEmpty()
        ));
    }
}
