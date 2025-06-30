package strategy;

import org.openqa.selenium.WebDriver;

public interface BrowserStrategy {
    WebDriver createDriver();
}
