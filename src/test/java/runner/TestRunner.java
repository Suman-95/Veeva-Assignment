package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepdefinitions"},
        monochrome = true
)
@Listeners({AllureTestNg.class})
public class TestRunner extends AbstractTestNGCucumberTests {

}
