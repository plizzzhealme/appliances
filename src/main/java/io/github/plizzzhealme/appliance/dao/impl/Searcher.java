package io.github.plizzzhealme.appliance.dao.impl;

import io.github.plizzzhealme.appliance.entity.Appliance;
import io.github.plizzzhealme.appliance.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Searcher {

    private final ApplianceRepository repository;

    public Searcher() {
        this.repository = ApplianceRepository.getInstance();
    }


    public List<Appliance> find(Criteria criteria) {
        if (criteria == null) {
            return repository.getData();
        }

        List<String> searchData = toStringForm(criteria.getParams());


        return filterAppliances(searchData);
    }

    private List<Appliance> filterAppliances(List<String> searchCriteria) {
        return repository.getData()
                .stream()
                .filter(appliance -> searchCriteria
                        .stream()
                        .allMatch(param -> appliance.toString().contains(param)))
                .toList();
    }

    private List<String> toStringForm(Map<String, String> searchParams) {
        List<String> searchData = new ArrayList<>();

        searchParams.keySet().forEach(key -> {
            if (key.equals("type")) {
                searchData.add(searchParams.get(key));
            } else {
                searchData.add(key + "=" + searchParams.get(key));
            }
        });

        return searchData;
    }
}
