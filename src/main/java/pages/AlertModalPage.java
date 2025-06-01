package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class AlertModalPage {

    WebDriver driver;

    public AlertModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card-body']//h5[contains(text(),\"Alerts, Frame & Windows\")]")
    private WebElement alertCard;

    @FindBy(xpath = "//li[contains(.,'Alerts')]")
    private WebElement alertOption;

    public void navigateToAlertSection() {
        ElementUtils.click(alertCard, driver);
        ElementUtils.click(alertOption, driver);
    }

    @FindBy(id = "alertButton")
    private WebElement simpleAlert;

    public void triggerSimpleAlert() {
        ElementUtils.click(simpleAlert, driver);
    }

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    public void triggerDelayedAlert() {
        ElementUtils.click(timerAlertButton, driver);
    }

    @FindBy(id="confirmButton")
    private WebElement confirmButton;

    public void triggerConfirmButton(){
        ElementUtils.click(confirmButton, driver);
    }

    @FindBy(xpath = "//li[contains(.,'Modal Dialogs')]")
    private WebElement modalOption;

    @FindBy(id = "showSmallModal")
    private WebElement smallModal;

    @FindBy(id = "example-modal-sizes-title-sm")
    private WebElement smallModalTitle;

    @FindBy(id = "closeSmallModal")
    private WebElement closeSmallModal;

    @FindBy(id = "showLargeModal")
    private WebElement largeModal;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement largeModalTitle;

    @FindBy(id = "closeLargeModal")
    private WebElement closeLargeModal;


    public void navigateToModalSection(){
        ElementUtils.click(alertCard,driver);
    }

    public void triggerDialogModal(){
        ElementUtils.click(modalOption,driver);
    }

    public void triggerSmallModal(){
        ElementUtils.click(smallModal,driver);
    }

    public String getSmallModalTitle(){
        return ElementUtils.getElementText(smallModalTitle);
    }


    public void closeSmallModal(){
        ElementUtils.click(closeSmallModal,driver);
    }

    public void triggerLargeModal(){
        ElementUtils.click(largeModal,driver);
    }

    public String getLargeModalTitle(){
       return ElementUtils.getElementText(largeModalTitle);
    }

    public void closeLargeModal(){
        ElementUtils.click(closeLargeModal,driver);
    }



}
