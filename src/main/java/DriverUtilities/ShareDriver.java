package DriverUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import stepDefination.Configuration;

public class ShareDriver {


    private WebDriver driver;
    private final String browser = Configuration.getBrowser();
    private final String OS=Configuration.getOs();

    public WebDriver standaloneDriver() throws Exception {

        String CurrentDir = System.getProperty("user.dir");
        String driverPath = CurrentDir + "\\DriverFiles\\";

        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

//        ChromeDriverService service =
//                new ChromeDriverService.Builder().withLogOutput(System.out).build();

        switch(Configuration.getBrowser()) {
            case "CHROME":
                if(OS.contains("WIN11")) {
                    //WebDriverManager.chromedriver().create();
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver" + Configuration.getBrowserVersion() + ".exe");
                }
                driver = new ChromeDriver(options);
                break;

            case "EDGE":
                if(OS.contains("WIN11")) {
                    System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver" + Configuration.getBrowserVersion() + ".exe");
                    //WebDriverManager.edgedriver().create();
                }
                driver =new EdgeDriver();
                break;

            case "FIREFOX" :
                if(OS.contains("WIN11")) {
                    System.setProperty("webdriver.firefox.driver", driverPath + "geckodriver" + Configuration.getBrowserVersion() + ".exe");
                    //WebDriverManager.firefoxdriver().create();
                }

                driver=new FirefoxDriver();
                break;

        }

        driver.manage().window().maximize();
        return driver;

    }


}
