package com.epam.qa.config;

import com.epam.qa.exceptions.TestConfigurationException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Slf4j
class PropertiesLoader {

    private static final String ENV = "env";
    private static final String ENV_PROPERTIES_TEMPLATE = "environments/%s.properties";
    private static final List<String> validEnvNames = Arrays.asList("QA", "DEV", "STAGE");

    private PropertiesLoader() {
    }

    static void loadEnvProperties() {
        loadProperties(getEnvironmentResourceName());
    }

    private static void loadProperties(final String resourceName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            properties.load(resourceStream);
            System.getProperties().putAll(properties);
        } catch (IOException e) {
            log.error("IOException {}", e);
            throw new Error(String.format("Can't read properties from %s file!", resourceName));
        }
    }

    private static String getEnvironmentResourceName() {
        String env = System.getProperty(ENV, "QA");
        env = env.toUpperCase();
        if (!validEnvNames.contains(env)) {
            throw new TestConfigurationException(
                "Environment name '%s' is not valid. Possible values: %s", env, validEnvNames);
        }
        log.info("Getting [{}] environment configuration", env);
        return String.format(ENV_PROPERTIES_TEMPLATE, env);
    }
}
