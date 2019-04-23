package com.apple.api.flagPicker.model;

public class Flag {
    private String flagName;

    public Flag(String flagName) {
        this.flagName = flagName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }
}
