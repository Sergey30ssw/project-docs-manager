package com.docs.repository;

import com.docs.model.Version;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class VersionRepository {
    private final MongoCollection<Version> collection;

    public VersionRepository(MongoCollection<Version> collection) {
        this.collection = collection;
    }

    public Version findById(ObjectId id) {
        return collection.find(eq("_id", id)).first();
    }

    public void save(Version version) {
        ReplaceOptions options = new ReplaceOptions().upsert(true);
        collection.replaceOne(
                eq("_id", version.getId()),
                version,
                options
        );
    }
}