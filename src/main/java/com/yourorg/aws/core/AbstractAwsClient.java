package com.yourorg.aws.core;

import com.yourorg.aws.config.AwsClientConfig;

/**
 * Internal base class that enforces a standard execution workflow
 * for all AWS client operations.
 *
 * This class is NOT intended to be used directly by consumers.
 */
public abstract class AbstractAwsClient<T> {

    protected final AwsClientConfig config;

    protected AbstractAwsClient(AwsClientConfig config) {
        this.config = config;
    }

    /**
     * Template method defining the fixed execution flow.
     */
    public final T execute() {
        try {
            beforeExecution();
            T result = doExecute();
            afterSuccess(result);
            return result;
        } catch (Exception ex) {
            handleFailure(ex);
            throw ex;
        }
    }

    /**
     * AWS-specific logic goes here.
     */
    protected abstract T doExecute();

    /**
     * Hooks for cross-cutting concerns.
     * Subclasses may override if required.
     */
    protected void beforeExecution() {
        // logging, metrics, tracing (future)
    }

    protected void afterSuccess(T result) {
        // success logging, metrics
    }

    protected void handleFailure(Exception ex) {
        // error logging, exception translation
    }
}

