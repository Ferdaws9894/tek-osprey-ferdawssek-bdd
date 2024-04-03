package tek.bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
// IF we want to run just one feature file from the test runner which is this class, how do we do that? Answer: we must target that specific file from classpath!
        // Example: If we are targeting Smoke test feature, then we write it as such: feature = "classpath:features/SmokeTest.feature" This will only run that feature file!
        features = "classpath:features",
 // We use glue to link our feature file with our step definition, which will have the step written in gherkin language (plain English) and the code which we are testing that feature.
        glue = "tek.bdd.steps",
 // If dryRun = True this will not run or execute our code, this will only detect if we have all the step definition, and if not, it will provide us in the console!
 // On the other hand, if dryRun = false, this will execute/run our code. NOTE: we will be able to execute our code with dryRun it is there main if we want to check if any step definition is missing.
        dryRun = false,
 // To Run a specific Tag which can be Smoke, Regression, Story_1 or Story_2 in the tag which will Execute that specific tests.
        tags = "@Regression",
 // The Plugin will help us to print a report of our test and present it in a simple english language which is it for PO and manager to read!
 // If we are adding more than one Plugins, we MUST put them inside { } and separate them by comma

        plugin = { "html:target/html_report/index.html",
                    "pretty",
                    "json:target/jsonReports/Report.json" // Cucumber Reporting!"
        }


)
public class TestRunner {
}
