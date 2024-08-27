package pages.WBPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Setter
public class WBPage {

    public static void main(String[] args) {
        WBPage wbPage = new WBPage();
        System.out.println(wbPage.parsePrice("1 256 Р"));

        String s1 = "Товары, 2 шт.1" +
                "16 275 ?";
        String sWP = s1.substring(0, s1.length() - 10);
        if (!sWP.equals("Товары, 2 шт.")) {
            sWP = s1.substring(0, s1.length() - 9);
        }
        System.out.println(sWP);
    }

    private String firstItemName;
    private Integer firstItemCount;
    private String firstItemPrice;
    private String secondItemName;
    private Integer secondItemCount;
    private String secondItemPrice;

    public Integer resultSum;
    public Integer countSum;


    public SelenideElement onMainPageButton = $x("//*[@alt=\"Wildberries\"]");
    public SelenideElement chooseSizeTable = $x("//div[@class=\"popup__content\"]//h2[contains(text(),\"Выберите размер\")]");
    public SelenideElement basketButton = $x("//*[@data-wba-header-name=\"Cart\"]");
    public SelenideElement itemLabel = $x("//*[@class=\"product-page__title\"]");
    public ElementsCollection articles = $$x("//article");
    public SelenideElement addInBasketButton = $x("//*[@class=\"product-page__aside-container j-price-block\"]//button[@class=\"order__button btn-main\"]");
    public SelenideElement itemPrice = $x("//*[@class=\"product-page__aside-container j-price-block\"]/div[2]/div/div/div/p/span/span");
    public SelenideElement resultSumInBasket = $x("//*[contains(text(),\"Итого\")]/..//span[2]");
    public SelenideElement availableFirstSize = $x("//div[@class=\"popup__content\"]//li[1]");

    public void addItemInBasket() throws NoSuchElementException {

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                SelenideElement item1 = $x("//article[1]" + "/div");
                item1.shouldBe(Condition.exist, Duration.ofSeconds(5)).click();
                firstItemName = itemLabel.getText();
                addInBasketButton.shouldBe(Condition.exist, Duration.ofSeconds(5)).click();
                firstItemCount = 1;
                firstItemPrice = itemPrice.getText();
                if (chooseSizeTable.exists()) {
                    String sizeTableLabel = chooseSizeTable.getText();
                    if (sizeTableLabel.equals("Выберите размер")) {
                        availableFirstSize.click();
                    }
                    onMainPageButton.click();
                } else {
                    onMainPageButton.click();
                }
            }
                if (i == 1) {
                    SelenideElement item2 = $x("//article[2]" + "/div");
                    item2.shouldBe(Condition.exist, Duration.ofSeconds(5)).click();
                    secondItemName = itemLabel.getText();
                    addInBasketButton.shouldBe(Condition.exist, Duration.ofSeconds(5)).click();
                    secondItemCount = 1;
                    secondItemPrice = itemPrice.getText();
                    if (chooseSizeTable.exists()) {
                        String sizeTableLabel = chooseSizeTable.getText();
                        if (sizeTableLabel.equals("Выберите размер")) {
                            availableFirstSize.click();
                        }
                        onMainPageButton.click();
                    } else {
                        break;
                    }
                }
            }

            Integer price1Item = parsePrice(firstItemPrice);
            Integer price2Item = parsePrice(secondItemPrice);

            countSum = firstItemCount + secondItemCount;
            resultSum = Integer.valueOf(price1Item + price2Item);
            System.out.println(resultSum);
        }

        public boolean isTitleExistInBasket (String title){
            SelenideElement titleItemInBasket = $x("//a[@title=\"" + title + "\"]");
            if (titleItemInBasket.exists()) {
                return true;
            } else {
                return false;
            }
        }

        public Integer parsePrice (String price){
            String priceSub = price.substring(0, price.length() - 2).replace(" ", "");
            int priceInt = 0;
            try {
                priceInt = Integer.parseInt(priceSub);
            } catch (NumberFormatException exception) {
                System.out.println("NumberFormatException: " + exception.getMessage());
            }
            return priceInt;
        }

        public String getItemsCountInBasket () throws InterruptedException {
            SelenideElement countLocator = $x("//*[@class=\"b-top__count line\"]");
            String countInfo = countLocator.getText();
            String s1 = countInfo.substring(0, countInfo.length() - 10);
            if (!s1.equals("Товары, 2 шт.")) {
                s1 = countInfo.substring(0, countInfo.length() - 9);
            }
            return s1;
        }

    }
