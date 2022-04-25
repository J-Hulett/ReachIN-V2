package com.reachIN.ReachIN.dao;

import com.reachIN.ReachIN.models.UnitOfMeasure;

import java.util.List;

public interface UnitOfMeasureDAO {

    List<UnitOfMeasure> getUnitsOfMeasure();
    UnitOfMeasure getUnitOfMeasure(int unitId);
    UnitOfMeasure createUnitOfMeasure(UnitOfMeasure unitOfMeasure);
    boolean updateUnitOfMeasure(int unitId, UnitOfMeasure unitOfMeasure);
    boolean deleteUnitOfMeasure(int unitId);
}
