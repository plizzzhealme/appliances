package io.github.plizzzhealme.appliance.entity;

import java.util.Objects;

public class Oven extends Appliance{

    private int width;
    private int height;
    private int depth;
    private int minOutputPower;
    private int maxOutputPower;

    public Oven(String brand,
                String model,
                int price,
                int width,
                int height,
                int depth,
                int minOutputPower,
                int maxOutputPower) {
        super(brand, model, price);
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.minOutputPower = minOutputPower;
        this.maxOutputPower = maxOutputPower;
    }

    @Override
    public String toString() {
        return "Oven {" +
                "price=" + getPrice() +
                " brand=" + getBrand() +
                " model=" + getModel() +
                " width=" + width +
                " height=" + height +
                " depth=" + depth +
                " minOutputPower=" + minOutputPower +
                " maxOutputPower=" + maxOutputPower +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Oven oven)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        return getWidth() == oven.getWidth()
                && getHeight() == oven.getHeight()
                && getDepth() == oven.getDepth()
                && getMinOutputPower() == oven.getMinOutputPower()
                && getMaxOutputPower() == oven.getMaxOutputPower();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWidth(), getHeight(), getDepth(), getMinOutputPower(), getMaxOutputPower());
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getMinOutputPower() {
        return minOutputPower;
    }

    public void setMinOutputPower(int minOutputPower) {
        this.minOutputPower = minOutputPower;
    }

    public int getMaxOutputPower() {
        return maxOutputPower;
    }

    public void setMaxOutputPower(int maxOutputPower) {
        this.maxOutputPower = maxOutputPower;
    }
}
