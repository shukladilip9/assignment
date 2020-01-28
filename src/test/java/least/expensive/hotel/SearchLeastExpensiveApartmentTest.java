package least.expensive.hotel;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Config.Config;
import Config.TestBase;
import data.TestData;
import junit.framework.Assert;

public class SearchLeastExpensiveApartmentTest extends TestBase {
	private final Logger log = Logger.getLogger(SearchLeastExpensiveApartmentTest.class);

	@Test(dataProvider = "inputs", dataProviderClass = TestData.class)
	public void PropertyFinderTest(String searchPlace, String minBedRoom, String propertyType)
			throws InterruptedException {
		Config config = new Config(prop);
		log.info("Configutaion is loaded");
		log.info("Opening URL : " + config.getUrl());

		driver.get(config.getUrl());
		log.info("Selecting Property Type:" + propertyType);
		driver.findElement(By.xpath("//div[@class='search-property__column search-property__category']")).click();
		driver.findElement(
				By.xpath("//div[@class='search-property__column search-property__category']/div/div/div[text()='"
						+ propertyType + "']"))
				.click();
		log.info("Selecting Min BedRooms: " + minBedRoom);
		driver.findElement(By.xpath("//div[@class='search-property__column search-property__bed']/div[1]/div[1]"))
				.click();
		int minBedRooms = Integer.parseInt(minBedRoom) + 2;
		driver.findElement(By.xpath(
				"//div[@class='search-property__column search-property__bed']/div[1]/div[1]/..//span/..//div/div["
						+ minBedRooms + "]"))
				.click();
		log.info("Seraching property in " + searchPlace + " for rent with min 2 bedrooms");

		driver.findElement(By.xpath("//input[@class='autocomplete__input']")).sendKeys(searchPlace);

		driver.findElement(By.xpath("//div[@class='search-property__submit-btn']/button")).sendKeys(Keys.ENTER);

		log.info("Results are fetching out");

		// List of web elements containing price values being fetched out
		List<WebElement> element = driver.findElements(By.xpath("//span[@class='card__price-value']"));
		// Storing the results into a tree map with [price,xpath of property link]
		// As possibility of more than one hotel in a same price may exists so appending
		// property link in value with"--" separator
		Map<Integer, String> map = new TreeMap<Integer, String>();

		for (WebElement e : element) {
			if (!e.getText().replace("AED/year", "").replace(",", "").trim().contains("Ask for price")) {
				String price = e.getText().replace("AED/year", "");
				String trimmedPrice = price.replace(",", "").trim();
				int intPrice = Integer.parseInt(trimmedPrice);

				String value = "//span[text()='" + price
						+ "AED/year']/../../following-sibling::div/../parent::*/..//h2";
				if (map.containsKey(intPrice)) {
					map.put(intPrice, map.get(intPrice) + "---" + value);
				} else
					map.put(intPrice, value);

			}

			else {
			}
		}

		Entry<Integer, String> entry = map.entrySet().iterator().next();

		Integer key = entry.getKey();

		log.info("Price of  Least Expensive property for rent with min 2 Bed Rooms is " + key);

		String value = entry.getValue();

		String[] allLinksInSamePrice = value.split("---");

		for (int i = 0; i < allLinksInSamePrice.length; i++) {
			log.info(i + 1 + " " + driver.findElement(By.xpath(allLinksInSamePrice[i])).getText());
		}
		// Fetching the last one property link
		int noOfLinks = allLinksInSamePrice.length;

		log.info("Number of Property founds at  price " + key + " is " + noOfLinks);

		log.info("property description or title are :");

		for (int i = 0; i < allLinksInSamePrice.length; i++) {
			log.info(i + 1 + " " + driver.findElement(By.xpath(allLinksInSamePrice[i])).getText());
		}
		String requiredPropertyLink = allLinksInSamePrice[noOfLinks - 1];

		// Opening the last item

		driver.findElement(By.xpath(requiredPropertyLink)).click();
		String noOfBedrooms = driver
				.findElement(By.xpath(
						"//div[@class='text property-facts__label'][contains(text(),'Bedrooms')]/following-sibling::*"))
				.getText();

		// Verifying no of bedrooms are 2 or not

		Assert.assertEquals(noOfBedrooms, minBedRoom);

		driver.quit();

	}

}
