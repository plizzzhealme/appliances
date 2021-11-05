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
    public boolean add(Appliance appliance) {
        return ApplianceRepository.getInstance().addData(appliance);
    }
}
