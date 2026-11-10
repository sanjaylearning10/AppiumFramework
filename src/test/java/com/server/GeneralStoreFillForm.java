package com.server;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GeneralStoreFillForm {

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
        appiumDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
        ((AndroidDriver) appiumDriver).hideKeyboard();
        appiumDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        appiumDriver.findElement(AppiumBy.id("android:id/text1")).click();
        //appiumDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Zambia'));"));
        List<WebElement> countryList=appiumDriver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));

            for (int i=0;i<countryList.size();i++)
            {
                ((JavascriptExecutor) appiumDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "direction", "down",
                        "percent", 3.0,
                        "speed",10000,
                        "element",((RemoteWebElement) countryList.get(i)).getId()
                ));
                if(countryList.get(i).getText().equalsIgnoreCase("Zambia"))
                {
                   countryList.get(i).click();
                    break;
                }
        };
        Thread.sleep(8000);

      //  PointerInput pointerInput=new PointerInput(PointerInput.Kind.TOUCH,"finger");
//appiumDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        appiumDriver.quit();
    }
}
