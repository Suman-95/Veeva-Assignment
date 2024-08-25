package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepdefinitions"},
        monochrome = true,
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@Listeners({AllureTestNg.class})
public class TestRunner extends AbstractTestNGCucumberTests {

}
