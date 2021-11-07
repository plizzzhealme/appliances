package io.github.plizzzhealme.appliance.dao.impl;

import io.github.plizzzhealme.appliance.dao.exception.DaoException;
import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.Kettle;
import io.github.plizzzhealme.appliance.entity.Oven;
import io.github.plizzzhealme.appliance.entity.TabletPC;
import io.github.plizzzhealme.appliance.entity.criteria.SearchCriteria;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class ApplianceXmlParser {

    private List<Appliance> appliancesFromXML;

    public List<Appliance> parse(String xmlSourcePath) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory;
        SAXParser parser;
        ApplianceXMLHandler handler;
        File applianceXMLSourceFile;

        appliancesFromXML = new ArrayList<>();

        factory = SAXParserFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        parser = factory.newSAXParser();
        handler = new ApplianceXMLHandler();
        applianceXMLSourceFile = createApplianceSourceFileInstance(xmlSourcePath);

        parser.parse(applianceXMLSourceFile, handler);

        return appliancesFromXML;
    }

    private File createApplianceSourceFileInstance(String xmlSourcePath) {
        URL xmlSourceURL = getClass().getClassLoader().getResource(xmlSourcePath);

        if (xmlSourceURL == null) {
            throw new DaoException("File is not found");
        }

        return new File(xmlSourceURL.getPath());
    }

    private class ApplianceXMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("appliance")) {
                Appliance appliance;
                String applianceType;

                applianceType = attributes.getValue("type").toLowerCase();

                appliance = switch (applianceType) {
                    case "oven" -> buildOven(attributes);
                    case "tabletpc" -> buildTabletPC(attributes);
                    case "kettle" -> buildKettle(attributes);
                    default -> null;
                };

                if (appliance != null) {
                    appliancesFromXML.add(appliance);
                }
            }
        }

        private Kettle buildKettle(Attributes attributes) {
            String brand = attributes.getValue(SearchCriteria.Appliance.BRAND.value);
            String model = attributes.getValue(SearchCriteria.Appliance.MODEL.value);
            int price = Integer.parseInt(attributes.getValue(SearchCriteria.Appliance.PRICE.value));
            int powerConsumption = Integer.parseInt(attributes.getValue(SearchCriteria.Kettle.POWER_CONSUMPTION.value));
            int capacityInLitres = Integer.parseInt(attributes.getValue(SearchCriteria.Kettle.CAPACITY_IN_LITRES.value));
            String bodyMaterial = attributes.getValue(SearchCriteria.Kettle.BODY_MATERIAL.value);

            return new Kettle(brand, model, price, powerConsumption, bodyMaterial, capacityInLitres);
        }

        private TabletPC buildTabletPC(Attributes attributes) {
            String brand = attributes.getValue(SearchCriteria.Appliance.BRAND.value);
            String model = attributes.getValue(SearchCriteria.Appliance.MODEL.value);
            int price = Integer.parseInt(attributes.getValue(SearchCriteria.Appliance.PRICE.value));
            String cpuModel = attributes.getValue(SearchCriteria.TabletPC.CPU_MODEL.value);
            int ram = Integer.parseInt(attributes.getValue(SearchCriteria.TabletPC.RAM.value));
            int ssdCapacity = Integer.parseInt(attributes.getValue(SearchCriteria.TabletPC.SSD_CAPACITY.value));

            return new TabletPC(brand, model, price, cpuModel, ram, ssdCapacity);
        }

        private Oven buildOven(Attributes attributes) {
            String brand = attributes.getValue(SearchCriteria.Appliance.BRAND.value);
            String model = attributes.getValue(SearchCriteria.Appliance.MODEL.value);
            int price = Integer.parseInt(attributes.getValue(SearchCriteria.Appliance.PRICE.value));
            int width = Integer.parseInt(attributes.getValue(SearchCriteria.Oven.WIDTH.value));
            int height = Integer.parseInt(attributes.getValue(SearchCriteria.Oven.HEIGHT.value));
            int depth = Integer.parseInt(attributes.getValue(SearchCriteria.Oven.DEPTH.value));
            int minPower = Integer.parseInt(attributes.getValue(SearchCriteria.Oven.MIN_OUTPUT_POWER.value));
            int maxPower = Integer.parseInt(attributes.getValue(SearchCriteria.Oven.MAX_OUTPUT_POWER.value));

            return new Oven(brand, model, price, width, height, depth, minPower, maxPower);
        }
    }
}
