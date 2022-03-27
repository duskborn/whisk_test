package tests;

import autotest.page.ShoppingListPage;
import org.junit.jupiter.api.Tag;

@Tag("shopping_list")
public class BaseShoppingListUiTest extends BaseUiTest{
    protected ShoppingListPage shoppingListPage = null;

    protected ShoppingListPage createNewShoppingList() {
        shoppingListPage = defaultPage.mainMenu.goToShoppingList();
        return shoppingListPage.createNewShoppingList();
    }
}
