package com.server;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GeneralStoreToastMessage {

    AppiumDriver appiumDriver;

    @Test
    public void launchBrowser() throws MalformedURLException, InterruptedException {

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("pixel_5");
        uiAutomator2Options.setUdid("emulator-5554");
        String filePath = System.getProperty(
                "user.dir") + File.separator + "resources" + File.separator + "General-Store.apk";
        uiAutomator2Options.setApp(filePath);
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAutomationName("uiautomator2");
        URL url = new URL("http://127.0.0.1:4723");
        appiumDriver = new AndroidDriver(url, uiAutomator2Options);

        Thread.sleep(10000);
       // appiumDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
        appiumDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage =appiumDriver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");

        appiumDriver.quit();
    }
}
