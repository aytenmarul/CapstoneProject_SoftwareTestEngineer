package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsPage extends CommonPage {


//input[@class='eventRegister_custom-checkbox__3eYP8']
//div/span[.='Events']

//div/span[.='Events']


    @FindBy(xpath = "//*[contains(text(),'Create New Event')]")
    public WebElement createNewbutton;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement title;



}