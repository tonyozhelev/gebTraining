import geb.Page
import pageObjects.AuthenticationPage
import pageObjects.MyAccountPage

class LoginSpec extends BaseSpec{
    def static validUserPass = ["testValid@test.test","testValid"]
    def static invalidUser = ["testInValid@test.test","testValid"]
    def static validUserInvalidPass = ["testValid@test.test","testInValid"]
    def static emptyUserPass = ["", ""]
    def static validUserEmptyPass = ["testValid@test.test",""]

    void testValidUserLogin(String userName, String pass, boolean atPage, String checkLoginError){
        given:
        to AuthenticationPage
        when:
        login(userName,pass)
        then:
        atPage
        checkError() == checkLoginError
        where:
        userName                | pass                    | atPage | checkLoginError
        //todo: set valid test case to work
        //validUserPass[0]        | validUserPass[1]        | true   | ""
        invalidUser[0]          | invalidUser[1]          | true   | "There is 1 error\nAuthentication failed."
        emptyUserPass[0]        | emptyUserPass[1]        | true   | "There is 1 error\nAn email address required."
        validUserInvalidPass[0] | validUserInvalidPass[1] | true   | "There is 1 error\nAuthentication failed."
        validUserEmptyPass[0]   | validUserEmptyPass[1]   | true   | "There is 1 error\nPassword is required."
    }
}
