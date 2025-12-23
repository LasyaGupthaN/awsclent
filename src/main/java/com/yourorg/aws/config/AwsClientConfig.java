package com.yourorg.aws.config;

public class AwsClientConfig {

    private final String region;

    private AwsClientConfig(Builder builder) {
        this.region = builder.region;
    }

    public String getRegion() {
        return region;
    }

    public static class Builder {
        private String region;

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public AwsClientConfig build() {
            return new AwsClientConfig(this);
        }
    }
}
