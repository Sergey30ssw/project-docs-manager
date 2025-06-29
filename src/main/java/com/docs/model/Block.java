package com.docs.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Block {
    private String id;
    private String type; // "text", "heading", "image", "code", etc.
    private String content;
    private Map<String, String> attributes;

    // Конструкторы
    public Block() {
        this.attributes = new HashMap<>();
    }

    public Block(String type, String content) {
        this();
        this.type = type;
        this.content = content;
    }

    // Геттеры
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    // Сеттеры
    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    // Дополнительные методы
    public void addAttribute(String key, String value) {
        this.attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return this.attributes.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(id, block.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Block{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}