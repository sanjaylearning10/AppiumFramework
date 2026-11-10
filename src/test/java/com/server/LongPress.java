package com.server;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LongPress {

    AppiumDriver appiumDriver;

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

           URL url = new URL("http://127.0.0.1:4723");
        //uiAutomator2Options.setApp(url);
         appiumDriver=new AndroidDriver(url,uiAutomator2Options);
        appiumDriver.findElement(AppiumBy.accessibilityId("Views")).click();
    appiumDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
    RemoteWebElement customAdapter= (RemoteWebElement) appiumDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));

    ((JavascriptExecutor)appiumDriver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",customAdapter.getId(),"pressure","0.5","duration","1000"));
    appiumDriver.quit();
    }
}
