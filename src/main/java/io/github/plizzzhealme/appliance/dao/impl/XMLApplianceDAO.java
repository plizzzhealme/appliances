package io.github.plizzzhealme.appliance.dao.impl;

import java.util.List;

import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.Criteria;
import io.github.plizzzhealme.appliance.dao.ApplianceSourceDAO;

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
