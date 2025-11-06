package com.example.demo.caso_1.models;

public enum Estado {
    ACTIVO("activo"),
    INACTIVO("inactivo");

    private final String displayName;

    Estado(String displayName) {
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
