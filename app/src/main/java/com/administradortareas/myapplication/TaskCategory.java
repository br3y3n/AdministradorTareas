package com.administradortareas.myapplication;

public enum TaskCategory {
    Personal("Personal"),
    Business("Business"),
    Other("Other");

    private final String name;
    private boolean isSelected = true; // Default selected

    TaskCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }
    }