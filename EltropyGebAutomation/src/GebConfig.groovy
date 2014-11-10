import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

//Base URL of the application under test
baseUrl = 'http://demo.eltropy.com'
	
driver = {new FirefoxDriver()}

// default driver...
//System.setProperty('webdriver.chrome.driver', "resources/chromedriver.exe")
//driver = {new ChromeDriver()}
	
waiting {
	presets {
		slow {
			timeout = 20
			retryInterval = 1
		}
		quick {
			timeout = 1
		}
	}
}
	
reportsDir = "target/geb-reports"
