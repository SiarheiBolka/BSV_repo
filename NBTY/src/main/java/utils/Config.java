package utils;

/**
 * Created by Siarhei Bolka on 6/16/2015.
 */
public class Config {

    private String url;
    private String hub;
    private String userName;
    private String password;
    private String browser;

    private static Config instance;

    private Config() {}

    public static Config getConfigInstance() {
        if(null == instance) {
            instance = new Config();
            instance.setUrl(PropertyFileReader.loadPropertiesFile().getProperty("URL"));
            instance.setHub(PropertyFileReader.loadPropertiesFile().getProperty("HUB"));
            instance.setUserName(PropertyFileReader.loadPropertiesFile().getProperty("username"));
            instance.setPassword(PropertyFileReader.loadPropertiesFile().getProperty("password"));
            instance.setBrowser(PropertyFileReader.loadPropertiesFile().getProperty("browser"));
        }
        return instance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHub() {
        return hub;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrowserName() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
