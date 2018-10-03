package io.sikusqa.tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.sikusqa.driver.ImageElement;
import io.sikusqa.driver.SikuSqaDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

//import static org.testng.Assert.assertEquals;
/**
 *
 * @author Oswaldo Buitrago - SQA S.A
 */
public class SampleTest extends BaseTest {

    static AndroidDriver ad;

    @Test
    public void testSampleScenarioOfClicking() throws InterruptedException {
        Thread.sleep(70000);
        driver.findElementByClassName("android.widget.ImageButton").click();
        //1
        ImageElement hand = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "bbva.png", 10);
        hand.tap();

        //driver.findElementByTagName("Cédula de ciudadanía").click();
        //System.out.println("Click Name");
        // 2
        ImageElement hand1 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "cedula.png", 10);
        hand1.tap();
        // 3
        ImageElement hand2 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "numerodocumento.png", 10);
        hand2.tap();
        // Documento
        //driver.findElement(By.className("android.widget.EditText")).sendKeys("1233903960");
        driver.escribirAndroid("1233903960");
        //driver.escribirRobot("a");
        // Oculta Teclado
        driver.hideKeyboard();
        // 4
        ImageElement hand3 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "continuar.png", 10);
        hand3.tap();
        //driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.ImageButton[@index='7']")).click();
        // 5
        Thread.sleep(4000);
        ImageElement hand4 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "quierosabermas.png", 10);
        hand4.tap();
        // 6
        ImageElement hand5 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "continuar2.png", 10);
        hand5.tap();
        Thread.sleep(2000);
        // 7
        driver.scroolRightAndLeft(580, 2000);
        
        ImageElement hand6 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "masbeneficios.png", 10);
        hand6.tap();
        Thread.sleep(1000);
        // 8
        ImageElement hand7 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "cerrar.png", 10);
        hand7.tap();
        Thread.sleep(1000);
        // 9
        ImageElement hand8 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "laquiero.png", 10);
        hand8.tap();

        // 10
        ImageElement hand9 = waitForImageElement(System.getProperty("user.dir") + "/src/test/resources/" + "entiendo.png", 10);
        hand9.tap();
        //driver.close();
        //driver.closeApp();
        driver.quit();

//        driver.getKeyboard().sendKeys("Prueba");
//        System.out.println("Driver");
//        Actions a = new Actions(driver);
//        a.sendKeys("123412432");
//        TouchAction touchAction = new TouchAction(driver);
        // 4
        //driver.escribirRobot("1233903960");
//        driver.findElementById("com.denyszaiats.myreactions:id/fingerButton").click();
//        ImageElement finger = waitForImageElement("index_finger", 60);
//        finger.tap();
//        driver.findElementById("com.denyszaiats.myreactions:id/startButton").click();
//        for (int i = 0; i < 3; i++) {
//            driver.findElementById("com.denyszaiats.myreactions:id/imageTapButton").click();
//        }
//
//        String result = driver.findElementById("com.denyszaiats.myreactions:id/resultsFasterClicker").getText();
//        assertEquals(result, "3");
    }
}
