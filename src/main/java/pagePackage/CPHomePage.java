package pagePackage;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonMethods;
import utility.DriverHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPHomePage extends CommonMethods {

    public CPHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath = "//img[@alt='NBA Logo']")
    WebElement nbaLogo;
@FindBy(xpath = "//div[text()='x']")
List<WebElement> closeButtonPresale;

@FindBy(xpath = "//a[@rel='noreferrer']/span[text()='Shop']")
WebElement shopMenu;

@FindBy(xpath = "//div[contains(@id,'172456007763157-global_nav_4th_pos1')]/../ul/li/a")
List<WebElement> shopMenulist;
@FindBy(xpath = "//div[@data-talos='ddPageSize']/i")
WebElement maxItemdownArrow;
@FindBy(xpath = "//ul[contains(@class,'drop-down')]/li")
List<WebElement> maxItemList;

@FindBy(xpath = "//input[@value='96']")
List<WebElement> currentPageSize;

@FindBy(xpath = "//div[@class='pagination-component']//div[@data-talos='pageCount']")
WebElement maxPageCountContainer;

@FindBy(xpath = "//div[@class='pagination-component']//a[@aria-label='next page']")
WebElement nextPagebuttonAtTop;

@FindBy(xpath="//div[@class='product-card row']")
List<WebElement> productsOnEachPage;


    public void click_logo(){
        click_on_element(nbaLogo);
    }
    public void close_presale_notification(){
        Boolean isVisisble=isElementVisible(closeButtonPresale);
       if(!isVisisble){
           Allure.step("Close button is not visible");
       }else{
           click_on_element(closeButtonPresale.get(0));
       }
    }

    public void clickValuefromShopMenu(String value){
        mouse_hover_on_element(shopMenu);
        selectFromList(shopMenulist,"Men's");
    }

    public void change_max_item(String valueToChange){
        click_on_element(maxItemdownArrow);
        selectFromList(maxItemList,valueToChange);
        isElementVisible(currentPageSize);
    }

    public void storeProductDetails(){
            int maxPageCount=Integer.parseInt
                    (maxPageCountContainer.getText().
                            trim().split("\\s+")[2]);
        Map<Integer,List<String> > productDetailsMap=new HashMap<Integer,List<String>>();
            for(int i=0;i<maxPageCount-1;i++){
                List<String> templist=new ArrayList<String>();
                for(WebElement ele:productsOnEachPage){
                    templist.add(ele.findElement(
                            By.xpath("div/div[@class='spacing']"))
                            .getText().trim());
                    templist.add(ele.findElement(
                                    By.xpath("div/div[@class='product-card-title']"))
                            .getText().trim());
                    templist.add(ele.findElement(
                                    By.xpath("div/div[@class='product-vibrancy-container"))
                            .getText().trim());
                }
                productDetailsMap.put(i+1,templist);
            }
         String fileName=System.getProperty("user.dir")+"src/test/resources/data.txt";
         try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
             for (Map.Entry<Integer,List<String>> entry:productDetailsMap.entrySet()){
                 List<String> values=entry.getValue();
             for(String val:values){
                 writer.write(val);
                 writer.newLine();
             }
             }
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}
