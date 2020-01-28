package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public WebDriver driver;
	public static Properties prop;

	public File f1;
	public FileInputStream file;

	public static final Logger logger = Logger.getLogger(TestBase.class);

	public void loadPropertiesFile() throws IOException {

		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		prop = new Properties();
		f1 = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "resources" + File.separator + "config.properties");
		file = new FileInputStream(f1);
		prop.load(file);
		logger.info("log is initialized");

	}

	@BeforeTest
	public void launchBrowser() {
		try {
			loadPropertiesFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Config config = new Config(prop);
		getBrowser(config.getBrowser());
		logger.info("Browser is being maximized");
		driver.manage().window().maximize();

	}

	public void getBrowser(String browser) {

		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
			}
		} else if (System.getProperty("os.name").contains("Mac")) {

			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();

				chromeOptions.addArguments("chrome.switches", "--disable-extensions");
				chromeOptions.addArguments("--disable-notifications");
				chromeOptions.addArguments("disable-infobars");

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver(chromeOptions);
			} else
				driver = new SafariDriver();
		}

	}

	public void setPageLoadTimeout(long timeout, TimeUnit unit) {

		driver.manage().timeouts().pageLoadTimeout(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

}
