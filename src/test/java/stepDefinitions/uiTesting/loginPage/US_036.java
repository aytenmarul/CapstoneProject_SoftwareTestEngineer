package stepDefinitions.uiTesting.loginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import static stepDefinitions.uiTesting.Hooks.commonPage;
import static stepDefinitions.uiTesting.Hooks.driver;

public class US_036  {
    @Given("User is on the login page")
    public void UserIsOnTheLoginPage() {

        JSutilities.clickWithJS( commonPage.getHomePage().loginButton);
    }

    @When("the user enters {string} and {string} and clicks on the login button")
    public void theUserEntersAndAndClicksOnTheLoginButton(String email, String password) {
        BrowserUtilities.loginMethod(email,password);

    }

    @Then("the user should see an error message indicating login failure")
    public void theUserShouldSeeAnErrorMessageIndicatingLoginFailure() {

      //  BrowserUtilities.waitForVisibility(commonPage.getHomePage().invalidAlert,2);
        Assert.assertTrue(commonPage.getHomePage().invalidAlert.isDisplayed());
        BrowserUtilities.wait(4);
    }

    @And("the user should not be redirected to the dashboard page")
    public void theUserShouldNotBeRedirectedToTheDashboardPage() {
        Assert.assertNotEquals("https://test.urbanicfarm.com/home",driver.getCurrentUrl());

    }

    @Given("User goes to {string}")
    public void userGoesTo(String url) {
        driver.get("https://test.urbanicfarm.com/");
    }
}
