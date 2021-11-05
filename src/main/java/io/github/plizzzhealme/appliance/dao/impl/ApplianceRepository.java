package io.github.plizzzhealme.appliance.dao.impl;

import io.github.plizzzhealme.appliance.dao.exception.DaoException;
import io.github.plizzzhealme.appliance.entity.Appliance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

class ApplianceRepository {

    private static final String XML_SOURCE_PATH = "src/main/resources/appliances.xml";

    private static final ApplianceRepository instance = new ApplianceRepository();

    private final List<Appliance> data;

    private ApplianceRepository() {
        ApplianceXmlParser parser = new ApplianceXmlParser();

        try {
            data = parser.parse(XML_SOURCE_PATH);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DaoException(e.getMessage());
        }
    }

    public static ApplianceRepository getInstance() {
        return instance;
    }

    public List<Appliance> getData() {
        return data;
    }

    public boolean addData(Appliance newAppliance) {
        data.add(newAppliance);

        ApplianceXmlSaver applianceXmlSaver = new ApplianceXmlSaver();
        applianceXmlSaver.saveToXml(data, XML_SOURCE_PATH);

        return true;
    }
}
