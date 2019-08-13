package com.ugandaairlines.ugair.flight.model;

public enum EFlightType {
    ONE_WAY ("One way"),
    ROUND_TRIP ("Round trip");
    private String description;
    public String getDescription() {
        return description;
    }
    EFlightType(String description){
        this.description= description;
    }
}
