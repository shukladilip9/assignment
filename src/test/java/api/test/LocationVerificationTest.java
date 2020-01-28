package api.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import Config.ServiceURI;
import Config.TestBase;
import fields.Location;
import fields.LocationAPIResponse;

public class LocationVerificationTest {

	@Test(description = "Verifying entered location matches with Dubai on the lattitude/longitude basis & google map API's response ")
	public void apiTest() throws URISyntaxException, ClientProtocolException, IOException {
		final Logger log = Logger.getLogger(LocationVerificationTest.class);

		log.info("Creating http client instance");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		log.info("Formation of URI");
		URI uri = new URIBuilder().setScheme(ServiceURI.SCHEME_HTTPS).setHost(ServiceURI.HOST)
				.setPath(ServiceURI.PLACE_SEARCH).addParameter("query", "dubai").addParameter("key", ServiceURI.API_KEY)
				.build();
		log.info("URI is " + uri.toString());

		log.info("Instance of HttpGet");
		HttpGet fetchLocation = new HttpGet(uri);
		log.info("Executing the request");
		CloseableHttpResponse response = client.execute(fetchLocation);
		if (response != null) {
			log.info("Verifying status code 200");
			Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

			HttpEntity entityResponse = response.getEntity();
			String apiOutput = EntityUtils.toString(entityResponse);
			log.info("response body : " + apiOutput);
			log.info("Verifying entered location belongs to Dubai with lattitude and longitude basis");
			log.info("Parsing Json response in java pojo");
			ObjectMapper mapper = new ObjectMapper();
			LocationAPIResponse locationAPIResponse = mapper.readValue(apiOutput, LocationAPIResponse.class);
			Location location = locationAPIResponse.getResults().get(0).getGeometry().getLocation();
			if (location != null) {
				Assert.assertEquals(location.getLat(), "25.2048493");
				Assert.assertEquals(location.getLng(), "55.2707828");
			} else {
				log.error("Location is Null");
				Assert.fail();
			}

		} else {
			log.error("Response is Null");
			Assert.fail();
		}
	}
}
