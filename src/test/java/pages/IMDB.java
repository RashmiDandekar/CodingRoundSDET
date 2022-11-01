package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.IMDBElements;
import static tests.BaseTests.driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import tests.BaseTests;

public class IMDB {

	WebElement releaseDate = driver.findElement(By.xpath(IMDBElements.xpathRelease));
	WebElement country = driver.findElement(By.xpath(IMDBElements.countryXpath));

	public LocalDate getReleaseDate() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(releaseDate);
		actions.perform();
		Thread.sleep(1000);
		String a = releaseDate.getText().substring(0, 17);
		System.out.println(a);
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		LocalDate date = LocalDate.parse(a, formater);
		System.out.println("After parsing to date::" + date);
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
