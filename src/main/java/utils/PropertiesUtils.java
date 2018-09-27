package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties readProperties(String appConfigPath) throws IOException {
        Properties appProps = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(appConfigPath)) {
            appProps.load(fileInputStream);
        }
        return appProps;
    }
}
