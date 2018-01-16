package com.epam.qa.config;

import lombok.Getter;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;

@Getter
public class EnvConfig {

    @Property("api.url")
    private String apiUrl;

    @Property("web.domain")
    private String webDomain;

    @Property("db.url")
    private String dbUrl;

    @Property("db.login")
    private String dbLogin;

    @Property("db.password")
    private String dbPassword;

    private EnvConfig() {
        PropertyLoader.populate(this);
    }

    private static class Holder {

        static {
            PropertiesLoader.loadEnvProperties();
        }

        private static final EnvConfig CONFIG = new EnvConfig();
    }

    public static EnvConfig get() {
        return Holder.CONFIG;
    }
}
