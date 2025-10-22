package com.example.demo.models;

public enum ClothingCategory {
    MAN("Man"), 
    WOMAN("Woman");

    private final String displayName;

    ClothingCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
