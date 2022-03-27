package autotest.common;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLoggerJUnitListener implements TestWatcher, AfterAllCallback, BeforeAllCallback, BeforeTestExecutionCallback {
    private static final Logger log = LoggerFactory.getLogger("test");
    private static int testCounter = 0;

    public void afterAll(ExtensionContext context) throws Exception {
        log.info("TEST SUIT IS FINISHED. TESTS QUANTITY = {}", testCounter);
    }

    public void beforeAll(ExtensionContext context) throws Exception {
        log.info("TEST SUIT IS STARTED");
    }

    public void beforeTestExecution(ExtensionContext context) throws Exception {
        log.info("STARTED TEST № {}: '{}' WITH TAGS {}", ++testCounter, context.getDisplayName(), context.getTags());
        log.info("TestLocation = {}#{}", context.getRequiredTestClass(), context.getRequiredTestMethod());
    }
}
