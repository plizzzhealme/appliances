package io.github.plizzzhealme.appliance.dao;

import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceSourceDAO {

    List<Appliance> find(Criteria criteria);

    boolean add(Appliance newAppliance);
}
