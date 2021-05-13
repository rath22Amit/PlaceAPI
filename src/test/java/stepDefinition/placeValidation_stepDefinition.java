package stepDefinition;

import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class placeValidation_stepDefinition extends Utils {
    RequestSpecification request;
    ResponseSpecification res;
    Response response;
    TestDataBuild payload= new TestDataBuild();

    @Given("User prepares addPlace payload with {string},{string},{string}")
    public void user_prepares_add_place_payload_with(String name, String address, String language) throws IOException {

        // Write code here that turns the phrase above into concrete actions
        request=given().spec(requestSpec()).body(payload.addPlacePayload(name,address,language));
    }
    @When("User sends POST method")
    public void user_sends_post_method() {
        res= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();
         response= request.when().post("/maps/api/place/add/json")
                           .then().spec(res).extract().response();
    }
    @Then("API call is success with status code {int}")
    public void api_call_is_success_with_status_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Then("the {string} should be {string}")
    public void the_should_be(String key, String value) {
        String resp=response.asString();
        JsonPath js= new JsonPath(resp);
        js.get(key);
        Assert.assertEquals(js.get(key).toString(),value);
    }
}
