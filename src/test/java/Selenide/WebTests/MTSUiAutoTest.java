package Selenide.WebTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.MTSMainPAge.MtsMainPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;
import static pages.MTSMainPAge.MtsMainPage.*;

public class MTSUiAutoTest extends BaseDriverSetup{

    MtsMainPage mtsMainPage = new MtsMainPage();

    @BeforeEach
    public void preconditions() throws InterruptedException {
        open("https://www.mts.by/");
        mtsMainPage.acceptCookies();
        mtsMainPage.scrollToTestSection();
    }

    @AfterEach
    public void teardown(){
        Selenide.closeWebDriver();
    }


    //TODO 1)Проверить название указанного блока;
    @Test
    public void onlinePaymentLabelTest(){
        String onlinePaymentLabel = mtsMainPage.onlinePayment.getText();
        String expctLabel = "Онлайн пополнение\nбез комиссии";
        Assertions.assertEquals(expctLabel,onlinePaymentLabel);
    }

    //TODO 2)Проверить наличие логотипов платёжных систем;
    @Test
    public void onlinePaymentLogosTest(){
        Integer countPartners = mtsMainPage.getPartnersCount();

        Assertions.assertEquals(5,countPartners);
    }

    //TODO 3)Проверить работу ссылки «Подробнее о сервисе»;;
    @Test
    public void onlinePaymentInfoLinkTest(){
        mtsMainPage.paymentInfoLink.click();
        String infoExpUrl ="https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String url = url();

        Assertions.assertEquals(infoExpUrl,url);
    }

    //TODO
    // 4)Заполнить поля и проверить работу кнопки «Продолжить»
    // (проверяем только вариант «Услуги связи», номер для теста 297777777)
    @Test
    public void onlinePaymentSectionTest(){
        String number = "(29)777-77-77";
        String count = "100";
        String email = "test@gmail.com";
        String header = "Услуги связи";

        Assertions.assertEquals(header,mtsMainPage.getPaymentHeader());

        mtsMainPage.inputTextIntoNumberField(number);
        mtsMainPage.inputTextIntoTransferField(count);
        mtsMainPage.inputTextIntoEmailField(email);
        mtsMainPage.submitPayment();

        String numberField = mtsMainPage.numberInputField.getValue();
        String transferField = mtsMainPage.transferSumInputField.getValue();
        String emailField = mtsMainPage.emailReportInputField.getValue();

        Assertions.assertEquals(number,numberField);
        Assertions.assertEquals(count,transferField);
        Assertions.assertEquals(email,emailField);
    }
}
