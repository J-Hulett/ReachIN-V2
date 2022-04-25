package com.reachIN.ReachIN.models;

public class UnitOfMeasure {

    private int unitId;
    private String unitType;

    public UnitOfMeasure(int unitId, String unitType) {
        this.unitId = unitId;
        this.unitType = unitType;
    }

    public UnitOfMeasure(){}

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
