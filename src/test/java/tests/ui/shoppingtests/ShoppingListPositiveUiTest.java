package tests.ui.shoppingtests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tests.BaseUiTest;

@Feature("Creating and deleting shopping list using GUI")
@Tags({@Tag("positive"), @Tag("smoke"), @Tag("shopping_list")})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingListPositiveUiTest extends BaseUiTest {
    @Test
    @Order(1)
    @DisplayName("Create Shopping list using GUI")
    void createList() {

    }

    @Test
    @Order(2)
    @DisplayName("Delete Shopping list using GUI")
    void deleteList() {

    }
}
