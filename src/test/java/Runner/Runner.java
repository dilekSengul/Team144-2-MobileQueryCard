package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@hurrem",
        dryRun = false


)
public class Runner {
}