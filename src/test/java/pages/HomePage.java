package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends CommonPage {

    @FindBy(xpath = "(//a[@href='/auth/login'])[1]")
    public WebElement loginButton;


           @FindBy(xpath=  "(//a[@href='/auth/login'])[1]")
           public WebElement loginlink;


     @FindBy(xpath = "(//a[text()='Logout'])[2]")
    public WebElement logoutButton;

    @FindBy(css = ".Navbar_textLink__f6_Al.mr-2")
    public WebElement registerButton_navbar;

    @FindBy(css = "nav>a[href^='/account/home']")
    public WebElement accountName_navbar;

    @FindBy(xpath = "//a[contains(text(),'Discover Local Sellers Near You')]")
    public WebElement discoverLink;

    @FindBy(xpath = "//*[@id='Urban\\u0131cFarm']")
    public WebElement urbanicFarmLogo;

    @FindBy(xpath = "//*[text()='Support the local food movement']")
    public WebElement supportTheLocalFoodMovementLink;


    @FindBy(xpath = "//*[@class='Navbar_linkContainer__2jWIM']//a")
    public List<WebElement> headersList;

    @FindBy(xpath = "(//*[text()='Blog'])")
    public WebElement blogLink;

    @FindBy(xpath=  "//a[@href='/account/home']")
    public WebElement eventslink;

    @FindBy(xpath = "//div[@class='row p-0']")
    private List<WebElement> productCards;

    @FindBy(css = "div.ProductCard_namePrice__1GlyT > p")
    public List<WebElement> productPrices;

    @FindBy(xpath = "//button[contains(@class,'btn-success ProductCard_addCartBtn___oxgf') and text()='Add to Cart']")
    public List<WebElement> productAddToCart;
    @FindBy(xpath = "//span[@class='Navbar_cartText__1jkrK']")
    public WebElement go_to_cart_button;
    @FindBy(xpath ="//div[@class='Toastify']")
            //*[contains(text(),'Invalid creds')]")
    public WebElement invalidAlert;


    @FindBy(xpath = "//a[contains(text(),'blog')]" )
    public WebElement blogOption;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerButton;

    @FindBy(xpath = "(//*[text()='Welcome to Urbanic Farm!'])[1]")
    public WebElement welcomeTheUrbanicFarmWindowText;
    @FindBy(xpath = "//button[@class='close btn']")
    public WebElement welcomeTheUrbanicFarmWindowCloseButton;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerLink;

    //@FindBy(css = ".Footer_social-links__FYd8U a" )
    @FindBy(xpath="//a[@href='https://www.facebook.com/urbanicfarmstead']")
    public WebElement facebookButton;


    @FindBy(xpath = "//div[@class='Footer_social-links__FYd8U']//following::a" )
    public WebElement linkedInButton;

    @FindBy(xpath = "//*[text()='Contact Us']")
    public WebElement contactUsLink;


    @FindBy(xpath = "//*[text()='Contribution to the Environment and Society']")
    public WebElement contributionToTheEnvironmentAndSocietyHeading;

    @FindBy(xpath = "//*[text()='Register Now']")
    public WebElement registerNowLink;

    @FindBy(xpath = "//button[text()='Sell your produce']")
    public  WebElement sellyourproduce;

    @FindBy(xpath = "(//a[@href='/about'])[3]")
    public WebElement aboutUs;

    @FindBy(xpath = "//a[@href='/privacy-policy']")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//a[@href='/terms-of-service']")
    public WebElement termOfservice;


    @FindBy(xpath = "(//a[@href='/explore'])[1]")
      //      "//div/a[text()='Explore']")
    public WebElement exploreLink;

//
//    @FindBy(css = "nav>a[href^='/account/home']")
//    public WebElement accountName_navbar;
//


    @FindBy(xpath = "(//*[text()='get the app'])[2]")
    public WebElement getTheApp;

    @FindBy(xpath = "//*[.='Sell-Share-Trade']")
    public WebElement sellShareTrade;


    @FindBy(xpath = "(//a[@class='d-block'])")
    public WebElement address;


    @FindBy(xpath = "(//address[contains(text(),'Dr San Jose, Californ')])")
    public WebElement addressContent;

    @FindBy(xpath ="//*[text()='Reduce waste, strengthen your community']" )
    public WebElement ReduceWasteStrengthenYourCommunityHeading;

    @FindBy(xpath ="//*[text()='Whats Near You']" )
    public WebElement WhatsNearYouLink;

    @FindBy(xpath ="//*[text()='Post Your Goods']" )
    public WebElement PostYourGoodsLink;


    @FindBy (xpath = "//div/a[@href= '/about']")
    public WebElement aboutUsLink;

    @FindBy(xpath = "(//a[@href='/auth/login'])[1]")
    public WebElement loginmodule;

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn btn-outline-success px-4']")
    public WebElement ssubmitButton;

    @FindBy(xpath = "//div[@class='Navbar_addHub__USGHm']")
    public WebElement sellShareTradeButton;

    @FindBy(xpath = "//a[text()='Phone:']")
    public WebElement phoneHomePage;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutButton2;

    @FindBy(xpath = "//button[text()='Register now!']" )
    public WebElement registernow;

    @FindBy(xpath = "//button[text()='GO WEFUNDER']" )
    public WebElement goWefunderButton;

    @FindBy(xpath = "(//span[contains(text(),'Sell-Share-Trade')])[1]")
    public WebElement sellShareTradeLink;

    @FindBy(xpath = "//input[@class='ProductCard_number__1yGnR']")
    public WebElement productAdcartNumberSeenIcon;

    @FindBy(xpath = "//div[@class='ProductCard_stockInfo__1vJgJ']")
    public WebElement listOfPoundAvailable;
//    @FindBy(xpath = "//div[@class='row p-0']")
//    private List<WebElement> productCards;
//    @FindBy(css = "div.ProductCard_namePrice__1GlyT > p")
//    public List<WebElement> productPrices;
//
//    @FindBy(xpath = "//button[contains(@class,'btn-success ProductCard_addCartBtn___oxgf') and text()='Add to Cart']")
//    public List<WebElement> productAddToCart;
//    @FindBy(xpath = "//span[@class='Navbar_cartText__1jkrK']")
//    public WebElement go_to_cart_button;

    @FindBy(xpath = "(//*[text()='Contact Us'])[2]")
    public WebElement contactUsNavbar;


    @FindBy (xpath = "//div[@class='Chat_chatBtn__1R54Q']")
    public WebElement sendMessageIcon;

    @FindBy (xpath = "//div[@class='col-4 pb-5 Chat_conversation_card_container__D00UY']/div")
    public List<WebElement> sendMessageParticipant;

    @FindBy (xpath = "//input[@class='Chat_input__1XjY8']")
    public WebElement enterToSendMessage;


    public List<WebElement> getProductNames() {

        return productCards.stream()
                .map(t -> t.findElement(By.cssSelector("p.m-0.text-white.ProductCard_productTitle__3K4rg")))
                .collect(Collectors.toList());

    }

}
