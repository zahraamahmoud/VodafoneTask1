package actions;

// this Framework I worked on it during ITI diploma
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BrowserActions {
    static WebDriverManager driverManager;

    static ThreadLocal<WebDriver>drivers=new ThreadLocal<>();;
    private static final Logger logger = Logger.getLogger(WebDriverManager.class.getName());

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void setWebDriver(browsers browser) {
        driverManager.chromedriver().setup();

        try{
            switch (browser){
                case chrome:
                    drivers.set(new ChromeDriver());
                    break;
                case firefox:
                    drivers.set(new FirefoxDriver());
                    break;
                case safari:
                    drivers.set(new SafariDriver());
            }
        }
        catch(Exception e){

            logger.log(Level.SEVERE, "failed to initialize WebDriver for " + browser, e);
            throw new RuntimeException("failed to initialize WebDriver for " + browser, e);
        }
    }



    public  static void maximizethewindow(){
            drivers.get().manage().window().maximize();

    }
    public static void setthewindowSize(int i, int i1) {
        drivers.get().manage().window().setSize(new Dimension(i,i1));
    }
    public static void quitDriver(){
        drivers.get().quit();
    }



    public enum browsers{
        chrome,
        firefox,
        safari
    }




}
