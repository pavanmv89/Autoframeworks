package com.qa.commons;


import java.util.logging.Logger;

import org.bouncycastle.cert.ocsp.Req;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class commonlib {
	Response resp=null;
	RequestSpecification req=RestAssured.given();
	Logger log=Logger.getLogger(commonlib.class.getName());
	public Response get(String url) {
		try {
			RestAssured.baseURI="https://reqres.in/api/";
			 resp=req.accept("application/json").when().get("https://reqres.in/api/users").then().extract().response();
		} catch (Exception e) {
		e.getMessage();
		}
		return resp;
	}
	
	public Response update() {
		try {
			resp=req.header("Content-type", "application/json").body("{\r\n"
					+ "    \"name\": \"testuser\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}").patch("https://reqres.in/api/users/2").then().extract().response();
		} catch (Exception e) {
			e.getMessage();
		}
		return resp;
	}

	public Response createuser() {
		try {
			resp=req.header("Content-type", "application/json").body("{\r\n"
					+ "    \"name\": \"testuser2\",\r\n"
					+ "    \"job\": \"testleader\"\r\n"
					+ "}").when().post("https://reqres.in/api/users").then().extract().response();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return resp;
	}
}
