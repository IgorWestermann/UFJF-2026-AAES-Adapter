package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArCondicionadoTest {
    @Test
    void deveLigarQuandoTemperaturaPassaDoLimite() {
        ArCondicionado arCondicionado = new ArCondicionado(new SensorDigital(27.5), 25);
        assertTrue(arCondicionado.deveLigar());
    }

    @Test
    void naoDeveLigarQuandoTemperaturaEstaNoLimiteOuAbaixo() {
        assertFalse(new ArCondicionado(new SensorDigital(25), 25).deveLigar());
        assertFalse(new ArCondicionado(new SensorDigital(18), 25).deveLigar());
    }

    @Test
    void deveFuncionarComSensorFahrenheitAtravesDoAdaptador() {
        assertTrue(new ArCondicionado(new SensorFahrenheitAdapter(86), 25).deveLigar());
        assertFalse(new ArCondicionado(new SensorFahrenheitAdapter(68), 25).deveLigar());
    }

    @Test
    void deveTratarSensorDigitalEAdaptadorDeFormaUniforme() {
        ISensorTemperatura digital = new SensorDigital(30);
        ISensorTemperatura adaptado = new SensorFahrenheitAdapter(86);

        assertEquals(new ArCondicionado(digital, 25).deveLigar(), new ArCondicionado(adaptado, 25).deveLigar());
        assertEquals(digital.getTemperaturaCelsius(), adaptado.getTemperaturaCelsius(), 0.001);
    }

    @Test
    void devePermitirTrocarOSensor() {
        ISensorTemperatura adaptado = new SensorFahrenheitAdapter(68);
        ArCondicionado arCondicionado = new ArCondicionado(new SensorDigital(30), 25);
        assertTrue(arCondicionado.deveLigar());

        arCondicionado.setSensor(adaptado);
        assertSame(adaptado, arCondicionado.getSensor());
        assertFalse(arCondicionado.deveLigar());
    }

    @Test
    void deveExibirStatus() {
        assertEquals("Temperatura: 30.0 °C - ar-condicionado ligado",
                new ArCondicionado(new SensorFahrenheitAdapter(86), 25).exibirStatus());
        assertEquals("Temperatura: 20.0 °C - ar-condicionado desligado",
                new ArCondicionado(new SensorDigital(20), 25).exibirStatus());
    }
}
