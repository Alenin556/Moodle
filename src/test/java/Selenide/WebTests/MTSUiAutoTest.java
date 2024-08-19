package Selenide.WebTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.MTSMainPAge.MtsMainPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static pages.MTSMainPAge.MtsMainPage.*;

public class MTSUiAutoTest extends BaseDriverSetup{

    @BeforeAll
    public static void preconditions() throws InterruptedException {
        open("https://www.mts.by/");
        acceptCookies();
        scrollToTestSection();
    }


    //TODO 1)Проверить название указанного блока;
    @Test
    public void onlinePaymentLabelTest() throws InterruptedException {
        String onlinePaymentLabel = onlinePayment.getText();
        String expctLabel = "Онлайн пополнение\nбез комиссии";
        Assertions.assertEquals(expctLabel,onlinePaymentLabel);
    }

    //TODO 2)Проверить наличие логотипов платёжных систем;
    @Test
    public void onlinePaymentLogosTest() throws InterruptedException {
        Integer countPartners = getPartnersCount();

        Assertions.assertEquals(5,countPartners);
    }

    //TODO 3)Проверить работу ссылки «Подробнее о сервисе»;;
    @Test
    public void onlinePaymentInfoLinkTest(){
        paymentInfoLink.click();
        String infoExpUrl ="https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assertions.assertEquals(infoExpUrl, url());
    }

    //TODO
    // 4)Заполнить поля и проверить работу кнопки «Продолжить»
    // (проверяем только вариант «Услуги связи», номер для теста 297777777)
    @Test
    public void onlinePaymentSectionTest(){
        String number = " 297777777";
        String header = "Услуги связи";
        Assertions.assertEquals(header,getPaymentHeader());

        numberInputField.shouldBe(Condition.exist, Duration.ofSeconds(2)).sendKeys(number);
        transferSumInputField.shouldBe(Condition.exist, Duration.ofSeconds(2)).sendKeys("100");
        emailReportInputField.shouldBe(Condition.exist, Duration.ofSeconds(2)).sendKeys("test@gmail.com");

        submitButton.shouldBe(Condition.enabled,Duration.ofSeconds(3)).click();

    }
}
