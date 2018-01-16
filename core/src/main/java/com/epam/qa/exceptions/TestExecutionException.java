package com.epam.qa.exceptions;

public class TestExecutionException extends RuntimeException {

    public TestExecutionException(final String message) {
        super(message);
    }

    public TestExecutionException(final Throwable cause) {
        super(cause);
    }

    public TestExecutionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TestExecutionException(final String message, final Object... args) {
        super(String.format(message, args));
    }

    public TestExecutionException(final String message, final Throwable cause, final Object... args) {
        super(String.format(message, args), cause);
    }
}
