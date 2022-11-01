package pageObjects;

public interface WikiElements {
	String wikiUrl="https://en.wikipedia.org/wiki/Pushpa:_The_Rise";
	String releaseDateXpath="//span[@class='bday dtstart published updated']";
	String countryXpath="//tr[contains(th/text(),'Country')]/td";
}
