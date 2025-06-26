package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import runners.BaseTest;


import static utils.ErrorMessage.PASSWORD_REQUIRED;
import static utils.ErrorMessage.USERNAME_REQUIRED;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void testEmptyCredentials_UC1() {
        LoginPage login = new LoginPage(driver);
        login.clickLogin();
        assertThat(login.getErrorMessage())
                .as("Check error message when credentials are empty")
                .isEqualTo(USERNAME_REQUIRED);
    }

    @Test
    public void testUsernameOnly_UC2() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.clickLogin();
        assertThat(login.getErrorMessage())
                .as("Check error message when password is empty")
                .isEqualTo(PASSWORD_REQUIRED);
    }

    @Test
    public void testValidCredentials_UC3() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        assertThat(driver.getCurrentUrl())
                .as("User should be redirected to inventory page")
                .contains("inventory");
    }
}