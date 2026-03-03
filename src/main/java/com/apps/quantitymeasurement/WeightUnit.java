package com.apps.quantitymeasurement;

public enum WeightUnit implements IMeasurable {
    KG(1000.0),
    GRAMS(1.0),
    TONNE(1000000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }
}
