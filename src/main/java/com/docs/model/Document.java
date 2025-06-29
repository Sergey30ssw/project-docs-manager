package com.docs.model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.ArrayList;

public class Document {
    @BsonId
    private ObjectId id;
    private String title;
    private ObjectId currentVersionId;
    private List<ObjectId> versionIds = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    // Геттеры и сеттеры
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ObjectId getCurrentVersionId() {
        return currentVersionId;
    }

    public void setCurrentVersionId(ObjectId currentVersionId) {
        this.currentVersionId = currentVersionId;
    }

    public List<ObjectId> getVersionIds() {
        return versionIds;
    }

    public void setVersionIds(List<ObjectId> versionIds) {
        this.versionIds = versionIds;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    // Дополнительные методы
    public void addVersionId(ObjectId versionId) {
        this.versionIds.add(versionId);
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }
}