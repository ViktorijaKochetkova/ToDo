package com.todoproject2jdbc.todo;

import java.sql.Timestamp;

public class Todo {

    private int id;
    private String description;
    private boolean isComplete;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Todo() {
    }

    public Todo(String description, boolean isComplete) {
        this.description = description;
        this.isComplete = isComplete;
    }

    public Todo(int id, String description, boolean isComplete, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.description = description;
        this.isComplete = isComplete;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
