package tests;

import io.qameta.allure.Epic;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Base test for all API-tests
 */
@Epic("API Test Automation")
@Tag("API")
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseApiTest extends BaseTest {
    private final String authFilePath = "src/main/resources/auth.txt";
    private final String endpointsPath = "src/main/resources/api_endpoints.txt";
    protected RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(getEndpoint())
            .addHeader("Content-Type", "application/json")
            .build();
    protected ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectHeader("Content-Type", "application/json; charset=utf-8")
            .expectHeader("access-control-allow-credentials", "true")
            .expectHeader("expires", "-1")
            .expectHeader("pragma", "no-cache")
            .expectHeader("x-ratelimit-limit", "1000")
            .build();
    private static String token = "";

    protected String getEndpoint() {
        return getEndpoint(endpointsPath);
    }

    @BeforeAll
    protected void setUp() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(authFilePath));
            scanner.useDelimiter("\n");
            while (scanner.hasNext() & token.equals("")) {
                String string = scanner.next().replace("\r", "");
                if (string.startsWith("token=")) token = string.replace("token=", "");
            }
        } catch (FileNotFoundException e) {
            log.info("No such file: " + authFilePath);
        }
    }
}
