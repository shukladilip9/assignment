package Config;

import java.util.Properties;

public class Config extends TestBase {

	private Properties OR;

	public Config(Properties OR) {
		this.OR = OR;
	}

	public String getUrl() {
		return OR.getProperty("Url");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(OR.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}

	public String getBrowser() {
		return OR.getProperty("Browser");
	}

}
