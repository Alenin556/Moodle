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
    public SelenideElement phoneNumberInputField = $x("//*[@class=\"phone\"]");
    public SelenideElement internetPhoneNumberInputField = $x("//*[@id=\"internet-phone\"]");
    public SelenideElement creditScoreInputField = $x("//*[@id=\"score-instalment\"]");
    public SelenideElement arrearsScoreInputField = $x("//*[@id=\"score-arrears\"]");
    public SelenideElement transferSumInputField = $x("//*[@id=\"connection-sum\"]");
    public SelenideElement emailReportInputField = $x("//*[@id=\"connection-email\"]");
    public SelenideElement submitButton = $x("//*[@class=\"pay-form opened\"]//button");

    public SelenideElement header = $x("//*[@class=\"select__header\"]");
    public ElementsCollection headerList = $$x("//*[@class=\"select__list\"]//li");
    public SelenideElement transferCountLabelSum = $x("//*[@class=\"payment-page__order-description pay-description\"]//span[contains(text(),\"100\")]");
    public SelenideElement transferSubmitButton = $x("//*[@class=\"card-page__container\"]//button[@type=\"submit\"]");
    public SelenideElement transferNumberInfo = $x("//*[@class=\"pay-description__text\"]//span");
    public ElementsCollection cardPaymentLabels = $$x("//*[@id=\"cc-number\"]//following::label");

    public SelenideElement visaIcon = $x("//*[@src=\"assets/images/payment-icons/card-types/visa-system.svg\"]");
    public SelenideElement mastercardIcon = $x("//*[@src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]");
    public SelenideElement belkartIcon = $x("//*[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]");
    public SelenideElement mirIcon = $x("//*[@src=\"assets/images/payment-icons/card-types/mir-system-ru.svg\"]");

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

    public void inputTextIntoNumberField(SelenideElement inputField,String number){
        inputField.shouldBe(Condition.exist, Duration.ofSeconds(2)).sendKeys(number);
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


    public void selectHeader(String headerPaymentService) throws InterruptedException {
        header.click();
        switch (headerPaymentService){
            case "Услуги связи" :  headerList.get(0).click();
            break;
            case "Домашний интернет" : headerList.get(1).click();
            break;
            case "Рассрочка" : headerList.get(2).click();
            break;
            case "Задолженность" : headerList.get(3).click();
            break;
        }
    }

    public String getCardPaymentInputFieldLabels(String field){
        switch (field){
            case "Номер карты" :
                return cardPaymentLabels.get(0).getText();
            case "Срок действия" :
                return cardPaymentLabels.get(1).getText();
            case "CVC" :
                return cardPaymentLabels.get(2).getText();
            case "Имя" :
                return cardPaymentLabels.get(3).getText();
        }
        return null;
    }

}
