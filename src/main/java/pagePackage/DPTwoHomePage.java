package pagePackage;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonMethods;
import utility.ReportUtility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPTwoHomePage extends CommonMethods {
    public DPTwoHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//footer")
    WebElement footer;

    @FindBy(xpath = "//footer//nav//ul/li")
    List<WebElement> hyperlinks;

    public void scrollToPageBottom(){
        mouse_hover_on_element(footer);
    }

    public void check_Duplicate_hyperlinks(){
        Map<String,Integer> mp=new HashMap<>();
        for(WebElement ele:hyperlinks){
            if(!mp.containsKey(ele.getText().trim())){
                mp.put(ele.getText(),1);
            }else{
                mp.put(ele.getText(),mp.get(ele.getText())+1);
            }
        }

        for(String key:mp.keySet()){
            if(mp.get(key)>1){
                Allure.step(key+" is present in the list "+mp.get(key)+" times.");
            }
        }
        //try(FileWriter csvWriter=new FileWriter(System.getProperty("user.dir")+"/src/test/resources/hyperlinks.csv")){
        try (Writer writer = new FileWriter(System.getProperty("user.dir")+"/src/test/resources/hyperlinks.csv")) {
            for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        ReportUtility.addAttachmentToAllure(System.getProperty("user.dir")+"/src/test/resources/hyperlinks.csv");
    }
}
