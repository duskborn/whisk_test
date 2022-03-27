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

import java.time.Instant;

@Feature("Test 2: Deleting Shopping List using GUI")
@Tags({@Tag("positive"), @Tag("smoke")})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeleteShoppingListPositiveUiTest extends BaseShoppingListUiTest {
    String shoppingListName = "AT_SL_DT_" + Instant.now().toEpochMilli();

    @BeforeAll
    void addAllItems() {
        createNewShoppingList(shoppingListName);
    }

    @Test
    @Order(1)
    @DisplayName("Delete Shopping List using GUI")
    void deleteList() {
        shoppingListPage.deleteShoppingList(shoppingListName);
    }

    @Test
    @Order(2)
    @DisplayName("Check Shopping List is deleted")
    void checkListIsDeleted() {
        checkListIsDeleted(shoppingListName);
    }
}
