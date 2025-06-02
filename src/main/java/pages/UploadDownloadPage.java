package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class UploadDownloadPage {
    WebDriver driver;

    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='card-body']//h5[contains(text(),\"Elements\")]")
    private WebElement elementCard;

    @FindBy(xpath = "//span[normalize-space(text())='Upload and Download']")
    private WebElement uploadDownloadOption;

    @FindBy(id = "downloadButton")
    private WebElement downloadButton;

    @FindBy(id = "uploadFile")
    private WebElement uploadFile;

    @FindBy(id= "uploadedFilePath")
    private WebElement uploadedFilePath;

    public void navigateToElements(){
        ElementUtils.click(elementCard,driver);
    }

    public void clickUploadDownload(){
        ElementUtils.click(uploadDownloadOption,driver);
    }

    public void triggerDownload(){
        ElementUtils.click(downloadButton,driver);
    }

    public void triggerUploadButton(){
        ElementUtils.click(uploadFile,driver);
    }

    public void performUploadFunction(){
        String filePath= System.getProperty("user.dir") + "/files/img.png";
        ElementUtils.sendKeys(uploadFile,filePath);
    }

    public String getUploadedFileTitle(){
         return ElementUtils.getElementText(uploadedFilePath);
    }



}
