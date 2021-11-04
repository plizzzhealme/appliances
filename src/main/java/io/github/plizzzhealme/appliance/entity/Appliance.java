package io.github.plizzzhealme.appliance.entity;

import java.util.Objects;

public class Appliance {

    private String brand;
    private String model;
    private int price;

    public Appliance(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Appliance appliance)) {
            return false;
        }

        return getPrice() == appliance.getPrice()
                && getBrand().equals(appliance.getBrand())
                && getModel().equals(appliance.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getPrice());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
