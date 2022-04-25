package com.reachIN.ReachIN.controllers;


import com.reachIN.ReachIN.dao.UnitOfMeasureDAO;
import com.reachIN.ReachIN.dao.UnitOfMeasureDaoJdbc;
import com.reachIN.ReachIN.models.UnitOfMeasure;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitOfMeasureController {

    private UnitOfMeasureDAO unitOfMeasureDAO;

    public UnitOfMeasureController(UnitOfMeasureDAO dao){
        this.unitOfMeasureDAO = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UnitOfMeasure> getAllUnits(){
        return unitOfMeasureDAO.getUnitsOfMeasure();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public UnitOfMeasure getUnitById(@PathVariable int id){
        return unitOfMeasureDAO.getUnitOfMeasure(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnitOfMeasure createUnit(@RequestBody UnitOfMeasure unit){
        return unitOfMeasureDAO.createUnitOfMeasure(unit);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public boolean updateUnit(@RequestBody UnitOfMeasure unit, @PathVariable int id){
        return unitOfMeasureDAO.updateUnitOfMeasure(id, unit);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteUnit(@PathVariable int id){
        return unitOfMeasureDAO.deleteUnitOfMeasure(id);
    }
}
