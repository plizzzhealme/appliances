package io.github.plizzzhealme.appliance.dao.impl;

import io.github.plizzzhealme.appliance.dao.exception.DaoException;
import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.Kettle;
import io.github.plizzzhealme.appliance.entity.Oven;
import io.github.plizzzhealme.appliance.entity.TabletPC;
import io.github.plizzzhealme.appliance.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import static io.github.plizzzhealme.appliance.entity.criteria.SearchCriteria.Appliance.*;

class ApplianceXmlSaver {

    public void saveToXml(List<Appliance> data, String path) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("appliances");

            data.forEach(appliance -> {
                Element e = document.createElement("appliance");

                e.setAttribute(BRAND.value, appliance.getBrand());
                e.setAttribute(PRICE.value, String.valueOf(appliance.getPrice()));
                e.setAttribute(MODEL.value, appliance.getModel());

                switch (appliance.getClass().getSimpleName()) {
                    case "Kettle" -> {
                        Kettle k = (Kettle) appliance;
                        e.setAttribute("type", "Kettle");
                        e.setAttribute(SearchCriteria.Kettle.BODY_MATERIAL.value, k.getBodyMaterial());
                        e.setAttribute(SearchCriteria.Kettle.POWER_CONSUMPTION.value, String.valueOf(k.getPowerConsumption()));
                        e.setAttribute(SearchCriteria.Kettle.CAPACITY_IN_LITRES.value, String.valueOf(k.getCapacityInLitres()));
                    }
                    case "Oven" -> {
                        Oven o = (Oven) appliance;
                        e.setAttribute("type", "Oven");
                        e.setAttribute(SearchCriteria.Oven.WIDTH.value, String.valueOf(o.getWidth()));
                        e.setAttribute(SearchCriteria.Oven.HEIGHT.value, String.valueOf(o.getHeight()));
                        e.setAttribute(SearchCriteria.Oven.DEPTH.value, String.valueOf(o.getDepth()));
                        e.setAttribute(SearchCriteria.Oven.MIN_OUTPUT_POWER.value, String.valueOf(o.getMinOutputPower()));
                        e.setAttribute(SearchCriteria.Oven.MAX_OUTPUT_POWER.value, String.valueOf(o.getMaxOutputPower()));
                    }
                    case "TabletPC" -> {
                        TabletPC t = (TabletPC) appliance;
                        e.setAttribute("type", "TabletPC");
                        e.setAttribute(SearchCriteria.TabletPC.CPU_MODEL.value, t.getCpuModel());
                        e.setAttribute(SearchCriteria.TabletPC.RAM.value, String.valueOf(t.getRam()));
                        e.setAttribute(SearchCriteria.TabletPC.SSD_CAPACITY.value, String.valueOf(t.getSsdCapacity()));
                    }

                    default -> throw new DaoException("Unknown appliance type");
                }

                root.appendChild(e);
            });

            document.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(path)));

        } catch (ParserConfigurationException | FileNotFoundException | TransformerException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
