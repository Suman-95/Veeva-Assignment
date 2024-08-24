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
@FindBy(xpath = "//div[text()='x']")
WebElement closeButtonPresale;

    public void click_logo(){
        click_on_element(nbaLogo);
    }
    public void close_presale_notification(){
        click_on_element(closeButtonPresale);
    }
}
