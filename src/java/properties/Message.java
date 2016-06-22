package properties;

import java.util.ResourceBundle;

public class Message {
    private static Message instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "properties.messages";
    public static final String WRONG_PASSWORD = "WRONG_PASSWORD";
    public static final String WRONG_LOGIN = "WRONG_LOGIN";
    public static final String WRONG_LOGIN_USED = "WRONG_LOGIN_USED";
    public static final String WRONG_EMAIL_USED = "WRONG_EMAIL_USED";
    public static final String RANDOM_ERROR = "RANDOM_ERROR";





    public static Message getInstance() {
        if (instance == null) {
            instance = new Message();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    private Message() {
    }

    public String getProperty(String key) {

        return (String) resource.getObject(key);
    }

}
