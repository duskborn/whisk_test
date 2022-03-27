package tests.api.shoppingtests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tests.BaseShoppingListApiTest;

@Feature("Creating and deleting shopping list using API")
@Tags({@Tag("positive"), @Tag("smoke")})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingListPositiveApiTest extends BaseShoppingListApiTest {
    @Test
    @Order(1)
    @DisplayName("Create Shopping list using API")
    void createList() {

    }

    @Test
    @Order(2)
    @DisplayName("Delete Shopping list using API")
    void deleteList() {

    }
}
