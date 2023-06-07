package src.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Database properties getter.
 */
public class DatabasePropertiesGetter {
    private static String url;
    private static String user;
    private static String password;

    /**
     * Gets url.
     *
     * @return the url
     */
    protected static String getUrl() {
        return url;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    protected static String getUser() {
        return user;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    protected static String getPassword() {
        return password;
    }
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/home/studs/s367528/Lab7/" + "db.cfg"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
