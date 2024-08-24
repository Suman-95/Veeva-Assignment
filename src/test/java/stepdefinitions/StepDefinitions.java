package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pagePackage.CPHomePage;
import utility.CommonMethods;
import utility.DriverHandler;

public class StepDefinitions {
    WebDriver driver=DriverHandler.getDriver();
    CommonMethods cm=new CommonMethods(driver);
    CPHomePage cph=new CPHomePage(driver);

    @Given("I load the {string} page")
    public void iLoadThePage(String arg0) throws InterruptedException {
        cm.go_to_url(arg0);
        Thread.sleep(1000);
        cph.close_presale_notification();
        cph.click_logo();
    }
}
