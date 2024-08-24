package Selenide.WebTests.Wildberries;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WBPage.WBPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class WildberriesPaymentTest {

    WBPage wbPage = new WBPage();

    @BeforeEach
    public void preconditions() {
        open("https://www.wildberries.ru/");
        wbPage.onMainPageButton.shouldBe(Condition.exist, Duration.ofSeconds(3)).click();
    }

    @Test
    public void addItemsInBasket() throws InterruptedException {
        wbPage.addItemInBasket();
        wbPage.basketButton.shouldBe(Condition.exist,Duration.ofSeconds(5)).click();

        String firstItemName = wbPage.getFirstItemName();
        String secondItemName = wbPage.getSecondItemName();

        Thread.sleep(1500);

        Assertions.assertTrue(wbPage.isTitleExistInBasket(firstItemName));
        Assertions.assertTrue(wbPage.isTitleExistInBasket(secondItemName));

        String countSum = String.valueOf(wbPage.getCountSum());
        String expectedCountItemsInfo = "Товары, "+countSum+" шт.";
        String actualCountItemsInfo = wbPage.getItemsCountInBasket();
        Assertions.assertEquals(expectedCountItemsInfo,actualCountItemsInfo);

        String expectedResultSum = String.valueOf(wbPage.getResultSum());
        String actualResultSumInBasket = String.valueOf(wbPage.parsePrice(wbPage.resultSumInBasket.getText()));

        Assertions.assertEquals(expectedResultSum,actualResultSumInBasket);
    }

}
//div/div/button[1]/span[1]