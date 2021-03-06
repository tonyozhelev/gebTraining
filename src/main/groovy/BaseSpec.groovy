import geb.Browser
import geb.spock.GebSpec

class BaseSpec extends GebSpec{
    static def browserConfig = new Browser().config.rawConfig

    //izpalnqva se predi wseki test
    //ako iskame generalen setup -> setupSpec
    //sashtoto e za cleanup
    void setup(){
        browser.go(getBaseURL())
        setupTest()
    }

    String getBaseURL(){
        return browserConfig.baseUrl
    }

    //izpolzva se za da si setvam nastroiki bez da pipam setup metoda
    void setupTest(){

    }

    void cleanup(){

    }

    void cleanupSpec() {
        browser.driver.close()
        browser.driver.quit()
    }
}
