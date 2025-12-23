package com.yourorg.aws.factory;



import com.yourorg.aws.config.AwsClientConfig;
import com.yourorg.aws.sqs.SqsClient;
import com.yourorg.aws.sqs.SqsPublisherStrategy;

/**
 * Factory responsible for creating AWS service clients.
 *
 * All object creation logic is centralized here.
 */
public final class AwsClientFactory {

    private AwsClientFactory() {
        // prevent instantiation
    }

    /**
     * Creates an SQS client.
     *
     * @param config   shared AWS client configuration
     * @param queueUrl SQS queue URL
     * @return configured SqsClient
     */
    public static SqsClient createSqsClient(AwsClientConfig config, String queueUrl) {
        return new SqsClient(
                new SqsPublisherStrategy(config, queueUrl)
        );
    }
}
