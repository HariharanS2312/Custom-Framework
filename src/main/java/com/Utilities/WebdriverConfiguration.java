package com.Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class WebdriverConfiguration extends DataProviders {

	@BeforeClass
	@Parameters({ "Browser", "Incognito", "WaitTime" })
	public WebDriver setBroswer(String browser, String incognito, int waitTime) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", getUserDirectory() + "\\chromedriver\\chromedriver.exe");
			ChromeOptions ops1 = new ChromeOptions();
			ops1.setBinary(getUserDirectory() + "\\chrome\\chrome.exe");
			if (incognito.equals("true")) {
				ops1.addArguments("-incognito");
			}
			super.driver = new ChromeDriver(ops1);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", getUserDirectory() + "\\edgedriver\\msedgedriver.exe");
			EdgeOptions ops2 = new EdgeOptions();
			if (incognito.equals("true")) {
				ops2.setCapability("InPrivate", true);
			}
			super.driver = new EdgeDriver(ops2);
			break;
		}
		setWaitTime(waitTime);
		return super.driver;
	}

	public WebDriverWait setWaitTime(int seconds) {
		super.wait = new WebDriverWait(super.driver, seconds);
		return super.wait;
	}

	public void waitForPageToLoad() {
		super.wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}

	@SuppressWarnings("unused")
	public void fluentWait() {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(0))
				.pollingEvery(Duration.ofSeconds(0)).ignoring(NoSuchElementException.class);
	}
}
