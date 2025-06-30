package runners;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import strategy.WebDriverFactory;
import utils.ConfigReader;

public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        driver.set(WebDriverFactory.getDriver(browser));
        getDriver().get("https://www.saucedemo.com/");
        logger.info("Driver initialized and navigated to login page.");
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            logger.info("Driver quit successfully.");
            driver.remove();
        }
    }
}
