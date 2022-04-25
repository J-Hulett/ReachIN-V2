package com.reachIN.ReachIN.dao;


import com.reachIN.ReachIN.models.UnitOfMeasure;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnitOfMeasureDaoJdbc implements UnitOfMeasureDAO{

    private JdbcTemplate jdbcTemplate;
    public UnitOfMeasureDaoJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<UnitOfMeasure> getUnitsOfMeasure() {
        List<UnitOfMeasure> unitsOfMeasure = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM unit;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            UnitOfMeasure unit = mapRowToUnitOfMeasure(results);
            unitsOfMeasure.add(unit);
        }
        return unitsOfMeasure;
    }

    @Override
    public UnitOfMeasure getUnitOfMeasure(int unitId) {
        UnitOfMeasure unit = new UnitOfMeasure();
        String sql = "SELECT * " +
                "FROM unit " +
                "WHERE unit_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, unitId);
        if(results.next()){
            unit = mapRowToUnitOfMeasure(results);
        }
        return unit;
    }

    @Override
    public UnitOfMeasure createUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        String sql = "INSERT INTO unit (unit_type) " +
                "VALUES (?) RETURNING unit_id;";
        int newID = jdbcTemplate.queryForObject(sql, int.class, unitOfMeasure.getUnitType());
        return getUnitOfMeasure(newID);
    }

    @Override
    public boolean updateUnitOfMeasure(int unitId, UnitOfMeasure unitOfMeasure) {
        String sql = "UPDATE unit " +
                "SET unit_type = ? " +
                "WHERE unit_id = ?;";
        return jdbcTemplate.update(sql, unitOfMeasure.getUnitType(), unitId) == 1;
    }

    @Override
    public boolean deleteUnitOfMeasure(int unitId) {
        String sql = "DELETE FROM unit WHERE unit_id = ?;";
        return jdbcTemplate.update(sql, unitId) == 1;
    }

    public UnitOfMeasure mapRowToUnitOfMeasure(SqlRowSet results){
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setUnitId(results.getInt("unit_id"));
        unitOfMeasure.setUnitType(results.getString("unit_type"));

        return unitOfMeasure;
    }
}
