import pageObjects.AuthenticationPage
import pageObjects.IndexPage

class TestingSpec extends BaseSpec {
    void signinClickTest(){
        given:
        to IndexPage
        when:
        signIn()
        then:
        //added to actually see the page I go to
        sleep(1000)
        at AuthenticationPage
    }
}
