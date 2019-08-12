package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class ProductListPage {

    By firstListedProduct = By.xpath("(//div[@class='product-image'])[1]");
    By linkRings = By.xpath("//h2[text()='Rings']/parent::div/parent::a");
    By lstOfItems = By.cssSelector("div.product-tile.full > a");
    By firstItem = By.cssSelector("ul.product-grid.grid li:nth-child(1) > div > a");
    //(//div[@class='product-tile full']/a)[1]");  (//div[@class='product-image']/parent::a)[1]
    By linkBellaLuceWatches = By.xpath("//h2[contains(text(),'Bella Luce Watches')]/ancestor::a");
    By linkWomensWatches = By.xpath("//h2[contains(text(),\"Women's Watches\")]/ancestor::a");
    By linkOffParkWatches = By.xpath("//h2[contains(text(),'Off Park Watches')]/ancestor::a");
    By linkFacetsOfTime = By.xpath("//h2[contains(text(),'Facets Of Time Watches')]/ancestor::a");
    By imgfirstProductListed = By.xpath("(//div[@class='product-image']//img)[1]");
    By linkQuickView = By.xpath("(//button[text()='Quick View'])[1]");
    By btnQuickBuy = By.id("quick-buy-submit");
    By linkQuickViewThirdProd = By.xpath("(//button[text()='Quick View'])[3]");
    By lnkWhiteDiamondRings = By.cssSelector("img[alt='White Diamond Ring']");
    By lnkColorDiamondRings = By.cssSelector("img[alt='Multicolor Diamond Dome Ring']");
    By lnkOpalRings = By.cssSelector("img[alt='Opal Bypass Ring']");
    By lnkChromeDiopsideRings = By.cssSelector("img[alt='Chrome Diopside Ring']");
    By lnkMoissaniteFireRings = By.cssSelector("img[alt='Moissanite Fire Solitaire Ring']");
    By lnkAmethystRings = By.cssSelector("img[alt='Amethyst Ring']");
    By imgThirdProduct = By.cssSelector("ul.product-grid.grid li:nth-child(3) div.product-image img");


    BaseClass bc = new BaseClass();

    public void selectRingsFirstProduct() {
        bc.WaitForElementPresent(linkRings, 25);
        bc.JSClick(linkRings);
        bc.waitUntillElementToBeClickable(firstItem, 25);
        bc.JSClick(firstItem);

    }

    public void selectWatchType(String type) {
        switch (type) {
            case "Bella Luce Watches":
                bc.JSClick(linkBellaLuceWatches);
                break;

            case "Facets Of Time Watches":
                bc.JSClick(linkFacetsOfTime);
                break;

            case "Off Park Watches":
                bc.JSClick(linkOffParkWatches);
                break;

            case "Women's Watches":
                bc.JSClick(linkWomensWatches);
                break;
        }
    }


    public void selectRingType(String type) {
        switch (type) {
            case "White Diamond Rings":
                bc.JSClick(lnkWhiteDiamondRings);
                break;

            case "Color Diamond Rings":
                bc.JSClick(lnkColorDiamondRings);
                break;

            case "Opal Rings":
                bc.JSClick(lnkOpalRings);
                break;

            case "Chrome Diopside Rings":
                bc.JSClick(lnkChromeDiopsideRings);
                break;

            case "Moissanite Fire Rings":
                bc.JSClick(lnkMoissaniteFireRings);
                break;


            case "Amethyst Rings":
                bc.JSClick(lnkAmethystRings);
                break;
        }


    }


    public void selectQuickView() {
        bc.WaitForElementPresent(imgfirstProductListed, 20);
        bc.mouseHover(imgfirstProductListed);
        bc.JSClick(linkQuickView);
    }


    public void clickQuickBuy() {
        bc.click(btnQuickBuy);
    }


    public void selectFirstProduct() {
        bc.waitUntillElementToBeClickable(firstItem, 25);
        bc.JSClick(firstItem);
    }


    public void hoverOverThirdProduct() throws Exception{
        bc.WaitForElementPresent(imgThirdProduct,10);
        bc.scrollToElement(imgThirdProduct);
        bc.mouseHoverAndClick(imgThirdProduct, linkQuickViewThirdProd);
    }

}
