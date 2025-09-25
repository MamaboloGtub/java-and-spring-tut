package com.mamabologtub.seleniumtutorial.seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GoogleSearchTest {

    public static void main(String[] args) {
        googleSearch();
    }

    public static void googleSearch() {
        WebDriver driver = new FirefoxDriver();

        //open the website
        driver.get("https://www.google.com");

        WebElement textBox = driver.findElement(By.id("APjFqb"));
        textBox.sendKeys("Fifa Club world cup");
        textBox.sendKeys(Keys.ENTER);

        // driver.close();
        System.out.println("success");


    }
}
