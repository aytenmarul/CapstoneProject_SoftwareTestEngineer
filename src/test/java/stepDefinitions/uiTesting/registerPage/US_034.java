package stepDefinitions.uiTesting.registerPage;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static stepDefinitions.uiTesting.Hooks.commonPage;
import static stepDefinitions.uiTesting.Hooks.driver;

public class US_034 {
    static Faker faker = new Faker();
    Actions actions = new Actions(driver);
    List<String> lastNames = new ArrayList<>(Arrays.asList("Apaydin", "Duyarer", "Siler", "Basar"));
    Random rand = new Random();
    public static String firstname=faker.name().firstName();
    public static String middleName=faker.name().firstName();
    public static String lastName=faker.name().lastName().replaceAll("[^A-Za-z]", "");
    public static String email=faker.internet().emailAddress().toLowerCase();


    @And("user fills out the registration form")
    public void userFillsOutTheRegistrationForm() {
//        commonPage.getRegisterPage().firstname.sendKeys(new Faker().name().firstName());

        commonPage.getRegisterPage().firstname.sendKeys(firstname);
        commonPage.getRegisterPage().middleName.sendKeys(middleName);
//        commonPage.getRegisterPage().lastName.sendKeys(faker.name().lastName());
//        commonPage.getRegisterPage().lastName.sendKeys(lastNames.get(rand.nextInt(4)));
        commonPage.getRegisterPage().lastName.sendKeys(lastName);
        commonPage.getRegisterPage().email.sendKeys(email);
        String password = faker.internet().password(8, 30, true, true, true);
        commonPage.getRegisterPage().password.sendKeys(password);
        commonPage.getRegisterPage().confirmPassword.sendKeys(password);
        commonPage.getRegisterPage().zipCode.sendKeys(faker.address().zipCode(), Keys.TAB);
        BrowserUtilities.wait(5);
    }

    @And("user clicks on Register button")
    public void userClicksOnRegisterButton() {
        actions.sendKeys(Keys.END).perform();

        BrowserUtilities.wait(5);
        commonPage.getRegisterPage().registerButton.click();
    }


    @Then("user verifies following elements are visible")
    public void userVerifiesFollowingElementsAreVisible(DataTable dataTable) {
        List<String> texts = dataTable.column(0);

        for (int i = 0; i < texts.size(); i++) {
            WebElement element = driver.findElement(By.xpath("//*[text()='"+texts.get(i)+"']"));
            Assert.assertTrue(element.isDisplayed());
        }

    }

    @And("user verifies following elements are clickable")
    public void userVerifiesFollowingElementsAreClickable(DataTable dataTable) {
        List<String> texts = dataTable.column(0);

        for (int i = 0; i < texts.size(); i++) {
            WebElement element = driver.findElement(By.xpath("//*[text()='"+texts.get(i)+"']"));
            Assert.assertTrue(element.isEnabled());
        }
    }

    @And("user verifies Welcome to Urbanic Farm is visible")
    public void userVerifiesWelcomeToUrbanicFarmIsVisible() {
        Assert.assertTrue(commonPage.getRegisterPage().welcome.isDisplayed());
    }

    @Then("user verifies that url contains {string}")
    public void userVerifiesThatUrlContains(String partialUrl) {
        BrowserUtilities.wait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains(partialUrl));
    }
}
