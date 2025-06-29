package com.docs.service;

import io.minio.*;
import io.minio.errors.*;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class StorageService {
    private final MinioClient minioClient;
    private final String defaultBucket;

    public StorageService(String endpoint, String accessKey, String secretKey, String defaultBucket) {
        this.minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
        this.defaultBucket = defaultBucket;
        initializeBucket();
    }

    private void initializeBucket() {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder()
                    .bucket(defaultBucket)
                    .build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder()
                        .bucket(defaultBucket)
                        .build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize bucket", e);
        }
    }

    public void uploadFile(String objectName, InputStream stream, long size, String contentType) {
        try {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(defaultBucket)
                    .object(objectName)
                    .stream(stream, size, -1)
                    .contentType(contentType)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    public InputStream downloadFile(String objectName) {
        try {
            return minioClient.getObject(GetObjectArgs.builder()
                    .bucket(defaultBucket)
                    .object(objectName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to download file", e);
        }
    }

    public void deleteFile(String objectName) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(defaultBucket)
                    .object(objectName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete file", e);
        }
    }
}