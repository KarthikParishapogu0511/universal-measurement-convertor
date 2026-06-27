package com.karthik.umc.service.converter;

public class WeightConverter {
    public double convert(double value, int fromUnit, int toUnit) {
        if (fromUnit < 1 || fromUnit > 8 || toUnit < 1 || toUnit > 8) {
            throw new IllegalArgumentException("Invalid weight unit selection");
        }

        // Convert to kilograms first
        double baseValue = toKilograms(value, fromUnit);

        // Convert from kilograms to target unit
        return fromKilograms(baseValue, toUnit);
    }

    private double toKilograms(double value, int unit) {
        switch (unit) {
            case 1: return value / 1000000.0; // mg to kg
            case 2: return value / 1000.0;    // g to kg
            case 3: return value;             // kg to kg
            case 4: return value * 1000.0;    // metric ton to kg
            case 5: return value * 0.0283495; // oz to kg
            case 6: return value * 0.453592;  // lb to kg
            case 7: return value * 6.35029;   // stone to kg
            case 8: return value * 907.185;   // US ton to kg
            default: throw new IllegalArgumentException("Invalid weight unit");
        }
    }

    private double fromKilograms(double baseValue, int unit) {
        switch (unit) {
            case 1: return baseValue * 1000000.0; // kg to mg
            case 2: return baseValue * 1000.0;    // kg to g
            case 3: return baseValue;             // kg to kg
            case 4: return baseValue / 1000.0;    // kg to metric ton
            case 5: return baseValue / 0.0283495; // kg to oz
            case 6: return baseValue / 0.453592;  // kg to lb
            case 7: return baseValue / 6.35029;   // kg to stone
            case 8: return baseValue / 907.185;   // kg to US ton
            default: throw new IllegalArgumentException("Invalid weight unit");
        }
    }
}
