package io.github.plizzzhealme.appliance.dao;


import io.github.plizzzhealme.appliance.dao.impl.XMLApplianceDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO = new XMLApplianceDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }
}
