package dev.it22.kmitl.reg.model.request;

import java.sql.Timestamp;

public class UserRequestModel {
    private int id;
    private String email;
    private String fieldName;
    private String oldValue;
    private String newValue;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public UserRequestModel(int id, String email, String fieldName, String oldValue, String newValue, String status, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.email = email;
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
