package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        String filepath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
        ConfigReader.readProperties(filepath);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("browser not available");
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
