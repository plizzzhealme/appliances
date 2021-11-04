package io.github.plizzzhealme.appliance.dao;

import java.util.List;

import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.Criteria;

public interface ApplianceSourceDAO {
	List<Appliance> find(Criteria criteria);
	boolean add(Appliance newAppliance);
}
