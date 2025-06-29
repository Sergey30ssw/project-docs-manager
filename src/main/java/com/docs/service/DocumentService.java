package com.docs.service;

import com.docs.model.Document;
import com.docs.model.Version;
import com.docs.repository.DocumentRepository;
import com.docs.repository.VersionRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

public class DocumentService {
    private final DocumentRepository documentRepository;
    private final VersionRepository versionRepository;

    public DocumentService(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("docsdb");
        this.documentRepository = new DocumentRepository(
                database.getCollection("documents", Document.class));
        this.versionRepository = new VersionRepository(
                database.getCollection("versions", Version.class));
    }

    public Document createDocument(String title, ObjectId userId) {
        Document document = new Document();
        document.setTitle(title);

        Version initialVersion = createInitialVersion(userId);
        document.setCurrentVersionId(initialVersion.getId());
        document.addVersionId(initialVersion.getId());

        documentRepository.save(document);
        return document;
    }

    private Version createInitialVersion(ObjectId userId) {
        Version version = new Version();
        version.setCreatedBy(userId);
        version.setComment("Initial version");
        version.setNumber(1);
        versionRepository.save(version);
        return version;
    }


}