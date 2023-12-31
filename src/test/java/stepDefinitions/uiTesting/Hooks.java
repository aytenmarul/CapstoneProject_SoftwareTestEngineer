package stepDefinitions.uiTesting;

import com.github.javafaker.Faker;
import enums.USER;
import enums.USERINFO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
//import utilities.ApiUtilities;
import utilities.BrowserUtilities;
import utilities.DatabaseUtilities;
import utilities.Driver;

import java.util.Random;


public class Hooks {
    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Faker faker =new Faker();
    public static Random random = new Random();

    public static Actions actions;
    public static boolean isCookiesDeleted = true;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before("@UI")
    public void setup() {

        driver = Driver.getDriver();

        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        BrowserUtilities.localClear();

//        int size = driver.getWindowHandles().size();
//        if (size > 1) {
//
//            driver.close();
//        }

    }


    @Before("@DB")
    public void setupDatabase() {
        DatabaseUtilities.createConnection();

    }

    @After("@DB")
    public void closeDatabase() {
        DatabaseUtilities.closeConnection();

    }

    @Before(order = 2, value = "@buyer")
    public void loginAsBasic() {
        BrowserUtilities.loginMethod(USERINFO.BUYER);
    }

    @Before(order = 2, value = "@seller")
    public void loginAsStandard() {
        BrowserUtilities.loginMethod(USERINFO.SELLER);
    }

//
//    @Before("@ezra")
//    public void loginAPI() {
//        ApiUtilities.loginWithAPI(USER.EZRA.getEmail(), USER.EZRA.getPassword());
//    }
}
