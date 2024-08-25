package pagePackage;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonMethods;
import utility.DriverHandler;
import utility.ReportUtility;

import java.io.BufferedWriter;
import java.io.File;
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

@FindBy(xpath = "//*[@id=\"nba-nav\"]/div[2]/nav/div/nav[1]/ul/li[4]/nav/ul/li[2]/a")
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

@FindBy(xpath = "//div[@class='pagination-component']//a[@aria-label='next page']/..")
WebElement nextPageLI;

@FindBy(xpath="//div[@class='product-card row']")
List<WebElement> productsOnEachPage;

String eachPageProductlocator="//div[@class='product-card row']";


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

    public void change_max_item(String valueToChange) throws InterruptedException {
        String winhand=get_current_window_handle();
        switch_to_window(winhand);
        click_on_element(maxItemdownArrow);
        selectFromList(maxItemList,valueToChange);
        isElementVisible(currentPageSize);
    }

    public void storeProductDetails() throws InterruptedException, IOException {
      //  Map<Integer,List<String> > productDetailsMap=new HashMap<Integer,List<String>>();
        List<List<String>> productDetailsList=new ArrayList<>();
         int count=0;
            try{
               do{
                List<WebElement> li=find_elements(eachPageProductlocator);
                System.out.println("List Size is:"+li.size());
                for(int i=0;i<li.size();i++){
                    List<String> templist=new ArrayList<String>();
                    List<WebElement> productDetails=find_elements("//div[@class='columns small-5 medium-12']");
                    templist.add(productDetails.get(i).getText());
                   /* System.out.println("Price is:"+ele1);*/
                    productDetailsList.add(templist);
                }
                click_on_element(nextPagebuttonAtTop);

            } while(!nextPageLI.getAttribute("class").contains("disabled"));
            }catch(org.openqa.selenium.ElementClickInterceptedException e){
                Allure.step("User has reached the last page");
            }finally{
                List<WebElement> li=find_elements(eachPageProductlocator);
                System.out.println("List Size is:"+li.size());
                for(int i=0;i<li.size();i++){
                    List<String> templist=new ArrayList<String>();
                    List<WebElement> productDetails=find_elements("//div[@class='columns small-5 medium-12']");
                    templist.add(productDetails.get(i).getText());
                    productDetailsList.add(templist);
                }
            }
            System.out.println("Final list size:"+productDetailsList.size());
            System.out.println(productDetailsList.get(0).get(0));
         String fileName=System.getProperty("user.dir")+"/src/test/resources/data.txt";
        FileWriter fw=new FileWriter(fileName);
        for(List<String> li:productDetailsList){
            fw.write(li.toString()+System.lineSeparator());
        }
        fw.close();

        Allure.step("Values are stored in the data.txt file");
        ReportUtility.addAttachmentToAllure(fileName);
    }
}
