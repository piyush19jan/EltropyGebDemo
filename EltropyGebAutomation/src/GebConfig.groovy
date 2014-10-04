import org.openqa.selenium.chrome.ChromeDriver

baseUrl = 'http://demo.eltropy.com'
	
// default driver...
System.setProperty('webdriver.chrome.driver', "resources/chromedriver.exe")
driver = {new ChromeDriver()}

	
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
