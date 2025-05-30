package testbase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

public class TestBase {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.get("https://demoqa.com/login");
    }

    @AfterMethod
    public void quitDriver() {
        DriverFactory.quitDriver();
    }
}