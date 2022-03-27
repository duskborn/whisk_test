package tests;

import autotest.common.TestLoggerJUnitListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Base test for all tests
 */
@ExtendWith(TestLoggerJUnitListener.class)
@Slf4j
public abstract class BaseTest extends AbstractJUnit4SpringContextTests {

    protected String getEndpoint(String endpointsPath) {
        String endpoint = null;
        try {
            endpoint = new String(Files.readAllBytes(Paths.get(endpointsPath)), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            throwError("ERROR - Can't get endpoint: " + e.getMessage());
        }
        return endpoint;
    }

    protected void throwError(String errorText) {
        fail(errorText);
        logger.error(errorText);
    }
}
