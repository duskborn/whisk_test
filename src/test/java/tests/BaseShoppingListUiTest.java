package tests;

import autotest.page.AuthPage;
import autotest.page.CommunitiesPage;
import autotest.page.ShoppingListPage;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selenide.open;

@Tag("shopping_list")
public class BaseShoppingListUiTest extends BaseUiTest{
    protected ShoppingListPage shoppingListPage = null;

    protected ShoppingListPage createNewShoppingList(String shoppingListName) {
        shoppingListPage = defaultPage.mainMenu.goToShoppingList();
        return shoppingListPage.createNewShoppingList(shoppingListName);
    }

    protected void checkListIsDeleted(String shoppingListName) {
        defaultPage = open(getEndpoint(), CommunitiesPage.class);
        shoppingListPage = defaultPage.mainMenu.goToShoppingList();
        shoppingListPage.checkListIsDeleted(shoppingListName);
    }
}
