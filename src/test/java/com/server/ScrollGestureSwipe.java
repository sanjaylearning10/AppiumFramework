package com.server;

import com.google.common.collect.ImmutableMap;
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
import java.util.List;

public class ScrollGestureSwipe {

    AppiumDriver appiumDriver;

    @Test
    public void launchBrowser() throws MalformedURLException, InterruptedException {

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("pixel_5");
        uiAutomator2Options.setUdid("emulator-5554");
        String filePath = System.getProperty(
                "user.dir") + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        uiAutomator2Options.setApp(filePath);
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAutomationName("uiautomator2");
        URL url = new URL("http://127.0.0.1:4723");
        appiumDriver = new AndroidDriver(url, uiAutomator2Options);

        appiumDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        appiumDriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        appiumDriver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
      // List<WebElement> listGallary= appiumDriver.findElements(AppiumBy.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView"));

        List<WebElement> listGallary= appiumDriver.findElements(AppiumBy.xpath("//android.widget.ImageView"));
        for(int i=0;i<listGallary.size()-2;i++){

               ((JavascriptExecutor) appiumDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                       "elementId", ((RemoteWebElement) listGallary.get(i)).getId(),
                       "direction", "left",
                       "percent", 0.75
               ));
        }
        appiumDriver.quit();
    }
}
