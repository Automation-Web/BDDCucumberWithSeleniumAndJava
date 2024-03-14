package stepDefination;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Configuration {

    static Logger log= LogManager.getLogManager().getLogger(String.valueOf(Configuration.class));
    final static String fileSeperator = "\\";
    public static final String resourceFilePath = System.getProperty("user.dir") + fileSeperator;



    public static String readConfig(String configuration) {
        String value = "";
        Properties prop = new Properties();
        File f = new File(resourceFilePath + "Config.properties".replace('\\', '/'));
        if (f.exists()) {
            try {
                prop.load(Files.newInputStream(f.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            value = prop.getProperty(configuration);
        }
        else {
            log.log(Level.ALL, "File not found");
        }
        if (value == null)
            log.log(Level.ALL, "Key not found in properties file");


        return value;
    }


    public static String getBrowser() {
        String browser = null;
        try {
            browser = readConfig("browser");
        } catch (Exception e) {
            // log.(Level.ALL, e.toString());
        }
        return browser;
    }

    public static String getOs() {
        String os = null;
        try {
            os = readConfig("os");
        } catch (Exception e) {
            //log.log(Level.ALL, e.toString());
        }
        return os;
    }

    public static String getBrowserVersion() {
        String browserVersion = null;
        try {
            // get the Browser value
            browserVersion = readConfig("version");
        } catch (Exception e) {
            // log.log(Level.ALL, e.toString());
        }
        return browserVersion;
    }

    public static String getURL() {
        String url = null;
        try {
            url = readConfig("URL");
        } catch (Exception e) {
            //log.log(Level.ALL, e.toString());
        }
        return url;
    }

}
