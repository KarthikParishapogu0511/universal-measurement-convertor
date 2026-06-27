package com.karthik.umc.service;
import com.karthik.umc.service.converter.LengthConverter;
import com.karthik.umc.service.converter.WeightConverter;

public class ConversionManager {

    private final LengthConverter lengthConverter = new LengthConverter();
    private final WeightConverter weightConverter = new WeightConverter();

    // Currency conversion rates (as of recent data - these would ideally be fetched from an API)
    private static final double[][] CURRENCY_RATES = {
        // INR, USD, EUR, GBP, JPY, CAD, AUD, CHF
        {1.0, 0.012, 0.011, 0.0095, 1.8, 0.016, 0.018, 0.011}, // INR
        {83.0, 1.0, 0.92, 0.79, 150.0, 1.35, 1.52, 0.92},      // USD
        {90.0, 1.09, 1.0, 0.86, 163.0, 1.47, 1.65, 1.0},       // EUR
        {105.0, 1.27, 1.16, 1.0, 190.0, 1.71, 1.92, 1.16},     // GBP
        {0.55, 0.0067, 0.0061, 0.0053, 1.0, 0.009, 0.010, 0.0061}, // JPY
        {62.0, 0.74, 0.68, 0.58, 111.0, 1.0, 1.13, 0.68},      // CAD
        {55.0, 0.66, 0.61, 0.52, 99.0, 0.89, 1.0, 0.61},       // AUD
        {90.0, 1.09, 1.0, 0.86, 163.0, 1.47, 1.65, 1.0}        // CHF
    };
    
    public double convertCurrency(double amount, int fromCurrency, int toCurrency) {
        if (fromCurrency < 1 || fromCurrency > 8 || toCurrency < 1 || toCurrency > 8) {
            throw new IllegalArgumentException("Invalid currency selection");
        }
        
        // Convert to 0-based indexing
        int from = fromCurrency - 1;
        int to = toCurrency - 1;
        
        // Convert to USD first, then to target currency
        double usdAmount = amount / CURRENCY_RATES[from][1]; // Convert to USD
        return usdAmount * CURRENCY_RATES[1][to]; // Convert from USD to target
    }
    
    public double convertLength(double length, int fromUnit, int toUnit) {
        return lengthConverter.convert(length, fromUnit, toUnit);
    }

    public double convertWeight(double weight, int fromUnit, int toUnit) {
        return weightConverter.convert(weight, fromUnit, toUnit);
    }
    

    public double convertTime(double time, int fromUnit, int toUnit) {
        if (fromUnit < 1 || fromUnit > 7 || toUnit < 1 || toUnit > 7) {
            throw new IllegalArgumentException("Invalid time unit selection");
        }
        
        // Convert to seconds first
        double seconds = toSeconds(time, fromUnit);
        
        // Convert from seconds to target unit
        return fromSeconds(seconds, toUnit);
    }
    
    private double toSeconds(double value, int unit) {
        switch (unit) {
            case 1: return value;           // seconds to seconds
            case 2: return value * 60.0;    // minutes to seconds
            case 3: return value * 3600.0;  // hours to seconds
            case 4: return value * 86400.0; // days to seconds
            case 5: return value * 604800.0; // weeks to seconds
            case 6: return value * 2592000.0; // months to seconds (30 days)
            case 7: return value * 31536000.0; // years to seconds (365 days)
            default: throw new IllegalArgumentException("Invalid time unit");
        }
    }
    
    private double fromSeconds(double seconds, int unit) {
        switch (unit) {
            case 1: return seconds;           // seconds to seconds
            case 2: return seconds / 60.0;    // seconds to minutes
            case 3: return seconds / 3600.0;  // seconds to hours
            case 4: return seconds / 86400.0; // seconds to days
            case 5: return seconds / 604800.0; // seconds to weeks
            case 6: return seconds / 2592000.0; // seconds to months
            case 7: return seconds / 31536000.0; // seconds to years
            default: throw new IllegalArgumentException("Invalid time unit");
        }
    }
    
    public double convertTemperature(double temperature, int fromUnit, int toUnit) {
        if (fromUnit < 1 || fromUnit > 3 || toUnit < 1 || toUnit > 3) {
            throw new IllegalArgumentException("Invalid temperature unit selection");
        }
        
        // Convert to Celsius first
        double celsius = toCelsius(temperature, fromUnit);
        
        // Convert from Celsius to target unit
        return fromCelsius(celsius, toUnit);
    }
    
    private double toCelsius(double value, int unit) {
        switch (unit) {
            case 1: return value;                    // Celsius to Celsius
            case 2: return (value - 32) * 5.0 / 9.0; // Fahrenheit to Celsius
            case 3: return value - 273.15;           // Kelvin to Celsius
            default: throw new IllegalArgumentException("Invalid temperature unit");
        }
    }
    
    private double fromCelsius(double celsius, int unit) {
        switch (unit) {
            case 1: return celsius;                    // Celsius to Celsius
            case 2: return celsius * 9.0 / 5.0 + 32;  // Celsius to Fahrenheit
            case 3: return celsius + 273.15;           // Celsius to Kelvin
            default: throw new IllegalArgumentException("Invalid temperature unit");
        }
    }
} 