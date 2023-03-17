package page;

import base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class DogAPIPage extends Base {
    public WebDriver driver;
    String responseBody;
    int statusCode;
    public DogAPIPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void PerformAnAPIRequestToProduceListOfAllDogBreeds()
    {

        RestAssured.baseURI = prop.getProperty("allDoApiURL");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("allDoApiURL"));

        responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        statusCode = response.statusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status Line is: "+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }
    public void UsingCodeToVerifySearchRetrieverBreedIsWithinTheList()
    {

        RestAssured.baseURI = prop.getProperty("searchRetrieverUrl");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("searchRetrieverUrl"));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        if (responseBody.contains("retriever"))
        {
            System.out.println("PASS Verify - retriever is within list");
        }else {
            System.out.println("FAIL Verify - retriever is NOT within list");
        }

        int statusCode = response.statusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

    }

    public void PerformRequestToProducelistOfSubBreedsForRetriever()
    {
        RestAssured.baseURI = prop.getProperty("breedsForRetrieverUrl");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("breedsForRetrieverUrl"));

        responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        statusCode = response.statusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    public void PerformAnApiRequestToProduceRandomImageLinkForSubBreedGolden()
    {
        RestAssured.baseURI = prop.getProperty("subBreedGoldenUrl");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("subBreedGoldenUrl"));

        responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        statusCode = response.statusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
