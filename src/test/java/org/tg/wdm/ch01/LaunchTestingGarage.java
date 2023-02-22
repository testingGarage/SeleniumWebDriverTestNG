package org.tg.wdm.ch01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;

import java.io.IOException;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class LaunchTestingGarage {

    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupChromeDriver(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void openBlogTestingGarage() throws IOException {
        String blogUrl = "https://testingGarage.blogspot.com";
        driver.manage().window().maximize();
        driver.get(blogUrl);
        String blogTitle = driver.getTitle();
        log.debug("The title of the blog {} is {}", blogUrl, blogTitle);
        assertThat(blogTitle).isEqualTo("Testing Garage");

    }
}
