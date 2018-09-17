package com.usage.dagger.daggerusage.domain.models;

public class NoteModel {

    private int id;

    private String title;
    private String text;
    private long editingDate;
    private int priority;
    private int orderNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getEditingDate() {
        return editingDate;
    }

    public void setEditingDate(long editingDate) {
        this.editingDate = editingDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
