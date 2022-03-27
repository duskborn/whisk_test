package tests.ui.shoppingtests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tests.BaseShoppingListUiTest;

@Feature("Creating and deleting shopping list using GUI")
@Tags({@Tag("positive"), @Tag("smoke")})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateShoppingListPositiveUiTest extends BaseShoppingListUiTest {

    @BeforeAll
    void addAllItems() {
        createNewShoppingList()
                .addItemToList("garlic")
                .addItemToList("onion")
                .addItemToList("tomato")
                .addItemToList("pasta")
                .addItemToList("salt");
    }

    @Test
    @Order(1)
    @DisplayName("Test1: Checking garlic")
    void checkGarlic() {
    }

    @Test
    @Order(2)
    @DisplayName("Test1: Checking onion")
    void checkOnion() {

    }

    @Test
    @Order(3)
    @DisplayName("Test1: Checking tomato")
    void checkTomato() {

    }

    @Test
    @Order(4)
    @DisplayName("Test1: Checking pasta")
    void checkPasta() {

    }

    @Test
    @Order(5)
    @DisplayName("Test1: Checking ")
    void checkSalt() {

    }
}
