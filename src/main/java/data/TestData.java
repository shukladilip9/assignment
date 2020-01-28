package data;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "inputs")
	public static Object[][] inputs() {
		return new Object[][] { new Object[] { "Dubai marina", "2", "Rent" } };
	}

}
