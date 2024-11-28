package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"com.qa.usersapi"},
		monochrome = true,
//		plugin = {"pretty","html:target/Reports/cucumber.html"},
				plugin = "json:target/cucumberreport.json",
		tags = "@listusers"
		)

public class Runner {

}
