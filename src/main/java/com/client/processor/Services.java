package com.client.processor;

import io.restassured.path.json.JsonPath;

interface Services {

    void setBody(String body);

    void setHeaders() ;

    void setRequestMethod(String method);

    void setServiceEndPoint(String endPoint);

    void setServiceUri(String uri);

    JsonPath getServiceResponse() ;

    void runServiceCall(String apiName);
}
