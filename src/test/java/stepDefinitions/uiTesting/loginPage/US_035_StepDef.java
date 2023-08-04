package stepDefinitions.uiTesting.loginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtilities;

import static stepDefinitions.uiTesting.Hooks.commonPage;
import static stepDefinitions.uiTesting.Hooks.driver;
public class US_035_StepDef  {
    @When("As a User clicks login link")
    public void asAUserClicksLoginLink() {
        BrowserUtilities.wait(3);
        commonPage.getHomePage().loginlink.click();
        //JSutilities.clickWithJS(getHomePage().loginButton);
        BrowserUtilities.wait(3);
    }

    @Then("As a User types valid email in email text box")
    public void asAUserTypesValidEmailInEmailTextBox() {
        BrowserUtilities.wait(3);
        commonPage.getLoginPage().loginMethod("aytenmarul23@gmail.com","12345Numbers@");
             //   "ezra_test@mailsac.com","Farmer21");

        BrowserUtilities.wait(15);
    }

    @Then("As a User types valid password in password text box")
    public void asAUserTypesValidPasswordInPasswordTextBox() {
    }

    @Then("As a User clicks the login button")
    public void asAUserClicksTheLoginButton() {
    }

    @Then("As a User verif the {string} alert is displayed")
    public void asAUserVerifTheAlertIsDisplayed(String text) {
        BrowserUtilities.wait(5);
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+text +"')]"));
        Assert.assertTrue(element.isDisplayed());
    }
}
//
//
//    @Then("User clicks on email address box")
//    public void user_clicks_on_email_address_box() {
//        //getLoginPage().emailText.click();
//        //Assert.assertTrue(getLoginPage().emailText.isDisplayed());
//
//        BrowserUtilities.wait(3);
//        getLoginPage().emailBox.click();
//        BrowserUtilities.wait(3);
//    }
//    @Then("User clicks on password box")
//    public void user_clicks_on_password_box() {
//        BrowserUtilities.wait(3);
//        getLoginPage().passwordBox.click();
//        BrowserUtilities.wait(3);
//    }
//
//    @Then("User enters a valid email,password and clicks the login button")
//    public void userEntersAValidEmailPasswordAndClicksTheLoginButton() {
//        BrowserUtilities.wait(3);
//        BrowserUtilities.loginMethod(
//                ConfigurationReader.getProperty("buyerEmail"),
//                ConfigurationReader.getProperty("buyerPassword"));
//        BrowserUtilities.wait(3);
//    }

//    @Then("User closes the {string} alert")
//    public void userClosesTheAlert(String welcomeToUrbanicFarm) {
//        BrowserUtilities.waitForVisibility(getSellShareTradePage().welcomeToUrbanicFarmCloseButton,45);
//        getSellShareTradePage().welcomeToUrbanicFarmCloseButton.click();
//    }



   /* @Then("User verifies {string} alert is visible")
    public void userVerifiesAlertIsVisible(String welcomeToUrbanicFarm) {
        BrowserUtilities.wait(2);
        Assert.assertTrue(getLoginPage().alertWelcomeToUrbanicFarm.isDisplayed());
        BrowserUtilities.wait(2);
    }
*/
