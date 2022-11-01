package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.WikiElements;
import static tests.BaseTests.driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Wiki {
	public Wiki() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(WikiElements.wikiUrl);
		releaseDate = driver.findElement(By.xpath(WikiElements.releaseDateXpath));
		country = driver.findElement(By.xpath(WikiElements.countryXpath));
	}

	public static WebElement releaseDate;
	public static WebElement country;

	public LocalDate getReleaseDate() throws InterruptedException {
		String rdate = releaseDate.getAttribute("innerHTML");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(rdate, formatter);
		System.out.println(date);
		return date;
	}

	public String getCountry() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(country);
		actions.perform();
		Thread.sleep(1000);
		String countyOrigin = country.getText();
		System.out.println(countyOrigin);
		return countyOrigin;
	}
}
