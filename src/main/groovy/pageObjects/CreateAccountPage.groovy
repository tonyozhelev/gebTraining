package pageObjects

import geb.Page
import geb.module.RadioButtons
import geb.module.Select
import geb.module.Checkbox
import geb.module.TextInput


class CreateAccountPage extends Page {
    static at = {
        waitFor {accountCreationFormCheck.isDisplayed()}
    }
    static content = {
        accountCreationFormCheck { $("h1.page-heading", text: "CREATE AN ACCOUNT")}
        mainHeading {$("h1.page-heading")}
        personalInfoHeading {$("h3.page-subheading", 0)}
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
        addressHeading {$("h3.page-subheading", 1)}
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
        submitButton {$("#submitAccount")}
        alertList {$(".alert")}
    }

    String registerUser(List<String> args) {
        radioGender = args.get(0)
        firstNameInput = args.get(1)
        lastNameInput = args.get(2)
        emailInput = args.get(3)
        passwordInput = args.get(4)
        selectDays = args.get(5)
        selectMonths = args.get(6)
        selectYears = args.get(7)
        if (args.get(8) == "1"){
            checkboxNewsletter.check()
        }
        if (args.get(9) == "1") {
            checkboxOptIn.check()
        }
        addressFirstName = args.get(10)
        addressLastName = args.get(11)
        addressCompany = args.get(12)
        addressAddress1 = args.get(13)
        addressAddress2 = args.get(14)
        addressCity = args.get(15)
        addressState = args.get(16)
        addressZip = args.get(17)
        addressCountry = args.get(18)
        addressAdditionalInfo = args.get(19)
        addressHomePhone = args.get(20)
        addressMobilePhone = args.get(21)
        addressAlias = args.get(22)
        submitButton.click()

        //Todo: kak shte stane tova
        return alertList.text()
    }
}
