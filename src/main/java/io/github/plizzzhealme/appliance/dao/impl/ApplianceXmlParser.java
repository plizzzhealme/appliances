package io.github.plizzzhealme.appliance.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.Kettle;
import io.github.plizzzhealme.appliance.entity.Oven;
import io.github.plizzzhealme.appliance.entity.TabletPC;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ApplianceXmlParser {
	
	private static final String XML_SOURCE_PATH = "src/main/resources/appliances.xml";

	private List<Appliance> appliancesFromXML;

	public List<Appliance> parse() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory;
		SAXParser parser;
		XMLHandler handler;

		appliancesFromXML = new ArrayList<>();
		factory = SAXParserFactory.newInstance();
		parser = factory.newSAXParser();
		handler= new XMLHandler();

		parser.parse(new File(XML_SOURCE_PATH), handler);

		return appliancesFromXML;
	}

	private class XMLHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) {
			if (qName.equals("appliance")) {
				Appliance appliance;
				String applianceType;

				applianceType = attributes.getValue("type");

				appliance = switch (applianceType) {
					case "oven" -> 	buildOven(attributes);
					case "tabletPC" -> buildTabletPC(attributes);
					case "kettle" -> buildKettle(attributes);
					default -> null;
				};

				if (appliance != null) {
					appliancesFromXML.add(appliance);
				}

			}
		}

		private Kettle buildKettle(Attributes attributes) {
			String brand = attributes.getValue("brand");
			String model = attributes.getValue("model");
			int price = Integer.parseInt(attributes.getValue("price"));
			int powerConsumption = Integer.parseInt(attributes.getValue("power"));
			int capacityInLitres = Integer.parseInt(attributes.getValue("capacity"));
			String bodyMaterial = attributes.getValue("body");

			return new Kettle(brand, model, price, powerConsumption, bodyMaterial, capacityInLitres);
		}

		private TabletPC buildTabletPC(Attributes attributes) {
			String brand = attributes.getValue("brand");
			String model = attributes.getValue("model");
			int price = Integer.parseInt(attributes.getValue("price"));
			String cpuModel = attributes.getValue("cpu");
			int ram = Integer.parseInt(attributes.getValue("ram"));
			int ssdVolume = Integer.parseInt(attributes.getValue("ssd"));

			return new TabletPC(brand, model, price, cpuModel, ram, ssdVolume);
		}

		private Oven buildOven(Attributes attributes) {
			String brand = attributes.getValue("brand");
			String model = attributes.getValue("model");
			int price = Integer.parseInt(attributes.getValue("price"));
			int width = Integer.parseInt(attributes.getValue("width"));
			int height = Integer.parseInt(attributes.getValue("height"));
			int depth = Integer.parseInt(attributes.getValue("depth"));
			int minPower = Integer.parseInt(attributes.getValue("minpower"));
			int maxPower = Integer.parseInt(attributes.getValue("maxpower"));

			return new Oven(brand, model, price, width, height, depth, minPower, maxPower);
		}
	}
}
