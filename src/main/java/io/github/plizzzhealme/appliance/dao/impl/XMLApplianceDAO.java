package io.github.plizzzhealme.appliance.dao.impl;

import io.github.plizzzhealme.appliance.dao.ApplianceSourceDAO;
import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.criteria.Criteria;

import java.util.List;

public class XMLApplianceDAO implements ApplianceSourceDAO {

    private final Searcher searcher = new Searcher();

    @Override
    public List<Appliance> find(Criteria criteria) {

        return searcher.find(criteria);
    }

    @Override
    public boolean add(Appliance newAppliance) {
        String type = newAppliance.getClass().getSimpleName();

        switch (type) {
            case "Oven":
                // todo oven save
                break;
            case "Kettle":
                // todo kettle save
                break;
            case "TabletPC":
                // todo tablet save
                break;
            default:
                //hmm..
        }
        // TODO Auto-generated method stub
        return false;
    }

}
