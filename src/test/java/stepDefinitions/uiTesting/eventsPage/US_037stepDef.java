package stepDefinitions.uiTesting.eventsPage;

import io.cucumber.java.en.And;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import static stepDefinitions.uiTesting.Hooks.commonPage;

import static stepDefinitions.uiTesting.Hooks.driver;

public class US_037stepDef {
    @And("As a user clicks {string} a")
    public void asAUserClicksA(String url) {

      //  driver.get(url);
        BrowserUtilities.wait(5);
    }

    @And("As a user clicks create new events button")
    public void asAUserClicksCreateNewEventsButton() {

        commonPage.getEvent().createNewbutton.click();
        BrowserUtilities.wait(5);
        commonPage.getEvent().title.sendKeys("festival");
        BrowserUtilities.wait(5);
    }

    @And("As a user click events link on the home page")
    public void asAUserClickEventsLinkOnTheHomePage() {
        commonPage.getHomePage().eventslink.click();
        BrowserUtilities.wait(5);
    }

    @And("As a user click exit icon for displayed pop up")
    public void asAUserClickExitIconForDisplayedPopUp() {
    //    driver.get("https://test.urbanicfarm.com/account/weekly-order");
        Actions actions= new Actions(driver);
        actions.moveToElement(commonPage.getAccountPage().exitIcon).click().build().perform();
////

//       JSutilities.scrollToWebElement(commonPage.getAccountPage().exitIcon);
//                JSutilities.clickWithJS(commonPage.getAccountPage().exitIcon);
    }

    @And("User goes to https:\\/\\/test.urbanicfarm.com\\/account\\/home")
    public void userGoesToHttpsTestUrbanicfarmComAccountHome() {

        driver.get("https://test.urbanicfarm.com/account/home");
    }

    @And("As a user clicks myEvent page")
    public void asAUserClicksMyEventPage() {
        driver.get("https://test.urbanicfarm.com/account/events-i-organize");
    }

    @And("As a user clicks myEvent page on the account page")
    public void asAUserClicksMyEventPageOnTheAccountPage() {
        commonPage.getAccountPage().myEvent.click();
        BrowserUtilities.wait(3);


    }

    @And("As a user type title on the new event page")
    public void asAUserTypeTitleOnTheNewEventPage() {
        commonPage.getEvent().title.sendKeys("tester");
    }

    @And("User clicks the Sell-Share-Trade link")
    public void userClicksTheSellShareTradeLink() {
        commonPage.getHomePage().sellShareTrade.click();
        BrowserUtilities.wait(2);

    }
}
