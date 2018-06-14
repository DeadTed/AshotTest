import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Setup {

    private WebDriver driver;

    public Setup(WebDriver driver) {
        this.driver = driver;
    }

    public void addWindow( String url) {
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1000, 1000));
//        driver.manage().timeouts().implicitlyWait(timeOutsInSec, TimeUnit.SECONDS);
        driver.get(url);
    }

    public static void driver(String TypeDriver, String OS) {
        if (TypeDriver.equals("gecko") & OS.equals("windows")) {
            System.out.println("--------------------------------------------------");
            System.out.println("initialization " + TypeDriver + " driver for " + OS + " operating system");
            System.out.println("Path: c:\\Users\\Minchanka\\Downloads\\geckodriver.exe");
            System.out.println("--------------------------------------------------");
            System.setProperty("webdriver.gecko.driver", "c:\\Users\\Minchanka\\Downloads\\geckodriver.exe");
        } else if (TypeDriver.equals("gecko") & OS.equals("linux")) {
            System.out.println("--------------------------------------------------");
            System.out.println("initialization " + TypeDriver + " driver for " + OS + " operating system");
            System.out.println("Path: /home/user/Downloads/geckodriver-v0.18.0-linux64/geckodriver");
            System.out.println("--------------------------------------------------");
            System.setProperty("webdriver.gecko.driver", "/home/user/Downloads/geckodriver-v0.18.0-linux64/geckodriver");
        }else if(TypeDriver.equals("chrome") & OS.equals("windows")){
            System.setProperty("webdriver.chrome.driver", "c:\\Users\\Minchanka\\Downloads\\chromedriver.exe");
        }
        else {
            System.out.println("...oops...some problems with driver....");
        }
    }
}
