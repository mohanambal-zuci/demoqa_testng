package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WindowHandlingPage;
import testbase.TestBase;

import java.util.Set;

public class WindowHandlingTest extends TestBase {
    @Test(description = "New Tab Validation")
    public void newTab() {
        driver.get("https://demoqa.com/");
        WindowHandlingPage windows = new WindowHandlingPage();
        windows.navigateToAlert();
        windows.navigateToList();
        windows.triggerTabButton();

        String mainWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Assert.assertTrue(windows.getSampleText().contains("This is a sample page"));
        Assert.assertTrue(windows.getSampleText().contains("This is a sample page"),
                "Expected sample page text not found in new tab.");
        driver.close();
        driver.switchTo().window(mainWindow);

    }
}
