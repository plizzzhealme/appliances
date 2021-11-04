package io.github.plizzzhealme.appliance.service;

import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.Criteria;

import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria);
	boolean add(Appliance appliance);
}
