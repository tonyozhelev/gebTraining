package pageObjects

import geb.Page
import org.openqa.selenium.By

class MyAccountPage extends Page {
    static at = {waitFor{mainHeading.isDisplayed()}}
    static content = {
        mainHeading {$("h1.page-heading", text: "MY ACCOUNT")}
        orderHistory {$(By.xpath("//a[@title=\"Orders\"]"))}
        creditSlips {$(By.xpath("//a[@title=\"Credit slips\"]"))}
        addresses {$(By.xpath("//a[@title=\"Addresses\"]"))}
        personalInformation {$(By.xpath("//a[@title=\"Information\"]"))}
        wishlist {$(By.xpath("//a[@title=\"My wishlist\"]"))}
        homeButton {$(By.xpath("//a[@title=\"Home\"]"))}
    }
}
