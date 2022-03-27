package tests;

import autotest.page.AuthPage;
import autotest.page.CommunitiesPage;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.open;

/**
 * Base test for all UI-tests
 */
@Epic("UI Test Automation")
@Tag("UI")
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseUiTest extends BaseTest {
    private static final String endpointsPath = "src/main/resources/ui_endpoints.txt";
    private static final String authFilePath = "src/main/resources/auth.txt";
    private static String username = "";
    private static String password = "";

    public static CommunitiesPage defaultPage;

    @BeforeAll
    protected void setUp() {
        Scanner scanner = null;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        try {
            scanner = new Scanner(new File(authFilePath));
            scanner.useDelimiter("\n");
            while (scanner.hasNext() & username.equals("")) {
                String string = scanner.next().replace("\r", "");
                if (string.startsWith("username=")) username = string.replace("username=", "");
            }
            while (scanner.hasNext() & password.equals("")) {
                String string = scanner.next().replace("\r", "");
                if (string.startsWith("password=")) password = string.replace("password=", "");
            }
        } catch (FileNotFoundException e) {
            log.info("No such file: " + authFilePath);
        }

        defaultPage = login();
    }

    @BeforeEach
    protected void setUpTest() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }

    @AfterAll
    protected static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
        closeWebDriver();
    }

    protected static void closeWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }

    protected String getEndpoint() {
        return getEndpoint(endpointsPath);
    }

    protected String getUsername() {
        return username;
    }

    protected CommunitiesPage login() {
        AuthPage authPage = open(getEndpoint(), AuthPage.class);
        return authPage.login(username, password);
    }
}
