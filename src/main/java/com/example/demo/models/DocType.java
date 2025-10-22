package com.example.demo.models;

public enum DocType {
    CC("cc"), 
    TI("ti");

    private final String displayName;

    DocType(String displayName) {
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
