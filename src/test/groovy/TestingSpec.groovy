import pageObjects.AuthenticationPage
import pageObjects.IndexPage

class TestingSpec extends BaseSpec {
    void signinclicktest(){
        when:
        def page = new IndexPage()
        to page
        page.signIn()
        then:
        at AuthenticationPage
    }
}
