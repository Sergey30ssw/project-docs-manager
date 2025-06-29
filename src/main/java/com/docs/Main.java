package com.docs;

import com.docs.config.MongoConfig;
import com.docs.model.Document;
import com.docs.service.DocumentService;
import com.mongodb.client.MongoClient;
import org.bson.types.ObjectId;

public class Main {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoConfig.createMongoClient()) {
            DocumentService docService = new DocumentService(mongoClient);

            ObjectId userId = new ObjectId();

            // Создаем документ
            Document doc = docService.createDocument("Project Spec", userId);
            System.out.println("Created document with ID: " + doc.getId());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}