package com.example.demo.models;

public enum Section {
    SHORTS("Shorts"), 
    PANTS("Pants"), 
    SHIRTS("Shirts"), 
    DRESSES("Dresses"), 
    OUTERWEAR("Outerwear"),
    ACCESSORIES("Accessories");

    private final String displayName;

    Section(String displayName) {
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
