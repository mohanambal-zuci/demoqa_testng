package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadDownloadPage;
import testbase.TestBase;

public class FileUploadTest extends TestBase {
    @Test(description = "Upload File Validation")
    public void uploadFile() {
        driver.get("https://demoqa.com/");
        UploadDownloadPage elements = new UploadDownloadPage(driver);
        elements.navigateToElements();
        elements.clickUploadDownload();
        elements.performUploadFunction();
        Assert.assertTrue(elements.getUploadedFileTitle().contains("img.png"),"File not uploaded");
    }
}
