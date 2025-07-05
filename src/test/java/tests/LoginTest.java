package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.LoginPage;
import runners.BaseTest;
import utils.ConfigReader;

import static utils.ErrorMessage.PASSWORD_REQUIRED;
import static utils.ErrorMessage.USERNAME_REQUIRED;

public class LoginTest extends BaseTest {

    @Test
    public void testEmptyCredentials_UC1() {
        // given
        getDriver().get(ConfigReader.getBaseUrl());
        LoginPage login = new LoginPage(getDriver());

        // when
        login.loginWithClearedUsernameAndPassword("testUser", "testPass");
        
        // then
        Assertions.assertThat(login.getErrorMessage()).isEqualTo(USERNAME_REQUIRED);
    }

    @Test
    public void testUsernameOnly_UC2() {
        // given
        getDriver().get(ConfigReader.getBaseUrl());
        LoginPage login = new LoginPage(getDriver());

        // when
        login.loginWithClearedPassword("standard_user", "anyPass");

        // then
        Assertions.assertThat(login.getErrorMessage()).isEqualTo(PASSWORD_REQUIRED);
    }

    @Test
    public void testValidCredentials_UC3() {
        // given
        getDriver().get(ConfigReader.getBaseUrl());
        LoginPage login = new LoginPage(getDriver());
        
        // when
        login.loginAs("standard_user", "secret_sauce");
        
        // then
        Assertions.assertThat(getDriver().getCurrentUrl()).contains("inventory");
    }
}

