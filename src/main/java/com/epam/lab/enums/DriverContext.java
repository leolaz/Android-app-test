package com.epam.lab.enums;

public enum DriverContext {
    NATIVE("NATIVE_APP"), WEBVIEW("WEBVIEW_io.selendroid.testapp");

    private String value;

    DriverContext(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
