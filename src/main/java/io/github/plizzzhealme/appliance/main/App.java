package io.github.plizzzhealme.appliance.main;

import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.Kettle;
import io.github.plizzzhealme.appliance.entity.TabletPC;
import io.github.plizzzhealme.appliance.entity.criteria.Criteria;
import io.github.plizzzhealme.appliance.entity.criteria.SearchCriteria;
import io.github.plizzzhealme.appliance.service.ApplianceService;
import io.github.plizzzhealme.appliance.service.ServiceFactory;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ServiceFactory serviceFactory;
        ApplianceService applianceService;
        List<Appliance> appliances;
        Criteria criteria;

        System.out.println(SearchCriteria.Appliance.BRAND.value);

        serviceFactory = ServiceFactory.getInstance();
        applianceService = serviceFactory.getApplianceService();

        // search with null parameter returns a whole list
        System.out.println("search whole list");
        appliances = applianceService.find(null);
        appliances.forEach(System.out::println);


        // search for glass kettles
        System.out.println("search for glass kettles");
        criteria = new Criteria("Kettle");
        criteria.getParams().put("bodyMaterial", "glass");
        appliances = applianceService.find(criteria);
        appliances.forEach(System.out::println);

        // search for ovens
        System.out.println("search for ovens");
        criteria = new Criteria("Oven");
        appliances = applianceService.find(criteria);
        appliances.forEach(System.out::println);

        applianceService.add(new TabletPC("apple", "X", 1000, "i-proc", 4096, 200));

    }
}
