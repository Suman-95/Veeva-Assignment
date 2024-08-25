package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FrameworkUtility {


    public static String getValueFromConfig(String key) throws IOException {
        FileReader reader=new FileReader(System.getProperty("user.dir")+"/src/test/resources/data.txt");

        Properties p=new Properties();
        p.load(reader);

       return p.getProperty(key);
    }

}
