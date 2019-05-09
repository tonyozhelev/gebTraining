package pageObjects

import geb.Page

class AuthenticationPage extends Page {
    static atCheckWaiting = true
    static url = "?controller=authentication"
    static at = {
        pageHeading.text() == "AUTHENTICATION"
    }
    static content = {
        pageHeading {$("h1.page-heading")}
        createAccountEmailField {$("#email_create")}
        createAccountSubmitButton {$("#SubmitCreate")}
    }
}
