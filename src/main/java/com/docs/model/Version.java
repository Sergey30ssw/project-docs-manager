package com.docs.model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import java.util.Date;
import java.util.List;

public class Version {
    @BsonId
    private ObjectId id;
    private ObjectId documentId;
    private int number;
    private Date createdAt = new Date();
    private ObjectId createdBy;
    private String comment;
    private List<Block> content;

    // Геттеры и сеттеры
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public ObjectId getDocumentId() { return documentId; }
    public void setDocumentId(ObjectId documentId) { this.documentId = documentId; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public ObjectId getCreatedBy() { return createdBy; }
    public void setCreatedBy(ObjectId createdBy) { this.createdBy = createdBy; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public List<Block> getContent() { return content; }
    public void setContent(List<Block> content) { this.content = content; }
}