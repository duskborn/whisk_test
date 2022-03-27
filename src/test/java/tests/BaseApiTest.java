package tests;

import io.qameta.allure.Epic;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Tag;

/**
 * Base test for all API-tests
 */
@Epic("API Test Automation")
@Tag("API")
public abstract class BaseApiTest extends BaseTest {
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

    protected String getEndpoint() {
        return getEndpoint(endpointsPath);
    }
}
