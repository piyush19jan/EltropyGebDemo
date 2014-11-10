import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.firefox.FirefoxDriver

waiting {
    timeout = 2
}

environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        File chromeDriverLocation = new File("./resources/chromedriver_LINUX_64")
        ChromeDriverService chromeDriverService   = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriverLocation)
                .usingAnyFreePort().withEnvironment("DISPLAY", ":1").build()
                //.withEnvironment(ImmutableMap.of("DISPLAY", ":1")).build()
        chromeDriverService.start()
        driver = { new ChromeDriver(chromeDriverService) }
    }

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }

    // phantomJs {
    //     driver = { new PhantomJSDriver() }
    // }

}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://gebish.org"