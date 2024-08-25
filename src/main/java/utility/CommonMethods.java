package utility;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    public String get_current_window_handle(){
        return driver.getWindowHandle();
    }

    public void refresh_page(){
        driver.navigate().refresh();
    }

    public void explicitWait(WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public List<WebElement> find_elements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public WebElement find_element(String locator){
        return driver.findElement(By.xpath("//div[@class='product-card row']/div[@class='columns small-5 medium-12']"));
    }
    public void switch_to_window(String excludehandle) throws InterruptedException {
       Set<String> windowHandles=driver.getWindowHandles();
        for(String windowHandle:windowHandles){
            if(!windowHandle.equals(excludehandle)){
                driver.switchTo().window(windowHandle);
                Thread.sleep(2000);
                break;
            }
        }
    }

    public void go_to_url(String url) throws InterruptedException {
        driver.get(url);
    }

    public void close_browser(){
        driver.quit();
    }
}
