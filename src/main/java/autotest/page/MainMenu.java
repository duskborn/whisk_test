package autotest.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainMenu {
    SelenideElement homeTab = $x("//*[@data-testid='home-nav-link']");
    SelenideElement savedTab = $x("//*[@data-testid='recipes-nav-link']");
    SelenideElement plannerTab = $x("//*[@data-testid='meal-plan-nav-link']");
    SelenideElement shoppingTab = $x("//*[@data-testid='shopping-list-nav-link']");

    @Step("Clicking 'Shopping' tab")
    public ShoppingListPage goToShoppingList() {
        shoppingTab.shouldBe(Condition.visible).click();
        return page(ShoppingListPage.class);
    }
}
