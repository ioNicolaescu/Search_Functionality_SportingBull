package com.sportingBull.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    private Driver(){    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();

                    Map<String, Object> preferences = new HashMap<>();

                    preferences.put("credentials_enable_service", false);
                    preferences.put("profile.password_manager_enabled", false);
                    options.setExperimentalOption("prefs", preferences);

                    options.addArguments("--incognito");
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-save-password-bubble");
                    options.addArguments("disable-infobars");
                    options.addArguments("--disable-notifications");

                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driverPool.get().manage().window().maximize();
                    break;
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
