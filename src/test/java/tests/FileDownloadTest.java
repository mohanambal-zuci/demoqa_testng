package tests;

import org.testng.annotations.Test;
import pages.UploadDownloadPage;
import testbase.TestBase;

import java.io.File;

public class FileDownloadTest extends TestBase  {

    protected String downloadPath = System.getProperty("user.dir") + "/downloads";


    @Test(description = "Download File Validation")
    public void downloadFile() {
        driver.get("https://demoqa.com/");
        UploadDownloadPage elements = new UploadDownloadPage(driver);
        elements.navigateToElements();
        elements.clickUploadDownload();
        elements.triggerDownload();
        
    }
}
