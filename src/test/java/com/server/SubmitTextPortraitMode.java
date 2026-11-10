package com.server;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SubmitTextPortraitMode {

    AppiumDriver appiumDriver;

@Test
    public  void launchApplicationInAllMode() throws MalformedURLException, InterruptedException {

        UiAutomator2Options uiAutomator2Options=new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("pixel_5");
        uiAutomator2Options.setUdid("emulator-5554");
        String filePath = System.getProperty(
                "user.dir")+ File.separator+"resources"+File.separator+"ApiDemos-debug.apk";
        System.out.println("FilePath:: " + filePath);
        uiAutomator2Options.setApp(filePath);
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAutomationName("uiautomator2");

           URL url = new URL("http://127.0.0.1:4723");
         appiumDriver=new AndroidDriver(url,uiAutomator2Options);
///DeviceRotation deviceRotation=new DeviceRotation(0,0,90);
ScreenOrientation screenOrientation=((AndroidDriver)appiumDriver).getOrientation();
  //  ((AndroidDriver) appiumDriver).rotate(deviceRotation);
    ((AndroidDriver) appiumDriver).rotate(ScreenOrientation.PORTRAIT);
        appiumDriver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
    appiumDriver.findElement(AppiumBy.accessibilityId("Accessibility Node Querying")).click();
    appiumDriver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id='io.appium.android.apis:id/tasklist_finished'])[1]")).click();
    appiumDriver.quit();
    }
}
