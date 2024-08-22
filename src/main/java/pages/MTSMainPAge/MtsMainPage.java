package pages.MTSMainPAge;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MtsMainPage {

    public SelenideElement cookiesAlert = $x("//*[@class=\"cookie__wrapper\"]");
    public SelenideElement cookiesAgreeButton = $x("//*[@id=\"cookie-agree\"]");
    public SelenideElement onlinePayment = $x("//*[contains(text(),\"Онлайн пополнение\")]");
    public SelenideElement paymentPartners = $x("//*[@class=\"pay__partners\"]");
    public ElementsCollection paymentPartnersCollections = $$x("//*[@class=\"pay__partners\"]//ul//li");
    public SelenideElement paymentInfoLink = $x("//*[contains(text(),\"Подробнее о сервисе\")]");
    public SelenideElement numberInputField = $x("//*[@placeholder=\"Номер телефона\"]");
    public SelenideElement transferSumInputField = $x("//*[@id=\"connection-sum\"]");
    public SelenideElement emailReportInputField = $x("//*[@id=\"connection-email\"]");
    public SelenideElement submitButton = $x("//*[@class=\"pay-form opened\"]//button");

    public void acceptCookies(){
        if(cookiesAlert.exists()) {
            cookiesAlert.shouldBe(Condition.exist, Duration.ofSeconds(5));
            cookiesAgreeButton.shouldBe(Condition.exist, Duration.ofSeconds(5)).click();
        } else {
            Selenide.refresh();
        }
    }

    public void scrollToTestSection() throws InterruptedException {;
        onlinePayment.scrollTo();
    }

    public Integer getPartnersCount(){
       return paymentPartnersCollections.size();
    }

    public String getPaymentHeader(){
        SelenideElement header = $x("//*[@class=\"select__header\"]//span[@class=\"select__now\"]");
        return header.getText();
    }

    public void inputTextIntoNumberField(String number){
        numberInputField.shouldBe(Condition.exist, Duration.ofSeconds(2)).sendKeys(number);
    }

    public void inputTextIntoTransferField(String transferCount){
        transferSumInputField.shouldBe(Condition.exist, Duration.ofSeconds(2)).sendKeys(transferCount);
    }

    public void inputTextIntoEmailField(String email){
        emailReportInputField.shouldBe(Condition.exist, Duration.ofSeconds(2)).sendKeys(email);
    }

    public void submitPayment(){
        submitButton.shouldBe(Condition.enabled,Duration.ofSeconds(3)).click();
    }

}
