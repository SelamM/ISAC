package main.java;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java",
	plugin = {"pretty", "html:C://Users/sgebreti/CucumberTestingSpace/JenkinProject"}
)
public class RunnerClass {

}
