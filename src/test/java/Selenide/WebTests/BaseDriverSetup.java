package Selenide.WebTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MTSMainPAge.MtsMainPage;

import static com.codeborne.selenide.Selenide.open;


public class BaseDriverSetup {

    MtsMainPage mts = new MtsMainPage();
    @BeforeAll
    public static void setUp() {
        Configuration.headless = true;
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
    }


    @AfterEach
    public void teardown(){
        Selenide.closeWebDriver();
        Selenide.clearBrowserCookies();
    }


    @AfterAll
    public static void tearDown() throws InterruptedException {
        Selenide.closeWebDriver();
    }

}
