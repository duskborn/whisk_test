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
public class DeleteShoppingListPositiveUiTest extends BaseShoppingListUiTest {

    @BeforeAll
    void addAllItems() {
        createNewShoppingList();
    }

    @Test
    @Order(1)
    @DisplayName("Test2: Delete Shopping list using GUI")
    void deleteList() {

    }
}
