package io.github.plizzzhealme.appliance.service.impl;

import io.github.plizzzhealme.appliance.dao.ApplianceSourceDAO;
import io.github.plizzzhealme.appliance.dao.DAOFactory;
import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.criteria.Criteria;
import io.github.plizzzhealme.appliance.service.ApplianceService;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> find(Criteria criteria) {

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceSourceDAO applianceDAO = factory.getApplianceDAO();

        return applianceDAO.find(criteria);
    }

    @Override
    public boolean add(Appliance appliance) {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceSourceDAO applianceDAO = factory.getApplianceDAO();

        return applianceDAO.add(appliance);
    }
}
