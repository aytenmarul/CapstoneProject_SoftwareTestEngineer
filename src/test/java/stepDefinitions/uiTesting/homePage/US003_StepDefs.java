package stepDefinitions.uiTesting.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.Driver;
import utilities.JSutilities;

import java.util.Set;

import static stepDefinitions.uiTesting.Hooks.actions;
import static stepDefinitions.uiTesting.Hooks.driver;
import static utilities.Driver.getDriver;

public class US003_StepDefs extends CommonPage {


    @When("User click Discover Local link")
    public void User_click_Discover_Local_link() {
        getHomePage().discoverLink.click();
    }
    @Then("User verifies relevant pages url")
    public void User_verifies_relevant_pages_url() {
        Assert.assertEquals("https://test.urbanicfarm.com/explore",driver.getCurrentUrl());
    }

    @And("User scrolls down the home page")
    public void userScrollsDownTheHomePage() {
        actions.sendKeys(Keys.END).perform();
        BrowserUtilities.wait(3);

    }


    @When("User clicks on the Get The App")
    public void user_clicks_on_the_get_the_app() {
        BrowserUtilities.wait(2);
        getHomePage().getTheApp.click();
        BrowserUtilities.wait(2);
    }

    @Then("User verifies Get The App visible")
    public void userVerifiesGetTheAppVisible() {
        Assert.assertTrue(getHomePage().getTheApp.isDisplayed());
        BrowserUtilities.wait(2);
    }

    @When("User clicks on Sell-Share-Trade under the Features bottom")
    public void userClicksOnSellShareTradeUnderTheFeaturesBottom() {
        //getHomePage().sellShareTrade.click();
        BrowserUtilities.wait(2);
        JSutilities.clickWithJS(getHomePage().sellShareTrade);
        BrowserUtilities.wait(2);
    }

    @Then("User verifies {string} visible")
    public void userVerifiesVisible(String sellShareTrade) {
        Assert.assertTrue(getHomePage().sellShareTrade.isDisplayed());
        BrowserUtilities.wait(2);
    }

    @And("the user clicks the {string}.")
    public void theUserClicksThe(String arg0) {
        BrowserUtilities.wait(3);
        getHomePage().aboutUs.isEnabled();
        getHomePage().aboutUs.click();


    }


    @Then("the user verifies the About us is enabled.")
    public void theUserVerifiesTheAboutUsIsEnabled() {
        BrowserUtilities.wait(3);
        Assert.assertTrue(getHomePage().aboutUs.isEnabled());
    }

    @Then("the user verifies the page is {string}.")
    public void theUserVerifiesThePageIs(String expectedurl) {
        String actualurl = getDriver().getCurrentUrl();
        Assert.assertEquals(expectedurl, actualurl);


    }

    @When("the user navigate to current.")
    public void theUserNavigateToCurrent() {
        driver.navigate().to("https://test.urbanicfarm.com/");
    }


    @And("the user clicks the Privacy Policy.")
    public void theUserClicksThePrivacyPolicy() {

        BrowserUtilities.wait(2);
    getHomePage().privacyPolicy.click();
        BrowserUtilities.wait(3);
    }

    @Then("the user verifies the Privacy Policy is enabled.")
    public void theUserVerifiesThePrivacyPolicyIsEnabled() {

        Assert.assertTrue(getHomePage().privacyPolicy.isEnabled());
    }


//    @And("the user clicks the Terms Of Service.")
//    public void theUserClicksTheTermsOfService() {
//    }
//
//    @Then("the user verifies the Terms Of Service is enabled.")
//    public void theUserVerifiesTheTermsOfServiceIsEnabled() {
//    }


    @And("the user clicks the Terms Of Service.")
    public void theUserClicksTheTermsOfService() {

        BrowserUtilities.wait(2);
      getHomePage().termOfservice.click();
    }

