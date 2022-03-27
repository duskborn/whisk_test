package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

/**
 * Base test for all UI-tests
 */
@Epic("UI Test Automation")
@Tag("UI")
public abstract class BaseUiTest extends BaseTest {
    private final String endpointsPath = "src/main/resources/ui_endpoints.txt";

    @BeforeAll
    protected void setUp() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

    @BeforeEach
    protected void setUpTest() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }

    @AfterAll
    protected void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
        closeWebDriver();
    }

    protected void closeWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }

    protected String getEndpoint() {
        return getEndpoint(endpointsPath);
    }
}
