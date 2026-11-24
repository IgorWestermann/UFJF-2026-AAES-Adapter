package org.example;

public class SensorFahrenheitAdapter extends SensorFahrenheit implements ISensorTemperatura {
    public SensorFahrenheitAdapter(double temperaturaFahrenheit) {
        super(temperaturaFahrenheit);
    }

    @Override
    public double getTemperaturaCelsius() {
        return (lerFahrenheit() - 32) * 5 / 9;
    }
}
