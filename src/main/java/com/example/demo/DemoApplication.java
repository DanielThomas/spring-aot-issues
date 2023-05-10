package com.example.demo;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public S3ClientConfiguration s3ClientConfiguration() {
        return new S3ClientConfigurationImpl();
    }

    @Bean
    public static AmazonS3 s3Client(S3ClientConfiguration config) {
        Objects.requireNonNull(config.getRegion());
        return AmazonS3ClientBuilder.standard()
                .withRegion(config.getRegion())
                .build();
    }

    interface S3ClientConfiguration {
        String getBucket();

        String getRegion();
    }

    static class S3ClientConfigurationImpl implements S3ClientConfiguration {

        @Value("${com.example.demo.s3.bucket:}")
        private String bucket;

        @Value("${EC2_REGION:}")
        private String ec2Region;

        public String getRegion() {
            return ec2Region;
        }

        public String getBucket() {
            return bucket;
        }
    }

}
