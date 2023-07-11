import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginFormTest extends BaseTest {

    @Test
    public void testWithEmptyCredentials() {
        String expectedErrorMessage = "Username is required";

        LoginPage loginPage = LoginPage.open(getDriver());
        loginPage.inputUserName("dummy username")
                .inputPassword("dummy_password")
                .clearUserNameField()
                .clearPasswordField()
                .clickSubmitAndAssertPageNotChanged();

        assertErrorMessageContains(loginPage, expectedErrorMessage);
    }

    @Test
    public void testWithCredentialsByPassingUsername() {
        String expectedErrorMessage = "Password is required";

        LoginPage loginPage = LoginPage.open(getDriver());
        loginPage.inputUserName("dummy username")
                .inputPassword("dummy_password")
                .clearPasswordField()
                .clickSubmitAndAssertPageNotChanged();

        assertErrorMessageContains(loginPage, expectedErrorMessage);
    }

    @Test
    public void testSuccessfulLogin() {
        final String validUserName = "standard_user";
        final String validPassword = "secret_sauce";

        LoginPage loginPage = LoginPage.open(getDriver());
        String actualTitle = loginPage.inputUserName(validUserName)
                .inputPassword(validPassword)
                .clickLoginButton()
                .getLogoText();

        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    private void assertErrorMessageContains(LoginPage loginPage, String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message: '" + loginPage.getErrorMessage() + "' does not contain " +
                        expectedErrorMessage);
    }
}
