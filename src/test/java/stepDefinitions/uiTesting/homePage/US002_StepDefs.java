package stepDefinitions.uiTesting.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import java.util.Set;

import static stepDefinitions.uiTesting.Hooks.driver;

public class US002_StepDefs extends CommonPage {

    @And("user goes  the {string} heading")
    public void userGoesTheHeading(String arg0) {
        JSutilities.scrollToWebElement(getHomePage().ReduceWasteStrengthenYourCommunityHeading);
    }

    @And("user waits {int} second")
    public void userWaitsSecond(int arg0) {
        BrowserUtilities.wait(2);
    }

    @Then("user verifies  the {string} heading is clickable")
    public void userVerifiesTheHeadingIsClickable(String arg0) {
        Assert.assertTrue(getHomePage().WhatsNearYouLink.isEnabled());
        Assert.assertTrue(getHomePage().PostYourGoodsLink.isEnabled());
    }

    @Then("User assert the go wefunder  button is clickable")
    public void userAssertTheGoWefunderButtonIsClickable() {
        Assert.assertTrue(getHomePage().goWefunderButton.isEnabled());


    }

    @When("User clicks on go wefunder button")
    public void userClicksOnGoWefunderButton() {

        JSutilities.clickElementByJS(getHomePage().goWefunderButton);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        String window1Handle = driver.getWindowHandle();
        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
    }


    @And("user clicks on Blog option under the Explore Icon")
    public void user_Clicks_On_Blog_Icon_Under_The_Explore_Icon() {
        BrowserUtilities.wait(3);
        getHomePage().blogOption.click();


    }

    @Then("user verifies that current url")
    public void user_Verifies_That_CurrentUrl_Is() {
        // Assert.assertEquals("https://test.urbanicfarm.com/blog/",driver.getCurrentUrl());
        Assert.assertEquals("https://urbanicfarm.com/blog/", driver.getCurrentUrl());

    }



}