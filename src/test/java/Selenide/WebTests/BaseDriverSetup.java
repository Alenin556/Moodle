package Selenide.WebTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public class BaseDriverSetup {

    @BeforeAll
    public static void setUp() {
        Configuration.headless = true;
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        log.info(" - 'Test session starts'");
    }


    @AfterAll
    public static void tearDown() throws InterruptedException {
        Selenide.closeWebDriver();
        log.info(" - 'Test session ends'");
        Thread.sleep(2000);
    }

}
