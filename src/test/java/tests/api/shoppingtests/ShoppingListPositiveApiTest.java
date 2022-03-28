package tests.api.shoppingtests;

import autotest.model.GetSLErrorResponse;
import autotest.model.SLSuccessResponse;
import autotest.model.PostShoppingListModel;
import com.google.gson.JsonObject;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tests.BaseShoppingListApiTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Creating and deleting Shopping List using API")
@Tags({@Tag("positive"), @Tag("smoke")})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingListPositiveApiTest extends BaseShoppingListApiTest {
    private final String shoppingListName = "AT_SL_API_" + Instant.now().toEpochMilli();
    private final PostShoppingListModel slModel = new PostShoppingListModel(shoppingListName, false);
    private SLSuccessResponse postSLSuccessResponse;
    private SLSuccessResponse getSLSuccessResponse;
    private String id;

    @Test
    @Order(1)
    @DisplayName("Create Shopping List using POST-request")
    void createList() {
        Response response = postShoppingList(slModel);
        checkStatusCode(response, 200);
        postSLSuccessResponse = response.body().as(SLSuccessResponse.class);
        id = postSLSuccessResponse.list.id;
    }

    @Test
    @Order(2)
    @DisplayName("GET Shopping List")
    void getList() {
        Response response = getShoppingList(id);
        checkStatusCode(response, 200);
        getSLSuccessResponse = response.body().as(SLSuccessResponse.class);
    }

    @Test
    @Order(3)
    @DisplayName("Check id in response")
    void checkIdInResponse() {
        assertEquals(id, getSLSuccessResponse.list.id);
    }

    @Test
    @Order(4)
    @DisplayName("Check that Shopping list is empty")
    void checkShoppingListIsEmpty() {
        JsonObject emptyJsonObject = new JsonObject();
        assertEquals(emptyJsonObject, getSLSuccessResponse.content);
    }

    @Test
    @Order(5)
    @DisplayName("Delete Shopping List using API")
    void deleteList() {
        Response deleteResponse = deleteShoppingList(id);
        checkStatusCode(deleteResponse, 200);
        Response getResponse = getShoppingList(id);
        checkStatusCode(getResponse, 400);
        GetSLErrorResponse getSLErrorResponse = getResponse.body().as(GetSLErrorResponse.class);
        assertEquals("shoppingList.notFound", getSLErrorResponse.code);
        assertEquals("LIST_ERROR_NOT_FOUND", getSLErrorResponse.errorCode);
        assertEquals("Shopping list not found", getSLErrorResponse.message);
    }
}
