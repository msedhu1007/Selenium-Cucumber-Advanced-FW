package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class BasePage {

    BaseClass bc = new BaseClass();

    By txtSearch = By.id("keyword");
    By imgJtvlogo = By.xpath("(//img[@alt='JTV Logo'])[1]");

    By iconBag = By.className("icon-bag");
    By iconHeart = By.className("icon-heart");
    By linkHelloGuest = By.cssSelector("span.greeting");
    By linkSignIn = By.xpath("//a[contains(text(),'Sign in to see your information')]");
    By linkCreateAccount = By.className("create-an-account");

    By linkOrderStatus = By.className("icon-truck-jtv");
    By linkMyAccount = By.className("icon-account");
    By icnSearch = By.id("search");
    By icnClose = By.cssSelector("div.modal-close");
    By icnclose = By.cssSelector("span.icon-close-x");
    By lnkMenuItem = By.cssSelector("a[href*='account/address'][role='menuitem']");


    public Boolean isSearchFieldPresent() {
        return bc.isDisplayed(txtSearch);
    }

    public void navigateToShoppingBagPage() {
        bc.JSClick(iconBag);
    }

    public void hoverOverBag() {
        bc.mouseHover(iconBag);
    }


    public void handleModal() {
        if (bc.findAllElements(icnClose).size() > 0) {
            bc.retryClick(icnClose, 3);
            bc.retryClick(icnclose, 3);
        }
    }


}
