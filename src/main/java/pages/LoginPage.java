package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='UserName']")
    private WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passWord;

    @FindBy(xpath = "//button[normalize-space(text())='Login']")
    private WebElement clickButton;

    @FindBy(xpath = "//p[@id=\"name\"]")
    private WebElement errorMessage;


    public void enterUserName(String username){
        ElementUtils.type(userName,username);
    }
    public void enterPassword(String password){
        ElementUtils.type(passWord,password);
    }
    public void clickButton(){
        ElementUtils.click(clickButton,driver);
    }
    public String errorMessage(){
      return ElementUtils.getElementText(errorMessage);
    }




}
