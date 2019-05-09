import pageObjects.AuthenticationPage
import pageObjects.CreateAccountPage
import pageObjects.IndexPage
import pageObjects.MyAccountPage


//tests here are designed only to verify that the Page Object properties are working as intended
class TestingSpec extends BaseSpec {
    void signinClickTest(){
        given:
        to IndexPage
        when:
        signIn()
        then:
        //added to actually see the page I go to
        at AuthenticationPage
    }


    void loginTest(){
        given:
        to AuthenticationPage
        when:
        login("fadsfs@fdsf.dsa", "asdfgqwer")
        then:
        at MyAccountPage
    }

    void radioTest(){
        given:
        to AuthenticationPage
        when:
        createAccount("test123@test123.test1")
        CreateAccountPage newPage = at CreateAccountPage
        newPage.radioGender.id_gender = "2"
        then:
        newPage.radioGender.id_gender == "2"
    }
}
