package pageObjects

import geb.Page

class AuthenticationPage extends Page {
    static atCheckWaiting = true
    static url = "?controller=authentication"
    static at = {
        waitFor {pageHeading.isDisplayed()}

    }
    static content = {
        pageHeading {$("h1.page-heading", text: "AUTHENTICATION")}
        createAccountEmailField {$("#email_create")}
        createAccountSubmitButton {$("#SubmitCreate")}
        loginEmailAdress {$("#email")}
        loginPassword {$("#passwd")}
        loginSubmit {$("#SubmitLogin")}
    }

    void createAccount(String accountName) {
        createAccountEmailField = accountName
        createAccountSubmitButton.click()
    }

    void login(String accountName, String password){
        loginEmailAdress = accountName
        loginPassword = password
        loginSubmit.click()
    }
}
