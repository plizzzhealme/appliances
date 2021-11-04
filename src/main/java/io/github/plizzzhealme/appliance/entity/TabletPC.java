package io.github.plizzzhealme.appliance.entity;

import java.util.Objects;

public class TabletPC extends Appliance{

    private String cpuModel;
    private int ram;
    private int ssdCapacity;

    public TabletPC(String brand, String model, int price, String cpuModel, int ram, int ssdCapacity) {
        super(brand, model, price);
        this.cpuModel = cpuModel;
        this.ram = ram;
        this.ssdCapacity = ssdCapacity;
    }

    @Override
    public String toString() {
        return "TabletPC {" +
                "price=" + getPrice() +
                " brand=" + getBrand() +
                " model=" + getModel() +
                " cpuModel=" + cpuModel +
                " ram=" + ram +
                " ssdCapacity=" + ssdCapacity +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TabletPC tabletPC)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        return getRam() == tabletPC.getRam()
                && getSsdCapacity() == tabletPC.getSsdCapacity()
                && getCpuModel().equals(tabletPC.getCpuModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCpuModel(), getRam(), getSsdCapacity());
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }

    public void setSsdCapacity(int ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }
}
