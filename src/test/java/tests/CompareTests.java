package tests;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IMDB;
import pages.Wiki;

public class CompareTests extends BaseTests{
	@Test
	public void compareReleaseDate_country() throws InterruptedException
	{
		IMDB imdb= new IMDB();
		LocalDate imdbDate=((pages.IMDB) imdb).getReleaseDate();
		logger.pass("Release Date of Pushpa movie is successfully retrieved from imdb site. Value:"+imdbDate);
		
		String imdbCountry=imdb.getCountry();
		logger.pass("Country of origin for Pushpa movie is successfully retrieved from imdb site. Value:"+imdbCountry);
		
		Wiki wiki = new Wiki();
		
		LocalDate wikiDate=wiki.getReleaseDate();
		logger.pass("Release Date of Pushpa movie is successfully retrieved from Wikipedia. Value:"+wikiDate);
		
		String wikiCountry=wiki.getCountry();
		logger.pass("Country of origin for Pushpa movie is successfully retrieved from Wikipedia. Value:"+wikiCountry);
		
		Assert.assertEquals(imdbDate, wikiDate, "Both dates are equal");
		logger.pass("Release date from both websites have matched");
		
		Assert.assertEquals(imdbCountry, wikiCountry, "Country of origin is matching.");
		logger.pass("Country of origin from both websites have matched");
	}

}
