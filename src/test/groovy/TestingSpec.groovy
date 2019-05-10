import geb.Page
import pageObjects.AuthenticationPage
import pageObjects.CreateAccountPage
import pageObjects.IndexPage
import pageObjects.MyAccountPage


//tests here are designed only to verify that the Page Object properties are working as intended
class TestingSpec extends BaseSpec {
    private void successfulLogin()
    {
        login("fadsfs@fdsf.dsa", "asdfgqwer")
    }

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
        successfulLogin()
        then:
        at MyAccountPage
    }

    void createAccountPageTest(){
        given:
        to AuthenticationPage
        when:
        createAccount("test123@test123.test1")
        Page newPage = at CreateAccountPage
        newPage.radioGender = "Mrs."
        newPage.selectDays.selected = '2'
        newPage.checkboxNewsletter.check()
        then:
        newPage.radioGender == "2"
        newPage.selectDays.selectedText.trim() == '2'
        newPage.checkboxNewsletter.checked
    }

    void myAccountPageTest(){
        given:
        to AuthenticationPage
        successfulLogin()
        when:
        Page newPage = at MyAccountPage
        newPage.orderHistory.click()
        def heading = waitFor {$("h1.page-heading", text: "ORDER HISTORY")}
        then:
        heading.isDisplayed()
    }
}
