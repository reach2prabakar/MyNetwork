package com.client.processor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.text.StringSubstitutor;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ApiService implements Services {

    private String serviceUri;
    private String serviceEndpoint;
    private String requestBody;
    private Map<String, Object> requestHeaders;
    private String requestMethod;
    private JsonPath jsonPath;

    @Override
    public void setBody(String body) {
        requestBody = body;
    }

    public String getBody() {
        return requestBody;
    }

    @Override
    public void setServiceUri(String uri){ this.serviceUri = uri; }

    public String getServiceUri() {
        return serviceUri;
    }

    @Override
    public void setHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("Accept","*/*");
        headers.put("Content-Type","application/json; charset=UTF-8");
        requestHeaders = headers;
    }

    public Map<String, Object> getHeaders(){
        return requestHeaders;
    }

    @Override
    public void setRequestMethod(String method) {
        requestMethod = method;
    }

    public String getRequestMethod(){
        return  requestMethod;
    }

    @Override
    public void setServiceEndPoint(String endpoint){
        serviceEndpoint = endpoint;
    }

    public String getServiceEndPoint(){
        return serviceEndpoint;
    }

    @Override
    public JsonPath getServiceResponse() {
        return jsonPath;
    }

    @Override
    public void runServiceCall(String apiName){
        Response serviceResponse;
        JSONObject jsonObject = DataHandlerThread.getCurrentDataHandler();
        JsonObject response = JsonParser.parseString(jsonObject.get(apiName).toString()).getAsJsonObject();
        try {
            StringSubstitutor sub = new StringSubstitutor();
            serviceUri = sub.replace(jsonObject.get("uri"));
            serviceEndpoint= sub.replace(response.get("endpoint").getAsString());
            requestBody = sub.replace(response.get("requestBody").toString());
            requestMethod = sub.replace(response.get("method").getAsString());
            setServiceEndPoint(serviceEndpoint);
            setRequestMethod(requestMethod);
            setHeaders();
            setBody(requestBody);
        } catch (NullPointerException e) {
            throw new RuntimeException(e + "The jsonTestData.json is missing /mismatch one of the key =>'endpoint,baseURI,method,requestBody,header' please update");
        }
        serviceResponse =  getRequestMethod().equalsIgnoreCase("get")? given()
                .baseUri(getServiceUri()).basePath(getServiceEndPoint())
                .headers(getHeaders()).body(getBody()).get() :
                given().baseUri(getServiceUri()).basePath(getServiceEndPoint())
                        .headers(getHeaders()).body(getBody()).post();
        assertThat("Response status was not 200 for api "+apiName, serviceResponse.getStatusCode(), equalTo(200));
        this.jsonPath = serviceResponse.jsonPath();
    }
}

