package pageObjects;

public interface IMDBElements {
	String xpathRelease="//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link' and contains(@href,'releaseinfo')]";
	String countryXpath="//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link' and contains(@href,'country_of_origin')]";
}
