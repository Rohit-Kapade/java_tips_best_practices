package com.example;

import java.util.Objects;

public class Tyre {
    private int diameter;
    private int width;

    public Tyre(int diameter, int width) {
        this.diameter = diameter;
        this.width = width;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    protected Object clone() {
        return new Tyre(this.diameter, this.width);
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "diameter=" + diameter +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tyre)) return false;
        Tyre tyre = (Tyre) o;
        return getDiameter() == tyre.getDiameter() &&
                getWidth() == tyre.getWidth();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDiameter(), getWidth());
    }
}
