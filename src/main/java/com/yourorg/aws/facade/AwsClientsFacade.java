package com.yourorg.aws.facade;


import com.yourorg.aws.config.AwsClientConfig;
import com.yourorg.aws.factory.AwsClientFactory;
import com.yourorg.aws.sqs.SqsClient;

/**
 * Facade providing a simplified interface to AWS clients.
 *
 * This is the recommended entry point for consuming projects.
 */
public class AwsClientsFacade {

    private final SqsClient sqsClient;

    public AwsClientsFacade(AwsClientConfig config, String sqsQueueUrl) {
        this.sqsClient = AwsClientFactory.createSqsClient(config, sqsQueueUrl);
    }

    /**
     * Publish a message to SQS.
     *
     * @param message payload
     * @return messageId
     */
    public String publishToSqs(String message) {
        return sqsClient.sendMessage(message);
    }
}
