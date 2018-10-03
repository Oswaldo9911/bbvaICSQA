package io.sikusqa.tests;

import io.sikusqa.driver.CapabilitiesFactory;
import io.sikusqa.driver.ImageElement;
import io.sikusqa.driver.SikuSqaDriver;
import java.io.File;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

/**
 *
 * @author Oswaldo Buitrago - SQA S.A
 */
public class BaseTest {

    protected SikuSqaDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new SikuSqaDriver(
                new URL("http://127.0.0.1:4723/wd/hub"),
                CapabilitiesFactory.getCapabilities());
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.setDriver(driver);
        driver.setSimilarityScore(0.95);
        driver.setWaitSecondsAfterClick(2);
        driver.setWaitSecondsForImage(10);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected ImageElement waitForImageElement(String rutaImg, int secondsToWait) throws InterruptedException {
        File resource = new File(rutaImg);
        System.out.println("Resource: " + resource);
        ImageElement image = driver.findImageElement(resource);
        int attempts = 0;
        while (image == null && attempts < secondsToWait / 10) {
            sleep(2000);
            image = driver.findImageElement(resource);
            attempts++;
            if (image != null) {
                break;
            }
        }
        assertTrue(image != null, String.format("No se puede encontrar la imagen %s en %s segundos",
                rutaImg, String.valueOf(secondsToWait)));
        return image;
    }
}
