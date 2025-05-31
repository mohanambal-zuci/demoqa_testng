package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class AlertPage {

    private final WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[contains(@class,'card mt-4')])[3]")
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

}
