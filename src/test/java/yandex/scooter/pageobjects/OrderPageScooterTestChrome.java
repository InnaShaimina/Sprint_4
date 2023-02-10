package yandex.scooter.pageobjects;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class) //запускаем тест с параметрами
public class OrderPageScooterTestChrome extends TestBaseChrome{
    //ниже объявляем все поля, которые потом будем параметризировать
    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String dateOfOrderArrival;
    private final String longivityOfOrderArrival;
    //создаем конструктор, в котором указываем все параметризириуемые поля
    public OrderPageScooterTestChrome(String name, String surname, String address, String subwayStation, String phoneNumber, String dateOfOrderArrival, String longivityOfOrderArrival)
    {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.dateOfOrderArrival = dateOfOrderArrival;
        this.longivityOfOrderArrival = longivityOfOrderArrival;
    }
    //собственно параметризированные тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                { "Инна", "Шаймина", "Петербург","Черкизовская","89098887766","05.02.2023","сутки"},
                { "Иван", "Иванов", "Хабаровск","Сокольники","89098889988","08.02.2023","двое суток"},
        };
    }
    //positive тест, проверяющий заказ через кнопку на Главной (Chrome)
    @Test
    public void orderPageScooterButtonMainPositiveTestChrome() {
        HomePageScooter objLoginPage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objLoginPage.scrollToElement(objLoginPage.getOrderButton());
        objLoginPage.clickButton(objLoginPage.getOrderButton());
        objOrderPage.waitForOrderPageScooterData();
        String pageHeader = objOrderPage.getElementText(objOrderPage.getPageHeader());
        MatcherAssert.assertThat(pageHeader, is ("Для кого самокат"));
        objOrderPage.setSimpleInputField(objOrderPage.getNameField(), name);
        String nameField = objOrderPage.getFieldValue();
        MatcherAssert.assertThat(nameField, is (name));
        objOrderPage.setSimpleInputField(objOrderPage.getSurnameField(), surname);
        objOrderPage.setSimpleInputField(objOrderPage.getAddressField(), address);
        objOrderPage.setSelectInputField(objOrderPage.getSubwayStationField(), subwayStation);
        objOrderPage.setSimpleInputField(objOrderPage.getPhoneField(), phoneNumber);
        objLoginPage.clickButton(objOrderPage.getNextButton());
        String nextPageHeader = objOrderPage.getElementText(objOrderPage.getPageHeader());
        MatcherAssert.assertThat(nextPageHeader, is ("Про аренду"));
        objOrderPage.setSimpleInputField(objOrderPage.getDateOfOrderArrivalField(), dateOfOrderArrival);
        objOrderPage.setSelectInputField(objOrderPage.getLongivityOfOrderField(), longivityOfOrderArrival);
        objLoginPage.clickButton(objOrderPage.getScooterColorField());
        objLoginPage.clickButton(objOrderPage.getNextButton());
        objLoginPage.clickButton(objOrderPage.getYesOrderButton());
        String modalWindowHeader = objOrderPage.getElementText(objOrderPage.getModalWindowHeader());
        //проверяем, что в результате отобразилось окно с сообщением о успешном оформлении заказа
        MatcherAssert.assertThat(modalWindowHeader, containsString ("Заказ оформлен"));
    }
    //positive тест, проверяющий заказ через кнопку в хедере Chrome
    @Test
    public void orderPageScooterButtonHeaderPositiveTestChrome() {
        HomePageScooter objLoginPage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objLoginPage.clickButton(objLoginPage.getOrderButtonHeader());
        objOrderPage.waitForOrderPageScooterData();
        String pageHeader = objOrderPage.getElementText(objOrderPage.getPageHeader());
        MatcherAssert.assertThat(pageHeader, is ("Для кого самокат"));
        objOrderPage.setSimpleInputField(objOrderPage.getNameField(), name);
        String nameField = objOrderPage.getFieldValue();
        MatcherAssert.assertThat(nameField, is (name));
        objOrderPage.setSimpleInputField(objOrderPage.getSurnameField(), surname);
        objOrderPage.setSimpleInputField(objOrderPage.getAddressField(), address);
        objOrderPage.setSelectInputField(objOrderPage.getSubwayStationField(), subwayStation);
        objOrderPage.setSimpleInputField(objOrderPage.getPhoneField(), phoneNumber);
        objLoginPage.clickButton(objOrderPage.getNextButton());
        String nextPageHeader = objOrderPage.getElementText(objOrderPage.getPageHeader());
        MatcherAssert.assertThat(nextPageHeader, is ("Про аренду"));
        objOrderPage.setSimpleInputField(objOrderPage.getDateOfOrderArrivalField(), dateOfOrderArrival);
        objOrderPage.setSelectInputField(objOrderPage.getLongivityOfOrderField(), longivityOfOrderArrival);
        objLoginPage.clickButton(objOrderPage.getScooterColorField());
        objLoginPage.clickButton(objOrderPage.getNextButton());
        objLoginPage.clickButton(objOrderPage.getYesOrderButton());
        String modalWindowHeader = objOrderPage.getElementText(objOrderPage.getModalWindowHeader());
        //проверяем, что в результате отобразилось окно с сообщением о успешном оформлении заказа
        MatcherAssert.assertThat(modalWindowHeader, containsString ("Заказ оформлен"));
    }
}