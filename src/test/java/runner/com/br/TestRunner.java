package runner.com.br;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report/cucumber.json"},
		glue = {""},
		tags = {"~@smoketest","@regression"}
		)
public class TestRunner {

}
