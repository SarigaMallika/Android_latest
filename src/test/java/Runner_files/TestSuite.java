package Runner_files;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"Features/Second_opinion_dashboard_positive_scenarios.feature"},
        glue= {"Step_Definition"})
public class TestSuite {

}
