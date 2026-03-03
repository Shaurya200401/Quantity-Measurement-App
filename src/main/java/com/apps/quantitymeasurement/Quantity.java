package com.apps.quantitymeasurement;

public class Quantity {
    private final double value;
    private final IMeasurable unit;

    public Quantity(double value, IMeasurable unit) {
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 1000.0) / 1000.0;
    }

    public boolean compare(Quantity other) {
        if (other == null)
            return false;

        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Quantity other = (Quantity) obj;
        return compare(other);
    }
}
