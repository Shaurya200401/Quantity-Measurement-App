package com.apps.quantitymeasurement;

public class Length {
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    public boolean compare(Length other) {
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
        Length other = (Length) obj;
        return compare(other);
    }
}
