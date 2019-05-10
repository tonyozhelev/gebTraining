package pageObjects

import geb.Page
import geb.module.RadioButtons
import geb.module.Select
import geb.module.Checkbox



class CreateAccountPage extends Page {
    static at = {
        waitFor {accountCreationFormCheck.isDisplayed()}
    }
    static content = {
        accountCreationFormCheck { $("h1.page-heading", text: "CREATE AN ACCOUNT")}
        radioGender {$(name: 'id_gender').module(RadioButtons)}
        firstNameInput {$("#customer_firstname")}
        lastNameInput {$("#customer_lastname")}
        emailInput {$("#email")}
        passwordInput {$("#passwd")}
        selectDays {$(name: 'days').module(Select)}
        selectMonths {$(name: 'months').module(Select)}
        selectYears {$(name: 'years').module(Select)}
        checkboxNewsletter {$(name: 'newsletter').module(Checkbox)}
        checkboxOptIn {$(name: 'optin').module(Checkbox)}
        addressFirstName {$("#firstname")}
        addressLastName {$("#lastname")}
        addressCompany {$("#company")}
        addressAddress1 {$("#address1")}
        addressAddress2 {$("#address2")}
        addressCity {$("#city")}
        addressState {$(name: 'id_state').module(Select)}
        addressZip {$("#postcode")}
        addressCountry {$(name:'id_country').module(Select)}
        addressAdditionalInfo {$("#other")}
        addressHomePhone {$("#phone")}
        addressMobilePhone {$("#phone_mobile")}
        addressAlias {$("#alias")}
    }
}
