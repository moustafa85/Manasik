package Pages.utils;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Properties;

public class GenerateAlerts {

    public static Properties prop;
    Timestamp timestamp;
    String jsonString;
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    /**
     *
     * @param deviceID
     * @param bpHigh
     * @param bpLow
     * @param bpHeart
     * @param temp
     * @param lat
     * @param lon
     * @throws IOException
     */
    public Boolean generateHealthVitalsAlert(String deviceID, String bpHigh, String bpLow,String bpHeart, String temp, String lat, String lon) throws IOException, ParseException {
        timestamp = new Timestamp(System.currentTimeMillis());
        prop = new Properties();
        //update the input dir value
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\fours.Configuration\\Configuration");
        prop.load(ip);
        // There is no need to add escape character manually. Just paste string within double
        // quotes. It will automatically add escape sequence as required.

        String jsonString = "{\"deviceId\": \""+deviceID+"\",\"deviceType\": \"default\",\"mfr\": \"620cd65b49bdfa68c83bd8d2\",\"ts\": 1652604796,\"data\":{\"bpHigh\": "+bpHigh+",\"bpLow\": "+bpLow+",\"bpHeart\": "+bpHeart+",\"temp\": "+temp+",\"packetType\": \"health\",\"ts\": "+timestamp.getTime()/1000+",\"lat\": "+lat+",\"lon\": "+lon+"}}";
        response = RestAssured.given().baseUri(prop.getProperty("api_url")).contentType(ContentType.JSON).body(jsonString).when().post();

        System.out.println(response.body().prettyPrint());

        return response.statusCode()==200||response.statusCode()==201||response.statusCode()==204;
    }

    /**
     *
     * @param deviceID
     * @param lat
     * @param lon
     * @throws IOException
     */
    public Boolean generateGeofenceAlert(String deviceID,String lat, String lon) throws IOException {
        timestamp = new Timestamp(System.currentTimeMillis());
        prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\fours.Configuration\\Configuration");
        prop.load(ip);
        jsonString = "{\"deviceId\": \""+deviceID+"\",\"deviceType\": \"default\",\"mfr\": \"620cd65b49bdfa68c83bd8d2\",\"ts\": 1622528326,\"data\": {\"lon\": "+lon+",\"lat\": "+lat+",\"northSouth\": \"N\",\"eastWest\": \"E\",\"status\": \"A\",\"packetType\": \"gps\",\"ts\": "+timestamp.getTime()/1000+"}}";


        response = RestAssured.given().baseUri(prop.getProperty("api_url")).contentType(ContentType.JSON).body(jsonString).when().post();

        System.out.println(response.body().prettyPrint());

        return response.statusCode()==200||response.statusCode()==201||response.statusCode()==204;

    }
}
