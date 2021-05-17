package domain;

import java.util.Properties;

/**
 * 这个类对象是我要管理的bean
 * bean中有一个properties属性
 */
public class TestProperties {

    private Properties properties;

    public TestProperties(Properties properties) {
        this.properties = properties;
    }
    public TestProperties() {
    }
    public Properties getProperties() {
        return properties;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