    @Then("the user verifies the Terms Of Service is enabled.")
    public void theUserVerifiesTheTermsOfServiceIsEnabled() {

        BrowserUtilities.wait(2);
       getHomePage().termOfservice.isEnabled();
        Assert.assertTrue(getHomePage().termOfservice.isEnabled());
    }
//    @And("user goes  the {string} heading")
//    public void userGoesTheHeading(String arg0) {
//        JSutilities.scrollToWebElement(getHomePage().ReduceWasteStrengthenYourCommunityHeading);
//    }
//
//
//    @Then("user verifies  the {string} heading is clickable")
//    public void userVerifiesTheHeadingIsClickable(String arg0) {
//        Assert.assertTrue(getHomePage().WhatsNearYouLink.isEnabled());
//        Assert.assertTrue(getHomePage().PostYourGoodsLink.isEnabled());
//    }
//
//    @Then("User assert the go wefunder  button is clickable")
//    public void userAssertTheGoWefunderButtonIsClickable() {
//        Assert.assertTrue(getHomePage().goWefunderButton.isEnabled());
//
//
//    }
//
//    @When("User clicks on go wefunder button")
//    public void userClicksOnGoWefunderButton() {
//
//        JSutilities.clickElementByJS(getHomePage().goWefunderButton);
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        System.out.println(allWindowHandles);
//        String window1Handle = driver.getWindowHandle();
//        for (String eachHandle : allWindowHandles) {
//            if (!eachHandle.equals(window1Handle)) {
//                driver.switchTo().window(eachHandle);
//                break;
//            }
//        }
//    }


//    @And("user clicks on Blog option under the Explore Icon")
//    public void user_Clicks_On_Blog_Icon_Under_The_Explore_Icon() {
//        BrowserUtilities.wait(3);
//        getHomePage().blogOption.click();
//
//
//    }
//    @Then("user verifies that current url")
//    public void user_Verifies_That_CurrentUrl_Is() {
//        // Assert.assertEquals("https://test.urbanicfarm.com/blog/",driver.getCurrentUrl());
//        Assert.assertEquals("https://urbanicfarm.com/blog/",driver.getCurrentUrl());
//
//    }

    @Then("User checks the Facebook button is clickable")
    public void userChecksTheFacebookButtonIsClickable() {

        Assert.assertTrue(getHomePage().facebookButton.isEnabled());

    }

    @Then("User clicks the Facebook button")
    public void userClicksTheFacebookButton() {

        getHomePage().facebookButton.click();
        BrowserUtilities.wait(2);
    }

    @Then("User verifies if Facebook page is visible")
    public void userVerifiesIfFacebookPageIsVisible() {
String link="https://www.facebook.com/urbanicfarmstead";
        Set<String> allWindowHandles = driver.getWindowHandles();
        String window1Handle=driver.getWindowHandle();
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        Assert.assertEquals("https://www.facebook.com/urbanicfarmstead", driver.getCurrentUrl());

    }

    @Then("User checks the LinkedIn button is clickable")
    public void userChecksTheLinkedInButtonIsClickable() {

        Assert.assertTrue(getHomePage().linkedInButton.isEnabled());

    }

    @Then("User clicks the LinkedIn button")
    public void userClicksTheLinkedInButton() {

        getHomePage().linkedInButton.click();

    }

    @Then("User verifies if LinkedIn page is visible")
    public void userVerifiesIfLinkedInPageIsVisible() {

        Set<String> allWindowHandles = driver.getWindowHandles();
        String window1Handle=driver.getWindowHandle();
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        Assert.assertEquals("https://www.linkedin.com/", driver.getCurrentUrl());

    }
    @Then("User verifies that Address is visible")
    public void user_verifies_that_address_is_visible() {
        BrowserUtilities.wait(2);
        Assert.assertTrue(getHomePage().address.isDisplayed());
        BrowserUtilities.wait(2);
    }


    @Then("user verifies the contents of current address")
    public void userVerifiesTheContentsOfCurrentAddress() {
        BrowserUtilities.wait(2);
        Assert.assertTrue(getHomePage().addressContent.isDisplayed());
        BrowserUtilities.wait(2);
    }
    @And("user clicks on phone")
    public void userClicksOnPhone() {
        BrowserUtilities.wait(5);
        BrowserUtilities.scrollToElement(getHomePage().phoneHomePage);
        getHomePage().phoneHomePage.click();

    }


    @Then("user verifies that pop-up is visible")
    public void userVerifiesThatPopUpIsVisible() {
        BrowserUtilities.wait(2);
//      Alert alert= (Alert) driver.switchTo();
//      alert.getText();

        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.toString();
        System.out.println(javascriptExecutor.toString());

        BrowserUtilities.wait(3);
    }
}
