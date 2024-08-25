package utility;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public void go_to_url(String url) throws IOException {
        driver.get(url);
        Allure.step("URL is triggered");
        ReportUtility.addAttachmentToAllure("C:\\Users\\Sumanraj Nayak\\Downloads\\test.txt");
    }
    public void close_browser(){
        driver.quit();
    }
}
