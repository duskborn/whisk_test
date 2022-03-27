package autotest.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AuthPage {
    SelenideElement username = $x("//*[@name='username']");
    SelenideElement password = $x("//*[@name='password']");

    public CommunitiesPage login(String username, String password) {
        this.username.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(username).pressEnter();
        this.password.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(password).pressEnter();
        return page(CommunitiesPage.class);
    }
}
