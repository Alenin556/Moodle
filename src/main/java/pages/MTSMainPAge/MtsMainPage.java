package pages.MTSMainPAge;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MtsMainPage {

    public static SelenideElement cookiesAlert = $x("//*[@class=\"cookie__wrapper\"]");
    public static SelenideElement cookiesAgreeButton = $x("//*[@id=\"cookie-agree\"]");
    public static SelenideElement onlinePayment = $x("//*[contains(text(),\"Онлайн пополнение\")]");
    public static SelenideElement paymentPartners = $x("//*[@class=\"pay__partners\"]");
    public static ElementsCollection paymentPartnersCollections = $$x("//*[@class=\"pay__partners\"]//ul//li");
    public static SelenideElement paymentInfoLink = $x("//*[contains(text(),\"Подробнее о сервисе\")]");
    public static SelenideElement numberInputField = $x("//*[@placeholder=\"Номер телефона\"]");
    public static SelenideElement transferSumInputField = $x("//*[@id=\"connection-sum\"]");
    public static SelenideElement emailReportInputField = $x("//*[@id=\"connection-email\"]");
    public static SelenideElement submitButton = $x("//*[@class=\"pay-form opened\"]//button");

    public static void acceptCookies(){
        cookiesAlert.shouldBe(Condition.exist, Duration.ofSeconds(5));
        cookiesAgreeButton.shouldBe(Condition.exist,Duration.ofSeconds(5)).click();
    }

    public static void scrollToTestSection() throws InterruptedException {;
        onlinePayment.scrollTo();
    }

    public static Integer getPartnersCount(){
       return paymentPartnersCollections.size();
    }

    public static String getPaymentHeader(){
        SelenideElement header = $x("//*[@class=\"select__header\"]//span[@class=\"select__now\"]");
        return header.getText();
    }

}
