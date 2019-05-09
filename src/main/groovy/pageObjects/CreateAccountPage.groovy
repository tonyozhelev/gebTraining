package pageObjects

import geb.Page
import geb.module.RadioButtons


class CreateAccountPage extends Page {
    static at = {
        waitFor {accountCreationForm.isDisplayed()}
    }
    static content = {
        accountCreationForm { $("h1.page-heading", text: "CREATE AN ACCOUNT")}
        radioGender {$('#account-creation_form')}
        firstNameInput {$("#customer_firstname")}
        lastNameInput {$("#customer_lastname")}
        emailInput {$("#email")}
        passwordInput {$("#passwd")}
        //todo: select dropdowns
        //todo: checkbox buttons

    }
}
