package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasicTestUtil {
    public WebDriver driver;
    public String TradePackURL, browser;
    public int implicitWait;

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void setupDriverAndOpenTestAddress(){
        readConfig("src/test/resources/config.properties");
        setupWebDriver();
        driver.get(TradePackURL);
    }

    private void readConfig(String confFile){
        try {
            FileInputStream fileInputStream = new FileInputStream(confFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            TradePackURL = properties.getProperty("TradePackURL");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private void setupWebDriver(){
        switch (browser){
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
        }
    }

    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver setupFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
