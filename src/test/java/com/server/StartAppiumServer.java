package com.server;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class StartAppiumServer {

    AppiumServiceBuilder appiumServiceBuilder;
    AppiumDriver appiumDriver;

    @BeforeMethod
    public void startServer() {
         appiumServiceBuilder=new AppiumServiceBuilder();
        //appiumServiceBuilder.withAppiumJS(new File("//Users//kanishk//node_modules//appium//build//lib//main.js"));
        appiumServiceBuilder.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"));
        appiumServiceBuilder.usingPort(4723);
        appiumServiceBuilder.withIPAddress("0.0.0.0");
        appiumServiceBuilder.build().start();


    }

@Test
    public  void launchBrowser() throws MalformedURLException {


        UiAutomator2Options uiAutomator2Options=new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("pixel_5");
        uiAutomator2Options.setUdid("emulator-5554");
        String filePath = System.getProperty(
                "user.dir")+ File.separator+"resources"+File.separator+"ApiDemos-debug.apk";


        System.out.println("FilePath:: " + filePath);
        uiAutomator2Options.setApp(filePath);
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAutomationName("uiautomator2");


           URL url = new URL("http://0.0.0.0:4723");

        //uiAutomator2Options.setApp(url);
         appiumDriver=new AndroidDriver(url,uiAutomator2Options);
       //  appiumDriver.findElement(By.id("Access'ibility")).click();


    }
    /*
    public void startServerDesiredCap()
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        String filePath = System.getProperty(
                "user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "java" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        System.out.println("FilePath:: " + filePath);
        desiredCapabilities.setCapability("appium:app", filePath);
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");

        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startServer() {
        AppiumServiceBuilder appiumServiceBuilder=new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress("127.0.0.1");
        appiumServiceBuilder.usingPort(4723);
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.usingPort(4723);
        appiumServiceBuilder.usingPort(4723);
        appiumServiceBuilder.usingPort(4723);
    }
*/

    @AfterMethod
    public void tearDown() {
        appiumDriver.quit();
        appiumServiceBuilder.build().stop();
    }

}
