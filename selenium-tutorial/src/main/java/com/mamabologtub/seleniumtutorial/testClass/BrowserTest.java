//package com.mamabologtub.seleniumtutorial.testClass;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.time.Duration;
//import java.util.List;
//
//public class BrowserTest {
//
//    public static void main(String[] args) {
//
//        WebDriver driver = new ChromeDriver();
//        // driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//        driver.get("https://www.google.com/");
//
//        driver.getTitle();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//
//        WebElement textBox = driver.findElement(By.id("APjFqb"));
//        List<WebElement> listOfElem = driver.findElements(By.xpath("//input"));
//
//         int count = listOfElem.size();
//         System.out.println("Count of Element:" + count);
//        textBox.sendKeys("FIFA club world cup");
//        textBox.sendKeys(Keys.ENTER);
////        WebElement submitButton = driver.findElement(By.cssSelector("button"));
////        textBox.sendKeys("Selenium");
//////        submitButton.click();
//////
//////        WebElement message = driver.findElement(By.id("message"));
//////        message.getText();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
//
//        // driver.quit();
//
//    }
//}
