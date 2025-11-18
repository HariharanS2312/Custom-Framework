package com.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\features\\Print.feature", glue = "com.SetpDefinations", plugin = {
		"pretty", "html:target/cucumber-reports.html" }, monochrome = true)

public class Print_Runner extends AbstractTestNGCucumberTests {

}
