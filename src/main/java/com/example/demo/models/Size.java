package com.example.demo.models;

public enum Size {
    XS("xs"),
    S("s"), 
    M("m"), 
    L("l"), 
    XL("xl"), 
    XXL("xxl");

    private final String displayName;

    Size(String displayName) {
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
