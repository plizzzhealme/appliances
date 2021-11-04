package io.github.plizzzhealme.appliance.entity;

import java.util.Objects;

public class TabletPC extends Appliance{

    private String cpuModel;
    private int ram;
    private int ssdVolume;

    public TabletPC(String brand, String model, int price, String cpuModel, int ram, int ssdVolume) {
        super(brand, model, price);
        this.cpuModel = cpuModel;
        this.ram = ram;
        this.ssdVolume = ssdVolume;
    }

    @Override
    public String toString() {
        return "TabletPC {" +
                "price=" + getPrice() +
                " brand=" + getBrand() +
                " model=" + getModel() +
                " cpuModel=" + cpuModel +
                " ram=" + ram +
                " ssdVolume=" + ssdVolume +
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
                && getSsdVolume() == tabletPC.getSsdVolume()
                && getCpuModel().equals(tabletPC.getCpuModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCpuModel(), getRam(), getSsdVolume());
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

    public int getSsdVolume() {
        return ssdVolume;
    }

    public void setSsdVolume(int ssdVolume) {
        this.ssdVolume = ssdVolume;
    }
}
