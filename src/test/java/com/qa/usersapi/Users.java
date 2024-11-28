package com.qa.usersapi;

import java.text.Format;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Info;
import com.google.common.collect.Multiset.Entry;
import com.qa.commons.commonlib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Users extends commonlib{
	Response users=null;
Logger log=Logger.getLogger(Users.class.getName());

	@Given("get on users api")
	public void get_on_users_api() {
		 users=get("users");
	}
	@Given("get the response")
	public void get_the_response() {
		log.info("users "+users.asPrettyString());
	}
	@When("get on specific user")
	public void get_on_specific_user() {
		JsonPath jpath=new JsonPath(users.asString());
		Map<String, Object> users=jpath.getMap("data[1]");
		log.info("user 1 "+users);
		for(Map.Entry<String, Object> userdata:users.entrySet()) {
			if (userdata.getKey().equalsIgnoreCase("first_name")) {
				log.info("user first name "+userdata.getValue());
			}
			
		}
		
	}
	@When("update user")
	public void update_user() {
		users=update();
		log.info("users >> "+users.asPrettyString());
	}
	@When("create a new user")
	public void create_a_new_user() {
		users=createuser();
		log.info("users >> "+users.asPrettyString());
	}
	@Then("validate updated user")
	public void validate_updated_user() {
	}
	@Then("delete user")
	public void delete_user() {
	}




}
