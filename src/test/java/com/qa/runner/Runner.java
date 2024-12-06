package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"com.qa.usersapi","com.qa.steps"},
		monochrome = true,
//		plugin = {"pretty","html:target/Reports/cucumber.html"},
				plugin = "json:Reports/cucumberreport.json",
		tags = "@swaglablogin"
		)

public class Runner {

}
