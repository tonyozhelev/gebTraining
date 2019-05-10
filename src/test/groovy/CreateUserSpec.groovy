import geb.Page
import pageObjects.AuthenticationPage;
import pageObjects.CreateAccountPage
import pageObjects.MyAccountPage;

class CreateUserSpec extends BaseSpec {

    def argsPossibleValues = ["radioGender - String: 1,2,Mr.,Mrs.",
                              "firstNameInput - String: any",
                              "lastNameInput - String: any",
                              "emailInput - String: email",
                              "passwordInput - String: 5 symbols",
                              "selectDays - String: 1-31",
                              "selectMonths - String: 1-12",
                              "selectYears - String: 1900-2019",
                              "checkboxNewsletter - String: 1 for checked",
                              "checkboxOptIn - String: 1 for checked",
                              "addressFirstName - String: any",
                              "addressLastName - String: any",
                              "addressCompany - String: any",
                              "addressAddress1 - String: any",
                              "addressAddress2 - String: any",
                              "addressCity - String: any",
                              "addressState - String: 1-53",
                              "addressZip - String: 5 digits",
                              "addressCountry - String: 21",
                              "addressAdditionalInfo - String: any",
                              "addressHomePhone - String: any",
                              "addressMobilePhone - String: any",
                              "addressAlias - String: any"]

    void testAllIsEmpty() {
        given:
        to AuthenticationPage
        when:
        def email = "test123@test123.test1"
        createAccount(email)
        Page newPage = at CreateAccountPage
        def errors = newPage.registerUser(["","","","","","","","","","","","","","","","","","","","","","",""])
        then:
        errors == "There are 11 errors\n" +
                "You must register at least one phone number.\n" +
                "lastname is required.\n" +
                "firstname is required.\n" +
                "email is required.\n" +
                "passwd is required.\n" +
                "id_country is required.\n" +
                "alias is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "Country cannot be loaded with address->id_country\n" +
                "Country is invalid"
    }

    //update e-mail each time
    void testValidAccount() {
        given:
        to AuthenticationPage
        when:
        //update before each itteration
        def emailModifier = "9"
        def email = emailModifier + "test123@test123.test1"
        createAccount(email)
        Page newPage = at CreateAccountPage
        def errors = newPage.registerUser(["","name","lastname",email,"12345","","","","","","name","lastname","","address","","city","1","12345","21","","123456","","allias"])
        then:
        at MyAccountPage
    }
}
