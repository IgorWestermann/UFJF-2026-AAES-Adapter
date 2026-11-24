package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorFahrenheitAdapterTest {
    @Test
    void sensorDigitalDeveInformarTemperaturaEmCelsius() {
        assertEquals(27.5, new SensorDigital(27.5).getTemperaturaCelsius(), 0.001);
    }

    @Test
    void sensorFahrenheitDeveInformarTemperaturaEmFahrenheit() {
        assertEquals(86, new SensorFahrenheit(86).lerFahrenheit(), 0.001);
    }

    @Test
    void adaptadorDeveConverterFahrenheitParaCelsius() {
        assertEquals(30, new SensorFahrenheitAdapter(86).getTemperaturaCelsius(), 0.001);
        assertEquals(0, new SensorFahrenheitAdapter(32).getTemperaturaCelsius(), 0.001);
        assertEquals(100, new SensorFahrenheitAdapter(212).getTemperaturaCelsius(), 0.001);
        assertEquals(-40, new SensorFahrenheitAdapter(-40).getTemperaturaCelsius(), 0.001);
    }

    @Test
    void adaptadorDeveManterALeituraOriginalEmFahrenheit() {
        assertEquals(86, new SensorFahrenheitAdapter(86).lerFahrenheit(), 0.001);
    }

    @Test
    void adaptadorDeveSerSensorFahrenheitESensorDeTemperatura() {
        SensorFahrenheitAdapter adaptador = new SensorFahrenheitAdapter(86);
        assertInstanceOf(SensorFahrenheit.class, adaptador);
        assertInstanceOf(ISensorTemperatura.class, adaptador);
    }
}
