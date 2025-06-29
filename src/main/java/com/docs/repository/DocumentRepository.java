package com.docs.repository;

import com.docs.model.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class DocumentRepository {
    private final MongoCollection<Document> collection;

    public DocumentRepository(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public Document findById(ObjectId id) {
        return collection.find(eq("_id", id)).first();
    }

    public void save(Document document) {
        ReplaceOptions options = new ReplaceOptions().upsert(true);
        collection.replaceOne(
                eq("_id", document.getId()),
                document,
                options
        );
    }

    public void delete(ObjectId id) {
        collection.deleteOne(eq("_id", id));
    }
}