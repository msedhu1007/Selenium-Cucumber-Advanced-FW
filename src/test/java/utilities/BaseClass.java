package utilities;

import com.google.common.io.Files;
import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static WebDriverWait wait = null;
    public static WebDriver driver;
    /******** Log Attribute ********/
    private static Logger log = Logger.getLogger(BaseClass.class);
    public static Properties config = null;
    String browser = null;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void LoadConfigProperty() throws IOException {
        Logger.getRootLogger().setLevel(Level.OFF);
        config = new Properties();
        FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
        config.load(ip);
    }


    public void setEnv() throws Exception {
        String baseUrl = System.getProperty("url");
        if (baseUrl == null) {
            LoadConfigProperty();
            baseUrl = config.getProperty("url");
        }
        driver.get(baseUrl);
        if (browser.equalsIgnoreCase("Firefox") && baseUrl.toLowerCase().contains("uat")) {
            dismissAlert();
            dismissAlert();
        }
		/*if(browser.equalsIgnoreCase("Firefox") && (baseUrl.toLowerCase().contains("uat"))) {
			String uName = System.getProperty("proxyUserName");
			String uPwd = System.getProperty("proxyPwd");
			String uUrl = System.getProperty("url");
			System.out.println("http://"+uName+":"+uPwd+"@"+uUrl + "   URL is this");
			driver.get("http://"+uName+":"+uPwd+"@"+uUrl);			
			//driver.get("https://jtv_uat:Dm5MMTg3H8PmVh@uat.jtv.com/");
		}
		else {
			driver.get(baseUrl);
		}	*/
    }

    public static String currentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String cal1 = dateFormat.format(cal.getTime());
        return cal1;
    }


    public void openBrowser() throws Exception {
        browser = System.getProperty("browser");
        LoadConfigProperty();
        if (browser == null) {
            browser = config.getProperty("browserType");
        }

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions foptions = new FirefoxOptions();
                foptions.setCapability(CapabilityType.BROWSER_VERSION, "62.0");
                foptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
                foptions.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver();
                Log.info("Firefox is launched");
                break;
            case "headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
                driver = new ChromeDriver(options);
                Log.info("Ghost browser is launched");
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                Log.info("Opera is launched");
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions choptions = new ChromeOptions();
                choptions.addExtensions(new File("src/main/resources/extension.crx"));
                //	choptions.addArguments("--no-sandbox");
                driver = new ChromeDriver(choptions);
                Log.info("Chrome is launched");
                break;
        }
    }

    public void capturess(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            scenario.write("Scenario Failed");
        } else {
            scenario.write("Scenario Passed");
        }
    }

    // Capture screenshot when there is a failure
    public void captureScreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String failureImageFileName = result.getMethod().getMethodName()
                    + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
            File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
            failureImageFile.getParentFile().mkdir();
            failureImageFile.createNewFile();
            Files.copy(imageFile, failureImageFile);
        }

    }


    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);

    }


    public int getCount(By objname) {
        return driver.findElements(objname).size();
    }


    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    public void pageLoad(int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }


    // Close all browsers
    public void tearDown() {
        driver.quit();
        reportInfo("Driver is Closed");
    }


    public void close() {
        driver.close();
    }


    /**
     * click method (objname)
     */
    public void click(By objname) {
        try {
            WebDriverWait newWait = new WebDriverWait(driver, 20);
            newWait.until(ExpectedConditions.elementToBeClickable(objname)).click();
            ;
            reportInfo("clicked on element " + objname);
        } catch (Exception e) {
            reportFail("Clicked on element by " + objname);
            Assert.fail("Clicked on element by " + objname);
        }
    }


    /**
     * click method (objname)
     */
    public void doubleclick(By objname) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(objname)).doubleClick().perform();
            reportInfo("Double clicked on element " + objname);
        } catch (Exception e) {
            reportFail("Double clicked on element by " + objname);
            Assert.fail("Double Clicked on element by " + objname);
        }
    }


    /* Click without Assert to ignore */
    public void ignoreClick(By objname) {
        try {
            WebElement element = driver.findElement(objname);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
        }
    }

    /**
     * report information
     */
    public void reportInfo(String message) {
        System.out.println(message);
        log.info(message);
        Reporter.log(message);
    }


    /**
     * report information
     */
    public void reportFail(String message) {
        System.out.println(message);
        log.info(message);
        Reporter.log("Fail: " + message);
    }


    public static void reportPass(String message) {
        System.err.println(message);
        log.info(message);
        Reporter.log(message);
    }

    /**
     * selectTextFromDropdown method (objname = the object name from objectmap
     * file)
     */
    public void SelectTextByValue(By objname, String value) {
        try {
            Select select = new Select(driver.findElement(objname));
            reportInfo("dropdown '" + objname + "' is selected");
            select.selectByValue(value);
            reportInfo("text '" + value + "' is selected from the dropdown '"
                    + objname + "'");
        } catch (Exception e) {
            reportFail("'" + objname + "' is not present or text '" + value
                    + "' is not selected");

        }

    }


    /**
     * selectTextFromDropdown method (objname = the object name from objectmap
     * file)
     */
    public void SelectTextByIndex(By objname, int index) {
        try {
            Select select = new Select(driver.findElement(objname));
            reportInfo("dropdown '" + objname + "' is selected");
            select.selectByIndex(index);
            reportInfo("text '" + index + "' is selected from the dropdown '"
                    + objname + "'");
        } catch (Exception e) {
            reportFail("'" + objname + "' is not present or text '" + index
                    + "' is not selected");

        }

    }


    /**
     * selectTextFromDropdown method (objname = the object name from objectmap
     * file)
     */
    public void SelectTextByVisibleText(By objname, String text) {
        try {
            Select select = new Select(driver.findElement(objname));
            reportInfo("dropdown '" + objname + "' is selected");
            select.selectByVisibleText(text);
            reportInfo("text '" + text + "' is selected from the dropdown '"
                    + objname + "'");
        } catch (Exception e) {
            reportFail("'" + objname + "' is not present or text '" + text
                    + "' is not selected");

        }

    }


    /**
     * Wait for number of windows to be opened
     *
     * @param numberOfWindows
     */
    public void waitForNumberOfWindowsToOpen(final int numberOfWindows) {
        new WebDriverWait(driver, 60) {
        }.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (driver.getWindowHandles().size() == numberOfWindows);
            }
        });
    }


    /**
     * waitForElementPresent method (objname = the object name from objectmap
     * file) , (time is in seconds)
     */
    public void WaitForElementPresent(By objname, int time) {
        try {
            WebDriverWait newWait = new WebDriverWait(driver, time);
            newWait.until(ExpectedConditions.visibilityOfElementLocated(objname));
        } catch (Exception e) {
            reportFail("timeout error: element '" + objname + "' not present");
        }
    }


    public void JSClick(By objname) {
        try {
            waitUntillElementToBeClickable(objname, 20);
            WebElement element = driver.findElement(objname);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception E) {
            reportFail("JS Click cannot be performed on " + objname);
            E.printStackTrace();
        }
    }


    /**
     * sendKeys method (objname = the object name from objectmap file) , (value
     * is the text to enter)
     */
    public void SendKeys(By objname, String value) {
        try {
            WaitForElementPresent(objname, 10);
            driver.findElement(objname).clear();
            driver.findElement(objname).sendKeys(value);
            reportInfo("'" + value + "' is entered in '" + objname + "'");
        } catch (Exception e) {
            reportFail("element '" + objname + "' is not displayed");
            Assert.fail();
        }
    }


    /**
     * Load URL
     *
     * @author Sedhu
     */
    public void loadURL(String url) {
        try {
            driver.manage().window().maximize();
            driver.get(url);
        } catch (Exception e) {
            reportFail("Unable to load Url '" + url + "'");
        }
    }


    /**
     * Get Text
     *
     * @param Object Name
     * @throws Exception
     * @author Sedhu
     */


    //Function to retrieve the text fom web element
    public String getText(By objname) {
        String strValue = null;
        try {
            strValue = driver.findElement(objname).getText();
        } catch (Exception E) {
            reportFail("Unable to get text '" + objname + "'");
            E.printStackTrace();
        }
        return strValue;
    }


    /**
     * Switch to Frame
     * @param frame index
     * @throws Exception
     * @author Sedhu
     */


    /**
     * Switch Between Frames
     */
    public void switchToFrame(int frameNumber) {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(frameNumber);
            driver.switchTo().frame(frameNumber);
        } catch (Exception e) {
            reportFail("Frame '" + frameNumber + "' is not found");
        }
    }


    /**
     * Sleep
     *
     * @param frame name
     * @throws Exception
     * @author Sedhu
     */
    public void sleep(int time) throws Exception {
        Thread.sleep(time * 1000);
    }


    /**
     * Switch to Frame by using name
     *
     * @param time(In seconds)
     * @throws Exception
     * @author Sedhu
     */
    public String switchToFrameByName(String frame) {

        driver.switchTo().defaultContent();
        String actual = "";
        try {

            wait = new WebDriverWait(driver, 90);
            sleep(1);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                    .name(frame)));

            System.out.println("Navigated to frame with name " + frame);
            actual = "Switched";
        } catch (final NoSuchFrameException e) {

            System.out.println("Unable to locate frame with id " + frame
                    + e.getStackTrace());
            reportFail("Frame with name'" + frame + "' is not found");
            actual = "Not Switched";
        } catch (final Exception e) {

            System.out.println("Unable to navigate t" + "o frame with id "
                    + frame + e.getStackTrace());
            reportFail("Frame with name '" + frame + "' is not found");
            actual = "Not Switched";
        }
        return actual;
    }


    /**
     * Switch to second window
     *
     * @param firstWinHandle (Handle of Main Window)
     */
    public void switchToSecondWindow(String firstWinHandle) {
        waitForNumberOfWindowsToOpen(2);
        Set<String> handles = driver.getWindowHandles();
        handles.remove(firstWinHandle);
        String winHandle = handles.iterator().next();
        if (winHandle != firstWinHandle) {
            String secondWinHandle = winHandle;
            driver.switchTo().window(secondWinHandle);
        }
    }


    /**
     * Switch to SubFrame
     */
    public void switchToChildFrame(int frameNumber) {
        try {
            driver.switchTo().frame(frameNumber);
        } catch (Exception e) {
            reportFail("Childframe '" + frameNumber + "' is not found");
        }
    }


    /**
     * Get Alert Message
     */
    public String getAlertMsg() throws Exception {
        String alertMsg = null;
        try {
            alertMsg = driver.switchTo().alert().getText();
            return alertMsg;
        } catch (Exception e) {
            reportFail("No message found in alert");
            return alertMsg;
        }
    }


    /**
     * Accept Alert
     */

    public void AlertAccept() throws Exception {
        try {
            //Get the Alert
            Alert alert = driver.switchTo().alert();
            //Click OK button, by calling accept() method of Alert Class
            alert.accept();
            reportInfo("Alert Accepted");
        } catch (Exception t) {
            reportFail("Alert message is not found");
        }
    }


    /**
     * Iterate between Frames to identify the object
     */

    public void Iterate_Frames(By objname) throws Exception {

        try {
            //Assume driver is initialized properly.
            List<WebElement> ele = driver.findElements(By.tagName("iframe"));
            System.out.println("Number of frames in a page :" + ele.size());

            for (WebElement el : ele) {
                //Returns the Id of a frame.
                System.out.println("Frame Id :" + el.getAttribute("id"));
                //Returns the Name of a frame.
                System.out.println("Frame name :" + el.getAttribute("name"));
                System.out.println(" ");
                if (driver.findElement(objname).isDisplayed()) {
                    driver.findElement(objname).click();
                }
            }

        } catch (Exception e) {
            reportFail(objname + " Frame not found");
            e.printStackTrace();
        }
    }

    public void waitUntillElementToBeVisible(By Element, int TotalTimeInSeconds) {
        FluentWait<WebDriver> visibleWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(TotalTimeInSeconds, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        visibleWait.until(ExpectedConditions.visibilityOf(driver.findElement(Element)));
    }


    public Boolean isDisplayed(By objname) {
        return driver.findElement(objname).isDisplayed();
    }


    public WebElement webelement(By objname) {
        return driver.findElement(objname);
    }

    public void selectChkbox(By objname) {
        try {
            if (!driver.findElement(objname).isSelected()) {
                driver.findElement(objname).click();
                reportInfo(objname + " Checkbox is selected");
            }
        } catch (Exception e) {
            reportFail(objname + " Checkbox cannot be selected");
            e.printStackTrace();
        }
    }


//	public void authenticate(String username, String password) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//	//	alert.authenticateUsing(new UserAndPassword(username,password));
//	}


    public void pressEnter(By objname) {
        driver.findElement(objname).sendKeys(Keys.ENTER);
    }


    public void pressEsc() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();

    }

    public void mouseHover(By objname) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(objname)).perform();

    }

    /**
     * Wait for element to disappear.
     *
     * @param driver  the driver
     * @param element the element
     * @param logger  the logger
     * @return true, if successful
     */
    public boolean waitForElementToDisappear(By objname) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
            fluentWait.until(ExpectedConditions.invisibilityOf(driver.findElement(objname)));
            return true;
        } catch (Exception e) {
            reportFail(
                    "Error occured while waiting for element to disappear</br>" + e.getStackTrace());
            return false;
        }
    }


    public WebElement waitUntilElementToBeClickable(By objname, int time) {
        final FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(time, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                try {
                    if (webDriver.findElement(objname).isDisplayed())
                        return webDriver.findElement(objname);
                    return null;
                } catch (final ElementNotVisibleException e) {
                    return null;
                }
            }
        });
    }


    public void dismissAlert() {
        try {
            Alert alt = driver.switchTo().alert();
            alt.dismiss();
        } catch (Exception c) {
            pressEsc();
            reportInfo("Alert Dismissed");
        }
    }


    public void acceptAlert() {
        try {
            Alert alt = driver.switchTo().alert();
            alt.accept();
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }


    public List<WebElement> findAllElements(By objname) {
        return driver.findElements(objname);
    }


    public void waitUntillElementToBeClickable(By objname, int time) {
        try {
            WebDriverWait newWait = new WebDriverWait(driver, time);
            newWait.until(ExpectedConditions.elementToBeClickable(objname));
        } catch (Exception e) {
            reportFail("timeout error: element '" + objname + "' not present");
        }
    }


    public void scrollToView(By objname) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(objname)).build().perform();
    }


    public WebElement focusElement() {
        return driver.switchTo().activeElement();
    }


    public void clickJS(By objname) {
        WebElement element = driver.findElement(objname);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].style.transform='scale(1)';", element);
        element.click();
    }


    public void retryClick(By objname, int i) {
        while (i > 0) {
            try {
                i--;
                driver.findElement(objname).click();
            } catch (Exception e) {
                ignoreClick(objname);
            }
        }
    }


    /**
     * Random String Generator
     */
    public String Random_StringGenerator(int length) throws Exception {
        String Random = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < length; i++) {
            double a = Math.random();
            int x = (int) (a * 100);

            if (x > 25 && x < 52) {
                x = x - 26;
            } else if (x > 51 && x < 78) {
                x = x - 52;
            } else if (x > 77 && x < 99) {
                x = x - 78;
            } else {
                x = 1;
            }

            char letter = abc.charAt(x);
            Random = Random + String.valueOf(letter);
        }
        System.out.println(Random);
        return Random;

    }

    /**
     * Random Number Generator
     */
    public String Random_NumberGenerator(int length) throws Exception {
        double number, value;
        int len;
        number = Math.random();

        StringBuffer s = new StringBuffer(length);
        s.append("1");
        for (int k = 0; k < length; k++) {
            s.append("0");
        }

        value = Double.parseDouble(s.toString());

        number = number * value;
        int random = (int) (number);
        String randomno = Integer.toString(random);
        len = randomno.length();

        if (len < length) {
            int diff = length - len;
            StringBuffer s1 = new StringBuffer(randomno);
            for (int k = 0; k < diff; k++) {
                s1.append("0");
            }
            randomno = s1.toString();
        }
        return randomno;
    }


    // Generate Alpha numeric values
    public String generateRandomAlphanumericString(int n) {
        String generatedString = RandomStringUtils.randomAlphanumeric(n);
        return generatedString;
    }


    public void setText(By objname, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + value + "';", driver.findElement(objname));
    }


    public void getCookies() {
        try {
            File file = new File(System.getProperty("user.dir") + "//src//test//resources//config//cookies.data");
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);

            for (Cookie ck : driver.manage().getCookies()) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void setCookies() {
        try {
            File file = new File(System.getProperty("user.dir") + "//src//test//resources//config//cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while ((strline = Buffreader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline, ";");
                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if (!(val = token.nextToken()).equals("null")) {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).
                            booleanValue();
                    Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                    driver.manage().addCookie(ck); // This will add the stored cookie to your current session
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
