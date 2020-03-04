package pageObjects
import geb.Page

class IndexPage extends Page{
    static at = {
        waitFor{homePageSlider.isDisplayed()}
    }

    static content = {
        homePageSlider {$("#homepage-slider")}
        signInButton {$(".login")}
    }

    void signIn(){
        signInButton.click()
    }
}
