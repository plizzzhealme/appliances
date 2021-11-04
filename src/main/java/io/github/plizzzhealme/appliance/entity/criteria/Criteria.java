package io.github.plizzzhealme.appliance.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

    private static final String FIND_IN_APPLIANCE_TYPE = "type";
    private final Map<String, String> params;

    public Criteria() {
        params = new HashMap<>();
    }

    public Criteria(String applianceType) {
        params = new HashMap<>();
        params.put(FIND_IN_APPLIANCE_TYPE, applianceType);

    }

    public Map<String, String> getParams() {
        return params;
    }
}
