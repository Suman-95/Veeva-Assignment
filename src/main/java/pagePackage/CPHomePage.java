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

@FindBy(xpath = "//button[text()='I Accept']")
List<WebElement> acceptCookie;

@FindBy(xpath = "//span[text()='...' and @class!='text-xl']")
WebElement threeDots;

@FindBy(xpath = "//*[@id=\"nba-nav\"]/div[2]//a[@title='News & Features']")
List<WebElement> newsFeedoption;

@FindBy(xpath = "//h3[text()='VIDEOS']/../..//ul[@data-testid='content-grid-']/li")
List<WebElement> allVideos;

@FindBy(xpath = "//h3[text()='VIDEOS']/../..//ul[@data-testid='content-grid-']/li//span[@aria-hidden='true']")
List<WebElement> videoDurations;

    public void close_presale_notification(){
        Boolean isVisisble=isElementVisible(closeButtonPresale);
       if(!isVisisble){
           Allure.step("Close button is not visible");
       }else{
           click_on_element(closeButtonPresale.get(0));
       }
       Boolean iscookieVisible=isElementVisible(acceptCookie);
       if(!iscookieVisible){
           Allure.step("Cookie option is not available");
       }else{
           click_on_element(acceptCookie.get(0));
       }

    }

    public void clickValuefromShopMenu(String value){
        mouse_hover_on_element(shopMenu);
        selectFromList(shopMenulist,"Men's");
    }

    public void gotoNewsFeed(){
        mouse_hover_on_element(threeDots);
        selectFromList(newsFeedoption,"News & Features");
    }

    public void validateVideoCount(){
        int totalVieoSize=allVideos.size();
        Allure.step("Total Video Count is:"+(totalVieoSize-1));
        int videomorethan3d=0;
        for(WebElement ele:videoDurations){
            if(ele.getText().contains("d")){
                if(Integer.parseInt(ele.getText().substring(0,ele.getText().length()-1))>3){
                    videomorethan3d++;
                }
            }else{
                videomorethan3d++;
            }
        }
        Allure.step("Total Video more than 3d is:"+videomorethan3d);
    }
}
