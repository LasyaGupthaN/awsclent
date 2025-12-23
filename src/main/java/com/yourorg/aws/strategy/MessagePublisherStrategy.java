package com.yourorg.aws.strategy;

/**
 * Strategy interface for publishing messages to a messaging service
 * such as SQS or SNS.
 *
 * No AWS SDK types should appear here.
 */
public interface MessagePublisherStrategy {

    /**
     * Publishes a message and returns a provider-specific identifier.
     *
     * @param payload message body
     * @return message identifier
     */
    String publish(String payload);
}

