import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty","html:target/Reports/cucumberreport.html",
                "junit:target/Reports/report.xml",
                "json:target/Reports/CucumberTestReport.json"},
        monochrome = true,
        glue = {
                "com.client.stepdefinitions"
        }
)
public class TestRunner {}

