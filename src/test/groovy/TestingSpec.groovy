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
        //TODO: da pitam iliq kak da go deklariram direktno v samiq class
        newPage.radioGender = "Mrs."
        newPage.selectDays.selected = '2'
        newPage.checkboxNewsletter.check()
        then:
        newPage.radioGender.value() == '2'
        newPage.selectDays.selectedText.trim() == '2'
        newPage.checkboxNewsletter.checked

    }
}
