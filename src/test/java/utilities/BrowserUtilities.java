package utilities;

import enums.USERINFO;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static stepDefinitions.uiTesting.Hooks.*;

public class BrowserUtilities {

    static Random random = new Random();

    public static void loginMethod(USERINFO userinfo) {

        driver.get("https://test.urbanicfarm.com/auth/login");
        commonPage.getLoginPage().loginMethod(userinfo);
    }

    public static void loginMethod(String userName, String password) {
        driver.get("https://test.urbanicfarm.com/auth/login");
        commonPage.getLoginPage().loginMethod(userName, password);
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void localClear() {
        LocalStorage local = ((WebStorage) Driver.getDriver()).getLocalStorage();
        local.clear();
        Driver.getDriver().navigate().refresh();
        waitForPageToLoad(10);

    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    /**
     * methood used to clean text
     *
     * @param webElement webelemnt will be cleaned
     * @author omeryttnc
     * @since 01.02.2023
     */
    public static void cleanTextFromWebelemnt(WebElement webElement) {
// omer -> 4 -> 4 defa backspace
        // a -> 1
        int valueLength = webElement.getAttribute("value").length();

        for (int i = 0; i < valueLength; i++) {
            actions.sendKeys(Keys.BACK_SPACE).perform();
            actions.sendKeys(Keys.DELETE).perform();

        }

    }


    /**
     * method used to assert text color of web element
     *
     * @param rgba       webelementin rgba degeri
     * @param webElement bakilcak weblement
     * @author omeryttnc
     * @since 01.02.2023
     */
    public static void assertTextColor(String rgba, WebElement webElement) {
        Assert.assertEquals(rgba, webElement.getCssValue("color"));
    }


    /**
     * method verdigimiz listeden sectigimiz bir objeyi cikartip bize bir tane random obje verecek
     *
     * @param flags icerisinde String turunde variable larimiz oldugu liste
     * @param flag  istemedigimiz String degerimiz
     * @return istemedigimiz String haricinde listeden verilecek bir parametre
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static String giveMeRandomFlag(List<String> flags, String flag) {
        flags.remove(flag);
        int randomFlag = random.nextInt(flags.size());
        return flags.get(randomFlag);
    }

    /**
     * method bize listeden random bir String degeri verecek
     *
     * @param flags icerisinde String turunde variable larimiz oldugu liste
     * @return listeden rastgele alacagimiz bir String
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static String giveMeRandomFlag(List<String> flags) {
        int randomFlag = random.nextInt(flags.size());
        return flags.get(randomFlag);
    }

    /**
     * method webelementin resmini almak icin kullanildi
     *
     * @param webElement resmini alacagimiz webelement
     * @param filePath   aldigimiz resmi koyacagimiz yol
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static void screenShotWebElement(WebElement webElement, String filePath) {

        File screenshotAs = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotAs, new File(filePath));
        } catch (IOException e) {
            //System.out.println("dosya bulunamadi");
            throw new RuntimeException(e);
        }
    }

    /**
     * method bize iki resim farkli mi oldugunu gosteriyor
     *
     * @param image1Path ilk resmin yolu
     * @param image2Path ikinci resmin yolu
     * @return iki resim birbirinden FARKLI mi, farkli ise true ayni ise false donecek
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean assertImageAreDifferent(String image1Path, String image2Path) {
        BufferedImage image1, image2;
        try {
            image1 = ImageIO.read(new File(image1Path));
            image2 = ImageIO.read(new File(image2Path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ImageDiffer imageDiffer = new ImageDiffer();
        ImageDiff diff = imageDiffer.makeDiff(image1, image2);


        return diff.hasDiff();
    }

    /**
     * method webelemente tiklayabilecegimiz ana kadar bekliyecek
     *
     * @param webElement bekleyecegimiz webelement note: bekleme suresini default olarak 10 saniye yaptim
     * @return bekledigimiz webelement
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static WebElement waitForClickable(WebElement webElement) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));

        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * method bilgisayarimizda olan bir dosyayi silmeye yariyor
     *
     * @param filePath silinecek dosyanin oldugu klasorun yolu
     * @param fileName silinecek dosyanin adi note: uzantisiyla beraber
     * @return eger dosya silindi ise true silinemedi ise false
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean deleteFile(String filePath, String fileName) {
        File file = new File(filePath);

        File[] listFiles = file.listFiles();

        for (File w : listFiles
        ) {

            if (w.getName().equals(fileName)) {
                w.delete();
                break;
            }

        }
        return false;

    }

    /**
     * method bilgisayarimizda olan bir dosyanin varligini gosteriyor
     *
     * @param filePath bakacagimiz dosyanin oldugu klasorun yolu
     * @param fileName bakacagimiz dosyanin adi note: uzantisiyla beraber
     * @return eger dosya var ise true yok ise false dondurecek
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean fileIsExist(String filePath, String fileName) {

        File file = new File(filePath);

        File[] listFiles = file.listFiles();

        for (File w : listFiles
        ) {

            if (w.getName().equals(fileName)) {
                return w.exists();
            }

        }
        return false;
    }

    /**
     * method bize 11 haneli random bir sayi verecek
     *
     * @return 11 haneli bir sayi
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static String fakePhoneNumber() {

        String phone = "1";

        StringBuilder fakeResult = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            fakeResult.append(random.nextInt(10));

        }
        return "1" + fakeResult.toString();


    }

    /**
     * method webelementin UI da gozukup gozukmedigini anlamamiza yarayacak
     *
     * @param webElement bakacagimiz webelement
     * @return eger gozukuyorsa true gozukmuyorsa false donecek
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean isDisplayed(WebElement webElement) {
        boolean flag;


        try {
            flag = webElement.isDisplayed();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }


    /**
     * method javascript kullanilarak verilen webelemente tiklanmasini sagliyor
     *
     * @param webElement tiklanacak web element
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static void scrollAndClickWithJS(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", webElement);
    }

    /**
     * method token kullanarak local storage i doldurup, login sayfasina gitmeden login yapmamizi sagliyor
     *
     * @param token kullanicinin token i
     * @param web   site icerisinde gitmek istedigimiz url note: urbanicfarm.com/  den sonrasi girilmesi lazim
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static void loginWithToken(String token, String web) {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String key1 = "a27c6fac85ae1295535e42c9d3e3f305";
        String key2 = "e3e1601fca9c429344c15527cd542142";

        String url = "https://test.urbanicfarm.com/";

        String value2 = token;
        String value1 = token.split("\\.")[1];
        driver.get(url);
        localStorage.setItem(key1, value1);
        localStorage.setItem(key2, value2);

        driver.get(url + web);
        waitForPageToLoad(10);


    }


    /**
     * method verilen urun isminin statusunu almamizi sagliyor
     *
     * @param productName statusunu kontrol etmek istedigimiz urunun ismi
     * @return urununun statusu. Approved, In-Review , Rejected
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static String getStatusOfProduct(String productName) {
        return driver.findElement(By.xpath("//a[@title='" + productName + "']/../../span")).getText();

    }

    /**
     * method verilen String degerinden harf olmayan herseyi cikarmak icin kullanildi
     *
     * @param str islem yapilacak String degeri
     * @return sadece letter kalmis olan String
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static String removeAllDigits(String str) {
        return "";
    }

    /**
     * method liste halinde verilen webelementden bir tane secmek icin kullanildi
     * select by index gibi calisiyor
     *
     * @param webElement tiklandigi zaman liste acilan webelement
     * @param times      kac defa arrow down a basacagiz
     * @return secilen webelementin value degeri
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static String chooseWebelementFromList(WebElement webElement, int times) {


        return "";
    }

    /**
     * method liste halinde verilen webelementden random olarak bir tane secmek icin kullanildi
     *
     * @param webElement tiklandigi zaman liste acilan webelement
     * @param maxRandom  random olarak bir deger araliginda bir webelemente tiklayacak
     * @return secilen webelementin value degeri
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static String chooseWebelementFromListRandomly(WebElement webElement, int maxRandom) {


        return "";
    }


    public static void toastMessageAssertion(String toastMessage) {
        BrowserUtilities.waitForClickable(commonPage.getAccountPage().toastMessage);
        String actualToastMessage = commonPage.getAccountPage().toastMessage.getText();
        String expectedToastMessage = toastMessage;
        Assert.assertEquals(expectedToastMessage, actualToastMessage);
    }

    public static void assertBorderColor(String rgba, WebElement webElement) {
        Assert.assertEquals(rgba, webElement.getCssValue("border-top-color"));
    }

    /**
     * method is used to switch window by giving window index number
     *
     * @param index index number of windows
     */
    public static void switchToWindow(int index) {
        waitForSecondWindow();
        List<String> windowsHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());

        Driver.getDriver().switchTo().window(windowsHandles.get(index));


    }

    /**
     * method is used to switch window
     */
    public static void switchToWindow() {

        waitForSecondWindow();
        String currentWindowHandle = Driver.getDriver().getWindowHandle(); //current

        Set<String> windowHandles = Driver.getDriver().getWindowHandles(); // current other

        for (String w : windowHandles) {

            if (!currentWindowHandle.equals(w)) {

                Driver.getDriver().switchTo().window(w);
                break;

            }

        }

    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * method is used to wait second window
     */
    private static void waitForSecondWindow() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }

    /**
     * method used to add two double string in proper way
     *
     * @param no1 first double in String format
     * @param no2 second double in String format
     * @return proper addition in String format
     */
    public static String addTwoDouble(String no1, String no2) {

        return "";
    }
    /**
     * method is used to create date and time for creation event
     * @param hours added hours
     * @param days added days
     * @return format which is required for backend
     */
    public static String getTimeForEvent(int hours, int days) {

        // 2024-03-17T21:31

        Calendar calendar  = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        calendar.add(Calendar.HOUR,hours);
        calendar.add(Calendar.DATE,days);
        String format = simpleDateFormat.format(calendar.getTime());

        return format;


    }

}
