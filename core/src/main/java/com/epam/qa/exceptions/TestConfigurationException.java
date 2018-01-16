package com.epam.qa.exceptions;

public class TestConfigurationException extends RuntimeException {

    public TestConfigurationException(final String message) {
        super(message);
    }

    public TestConfigurationException(final Throwable cause) {
        super(cause);
    }

    public TestConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TestConfigurationException(final String message, final Object... args) {
        super(String.format(message, args));
    }

    public TestConfigurationException(final String message, final Throwable cause, final Object... args) {
        super(String.format(message, args), cause);
    }
}
