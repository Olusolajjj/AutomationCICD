package Olu1.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import OluLearn.PageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	protected LandingPage LP;
	
	public WebDriver initializedDriver() throws IOException {
		
		
		
		Properties prop = new Properties();
		FileInputStream fil = new FileInputStream("C:\\Users\\New Owner\\eclipse-workspace\\SeleniumFrameworks\\src\\main\\java\\OluLearn\\resources\\GlobalData.properties");
		prop.load(fil);
		
		String browserName = System.getProperty("browser")!=null? System.getProperty("browser"): prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		ChromeOptions option = new ChromeOptions();
		
		if (browserName.contains("headless")) {
			
			option.addArguments("headless");
			
		}
		driver = new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1440, 900));

		}
		
		else if (browserName.equalsIgnoreCase("firefox") ) {
			
			driver = new FirefoxDriver();

			
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();

			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		return driver;
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String Path) throws IOException {
		String JsonContent = FileUtils.readFileToString(new File (Path),  
				StandardCharsets.UTF_8);
	
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {
    });
	return data;
}
	
	public String takeTheScreenShot(String TestCase, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//report//" + TestCase + ".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir") + "//report//" + TestCase + ".png";
		
		
	}
	
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage LaunchApp() throws IOException {
		
			driver = initializedDriver();

			LP = new LandingPage(driver);
			
			LP.GoTo();
			
			return LP;
	}
	
	//@AfterMethod(alwaysRun = true)
	//public void BrowserClosed() {
		//driver.close();
	//}
}


