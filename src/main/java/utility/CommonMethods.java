package utility;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CommonMethods {
    protected WebDriver driver;
    public CommonMethods(WebDriver driver){
        this.driver=driver;
    }

    public void click_on_element(WebElement ele){
        ele.click();
    }

    public void mouse_hover_on_element(WebElement ele){
        Actions act=new Actions(driver);
        act.moveToElement(ele).perform();
    }

    public void mouse_hover_click(WebElement ele){
        Actions act=new Actions(driver);
        act.moveToElement(ele).click().build().perform();
    }

    public boolean isElementVisible(List<WebElement> li){
        if(li.size()==1) {
            return true;
        }
     return false;
    }

    public void selectFromList(List<WebElement> li,String value){
       try{ int temp=0;
        for(WebElement ele:li){
            if(ele.getText().trim().equals(value)){
                mouse_hover_click(ele);
                Thread.sleep(2000);
                temp++;
                break;
            }
        }
        if(temp==0){
            throw new Exception("Mentioned Value is not present in the List.");
        }
       }catch(Exception e){
           Allure.step(e.getLocalizedMessage());
       }
    }
    public void add_text_to_field(WebElement ele,String text){
        ele.sendKeys(text);
    }

    public void go_to_url(String url){
        driver.get(url);
       // Allure.step("URL is triggered");
        //ReportUtility.addAttachmentToAllure("C:\\Users\\Sumanraj Nayak\\Downloads\\test.txt");
    }
    public void close_browser(){
        driver.quit();
    }
}
