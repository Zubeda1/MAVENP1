package com.mavenitseleniumtraining.Driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

    public class DriverManager {
        public static WebDriver driver;
        private String browser = System.getProperty("instance");

        @Before
        public void runOnLocalHost() {
            System.out.println("Running instance is : " + browser);

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
        }
        public void runOnRemoteHost() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.1.120:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        public void navigateTo(String url) {
            driver.get("http://www.argos.co.uk/");
        }

        public void maxBrowser() {
            driver.manage().window().maximize();
        }

        public void applyImlicit() {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @After
        public void closeBrowser() {
            driver.quit();
        }

        public void handleApplicationCookies() {
            driver.findElement(By.linkText("GOT IT")).click();
        }

        public void sleep(int milli) {
            try {
                Thread.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public Boolean waitForInviOfElement(By by) {
            return  new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(by));
        }

        public WebElement waitUntilClickable(WebElement element){
            return  new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(element));
        }
        public DriverManager() {
            PageFactory.initElements(driver, this);}

        public void takeSceenShot(Scenario scenario) {
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        }
    }



