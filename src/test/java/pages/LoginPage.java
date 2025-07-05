package pages;

import org.openqa.selenium.*;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameInput = By.cssSelector("#user-name");
    private final By passwordInput = By.cssSelector("#password");
    private final By loginButton = By.cssSelector("#login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();

    }

    public void loginWithClearedUsernameAndPassword(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clearUsername();
        clearPassword();
        clickLogin();

    }

    public void loginWithClearedPassword(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clearPassword();
        clickLogin();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    private void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    private void clickLogin() {
        driver.findElement(loginButton).click();
    }

    private void clearUsername() {
        WebElement element = driver.findElement(usernameInput);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    private void clearPassword() {
        WebElement element = driver.findElement(passwordInput);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}

