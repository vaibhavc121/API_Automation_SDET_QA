package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.pet.pet.PetStoreModel;

import static io.restassured.RestAssured.given;

public class StoreEndPoints
{
    public static Response getInventory()
    {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get(Routes.GET_INVENTORY);
        return response;
    }

    public static Response placeOrder(PetStoreModel.StoreModel store)
    {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(store)
                .when()
                .post(Routes.PLACE_ORDER);
        return response;
    }

    public static Response getOrder(PetStoreModel.StoreModel store)
    {
        Response response = given().accept(ContentType.JSON)
                .pathParams("orderId", store.id)
                .when()
                .get(Routes.GET_ORDER);
        return response;
    }

    public static Response deleteOrder(PetStoreModel.StoreModel store)
    {
        Response response = given().accept(ContentType.JSON)
                .pathParam("orderId", store.id)
                .when()
                .delete(Routes.DELETE_ORDER);
        return response;
    }
}