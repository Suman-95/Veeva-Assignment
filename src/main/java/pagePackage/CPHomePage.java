package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonMethods;
import utility.DriverHandler;

public class CPHomePage extends CommonMethods {

    public CPHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath = "//img[@alt='NBA Logo']")
    WebElement nbaLogo;


    public void click_logo(){
        click_on_element(nbaLogo);
    }
}
