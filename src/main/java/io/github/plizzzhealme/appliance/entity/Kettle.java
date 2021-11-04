package io.github.plizzzhealme.appliance.entity;

import java.util.Objects;

public class Kettle extends Appliance{

    private int powerConsumption;
    private String bodyMaterial;
    private int capacityInLitres;

    public Kettle(String brand,
                  String model,
                  int price,
                  int powerConsumption,
                  String bodyMaterial,
                  int capacityInLitres) {
        super(brand, model, price);
        this.powerConsumption = powerConsumption;
        this.bodyMaterial = bodyMaterial;
        this.capacityInLitres = capacityInLitres;
    }

    @Override
    public String toString() {
        return "Kettle {" +
                "price=" + getPrice() +
                " brand=" + getBrand() +
                " model=" + getModel() +
                " powerConsumption=" + powerConsumption +
                " bodyMaterial=" + bodyMaterial +
                " capacityInLitres=" + capacityInLitres +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Kettle kettle)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        return getPowerConsumption() == kettle.getPowerConsumption()
                && getCapacityInLitres() == kettle.getCapacityInLitres()
                && getBodyMaterial().equals(kettle.getBodyMaterial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPowerConsumption(), getBodyMaterial(), getCapacityInLitres());
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public int getCapacityInLitres() {
        return capacityInLitres;
    }

    public void setCapacityInLitres(int capacityInLitres) {
        this.capacityInLitres = capacityInLitres;
    }
}
