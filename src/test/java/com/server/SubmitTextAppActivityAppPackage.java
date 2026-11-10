package com.server;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SubmitTextAppActivityAppPackage {

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
    Activity activity=new Activity("","");
    ((JavascriptExecutor) appiumDriver).executeScript("mobile: startActivity", ImmutableMap.of(
            "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
    ));
    appiumDriver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
    appiumDriver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
    String title=appiumDriver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
    Assert.assertEquals(title,"WiFi settings");
    appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='android:id/edit']")).sendKeys("kanishk");
    ((AndroidDriver)appiumDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
    ((AndroidDriver)appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
    appiumDriver.findElement(AppiumBy.id("android:id/button1")).click();
    appiumDriver.quit();
    }
}
