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

public class DragDropGesture {

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
        appiumDriver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = appiumDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 683,
                "endY", 655
        ));
        String droppedText = appiumDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(droppedText,"Dropped!");
        appiumDriver.quit();
    }
}
