package org.example;

public class ArCondicionado {
    private ISensorTemperatura sensor;
    private double limiteCelsius;

    public ArCondicionado(ISensorTemperatura sensor, double limiteCelsius) {
        this.sensor = sensor;
        this.limiteCelsius = limiteCelsius;
    }

    public ISensorTemperatura getSensor() {
        return sensor;
    }

    public void setSensor(ISensorTemperatura sensor) {
        this.sensor = sensor;
    }

    public double getLimiteCelsius() {
        return limiteCelsius;
    }

    public boolean deveLigar() {
        return sensor.getTemperaturaCelsius() > limiteCelsius;
    }

    public String exibirStatus() {
        String estado = deveLigar() ? "ligado" : "desligado";
        return "Temperatura: " + sensor.getTemperaturaCelsius() + " °C - ar-condicionado " + estado;
    }
}
