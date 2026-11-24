package org.example;

public class SensorDigital implements ISensorTemperatura {
    private double temperaturaCelsius;

    public SensorDigital(double temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
    }

    @Override
    public double getTemperaturaCelsius() {
        return temperaturaCelsius;
    }
}
