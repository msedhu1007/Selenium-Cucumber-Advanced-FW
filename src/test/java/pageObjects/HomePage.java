package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;


public class HomePage extends BasePage{



	By errorMessage = By.cssSelector("span.kc-feedback-text");
	By lnkCreateAccount = By.className("create-an-account");
	By lnkCurrentOnAirItem = By.cssSelector("div.current-item div.product-tile a");
	By lnkProductCarousel = By.cssSelector("div.hero-slide.slick-slide.slick-current.slick-activee");
//	By linkJewelry = By.xpath("//div/a[contains(text(),'Jewelry') and not(contains(text(),'Making'))]");
//	By linkJewelry = By.partialLinkText("Jewelry");
	By linkJewelry = By.cssSelector("a.nav-link[href*='jewelry/_'] ");
	By lnkSignIn = By.xpath("//a[contains(text(),'Sign in to see your information')]");
	By icnclose = By.className("icon-close-x");
	By linkRings = By.xpath("(//a[text()='Rings'])[1]");
	By linkEarrings = By.xpath("(//a[text()='Earrings'])[1]");
	By linkBracelets = By.xpath("(//a[text()='Bracelets'])[1]");
	By linkNecklaces = By.xpath("(//a[text()='Necklaces'])[1]");
	By linkWatches = By.xpath("(//a[text()='Watches'])[1]");

	By linkJewelrySets = By.xpath("(//a[text()='Jewelry Sets'])[1]");
	By linkJewelryAccessories = By.xpath("(//a[text()='Jewelry Accessories'])[1]");
	By linkNewJewelry = By.xpath("(//a[text()='New Jewelry'])[1]");
	By linkJewelrySale = By.xpath("(//a[text()='Jewelry Sale'])[1]");
	By linkMensJewelry = By.xpath("(//a[text()='Men's Jewelry'])[1]");
	By linkChildrensJewelry = By.xpath("(//a[text()='Children's Jewelry'])[1]");
	By linkAllJewelry = By.xpath("(//a[text()='All Jewelry'])[1]");
	By linkStretchPay = By.id("facet-title-stretchPay");
	By chkboxStretchPay5 = By.cssSelector("div[data-id='StretchPay-5-Pay-stretchPay']");
	By eleFilter = By.xpath("(//div[@class='applied-facet-item'])[2]");


	BaseClass bc = new BaseClass();

	public void navigate_to_LoginPage(){
		bc.implicitWait(0);
		bc.WaitForElementPresent(linkHelloGuest, 15);
		//bc.doubleclick(linkHelloGuest);
		bc.mouseHover(linkHelloGuest);
		bc.waitUntillElementToBeVisible(lnkSignIn, 10);
		bc.click(lnkSignIn);
	}

	public boolean isPageOpened(){
		return bc.isDisplayed(linkHelloGuest);
	}


	public void waitforHomePageToOpen() {
		bc.WaitForElementPresent(linkHelloGuest, 20);		   
	}

	public void navigate_to_CreateAccountPage(){
		bc.waitUntillElementToBeVisible(linkHelloGuest, 20);
		bc.mouseHover(linkHelloGuest);
		bc.JSClick(lnkCreateAccount);
	}

	public String getErrorMsg() {
		bc.WaitForElementPresent(errorMessage, 10);
		return bc.getText(errorMessage);
	}


	public void selectCurrentOnAirItem() {
		bc.JSClick(lnkCurrentOnAirItem);
	}

	public void selectCurrentCarouselItem() {
		bc.waitUntillElementToBeVisible(lnkProductCarousel, 15);
		bc.JSClick(lnkProductCarousel);
	}


	public void selectJewelry() {
		bc.waitUntillElementToBeVisible(linkJewelry, 15);
		bc.click(linkJewelry);
	}


	public void selectJewelryTypes(String type) {
		bc.waitUntillElementToBeVisible(linkJewelry, 15);
		bc.mouseHover(linkJewelry);
		
		switch(type) {
		case "Rings":
			bc.WaitForElementPresent(linkRings,10);
			bc.JSClick(linkRings);
			break;

		case "Earrings":
			bc.WaitForElementPresent(linkEarrings,10);
			bc.JSClick(linkEarrings);
			break;

		case "Bracelets":
			bc.WaitForElementPresent(linkBracelets,10);
			bc.JSClick(linkBracelets);
			break;

		case "Necklaces":
			bc.WaitForElementPresent(linkNecklaces,10);
			bc.JSClick(linkNecklaces);
			break;

		case "Watches":
			bc.WaitForElementPresent(linkWatches,10);
			bc.JSClick(linkWatches);
			break;

		case "Jewelry Sets":
			bc.WaitForElementPresent(linkJewelrySets,10);
			bc.JSClick(linkJewelrySets);
			break;

		case "Jewelry Accessories":
			bc.WaitForElementPresent(linkJewelryAccessories,10);
			bc.JSClick(linkJewelryAccessories);
			break;

		case "New Jewelry":
			bc.WaitForElementPresent(linkNewJewelry,10);
			bc.JSClick(linkNewJewelry);
			break;

		case "Jewelry Sale":
			bc.WaitForElementPresent(linkJewelrySale,10);
			bc.JSClick(linkJewelrySale);
			break;

		case "Men's Jewelry":
			bc.WaitForElementPresent(linkMensJewelry,10);
			bc.JSClick(linkMensJewelry);
			break;

		case "Children's Jewelry":
			bc.WaitForElementPresent(linkChildrensJewelry,10);
			bc.JSClick(linkChildrensJewelry);
			break;

		case "All Jewelry":
			bc.WaitForElementPresent(linkAllJewelry,10);
			bc.JSClick(linkAllJewelry);
			break;

		}
	}
	
	
	public void clickStretchPay() throws Exception{
		bc.click(linkStretchPay);
		bc.click(chkboxStretchPay5);
		bc.WaitForElementPresent(eleFilter,20);
	}




}
