package com.example.demo.caso_1.models;

public enum Cancelacion {
    
    ACTIVA("activa"),
    TARDIA("tardia");

    private final String displayName;

    Cancelacion(String displayName) {
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
