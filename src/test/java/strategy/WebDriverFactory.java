package strategy;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserName) {
        BrowserStrategy strategy;

        switch (browserName.toLowerCase()) {
            case "chrome":
                strategy = new ChromeStrategy();
                break;
            case "firefox":
                strategy = new FirefoxStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        return strategy.createDriver();
    }
}

