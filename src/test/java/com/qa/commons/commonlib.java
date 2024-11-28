package com.qa.commons;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class commonlib {
	
	public Response get(String url) {
		RestAssured.baseURI="https://reqres.in/api/";
		RequestSpecification req=RestAssured.given();
		Response resp=null;
		try {
			 resp=req.accept("application/json").when().get(url).then().extract().response();
		} catch (Exception e) {
		e.getMessage();
		}
		return resp;
	}

}
