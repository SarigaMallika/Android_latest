package Runner_files;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"Features/Utilities_positive_scenarios.feature"},
        glue= {"Step_Definition"})
public class TestSuite {

}
