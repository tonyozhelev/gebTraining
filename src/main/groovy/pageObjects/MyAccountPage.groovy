package pageObjects

import geb.Page

class MyAccountPage extends Page {
    static at = {waitFor{mainHeading.isDisplayed()}}
    static content = {
        mainHeading {$("h1.page-heading", text: "MY ACCOUNT")}
    }
}
