package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class WindowHandlingPage {
    WebDriver driver;

    public void WindowHandlingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card-body']//h5[contains(text(),\"Alerts, Frame & Windows\")]")
    private WebElement alertCard;

    @FindBy(xpath = "//li[contains(.,'Browser Windows')]")
    private WebElement browserWindowOption;

        @FindBy(id = "tabButton")
    private WebElement tabButton;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    public void navigateToAlert(){
        ElementUtils.click(alertCard,driver);
    }

    public void navigateToList(){
        ElementUtils.click(browserWindowOption,driver);
    }

    public void triggerTabButton(){
        ElementUtils.click(tabButton,driver);
    }

    public String getSampleText(){
       return ElementUtils.getElementText(sampleHeading);
    }

}
