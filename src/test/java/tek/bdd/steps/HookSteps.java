package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tek.bdd.utility.SeleniumUtilities;

public class HookSteps extends SeleniumUtilities {
    // Hook that Run before Each Scenario || We Must import @Before from io.Cucumber.java not from junit
    @Before
    public void initiateTest(){
        openBrowser();
    }
    //Hook will Execute After Each Scenario no matter what happened to Scenario.
    /*Have proof and report! How are you going to provide proof?
    * @After before we quit the driver, we can write a couple lines of codes to capture screenShot and attach it to failed test!
    * Now we are changing the method to take a screenshot and append it to the fail test!
    * "public void closingTest(Scenario scenario)" we are passing parameters to take a screenShot of the failed scenario!
    * "TakesScreenshot screenshot = (TakesScreenshot) getDriver();" to take screenShot we're creating the Object of screenShot! And we need to cast our driver to take a screenShot of "(TakesScreenshot)".
    * "byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);" we use this screenShot Object and say get screenshot as outputType.BYTES(in cucumber is required to be byte[]) and store it in byte[] array name it capture!
    * "scenario.attach(capture,"image/png", "ScreenShot");" Remember up top we pass parameters for our scenario, so here we are asking cucumber to attach this capture into this mediaType and name it as ScreeShot!
    * Then we are asking our driver to quiet!
    *
    * This will capture screenshot if the test passes or fails! To resolve this issue we MUST use a small if statement as such!
    * Which means if a scenario is failed to capture a Screenshot, otherwise no screenshot is required! Sometimes we have lots of test cases if we take screenshot it every validation the file will very large!
    * */

    @After
    public void closingTest(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(capture, "image/png", "screenShot");
        }
        getDriver().quit();
    }


}
