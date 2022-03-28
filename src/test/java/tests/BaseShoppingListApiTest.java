package tests;

import autotest.model.PostShoppingListModel;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Tag;

import static io.restassured.RestAssured.given;

@Tag("shopping_list")
public abstract class BaseShoppingListApiTest extends BaseApiTest {

    protected Response getShoppingList(String id) {
        Response response = given()
                .spec(requestSpecification)
                .baseUri(getEndpoint())
                .when()
                .get("/list/v2/" + id);
        response
                .then()
                .assertThat()
                .spec(responseSpecification);
        return response;
    }

    protected String createPostBody(String name, Boolean primary) {
        JSONObject jsonobject = new JSONObject();
        try {
            jsonobject.put("name", name);
            jsonobject.put("primary", primary);
        } catch (JSONException e) {
            throwError("ERROR - Can't create POST-request: " + e.getMessage());
        }
        return jsonobject.toString();
    }

    protected Response postShoppingList(String stringPostBody, RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        Response response = given()
                .spec(requestSpecification)
                .body(stringPostBody)
                .baseUri(getEndpoint())
                .when()
                .post("/list/v2");
        response
                .then()
                .assertThat()
                .spec(responseSpecification);
        return response;
    }

    protected Response postShoppingList(String stringPostBody) {
        return postShoppingList(stringPostBody, requestSpecification, responseSpecification);
    }

    protected Response postShoppingList(String name, Boolean primary) {
        return postShoppingList(createPostBody(name, primary));
    }

    protected Response postShoppingList(PostShoppingListModel postShoppingListModel) {
        return postShoppingList(postShoppingListModel.name, postShoppingListModel.primary);
    }
}
