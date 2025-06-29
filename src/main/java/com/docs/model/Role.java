package com.docs.model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Role {
    @BsonId
    private ObjectId id;
    private String name;
    private String description;
    private Set<Permission> permissions = new HashSet<>();
    private Date createdAt;
    private boolean systemRole;

    // Конструкторы
    public Role() {
        this.createdAt = new Date();
    }

    public Role(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    // Геттеры
    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isSystemRole() {
        return systemRole;
    }

    // Сеттеры
    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setSystemRole(boolean systemRole) {
        this.systemRole = systemRole;
    }

    // Методы управления permissions
    public boolean addPermission(Permission permission) {
        return permissions.add(permission);
    }

    public boolean removePermission(Permission permission) {
        return permissions.remove(permission);
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}