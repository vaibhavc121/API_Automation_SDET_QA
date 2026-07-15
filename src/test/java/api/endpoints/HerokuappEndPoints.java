package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.conn.routing.RouteInfo;

import static io.restassured.RestAssured.given;

public class HerokuappEndPoints
{
    public static Response getBookingIds()
    {
        Response response = given()
                .when()
                .get(Routes.GET_BOOKING_IDS);
        return response;
    }

    public static Response getBookingId(HerokuappModel app)
    {
        Response response=given()
                .pathParam("id", )
                .when()
                .get(Routes.GET_BOOKING);
        return response;
    }

    public static Response createBooking(HerokuappModel app)
    {
        Response response=given()
                .contentType(ContentType.JSON)
                .body()
                .when()
                .post(Routes.CreateBooking);
        return response;

    }

    public static Response updateBooking(HerokuappModel app)
    {
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id",)
                .body()
                .when()
                .post(Routes.UpdateBooking);
        return response;
    }

    public static Response updateBooking(HerokuappModel app)
    {
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id",)
                .body()
                .when()
                .patch(Routes.PartialUpdateBooking);
        return response;
    }

    public static Response updateBooking(HerokuappModel app)
    {
        Response response=given()
                .contentType(ContentType.JSON)
                .pathParam("id",)
                .when()
                .delete(Routes.DeleteBooking);
        return response;
    }

}