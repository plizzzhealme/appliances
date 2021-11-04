package io.github.plizzzhealme.appliance.dao;


import io.github.plizzzhealme.appliance.dao.impl.XMLApplianceDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceSourceDAO applianceDAO = new XMLApplianceDAO();
	
	private DAOFactory() {}

	public ApplianceSourceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
