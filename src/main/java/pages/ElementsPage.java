package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class ElementsPage {
    WebDriver driver;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card-body']//h5[contains(text(),\"Elements\")]")
    private WebElement elementCard;

    @FindBy(xpath = "//span[normalize-space(text())='Dynamic Properties']")
    private WebElement dynamicProperties;

    @FindBy(id = "enableAfter")
    private WebElement dynamicButton;

    public void navigateToElements(){
        ElementUtils.click(elementCard,driver);
    }

    public void clickDynamicProperties(){
        ElementUtils.click(dynamicProperties,driver);
    }

    public void clickButton() {
        ElementUtils.click(dynamicButton,driver);
    }
}
