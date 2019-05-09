import pageObjects.AuthenticationPage
import pageObjects.IndexPage

class TestingSpec extends BaseSpec {
    void signinClickTest(){
        given:
        def page = new IndexPage()
        to page
        when:
        page.signIn()
        then:
        at AuthenticationPage
    }
}
