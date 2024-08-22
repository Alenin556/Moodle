package Selenide.WebTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class BaseDriverSetup {

    @BeforeAll
    public static void setUp() {
        Configuration.headless = true;
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
    }


    @AfterAll
    public static void tearDown() throws InterruptedException {
        Selenide.closeWebDriver();
    }

}
