package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pagePackage.CPHomePage;
import pagePackage.CPShopMenPage;
import pagePackage.DPTwoHomePage;
import utility.CommonMethods;
import utility.DriverHandler;
import utility.FrameworkUtility;
import utility.ReportUtility;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StepDefinitions {
    WebDriver driver=DriverHandler.getDriver();
    CommonMethods cm=new CommonMethods(driver);
    CPHomePage cph=new CPHomePage(driver);
    DPTwoHomePage dpt=new DPTwoHomePage(driver);
    CPShopMenPage cpm=new CPShopMenPage(driver);

    public StepDefinitions() throws IOException {
    }

    @Step("Page is loaded")
    @Given("I load the {string} page")
    public void iLoadThePage(String arg0) throws InterruptedException, IOException {
        cm.go_to_url(arg0);
        Thread.sleep(1000);
    }



    @After
    public void closeBrowser(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.attachment("Failed Screenshot",new ByteArrayInputStream(screenshot));
        }
    cm.close_browser();

    }

    @Given("User triggers URL:{string} in Browser")
    public void userTriggersURLInBrowser(String url) throws IOException, InterruptedException {
        cm.go_to_url(url);
        cph.close_presale_notification();
    }

    @When("User validates presale notification and closes the same")
    public void userValidatesPresaleNotificationAndClosesTheSame() {
        cph.close_presale_notification();
    }

    @Then("user clicks on {string} on the Shop Menu")
    public void userClicksOnOnTheShopMenu(String pageName) {
        cph.clickValuefromShopMenu(pageName);
    }

    @And("User changes max item to {string} in men's page")
    public void userChangesMaxItemToInMenSPage(String value) throws InterruptedException {
        cpm.change_max_item(value);
    }

    @And("user goes to each Page and stores data in text file")
    public void userGoesToEachPageAndStoresDataInTextFile() throws InterruptedException, IOException {
        cpm.storeProductDetails();
    }

    @Then("User goes to newsfeed page")
    public void userGoesToNewsfeedPage() {
        cph.gotoNewsFeed();
    }

    @And("User notes video count for more than three days")
    public void userNotesVideoCountForMoreThanThreeDays() {
        cph.validateVideoCount();
    }

    @When("User goes to page bottom")
    public void userGoesToPageBottom() {
    dpt.scrollToPageBottom();
    }

    @Then("Check duplicates in hyperlinks")
    public void checkDuplicatesInHyperlinks() {
    dpt.check_Duplicate_hyperlinks();
    }
}
