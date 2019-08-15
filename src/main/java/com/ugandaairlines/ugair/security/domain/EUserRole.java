package com.ugandaairlines.ugair.security.domain;

public enum EUserRole {

    ROLE_ADMINISTRATOR ("ADMINISTRATOR"),
    ROLE_MANAGER("MANAGER"),
    ROLE_CUSTOMER ("CUSTOMER");

    private String description;

    EUserRole(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
