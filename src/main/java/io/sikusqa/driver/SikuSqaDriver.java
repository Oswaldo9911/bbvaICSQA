package io.sikusqa.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.Capabilities;
import org.sikuli.api.DefaultScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Keyboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.Robot;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Dimension;
import javafx.scene.input.KeyCode;
import org.sikuli.api.robot.Key;

/**
 *
 * @author Oswaldo Buitrago - SQA S.A
 */
public class SikuSqaDriver extends AppiumDriver {

    private final static Logger LOG = LoggerFactory.getLogger(SikuSqaDriver.class);

    private int waitSecondsAfterClick = 2;
    private double similarityScore = 0.7;
    private int waitSecondsForImage = 10;
    private AppiumDriver driver;
    private DriverScreen driverScreen;
    static Robot robot;

    public SikuSqaDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
    }

    public ImageElement findImageElement(File imageUrl) {
        try {
            driverScreen = new DriverScreen(driver);
        } catch (IOException e1) {
            System.out.println("Error: " + e1.getMessage());
            throw new RuntimeException("No se puede iniciar SikkuApiumDriver");
        }

        ScreenRegion webdriverRegion = new DefaultScreenRegion(driverScreen);
        webdriverRegion.setScore(similarityScore);

        ImageTarget target = new ImageTarget(imageUrl);
        ScreenRegion imageRegion = webdriverRegion.wait(target, waitSecondsForImage);

        Rectangle rectangle;

        if (imageRegion != null) {
            rectangle = imageRegion.getBounds();
            LOG.debug("La imagen se encuentra en {} {} {} {}", rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        } else {
            LOG.debug("La imagen no se encuentra");
            return null;
        }

        return new CustomImageElement(
                this.driver,
                rectangle.x,
                rectangle.y,
                rectangle.width,
                rectangle.height,
                this.waitSecondsAfterClick
        );
    }

    public Dimension getSize() {
        try {
            driverScreen = new DriverScreen(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driverScreen.getSize();
    }

    public void escribirRobot(CharSequence characters) {
        int length = characters.length();
        for (int i = 0; i < length; i++) {
            char character = characters.charAt(i);
            imprimirRobot(character);
        }
    }
    
    public void atras(){
        driver.navigate().back();
    }
    
    public void escribirAndroid(String texto){
        driver.getKeyboard().sendKeys(texto);
        //driver.getKeyboard().pressKey(texto);
        //((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
    }
    
    public void tab(){
        driver.getKeyboard().pressKey(Key.TAB);
    }

    public void imprimirRobot(char character) {
        switch (character) {
            case 'a':
                doChar(KeyEvent.VK_A);
                break;
            case 'b':
                doChar(KeyEvent.VK_B);
                break;
            case 'c':
                doChar(KeyEvent.VK_C);
                break;
            case 'd':
                doChar(KeyEvent.VK_D);
                break;
            case 'e':
                doChar(KeyEvent.VK_E);
                break;
            case 'f':
                doChar(KeyEvent.VK_F);
                break;
            case 'g':
                doChar(KeyEvent.VK_G);
                break;
            case 'h':
                doChar(KeyEvent.VK_H);
                break;
            case 'i':
                doChar(KeyEvent.VK_I);
                break;
            case 'j':
                doChar(KeyEvent.VK_J);
                break;
            case 'k':
                doChar(KeyEvent.VK_K);
                break;
            case 'l':
                doChar(KeyEvent.VK_L);
                break;
            case 'm':
                doChar(KeyEvent.VK_M);
                break;
            case 'n':
                doChar(KeyEvent.VK_N);
                break;
            case 'o':
                doChar(KeyEvent.VK_O);
                break;
            case 'p':
                doChar(KeyEvent.VK_P);
                break;
            case 'q':
                doChar(KeyEvent.VK_Q);
                break;
            case 'r':
                doChar(KeyEvent.VK_R);
                break;
            case 's':
                doChar(KeyEvent.VK_S);
                break;
            case 't':
                doChar(KeyEvent.VK_T);
                break;
            case 'u':
                doChar(KeyEvent.VK_U);
                break;
            case 'v':
                doChar(KeyEvent.VK_V);
                break;
            case 'w':
                doChar(KeyEvent.VK_W);
                break;
            case 'x':
                doChar(KeyEvent.VK_X);
                break;
            case 'y':
                doChar(KeyEvent.VK_Y);
                break;
            case 'z':
                doChar(KeyEvent.VK_Z);
                break;
            case 'á':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_A);
                break;
            case 'é':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_E);
                break;
            case 'í':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_I);
                break;
            case 'ó':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_O);
                break;
            case 'ú':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_U);
                break;
            case 'ü':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_DEAD_ACUTE);
                doChar(KeyEvent.VK_U);
                break;
            case 'A':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_A);
                break;
            case 'B':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
                break;
            case 'C':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_C);
                break;
            case 'D':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_D);
                break;
            case 'E':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_E);
                break;
            case 'F':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_F);
                break;
            case 'G':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_G);
                break;
            case 'H':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_H);
                break;
            case 'I':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_I);
                break;
            case 'J':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_J);
                break;
            case 'K':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_K);
                break;
            case 'L':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_L);
                break;
            case 'M':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_M);
                break;
            case 'N':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_N);
                break;
            case 'O':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_O);
                break;
            case 'P':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_P);
                break;
            case 'Q':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_Q);
                break;
            case 'R':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_R);
                break;
            case 'S':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_S);
                break;
            case 'T':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_T);
                break;
            case 'U':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_U);
                break;
            case 'V':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_V);
                break;
            case 'W':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_W);
                break;
            case 'X':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_X);
                break;
            case 'Y':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
                break;
            case 'Z':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_Z);
                break;
            case 'Á':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_A);
                break;
            case 'É':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_E);
                break;
            case 'Í':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_I);
                break;
            case 'Ó':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_O);
                break;
            case 'Ú':
                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_U);
                break;
            case 'Ü':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_DEAD_ACUTE);
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_U);
                break;
            case '`':
                doChar(KeyEvent.VK_BACK_QUOTE);
                break;
            case '0':
                doChar(KeyEvent.VK_0);
                break;
            case '1':
                doChar(KeyEvent.VK_1);
                break;
            case '2':
                doChar(KeyEvent.VK_2);
                break;
            case '3':
                doChar(KeyEvent.VK_3);
                break;
            case '4':
                doChar(KeyEvent.VK_4);
                break;
            case '5':
                doChar(KeyEvent.VK_5);
                break;
            case '6':
                doChar(KeyEvent.VK_6);
                break;
            case '7':
                doChar(KeyEvent.VK_7);
                break;
            case '8':
                doChar(KeyEvent.VK_8);
                break;
            case '9':
                doChar(KeyEvent.VK_9);
                break;
            case '!':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_1);
                break;
            case '"':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_2);
                break;
            case '#':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_3);
                break;
            case '$':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_4);
                break;
            case '%':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_5);
                break;
            case '&':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_6);
                break;
            case '/':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_7);
                break;
            case '(':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_8);
                break;
            case ')':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_9);
                break;
            case '=':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_0);
                break;
            case '+':
                doChar(KeyEvent.VK_PLUS);
                break;
            case '*':
                doChar(KeyEvent.VK_MULTIPLY);
                break;
            case '-':
                doChar(45);
                break;
            case '_':
                doChar(KeyEvent.VK_SHIFT, 45);
                break;
            case ',':
                doChar(KeyEvent.VK_COMMA);
                break;
            case ';':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA);
                break;
            case '.':
                doChar(KeyEvent.VK_PERIOD);
                break;
            case ':':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD);
                break;
            case '<':
                doChar(KeyEvent.VK_LESS);
                break;
            case '>':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_LESS);
                break;
            case ' ':
                doChar(KeyEvent.VK_SPACE);
                break;
            case '@':
                doChar(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_Q);
                break;
            case '\t':
                doChar(KeyEvent.VK_TAB);
                break;
            case '\n':
                doChar(KeyEvent.VK_ENTER);
                break;
            case '~':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD6);
                break;
            case '|':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD4);
                break;
            case '\\':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD2);
                break;
            case '\'':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD9);
                break;
            case '{':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3);
                break;
            case '}':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD5);
                break;
            case '[':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD1);
                break;
            case ']':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD3);
                break;
            case '^':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD4);
                break;
            case '?':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD3);
                break;
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    private void doChar(int keyCode) {
        try {
            robot = new Robot();
            robot.keyPress(keyCode);
            Thread.sleep(20);
            robot.keyRelease(keyCode);
            Thread.sleep(20);
        } catch (AWTException | InterruptedException e) {
            System.out.println("Invalid key code(s) for above character: " + e.getMessage());
        }
    }

    private void doChar(int keyCode1, int keyCode2) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode1);
            Thread.sleep(20);
            robot.keyPress(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode1);
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    private void doChar(int keyCode1, int keyCode2, int keyCode3) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode1);
            Thread.sleep(20);
            robot.keyPress(keyCode2);
            Thread.sleep(20);
            robot.keyPress(keyCode3);
            Thread.sleep(20);
            robot.keyRelease(keyCode3);
            Thread.sleep(20);
            robot.keyRelease(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode1);
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    private void doChar(int keyCode1, int keyCode2, int keyCode3, int keyCode4) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode1);
            Thread.sleep(20);
            robot.keyPress(keyCode2);
            Thread.sleep(20);
            robot.keyPress(keyCode3);
            Thread.sleep(20);
            robot.keyPress(keyCode4);
            Thread.sleep(20);
            robot.keyRelease(keyCode4);
            Thread.sleep(20);
            robot.keyRelease(keyCode3);
            Thread.sleep(20);
            robot.keyRelease(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode1);
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    public void scroolRightAndLeft(int cordenadaY, int espera) {
        try {
            org.openqa.selenium.Dimension dm = driver.manage().window().getSize();
            int scrollRigth = (int) (dm.getWidth() * 0.99);
            System.out.println("SCROLL RIGHT " + scrollRigth);
            int scrollLeft = (int) (dm.getWidth() * 0.01);
            System.out.println("SCROLL LEFT " + scrollLeft);
            driver.swipe(scrollRigth, cordenadaY, scrollLeft, cordenadaY, espera);
        } catch (Exception e) {
            System.out.println("Error Mobile (4013): No Fue Posible Realizar Scroll De Derecha a Izquierda");
        }
    }

    public void setWaitSecondsAfterClick(int waitSecondsAfterClick) {
        this.waitSecondsAfterClick = waitSecondsAfterClick;
    }

    public void setSimilarityScore(double similarityScore) {
        this.similarityScore = similarityScore;
    }

    public void setWaitSecondsForImage(int waitSecondsForImage) {
        this.waitSecondsForImage = waitSecondsForImage;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public MobileElement scrollTo(String s) {
        return null;
    }

    @Override
    public MobileElement scrollToExact(String s) {
        return null;
    }
}
