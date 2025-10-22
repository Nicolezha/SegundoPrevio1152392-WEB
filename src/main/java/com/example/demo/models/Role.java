package com.example.demo.models;

public enum Role {
    ADMIN("Admin"), 
    CUSTOMER("Customer");

    private String displayName;

    Role(String displayName) {
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
