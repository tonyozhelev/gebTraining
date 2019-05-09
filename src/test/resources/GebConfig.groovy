import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    def chromeDriver = new File("src/test/resources/drivers/chromedriver.exe")
    System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
    DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    ChromeOptions chromeOptions = new ChromeOptions()
    chromeOptions.addArguments("--no-sandbox")
    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions)
    WebDriver driver = new ChromeDriver(capabilities)
    driver.manage().deleteAllCookies()
    driver.manage().window().maximize()
    driver
}

environments {
    'dev' {
        baseUrl = "http://automationpractice.com/index.php"
    }
}
