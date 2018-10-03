package io.sikusqa.driver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author Oswaldo Buitrago - SQA S.A
 */
public class CapabilitiesFactory {

    protected static DesiredCapabilities capabilities;

    public static DesiredCapabilities getCapabilities() throws Exception {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
        capabilities.setCapability("platformName", "Android");
        
        // Por Apk
        //capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\app\\BBVA CO 6.1.2.40838.apk");
        // Por paquete y Actividad
        capabilities.setCapability("appPackage", "co.com.bbva.mb");
        capabilities.setCapability("appActivity", "co.com.bbva.mb.VTSpecialStartActivity");
        // MonkeYTalk
        //capabilities.setCapability("appPackage", "com.gorillalogic.monkeytalk.demo1");
        //capabilities.setCapability("appActivity", "com.gorillalogic.monkeytalk.demo1.RootActivity");
        
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "42002459cac6b300");
        // Para habilitar Teclado Android
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        return capabilities;
    }

}
