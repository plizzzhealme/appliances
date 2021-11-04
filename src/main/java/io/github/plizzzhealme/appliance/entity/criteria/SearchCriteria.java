package io.github.plizzzhealme.appliance.entity.criteria;

public class SearchCriteria {

    public enum Appliance {

        BRAND("brand"),
        MODEL("model"),
        PRICE("price");

        public final String value;

        Appliance(String value) {
            this.value = value;
        }
    }

    public enum Oven {

        DEPTH("depth"),
        HEIGHT("height"),
        MAX_OUTPUT_POWER("maxOutputPower"),
        MIN_OUTPUT_POWER("minOutputPower"),
        WIDTH("width");

        public final String value;

        Oven(String value) {
            this.value = value;
        }
    }

    public enum Kettle {

        BODY_MATERIAL("bodyMaterial"),
        CAPACITY_IN_LITRES("capacityInLitres"),
        POWER_CONSUMPTION("powerConsumption");

        public final String value;

        Kettle(String value) {
            this.value = value;
        }
    }

    public enum TabletPC {

        CPU_MODEL("cpuModel"),
        RAM("ram"),
        SSD_CAPACITY("ssdCapacity");

        public final String value;

        TabletPC(String value) {
            this.value = value;
        }
    }
}
