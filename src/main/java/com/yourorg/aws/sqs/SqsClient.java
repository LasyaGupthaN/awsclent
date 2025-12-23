package com.yourorg.aws.sqs;


import com.yourorg.aws.strategy.MessagePublisherStrategy;

/**
 * Public-facing SQS client.
 *
 * This class hides AWS SDK and strategy details
 * from consuming projects.
 */
public class SqsClient {

    private final MessagePublisherStrategy publisherStrategy;

    public SqsClient(MessagePublisherStrategy publisherStrategy) {
        this.publisherStrategy = publisherStrategy;
    }

    /**
     * Sends a message to SQS.
     *
     * @param message payload
     * @return messageId
     */
    public String sendMessage(String message) {
        return publisherStrategy.publish(message);
    }
}
