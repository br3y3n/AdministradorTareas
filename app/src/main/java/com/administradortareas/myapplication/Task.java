package com.administradortareas.myapplication;

public class Task {

    private String name;
    private TaskCategory category;
    private boolean isSelected;

    public Task(String name, TaskCategory category) {
        this.name = name;
        this.category = category;
        this.isSelected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskCategory getCategory() {
        return category;
    }

    public void setCategory(TaskCategory category) {
        this.category = category;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
