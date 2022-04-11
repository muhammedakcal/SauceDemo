package com.cloudwise.base;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class OptionsManager {
    public static ChromeOptions co;
    public static FirefoxOptions fo;

    public static ChromeOptions getChromeOptions()
    {
        co = new ChromeOptions();
        if(ConfigReader.getProperty("incognito").equals("yes")) co.addArguments("--incognito");
        if(ConfigReader.getProperty("headless").equals("yes")) co.addArguments("--headless");
        return co;
    }

    public static FirefoxOptions getFirefoxOptions()
    {
        FirefoxProfile profile = new FirefoxProfile();
        fo = new FirefoxOptions();
        if(ConfigReader.getProperty("headless").equals("yes")) fo.addArguments("--headless");
        profile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", "false");
        fo.setProfile(profile);
        fo.setAcceptInsecureCerts(true);
        return fo;
    }

}
