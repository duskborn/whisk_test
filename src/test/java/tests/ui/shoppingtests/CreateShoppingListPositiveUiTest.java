package tests.ui.shoppingtests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tests.BaseShoppingListUiTest;

import java.time.Duration;
import java.time.Instant;

@Feature("Test 1: Creating Shopping List using GUI")
@Tags({@Tag("positive"), @Tag("smoke")})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateShoppingListPositiveUiTest extends BaseShoppingListUiTest {
    private final String[] itemList = {"Garlic", "Onion", "Tomato", "Pasta", "Salt"};
    private final String shoppingListName = "AT_SL_CT_" + Instant.now().toEpochMilli();

    @BeforeAll
    void addAllItems() {
        createNewShoppingList(shoppingListName).addAllItemsToList(itemList);
    }

    @Test
    @Order(1)
    @DisplayName("Checking garlic")
    void checkGarlic() {
        shoppingListPage.getShoppingListItem(itemList[0]).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    @Test
    @Order(2)
    @DisplayName("Checking onion")
    void checkOnion() {
        shoppingListPage.getShoppingListItem(itemList[1]).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    @Test
    @Order(3)
    @DisplayName("Checking tomato")
    void checkTomato() {
        shoppingListPage.getShoppingListItem(itemList[2]).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    @Test
    @Order(4)
    @DisplayName("Checking pasta")
    void checkPasta() {
        shoppingListPage.getShoppingListItem(itemList[3]).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    @Test
    @Order(5)
    @DisplayName("Checking salt")
    void checkSalt() {
        shoppingListPage.getShoppingListItem(itemList[4]).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    @AfterAll
    void deleteShoppingList() {
        shoppingListPage.deleteShoppingList(shoppingListName);
        checkListIsDeleted(shoppingListName);
    }
}
