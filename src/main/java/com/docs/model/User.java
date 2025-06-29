package com.docs.model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class User {
    @BsonId
    private ObjectId id;
    private String username;
    private String email;
    private String passwordHash;
    private Set<ObjectId> roleIds = new HashSet<>();
    private boolean active = true;
    private Date createdAt = new Date();
    private Date lastLogin;

    // Конструкторы
    public User() {}

    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    // Геттеры
    public ObjectId getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Set<ObjectId> getRoleIds() {
        return roleIds;
    }

    public boolean isActive() {
        return active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    // Сеттеры
    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRoleIds(Set<ObjectId> roleIds) {
        this.roleIds = roleIds;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    // Методы управления ролями
    public boolean addRole(ObjectId roleId) {
        return roleIds.add(roleId);
    }

    public boolean removeRole(ObjectId roleId) {
        return roleIds.remove(roleId);
    }

    public boolean hasRole(ObjectId roleId) {
        return roleIds.contains(roleId);
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }
}