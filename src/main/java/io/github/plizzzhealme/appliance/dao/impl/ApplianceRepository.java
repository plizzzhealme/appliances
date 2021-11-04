package io.github.plizzzhealme.appliance.dao.impl;

import java.io.IOException;
import java.util.List;

import io.github.plizzzhealme.appliance.entity.Appliance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class ApplianceRepository {

	private static final ApplianceRepository instance = new ApplianceRepository();

	private List<Appliance> data;
	
	private ApplianceRepository() {
		ApplianceXmlParser parser = new ApplianceXmlParser();

		try {
			data = parser.parse();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// todo process exceptions
			e.printStackTrace();
		}
	}
	
	public List<Appliance> getData(){
		return data;
	}
	
	public static ApplianceRepository getInstance() {
		return instance;
	}
}
