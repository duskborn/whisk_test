package tests;

import autotest.common.TestLoggerJUnitListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ExtendWith(TestLoggerJUnitListener.class)
@Slf4j
public abstract class BaseTest extends AbstractJUnit4SpringContextTests {
}
