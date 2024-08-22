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
        Selenide.clearBrowserCookies();
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

        mtsMainPage.inputTextIntoNumberField(mtsMainPage.phoneNumberInputField,number);
        mtsMainPage.inputTextIntoTransferField(count);
        mtsMainPage.inputTextIntoEmailField(email);

        String numberField = mtsMainPage.phoneNumberInputField.getValue();
        String transferField = mtsMainPage.transferSumInputField.getValue();
        String emailField = mtsMainPage.emailReportInputField.getValue();

        Assertions.assertEquals(number,numberField);
        Assertions.assertEquals(count,transferField);
        Assertions.assertEquals(email,emailField);
    }

    @Test
    public void checkFieldsTextPaymentSectionConnectionServicePaymentTest(){

        String header = "Услуги связи";
        Assertions.assertEquals(header,mtsMainPage.getPaymentHeader());

        String number = "Номер телефона";
        String count = "Сумма";
        String email = "E-mail для отправки чека";

        String numberField = mtsMainPage.phoneNumberInputField.getAttribute("placeHolder");
        String transferField = mtsMainPage.transferSumInputField.getAttribute("placeHolder");
        String emailField = mtsMainPage.emailReportInputField.getAttribute("placeHolder");

        Assertions.assertEquals(number,numberField);
        Assertions.assertEquals(count,transferField);
        Assertions.assertEquals(email,emailField);
    }

    @Test
    public void checkFieldsTextPaymentSectionHomeInternetPaymentTest() throws InterruptedException {

        String header = "Домашний интернет";
        mtsMainPage.selectHeader(header);
        Assertions.assertEquals(header,mtsMainPage.getPaymentHeader());

        String number = "Номер абонента";
        String count = "Сумма";
        String email = "E-mail для отправки чека";

        String numberField = mtsMainPage.internetPhoneNumberInputField.getAttribute("placeHolder");
        String transferField = mtsMainPage.transferSumInputField.getAttribute("placeHolder");
        String emailField = mtsMainPage.emailReportInputField.getAttribute("placeHolder");

        Assertions.assertEquals(number,numberField);
        Assertions.assertEquals(count,transferField);
        Assertions.assertEquals(email,emailField);
    }

    @Test
    public void checkFieldsTextPaymentSectionCreditPaymentTest() throws InterruptedException {

        String header = "Рассрочка";
        mtsMainPage.selectHeader(header);
        Assertions.assertEquals(header,mtsMainPage.getPaymentHeader());

        String number = "Номер счета на 44";
        String count = "Сумма";
        String email = "E-mail для отправки чека";

        String numberField = mtsMainPage.creditScoreInputField.getAttribute("placeHolder");
        String transferField = mtsMainPage.transferSumInputField.getAttribute("placeHolder");
        String emailField = mtsMainPage.emailReportInputField.getAttribute("placeHolder");

        Assertions.assertEquals(number,numberField);
        Assertions.assertEquals(count,transferField);
        Assertions.assertEquals(email,emailField);
    }

    @Test
    public void checkFieldsTextPaymentSectionArrearsPaymentTest() throws InterruptedException {

        String header = "Задолженность";
        mtsMainPage.selectHeader(header);
        Assertions.assertEquals(header,mtsMainPage.getPaymentHeader());

        String number = "Номер счета на 2073";
        String count = "Сумма";
        String email = "E-mail для отправки чека";

        String numberField = mtsMainPage.arrearsScoreInputField.getAttribute("placeHolder");
        String transferField = mtsMainPage.transferSumInputField.getAttribute("placeHolder");
        String emailField = mtsMainPage.emailReportInputField.getAttribute("placeHolder");

        Assertions.assertEquals(number,numberField);
        Assertions.assertEquals(count,transferField);
        Assertions.assertEquals(email,emailField);
    }

    @Test
    public void onlinePaymentTest(){
        String number = "(29)777-77-77";
        String count = "100";
        String email = "test@gmail.com";
        String header = "Услуги связи";

        Assertions.assertEquals(header,mtsMainPage.getPaymentHeader());

        mtsMainPage.inputTextIntoNumberField(mtsMainPage.phoneNumberInputField,number);
        mtsMainPage.inputTextIntoTransferField(count);
        mtsMainPage.inputTextIntoEmailField(email);
        mtsMainPage.submitPayment();

        String expectedTranferSum = "100 ?";
        String actualLabelText = mtsMainPage.transferCountLabelSum.shouldBe(Condition.exist,Duration.ofSeconds(3)).getText();
        Assertions.assertEquals(expectedTranferSum,actualLabelText);

        String expectedTranferSubmitButtonSum = "Оплатить 100 ?";
        String actualButtonText = mtsMainPage.transferSubmitButton.getText();
        Assertions.assertEquals(expectedTranferSubmitButtonSum,actualButtonText);

        String expectedTransferNumber = "+375297777777";
        String actualTransferNumber = mtsMainPage.transferNumberInfo.getText().substring(10);
        Assertions.assertEquals(expectedTransferNumber,actualTransferNumber);


        String cardNumber = "Номер карты";
        String period = "Срок действия";
        String cvc = "CVC";
        String name = "Имя держателя (как на карте)";

        String cardNumberFieldLabel = mtsMainPage.getCardPaymentInputFieldLabels("Номер карты");
        String periodFieldLabel = mtsMainPage.getCardPaymentInputFieldLabels("Срок действия");
        String cvcFieldLabel = mtsMainPage.getCardPaymentInputFieldLabels("CVC");
        String nameFieldLabel = mtsMainPage.getCardPaymentInputFieldLabels("Имя");

        Assertions.assertEquals(cardNumber,cardNumberFieldLabel);
        Assertions.assertEquals(period,periodFieldLabel);
        Assertions.assertEquals(cvc,cvcFieldLabel);
        Assertions.assertEquals(name,nameFieldLabel);

        Assertions.assertTrue(mtsMainPage.visaIcon.exists());
        Assertions.assertTrue(mtsMainPage.mastercardIcon.exists());
        Assertions.assertTrue(mtsMainPage.belkartIcon.exists());
        Assertions.assertTrue(mtsMainPage.mirIcon.exists());

    }

}
