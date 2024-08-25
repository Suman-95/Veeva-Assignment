package utility;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReportUtility {

    public static void addAttachmentToAllure(String filePath){
       try{
           byte[] bytes= Files.readAllBytes(Paths.get(filePath));
           Allure.addAttachment("Please refer to the attachment",new ByteArrayInputStream(bytes));
    } catch(Exception e){
           e.getLocalizedMessage();
     }
    }

}
