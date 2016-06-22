package properties;

import java.util.ResourceBundle;

public class Config {

    private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "properties.config";
    public static final String INDEX = "INDEX";
    public static final String COURSES = "COURSES";
    public static final String STUDENT_PAGE = "STUDENT_PAGE";
    public static final String TEACHER_PAGE = "TEACHER_PAGE";
    public static final String ERROR_PAGE = "ERROR_PAGE";
    public static final String TEST_PAGE = "TEST_PAGE";
    public static final String TEST = "TEST";

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);

        }
        return instance;
    }

    private Config() {
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
