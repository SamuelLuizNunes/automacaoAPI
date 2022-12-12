package runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import utils.RestUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		tags = "@filme",
		glue = "steps",
		plugin = {"json:target/reports/CucumberReports.json", "pretty"},
		snippets = SnippetType.CAMELCASE	
)
public class RunnerTest {
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		RestUtils.setBaseURI("http://192.168.0.6:8181/");
	}
}
 