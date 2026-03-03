package com.apps.quantitymeasurement;

public enum VolumeUnit implements IMeasurable {
    GALLON(3785.41),
    LITRE(1000.0),
    ML(1.0);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }
}
