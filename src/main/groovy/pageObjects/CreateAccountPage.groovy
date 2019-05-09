package pageObjects

import geb.Page


class CreateAccountPage extends Page {
    static at = {
        waitFor {accountCreationForm.isDisplayed()}
    }
    static content = {
        accountCreationForm { $("h1.page-heading", text: "CREATE AN ACCOUNT")}
        firstNameInput {$("#customer_firstname")}
        lastNameInput {$("#customer_lastname")}
        emailInput {$("#email")}
        passwordInput {$("#passwd")}
        radioGender {$("#account-creation_form")}
    }


    //tova vaobshte ne mi hareswa
    void setGenderValue(String value){
        id_gender = value
    }

    String getGenderValue(){
        return id_gender
    }
}
