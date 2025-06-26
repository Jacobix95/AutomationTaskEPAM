package runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.ConfigReader;
import strategy.WebDriverFactory;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setupClass() throws IOException {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() throws WebDriverException {
        String browser = ConfigReader.getBrowser();
        driver = WebDriverFactory.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        logger.info("Driver initialized and navigated to login page.");
    }

    @AfterMethod
    public void tearDown() throws WebDriverException {
        if (driver != null) {
            driver.quit();
            logger.info("Driver quit successfully.");
        }
    }
}
