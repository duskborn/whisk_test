package autotest.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ShoppingListPage extends BasePage {
    private final SelenideElement newShoppingListButton = $x("//*[@data-testid='create-new-shopping-list-button']");
    private final SelenideElement shoppingListNameInput = $x("//*[@data-testid='UI_KIT_INPUT']");
    private final SelenideElement approveCreatingShoppingListButton = $x("//*[@data-testid='create-new-shopping-list-create-button']");
    private final SelenideElement newSLModalWindow = $x("//*[@data-testid='list-form-modal']");
    private final SelenideElement addItemInput = $x("//input[@data-testid='desktop-add-item-autocomplete']");
    private final SelenideElement shoppingListOptions = $x("//*[@data-testid='vertical-dots-shopping-list-button']");
    private final SelenideElement deleteListButton = $x("//button[@data-testid='shopping-list-delete-menu-button']");
    private final SelenideElement confirmDeleteButton = $x("//button[@data-testid='confirm-delete-button']");

    @Step("Creating new Shopping List")
    public ShoppingListPage createNewShoppingList(String shoppingListName) {
        newShoppingListButton.shouldBe(Condition.visible).click();
        shoppingListNameInput.shouldBe(Condition.visible, Duration.ofSeconds(10));
        if (!shoppingListName.equals("")) {
            shoppingListNameInput.click();
            shoppingListNameInput.sendKeys(Keys.CONTROL,"a");
            shoppingListNameInput.sendKeys(Keys.DELETE);
            shoppingListNameInput.setValue(shoppingListName);
        }
        approveCreatingShoppingListButton.shouldBe(Condition.visible).click();
        newSLModalWindow.shouldNotBe(Condition.visible, Duration.ofSeconds(10));
        return page(ShoppingListPage.class);
    }

    public ShoppingListPage createNewShoppingList() {
        return createNewShoppingList("");
    }

    @Step("Adding new item to Shopping List")
    @SneakyThrows
    public ShoppingListPage addItemToList(String item) {
        addItemInput.shouldBe(Condition.visible).setValue(item).pressEnter();
        Thread.sleep(500);
        return page(ShoppingListPage.class);
    }

    public ShoppingListPage addAllItemsToList(String[] item) {
        for (String i : item) {
            addItemToList(i);
        }
        return page(ShoppingListPage.class);
    }

    public SelenideElement getShoppingListItem(String itemName) {
        return $x("//*[(@data-testid='shopping-list-item-name')and(text()='" + itemName + "')]");
    }

    public SelenideElement getShoppingListList(String listName) {
        return $x("//*[(@data-testid='shopping-lists-list-name')and(text()='" + listName + "')]");
    }

    @SneakyThrows
    public ShoppingListPage deleteShoppingList(String listName) {
        getShoppingListList(listName).shouldBe(Condition.visible).click();
        shoppingListOptions.shouldBe(Condition.visible).click();
        deleteListButton.shouldBe(Condition.visible).click();
        confirmDeleteButton.shouldBe(Condition.visible).click();
        Thread.sleep(5000);
        return page(ShoppingListPage.class);
    }
}
