package utility;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverHandler {
    static WebDriver driver;
    public static WebDriver getDriver() {


        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed.default_content_settings.images", 1);
        //  options.addArguments("window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        /* driver.manage().window().maximize();*/
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return driver;
    }
}
