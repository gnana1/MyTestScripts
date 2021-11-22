package test.java;

import io.qameta.allure.Description;

import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static test.java.InputValues.driverPath;


public class GeminiTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        driver.get("https://exchange.sandbox.gemini.com/");
        //driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        // navigate from the SanBox environment Home page to the Institutional Client Registration form
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.linkText("OK")).click();
        driver.findElement(By.linkText("Create a business account")).click();
        driver.findElement(By.linkText("Institutional Client Registration")).isDisplayed();

        //Happy Path
        driver.findElement(By.name("company.legalName")).sendKeys("XYZ Films");

        Thread.sleep(10000);

    }
}