
package stepDefinitions.uiTesting.homePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import java.util.List;

import static stepDefinitions.uiTesting.Hooks.driver;

public class US001_StepDefs extends CommonPage {
    @Given("User verifies Urbanic Farm Logo is visible")
    public void userVerifiesUrbanicFarmLogoIsVisible() {
        Assert.assertTrue(getHomePage().urbanicFarmLogo.isDisplayed());
    }


    @And("User verifies {string} link is displayed")
    public void userVerifiesLinkIsDisplayed(String supportLink) {
        Assert.assertTrue(getHomePage().supportTheLocalFoodMovementLink.isDisplayed());
        BrowserUtilities.wait(2);
    }

    @And("User verifies {string} is visible")
    public void userVerifiesIsVisible(String str, DataTable dta) {
        List<String> headers = dta.column(0);
        for (int i = 0; i<headers.size() ; i++) {
            Assert.assertEquals(headers.get(i), getHomePage().headersList.get(i).getText());
        }
        /*for each methodu "List elementlerde kullanilabilir"
        for (WebElement each : topSubmodel) {
                   Assert.assertTrue(each.isDisplayed());
        }*/

        System.out.println(getHomePage().headersList.get(1).getText());

    }

    @Given("User verifies Blog Link is clickable and clicks")
    public void userVerifiesBlogLinkIsClickableAndClicks() {
        Assert.assertTrue(getHomePage().blogLink.isDisplayed());
        getHomePage().blogLink.click();
        BrowserUtilities.wait(2);
        driver.navigate().to("https://test.urbanicfarm.com/");
    }

    @Then("User verifies relevant Blog Page with url")
    public void userVerifiesRelevantBlogPageWithUrl() {
        Assert.assertEquals("https://test.urbanicfarm.com/", driver.getCurrentUrl());


    }
    @When("user clicks to explore button")
    public void userClicksToExploreButton() {
        getHomePage().exploreLink.click();
//        BrowserUtilities.wait(2);
    }

    @Then("user verifies relavent page is {string}")
    public void userVerifiesRelaventPageIs(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @When("user clicks to About Us button")
    public void userClicksToAboutUsButton() {

        getHomePage().aboutUsLink.click();
    }
    @Then("user verifies relevant page is {string}")
    public void userVerifiesRelevantPageIs(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Then("User assert register now button is clickable")
    public void userAssertRegisterNowButtonIsClickable(){
        Assert.assertTrue(getHomePage().registernow.isEnabled());
    }

    @When("User clicks on register now button")
    public void userClicksOnRegisterNowButton(){
        JSutilities.clickElementByJS(getHomePage().registernow);
    }



    @Then("User verified the url is {string}")
    public void userVerifiedTheUrlIs(String expectedurl) {
        Assert.assertEquals(expectedurl,driver.getCurrentUrl());
    }
    @And("user goes to the {string} heading")
    public void userGoesToTheHeading(String arg0) {
        JSutilities.scrollToWebElement(getHomePage().contributionToTheEnvironmentAndSocietyHeading);
        BrowserUtilities.wait(2);
    }


    @Then("user verifies that the {string} heading is clickable")
    public void user_verifies_that_the_heading_is_clickable(String string) {
        Assert.assertTrue(getHomePage().registerNowLink.isEnabled());
    }
    @And("User checks the Login button is clickable")
    public void userChecksTheLoginButtonIsClickable() {

        Assert.assertTrue(getHomePage().loginButton.isDisplayed());

    }

    @Then("User clicks Login button")
    public void userClicksLoginButton() {

        getHomePage().loginButton.click();
        BrowserUtilities.wait(3);

    }

    @Then("User verifies if Login page is visible")
    public void userVerifiesIfLoginPageIsVisible() {

        Assert.assertEquals("https://test.urbanicfarm.com/auth/login", driver.getCurrentUrl());

    }
    @And("User checks the Contact Us button is clickable")
    public void userChecksTheContactUsButtonIsClickable() {

        getHomePage().contactUsLink.isEnabled();

    }

    @Then("User clicks Contact Us button")
    public void userClicksContactUsButton() {

        getHomePage().contactUsLink.click();

    }

    @Then("User verifies if Contact Us page is visible")
    public void userVerifiesIfContactUsPageIsVisible() {

        Assert.assertEquals("https://test.urbanicfarm.com/contact-us", driver.getCurrentUrl());

    }
}
