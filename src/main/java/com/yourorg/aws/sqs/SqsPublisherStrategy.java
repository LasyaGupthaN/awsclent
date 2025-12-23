package com.yourorg.aws.sqs;

import com.yourorg.aws.config.AwsClientConfig;
import com.yourorg.aws.exception.AwsClientException;
import com.yourorg.aws.strategy.MessagePublisherStrategy;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

/**
 * AWS SQS implementation of MessagePublisherStrategy.
 */
public class SqsPublisherStrategy implements MessagePublisherStrategy {

    private final SqsClient sqsClient;
    private final String queueUrl;

    public SqsPublisherStrategy(AwsClientConfig config, String queueUrl) {
        this.queueUrl = queueUrl;
        this.sqsClient =
                SqsClient.builder()
                        .region(Region.of(config.getRegion()))
                        .build();
    }

    @Override
    public String publish(String payload) {
        try {
            SendMessageRequest request =
                    SendMessageRequest.builder()
                            .queueUrl(queueUrl)
                            .messageBody(payload)
                            .build();

            SendMessageResponse response = sqsClient.sendMessage(request);
            return response.messageId();

        } catch (Exception ex) {
            throw new AwsClientException("Failed to publish message to SQS", ex);
        }
    }

}
