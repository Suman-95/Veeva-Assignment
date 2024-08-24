package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {
    protected WebDriver driver;
    public CommonMethods(WebDriver driver){
        this.driver=driver;
    }

    public void click_on_element(WebElement ele){
        ele.click();
    }
    public void add_text_to_field(WebElement ele,String text){
        ele.sendKeys(text);
    }

    public void go_to_url(String url){
        driver.get(url);
    }
}
