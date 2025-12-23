package com.yourorg.aws.exception;

/**
 * Base exception for all AWS client errors in this library.
 *
 * Consumers should catch this exception, not AWS SDK exceptions.
 */
public class AwsClientException extends RuntimeException {

    public AwsClientException(String message) {
        super(message);
    }

    public AwsClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public AwsClientException(Throwable cause) {
        super(cause);
    }
}

